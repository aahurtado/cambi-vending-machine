DROP TABLE IF EXISTS nutrient CASCADE;
DROP TABLE IF EXISTS nutrient_group CASCADE;
DROP TABLE IF EXISTS unit CASCADE;
DROP TABLE IF EXISTS product CASCADE;
DROP TABLE IF EXISTS product_nutrient CASCADE;

CREATE TABLE unit (
	unit_name varchar(20) PRIMARY KEY,
	symbol varchar(5) NOT NULL
);


CREATE TABLE nutrient_group (
    nutrient_group_name varchar(20) PRIMARY KEY
);

CREATE TABLE nutrient (
    nutrient_name VARCHAR(50) PRIMARY KEY,
    unit_name varchar(20),
    nutrient_group_name varchar(20) NOT NULL,
    FOREIGN KEY (nutrient_group_name) REFERENCES nutrient_group (nutrient_group_name),
	FOREIGN KEY (unit_name) REFERENCES unit (unit_name)
);

CREATE TABLE product (
	product_id SERIAL PRIMARY KEY,
	gtin_upc VARCHAR(20) UNIQUE NOT NULL,
	publication_date TIMESTAMP,
	modified_date TIMESTAMP,
	brand_owner VARCHAR(100),
	Food_category VARCHAR(100),
	description VARCHAR(500),
	household_serving_full_text VARCHAR(500),
	serving_size_unit varchar(20),
	serving_size DECIMAL (8, 4),
	CONSTRAINT check_decimal_range CHECK (serving_size > 0),
	FOREIGN KEY (serving_size_unit) REFERENCES unit(unit_name)
);
--need to add something to deal with ids from diferent data sources

CREATE TABLE product_nutrient(
	amount DECIMAL (8, 4),
	CONSTRAINT check_decimal_range CHECK (amount > 0),
	nutrient_name varchar(50) NOT NULL,
	product_id INT NOT NULL,
	FOREIGN KEY (nutrient_name) REFERENCES nutrient (nutrient_name),
	FOREIGN KEY (product_id) REFERENCES product (product_id)
);

INSERT INTO unit (unit_name, symbol) VALUES ('grams', 'g');
INSERT INTO nutrient_group (nutrient_group_name) VALUES ('macro')

INSERT INTO product (gtin_upc, publication_date, modified_date, brand_owner, food_category, description, household_serving_full_text, serving_size_unit, serving_size)
VALUES ('1234567890123', '2022-06-01', '2022-05-15', 'ABC Company', 'Food', 'Sample Product', '2 slices', 'grams', 100);
