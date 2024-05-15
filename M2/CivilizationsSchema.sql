CREATE TABLE civilization_stats ( 
    civilization_id NUMBER PRIMARY KEY, 
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
    battles_counter NUMBER 
);

CREATE TABLE attack_unit_stats ( 
    attack_unit_id NUMBER PRIMARY KEY, 
    civilization_id NUMBER NOT NULL, 
    type VARCHAR2(20), 
    armor NUMBER, 
    base_damage NUMBER, 
    experience NUMBER, 
    sanctified CHAR(1), 
    CONSTRAINT ck_type_unit_attack CHECK (type IN ('Swordsman', 'Spearman', 'Crossbow', 'Cannon')),
  	CONSTRAINT fk_civilization_unit_attack
    	FOREIGN KEY (civilization_id)
    	REFERENCES civilization_stats(civilization_id)
);

CREATE TABLE special_unit_stats ( 
    special_unit_id NUMBER PRIMARY KEY, 
    civilization_id NUMBER NOT NULL, 
    type VARCHAR2(20), 
    armor NUMBER, 
    base_damage NUMBER, 
    experience NUMBER, 
    CONSTRAINT ck_type_unit_special CHECK (type IN ('Magician','Priest')),
  	CONSTRAINT fk_civilization_unit_special
    	FOREIGN KEY (civilization_id)
    	REFERENCES civilization_stats(civilization_id)
);

CREATE TABLE defence_unit_stats ( 
    defence_unit_id NUMBER PRIMARY KEY, 
    civilization_id NUMBER NOT NULL, 
    type VARCHAR2(20), 
    armor NUMBER, 
    base_damage NUMBER, 
    experience NUMBER, 
    sanctified CHAR(1), 
    CONSTRAINT ck_type_unit_defence CHECK (type IN ('ArrowTower','Catapult','RocketLauncherTower') ),
  	CONSTRAINT fk_civilization_unit_defence
    	FOREIGN KEY (civilization_id)
    	REFERENCES civilization_stats(civilization_id)
);

CREATE TABLE battle_stats ( 
    civilization_id NUMBER NOT NULL, 
    num_battle NUMBER NOT NULL, 
    wood_acquired NUMBER, 
    iron_acquired NUMBER, 
    PRIMARY KEY(civilization_id, num_battle), 
  	CONSTRAINT fk_civilization_battle
    	FOREIGN KEY (civilization_id)
    	REFERENCES civilization_stats(civilization_id)
);


CREATE TABLE civilization_attack_stats ( 
    civilization_id NUMBER NOT NULL, 
    num_battle NUMBER NOT NULL, 
    type VARCHAR2(20), 
    initial_attack NUMBER, 
    drops NUMBER, 
    PRIMARY KEY(civilization_id, num_battle, type), 
    CONSTRAINT ck_type_attack CHECK (type IN ('Swordsman','Spearman','Crossbow','Cannon')  ),
  	CONSTRAINT fk_civilization_attack
    	FOREIGN KEY (civilization_id, num_battle)
    	REFERENCES battle_stats(civilization_id, num_battle)
);

CREATE TABLE civilization_defense_stats ( 
    civilization_id NUMBER NOT NULL, 
    num_battle NUMBER NOT NULL, 
    type VARCHAR2(20), 
    initial_defence NUMBER, 
    drops NUMBER, 
    PRIMARY KEY(civilization_id, num_battle, type), 
    CONSTRAINT ck_type_defence CHECK (type IN ('Magician','Priest')),
  	CONSTRAINT fk_civilization_defence
    	FOREIGN KEY (civilization_id, num_battle)
    	REFERENCES battle_stats(civilization_id, num_battle)
);


CREATE TABLE civilization_special_stats ( 
    civilization_id NUMBER NOT NULL, 
    num_battle NUMBER NOT NULL, 
    type VARCHAR2(20), 
    initial_special NUMBER, 
    drops NUMBER, 
    PRIMARY KEY(civilization_id, num_battle, type), 
    CONSTRAINT ck_type_special CHECK (type IN ('ArrowTower','Catapult','RocketLauncherTower') ),
  	CONSTRAINT fk_civilization_special
    	FOREIGN KEY (civilization_id, num_battle)
    	REFERENCES battle_stats(civilization_id, num_battle)
);

CREATE TABLE enemy_attack_stats ( 
    civilization_id NUMBER NOT NULL, 
    num_battle NUMBER NOT NULL, 
    type VARCHAR2(20), 
    initial_enemy_attack NUMBER, 
    drops NUMBER, 
    PRIMARY KEY(civilization_id, num_battle, type), 
    CONSTRAINT ck_type_enemy_attack CHECK (type IN ('Swordsman','Spearman','Crossbow','Cannon')  ),
  	CONSTRAINT fk_civilization_enemy_attack
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