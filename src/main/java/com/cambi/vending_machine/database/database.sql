CREATE TABLE nutrient_group (
	nutrient_group_id SERIAL PRIMARY KEY,
	nutrient_group_name ENUM('macro', 'micro', 'ingredient') NOT NULL
);

CREATE TABLE nutrient (
	nutrient_id SERIAL PRIMARY KEY,
	nutrient_name VARCHAR(50) NOT NULL,
	unit ENUM('g', 'mg', 'μg', 'oz', NULL),
	nutrient_group_id INT,
	FOREIGN KEY (nutrient_group_id) REFERENCES nutrient_group (nutrient_group_id)
);

CREATE TABLE product (
	product_id SERIAL PRIMARY KEY,
	gtin_upc VARCHAR(14) NOT NULL
);

CREATE TABLE product_nutrient (
	amount INT,
	product_id INT,
	nutrient_id INT,
	FOREIGN KEY (product_id) REFERENCES product (product_id),
	FOREIGN KEY (nutrient_id) REFERENCES nutrient (nutrient_id)
);

CREATE TABLE preference (
	preference_id SERIAL PRIMARY KEY,
	preference_name VARCHAR(50),
	priority ENUM('0', '1', '2', '3') NOT NULL
);

CREATE TABLE nutrient_range (
	minimum DECIMAL(5, 2),
	maximum DECIMAL(5, 2),
	slope DECIMAL(5, 2),
	preference_id INT,
	nutrient_id INT,
	FOREIGN KEY (preference_id) REFERENCES preference (preference_id),
	FOREIGN KEY (nutrient_id) REFERENCES nutrient (nutrient_id)
);




-- nutrient group table table would only include these 3 do I use ENUM or make it read only somehow
-- product table ups are at max 14 chars is this a good idea to restrict it to 14