CREATE SEQUENCE civilization_id START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE attack_unit_id START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE special_unit_id START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE defence_unit_id START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE num_battle START WITH 1 INCREMENT BY 1;


CREATE OR REPLACE TRIGGER civilization_id_trigger
BEFORE INSERT ON civilization_stats
FOR EACH ROW
BEGIN
    IF :NEW.civilization_id IS NULL THEN
        SELECT civilization_id.NEXTVAL
        INTO :NEW.civilization_id
        FROM dual;
    END IF;
END;
/

CREATE OR REPLACE TRIGGER attack_unit_id_trigger
BEFORE INSERT ON attack_unit_stats
FOR EACH ROW
BEGIN
    IF :NEW.attack_unit_id IS NULL THEN
        SELECT attack_unit_id.NEXTVAL
        INTO :NEW.attack_unit_id
        FROM dual;
    END IF;
END;
/

CREATE OR REPLACE TRIGGER special_unit_id_trigger
BEFORE INSERT ON special_unit_stats
FOR EACH ROW
BEGIN
    IF :NEW.special_unit_id IS NULL THEN
        SELECT special_unit_id.NEXTVAL
        INTO :NEW.special_unit_id
        FROM dual;
    END IF;
END;
/

CREATE OR REPLACE TRIGGER defence_unit_id_trigger
BEFORE INSERT ON defence_unit_stats
FOR EACH ROW
BEGIN
    IF :NEW.defence_unit_id IS NULL THEN
        SELECT defence_unit_id.NEXTVAL
        INTO :NEW.defence_unit_id
        FROM dual;
    END IF;
END;
/

CREATE OR REPLACE TRIGGER num_battle_trigger
BEFORE INSERT ON battle_stats
FOR EACH ROW
BEGIN
    IF :NEW.defence_unit_id IS NULL THEN
        SELECT num_battle.NEXTVAL
        INTO :NEW.num_battle
        FROM dual;
    END IF;
END;
/