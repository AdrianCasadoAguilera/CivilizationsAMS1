import oracledb
import os

# Parámetros de conexión y conexión a la db
username = 'azueuser'
password = 'CivilizationsAMS1'
host = '20.224.68.0'
port = '1521'
service_name = 'orcl'  # o SID si usas SID en lugar de service name
dsn = oracledb.makedsn(host, port, service_name=service_name)

def fetch_xml_from_db(output_path):
    try:
        connection = oracledb.connect(user=username, password=password, dsn=dsn)
        print("Connected to Oracle Database!")

        # Consulta PL/SQL para conseguir el xml
        plsql_query = """
        DECLARE
            l_context    DBMS_XMLGEN.ctxHandle;
            l_xml        CLOB;
            l_table_name VARCHAR2(255);
            l_sql        VARCHAR2(4000);
            l_full_xml   CLOB := '<database>'; -- Inicializamos con la raíz del XML
        BEGIN
            FOR table_record IN (SELECT table_name FROM user_tables) LOOP
                l_table_name := table_record.table_name;
                l_sql := 'SELECT * FROM ' || l_table_name;
                l_context := DBMS_XMLGEN.newContext(l_sql);
                DBMS_XMLGEN.setRowTag(l_context, l_table_name);
                DBMS_XMLGEN.setRowSetTag(l_context, 'ROWSET');
                l_xml := DBMS_XMLGEN.getXML(l_context);
                DBMS_XMLGEN.closeContext(l_context);
                l_full_xml := l_full_xml || '<' || l_table_name || '>' || l_xml || '</' || l_table_name || '>';
            END LOOP;
            l_full_xml := l_full_xml || '</database>';
            :full_xml := l_full_xml;
        END;
        """

        # ejecutar la consulta
        with connection.cursor() as cursor:
            full_xml_var = cursor.var(oracledb.CLOB)
            cursor.execute(plsql_query, full_xml=full_xml_var)
            full_xml = full_xml_var.getvalue()

        # guardar el xml en la ruta  o crearla si no existe
        os.makedirs(os.path.dirname(output_path), exist_ok=True)
        with open(output_path, 'w', encoding='utf-8') as file:
            file.write(full_xml)
        print(f"El resultado se ha guardado en {output_path}")

    except oracledb.DatabaseError as e:
        print(f"Error al conectarse a la base de datos: {str(e)}")

    finally:
        if connection:
            connection.close()
            print("Conexión cerrada")

fetch_xml_from_db('./xml/zivilizations.xml')