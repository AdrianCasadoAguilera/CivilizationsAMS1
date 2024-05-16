CREATE TABLE civilization_stats ( 
    civilization_id NUMBER PRIMARY KEY AUTO-INCREMENT, 
    name VARCHAR2(255), 
    wood_amount NUMBER NOT NULL, 
    iron_amount NUMBER NOT NULL, 
    food_amount NUMBER NOT NULL, 
    mana_amount NUMBER NOT NULL, 
    magicTower_counter NUMBER NOT NULL, 
    church_counter NUMBER NOT NULL, 
    farm_counter NUMBER NOT NULL, 
    smithy_counter NUMBER NOT NULL, 
    carpentry_counter NUMBER NOT NULL, 
    technology_defence_level NUMBER, 
    technology_attack_level NUMBER, 
    battles_counter NUMBER,
    battle_timer NUMBER,
    NextBattleIn NUMBER
);

CREATE TABLE units ( 
    unit_id NUMBER PRIMARY KEY, 
    civilization_id NUMBER NOT NULL, 
    type VARCHAR2(20), 
    experience NUMBER, 
    CONSTRAINT ck_type_unit CHECK (type IN ('Swordsman', 'Spearman', 'Crossbow', 'Cannon','Arrowtower','Rocketlaunchertower','Magician','Priest')),
  	CONSTRAINT fk_civilization_unit
    	FOREIGN KEY (civilization_id)
    	REFERENCES civilization_stats(civilization_id)
);

CREATE TABLE enemy_unit ( 
    unit_id NUMBER PRIMARY KEY, 
    civilization_id NUMBER NOT NULL, 
    type VARCHAR2(20), 
    experience NUMBER, 
    CONSTRAINT ck_type_enemy_unit CHECK (type IN ('Swordsman', 'Spearman', 'Crossbow', 'Cannon')),
  	CONSTRAINT fk_enemy_unit
    	FOREIGN KEY (civilization_id)
    	REFERENCES civilization_stats(civilization_id)
);

CREATE TYPE number_array AS VARRAY(4) OF NUMBER;

CREATE TABLE battle_stats ( 
    civilization_id NUMBER NOT NULL, 
    num_battle NUMBER NOT NULL, 
    wood_acquired NUMBER, 
    iron_acquired NUMBER, 
    win NUMBER CHECK (win IN (0, 1)),
    civilizationLoses number_array,
    EnemyLoses number_array,
    PRIMARY KEY(civilization_id, num_battle), 
  	CONSTRAINT fk_civilization_battle
    	FOREIGN KEY (civilization_id)
    	REFERENCES civilization_stats(civilization_id)
);


CREATE TABLE civilization_unit_stats ( 
    civilization_id NUMBER NOT NULL, 
    num_battle NUMBER NOT NULL, 
    type VARCHAR2(20), 
    initial_attack NUMBER, 
    drops NUMBER, 
    PRIMARY KEY(civilization_id, num_battle, type), 
    CONSTRAINT ck_type_unit_stats CHECK (type IN ('Swordsman','Spearman','Crossbow','Cannon')  ),
  	CONSTRAINT fk_unit_stats
    	FOREIGN KEY (civilization_id, num_battle)
    	REFERENCES battle_stats(civilization_id, num_battle)
);

CREATE TABLE enemy_unit_stats ( 
    civilization_id NUMBER NOT NULL, 
    num_battle NUMBER NOT NULL, 
    type VARCHAR2(20), 
    initial_enemy_attack NUMBER, 
    drops NUMBER, 
    PRIMARY KEY(civilization_id, num_battle, type), 
    CONSTRAINT ck_type_enemy_stats CHECK (type IN ('Swordsman','Spearman','Crossbow','Cannon')  ),
  	CONSTRAINT fk_enemy_stats
    	FOREIGN KEY (civilization_id, num_battle)
    	REFERENCES battle_stats(civilization_id, num_battle)
);

CREATE TABLE battle_log (
    civilization_id NUMBER NOT NULL, 
    num_battle NUMBER NOT NULL, 
    log_entry CLOB,
    PRIMARY KEY(civilization_id,num_battle),
  	CONSTRAINT fk_civilization_battle_log
    	FOREIGN KEY (civilization_id, num_battle)
    	REFERENCES battle_stats(civilization_id, num_battle)
);