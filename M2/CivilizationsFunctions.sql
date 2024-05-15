CREATE OR REPLACE TYPE number_array AS VARRAY(100) OF NUMBER(10);

CREATE OR REPLACE FUNCTION F_civilizations_stats_quantity(p_id civilization_stats.civilization_id%TYPE) 
RETURN number_array 
IS 
    myArray number_array; 
BEGIN 
    SELECT wood_amount, iron_amount, food_amount, mana_amount, 
           magicTower_counter, church_counter, farm_counter, smithy_counter, carpentry_counter, 
           technology_defence_level, technology_attack_level, battles_counter 
    INTO myArray 
    FROM civilization_stats 
    WHERE civilization_id = p_id; 
 
    RETURN myArray; 
END; 

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
    DBMS_OUTPUT.put_line(l_full_xml);
END;
/
