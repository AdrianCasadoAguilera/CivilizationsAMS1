import oracledb
import os

# Parámetros de conexión y conexión a la db
username = 'usuario'
password = '1234'
host = '20.224.68.0'
port = '1521'
service_name = 'MYDB'  # o SID si usas SID en lugar de service name
dsn = oracledb.makedsn(host, port, service_name=service_name)

def fetch_xml_from_db(output_path):
    connection = None
    try:
        print(f"Intentando conectar a la base de datos con DSN: {dsn}")
        connection = oracledb.connect(user=username, password=password, dsn=dsn)
        print("Connected to Oracle Database!")

        # Consulta PL/SQL para conseguir el xml sin tablas con CLOB
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
                -- Excluir tablas que tienen campos CLOB
                IF l_table_name NOT IN ('BATTLE_LOG') THEN
                    l_sql := 'SELECT * FROM ' || l_table_name;
                    l_context := DBMS_XMLGEN.newContext(l_sql);
                    DBMS_XMLGEN.setRowTag(l_context, l_table_name);
                    DBMS_XMLGEN.setRowSetTag(l_context, 'ROWSET');
                    l_xml := DBMS_XMLGEN.getXML(l_context);
                    DBMS_XMLGEN.closeContext(l_context);
                    l_full_xml := l_full_xml || '<' || l_table_name || '>' || l_xml || '</' || l_table_name || '>';
                END IF;
            END LOOP;
            l_full_xml := l_full_xml || '</database>';
            :full_xml := l_full_xml;
        END;
        """

        # Ejecutar la consulta
        with connection.cursor() as cursor:
            full_xml_var = cursor.var(oracledb.CLOB)
            cursor.execute(plsql_query, full_xml=full_xml_var)
            full_xml = full_xml_var.getvalue()

        # Guardar el xml en la ruta o crearla si no existe
        os.makedirs(os.path.dirname(output_path), exist_ok=True)
        with open(output_path, 'w', encoding='utf-8') as file:
            file.write(full_xml.read())
        print(f"El resultado se ha guardado en {output_path}")

        # Leer el archivo y eliminar cabeceras duplicadas
        remove_duplicate_xml_headers(output_path)

    except oracledb.DatabaseError as e:
        print(f"Error al conectarse a la base de datos: {str(e)}")

    finally:
        if connection:
            connection.close()
            print("Conexión cerrada")

def remove_duplicate_xml_headers(file_path):
    try:
        with open(file_path, 'r', encoding='utf-8') as file:
            content = file.read()

        # Eliminar todas las cabeceras <?xml version="1.0"?>
        content = content.replace('<?xml version="1.0"?>', '')
        
        # Añadir la cabecera completa al inicio del archivo
        content = '<?xml version="1.0" encoding="UTF-8"?>\n' + content

        # Escribir el contenido actualizado de vuelta al archivo
        with open(file_path, 'w', encoding='utf-8') as file:
            file.write(content)

        print(f"La cabecera del archivo XML ha sido actualizada en {file_path}")

    except Exception as e:
        print(f"Error al procesar el archivo XML: {str(e)}")

# fetch_xml_from_db('./xml/civilizations.xml')
