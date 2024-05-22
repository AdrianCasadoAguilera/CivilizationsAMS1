CREATE SEQUENCE civilization_id START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE enemy_unit_id START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE unit_id START WITH 1 INCREMENT BY 1;

create or replace TRIGGER civilization_id_trigger
BEFORE INSERT ON civilization_stats
FOR EACH ROW
BEGIN
    IF :NEW.civilization_id IS NULL THEN
        SELECT civilization_id.NEXTVAL
        INTO :NEW.civilization_id
        FROM dual;
    END IF;
END;

create or replace TRIGGER enemy_unit_id_trigger
BEFORE INSERT ON enemy_unit
FOR EACH ROW
BEGIN
    IF :NEW.unit_id IS NULL THEN
        SELECT enemy_unit_id.NEXTVAL
        INTO :NEW.unit_id
        FROM dual;
    END IF;
END;

create or replace TRIGGER units_id_trigger
BEFORE INSERT ON units
FOR EACH ROW
BEGIN
    IF :NEW.unit_id IS NULL THEN
        SELECT unit_id.NEXTVAL
        INTO :NEW.unit_id
        FROM dual;
    END IF;
END;




