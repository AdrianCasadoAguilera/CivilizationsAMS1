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
