CREATE TABLE IF NOT EXISTS category (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);
INSERT INTO category (id, name) VALUES (1, 'Pizza');
INSERT INTO category (id, name) VALUES (2, 'Drinks');

CREATE TABLE IF NOT EXISTS dish (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    category_id INT,
    FOREIGN KEY (category_id) REFERENCES category(id) ON DELETE CASCADE
);

INSERT INTO dish (id, name, price, category_id) VALUES (1, 'Margherita', 12.99, 1);
INSERT INTO dish (id, name, price, category_id) VALUES (2, 'Coke', 1.99, 2);

CREATE TABLE IF NOT EXISTS customer (
    id INT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);

INSERT INTO customer (id, first_name, last_name, email) VALUES (1, 'John', 'Doe', 'john.doe@example.com');

CREATE TABLE IF NOT EXISTS restaurant (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    location VARCHAR(100),
    contact_number VARCHAR(20)
 );
INSERT INTO restaurant (id, name, location, contact_number) VALUES (1, 'Pizzeria', 'Main Street', '+123456789');

CREATE TABLE IF NOT EXISTS purchase (
    id INT PRIMARY KEY,
    dish_id INT,
    quantity INT NOT NULL,
    total_price DECIMAL(10, 2) NOT NULL,
    customer_id INT,
    FOREIGN KEY (dish_id) REFERENCES dish(id) ON DELETE CASCADE,
    FOREIGN KEY (customer_id) REFERENCES customer(id) ON DELETE CASCADE
);
INSERT INTO purchase (id, dish_id, quantity, total_price, customer_id) VALUES (1, 1, 2, 25.98, 1);
