ROLLBACK;


-- Create the preference_stack table
CREATE TABLE preference_stack (
  id SERIAL PRIMARY KEY,
  user_id INT
);

-- Create the preference_stack_nutrient_group table
CREATE TABLE preference_stack_nutrient_group (
  preference_stack_id INT,
  nutrient_group_id INT,
  FOREIGN KEY (preference_stack_id) REFERENCES preference_stack (id),
  FOREIGN KEY (nutrient_group_id) REFERENCES nutrient_group (id)
);

-- Create the nutrient table
CREATE TABLE nutrient (
  id SERIAL PRIMARY KEY,
  nutrient_group_id INT,
  name VARCHAR(255),
  unit VARCHAR(255),
  FOREIGN KEY (nutrient_group_id) REFERENCES nutrient_group (id)
);

-- Create the nutrient_range table
CREATE TABLE nutrient_range (
  id SERIAL PRIMARY KEY,
  nutrient_id INT,
  min INT,
  max INT,
  score DOUBLE PRECISION,
  FOREIGN KEY (nutrient_id) REFERENCES nutrient (id)
);

-- Insert sample data into the preference_stack table
INSERT INTO preference_stack (user_id)
VALUES (1);

-- Insert sample data into the preference_stack_nutrient_group table
INSERT INTO preference_stack_nutrient_group (preference_stack_id, nutrient_group_id)
VALUES (1, 1),
       (1, 2),
       (1, 3);

-- Insert sample data into the nutrient table
INSERT INTO nutrient (nutrient_group_id, name, unit)
VALUES (1, 'protein', 'g'),
       (1, 'iron', 'mg'),
       (3, 'seed oil', NULL);

-- Insert sample data into the nutrient_range table
INSERT INTO nutrient_range (nutrient_id, min, max, score)
VALUES (1, 0, 10, 0.2),
       (1, 11, 20, 0.5),
       (1, 21, 1000000, 0.7),
       (2, 0, 5, 0.2),
       (2, 6, 15, 0.5),
       (2, 16, 1000000, 0.7);





-- Create the product table
CREATE TABLE product (
  id SERIAL PRIMARY KEY,
  gtin_upc VARCHAR(255)
);

-- Create the nutrient_group table
CREATE TABLE nutrient_group (
  id SERIAL PRIMARY KEY,
  group_name VARCHAR(255),
  weight DOUBLE PRECISION
);

-- Create the product_nutrient table
CREATE TABLE product_nutrient (
  id SERIAL PRIMARY KEY,
  product_id INT,
  nutrient_group_id INT,
  name VARCHAR(255),
  unit VARCHAR(255),
  amount DOUBLE PRECISION,
  FOREIGN KEY (product_id) REFERENCES product (id),
  FOREIGN KEY (nutrient_group_id) REFERENCES nutrient_group (id)
);

-- Insert sample data into the product table
INSERT INTO product (gtin_upc)
VALUES ('1');

-- Insert sample data into the nutrient_group table
INSERT INTO nutrient_group (group_name, weight)
VALUES ('macro', 0.5),
       ('micro', 0.3),
       ('ingredient', 0.2);

-- Insert sample data into the product_nutrient table
INSERT INTO product_nutrient (product_id, nutrient_group_id, name, unit, amount)
VALUES (1, 1, 'protein', 'g', 10.0),
       (1, 1, 'iron', 'mg', 15.0),
       (1, 1, 'seed oil', NULL, NULL);
