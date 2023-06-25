DROP TABLE IF EXISTS nutrient_range CASCADE;
DROP TABLE IF EXISTS preference_priority_nutrient CASCADE;
DROP TABLE IF EXISTS preference_priority CASCADE;
DROP TABLE IF EXISTS nutrient CASCADE;
DROP TABLE IF EXISTS nutrient_group CASCADE;
DROP TABLE IF EXISTS preference CASCADE;

CREATE TABLE nutrient_group (
    nutrient_group_name varchar(20) PRIMARY KEY,
    weight DECIMAL(4, 4),
    CONSTRAINT check_decimal_range CHECK (weight > 0 AND weight < 1)
);

CREATE TABLE nutrient (
    nutrient_name VARCHAR(50) PRIMARY KEY,
    unit varchar(10),
    nutrient_group_name varchar(20) NOT NULL,
    FOREIGN KEY (nutrient_group_name) REFERENCES nutrient_group (nutrient_group_name)
);

CREATE TABLE preference (
    preference_id SERIAL PRIMARY KEY,
    preference_name VARCHAR(50) NOT NULL
);

CREATE TABLE preference_priority (
    preference_priority_id SERIAL PRIMARY KEY,
    priority_level int NOT NULL,
    preference_id INT NOT NULL,
    FOREIGN KEY (preference_id) REFERENCES preference (preference_id)
);

CREATE TABLE preference_priority_nutrient (
    preference_priority_nutrient_id SERIAL PRIMARY KEY,
    preference_priority_id INT NOT NULL,
    preference_nutrient_id INT NOT NULL,
    FOREIGN KEY (preference_priority_id) REFERENCES preference_priority (preference_priority_id)
);

CREATE TABLE nutrient_range (
    nutrient_range_id SERIAL PRIMARY KEY,
    x_min DECIMAL(7, 2),
    y_min DECIMAL(7, 2),
    x_max DECIMAL(7, 2),
    y_max DECIMAL(7, 2),
    preference_priority_nutrient_id INT NOT NULL,
    FOREIGN KEY (preference_priority_nutrient_id) REFERENCES preference_priority_nutrient (preference_priority_nutrient_id)
);
