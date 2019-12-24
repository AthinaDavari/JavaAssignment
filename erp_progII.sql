 drop schema proderp;
CREATE DATABASE proderp;
USE proderp;

CREATE TABLE `Users`(
`full_name` varchar(255),
`user_name` varchar(255) PRIMARY KEY,
`password` varbinary(255),
`role` ENUM ('admin', 'simpleuser'),
`is_deleted` boolean default false
);

CREATE TABLE `Suppliers` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `full_name` varchar(255),
  `address` varchar(255),
  `phonenumber` int,
  `email` varchar(255),
  `is_deleted` boolean default false
);

CREATE TABLE `Customers` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `full_name` varchar(255),
  `address` varchar(255),
  `phonenumber` int,
  `email` varchar(255),
  `is_deleted` boolean default false
);

CREATE TABLE `Raw_Materials` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255),
  `supplier_id` int NOT NULL,
  `quantity` int,
  `price` double,
  `is_deleted` boolean default false,
  FOREIGN KEY (`supplier_id`) REFERENCES `Suppliers` (`id`) on delete cascade
);

CREATE TABLE `Products` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255),
  `quantity` int,
  `price` double,
  `is_deleted` boolean default false
);

CREATE TABLE `S_Orders` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `supplier_id` int NOT NULL,
  `status` ENUM ('delivered', 'pending'),
  `created_at` datetime DEFAULT now(),
  FOREIGN KEY (`supplier_id`) REFERENCES `Suppliers` (`id`) on delete cascade
);

CREATE TABLE `C_Orders` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  `status` ENUM ('preparing', 'ready', 'delivered'),
  `created_at` datetime DEFAULT now(),
  `user_name` varchar(255) NOT NULL,
  FOREIGN KEY (`customer_id`) REFERENCES `Customers` (`id`) on delete cascade,
  FOREIGN KEY (`user_name`) REFERENCES `Users` (`user_name`) on delete cascade 
);

CREATE TABLE `C_order_items` (
  `c_order_id` int,
  `product_id` int,
  `quantity` int DEFAULT 1,
  primary key(c_order_id, product_id),
  FOREIGN KEY (`c_order_id`) REFERENCES `C_Orders` (`id`) on delete cascade,
  FOREIGN KEY (`product_id`) REFERENCES `Products` (`id`) on delete cascade
);

CREATE TABLE `S_order_items` (
  `s_order_id` int,
  `raw_material_id` int,
  `quantity` int DEFAULT 1,
  primary key(s_order_id, raw_material_id),
  FOREIGN KEY (`s_order_id`) REFERENCES `S_Orders` (`id`) on delete cascade,
  FOREIGN KEY (`raw_material_id`) REFERENCES `Raw_Materials` (`id`) on delete cascade
);

CREATE TABLE `P_Materials` (
  `product_id` int,
  `raw_material_id` int,
  `quantity_of_raw_material` int,
  primary key(product_id, raw_material_id),
  FOREIGN KEY (`product_id`) REFERENCES `Products` (`id`) on delete cascade,
  FOREIGN KEY (`raw_material_id`) REFERENCES `Raw_Materials` (`id`) on delete cascade
);



-- INSERTS
insert into suppliers(full_name, address, phonenumber, email) 
values("INA PLASTICS SA", "A.Papadreou 30", 2105678934, "info@inaplastics.gr"),
	  ("Titanium Fabrication Corporation", "Palaiologou 156", 2103789023, "info@tfc.gr"),
      ("Universal Metals", "Vasileos Georgiou 59", 2103825677, "info@unimetals.gr"),
      ("Salomon’s Metalen", "Anatolikis Romilias 26", 2115027459, "info@salomonsmetalen.gr"),
      ("Toray Carbon Fibers", "Perikleous 89", 2130796782, "info@torays.gr");
      
insert into products(name, quantity, price)
values("Orient City Classic", 10, 479.65),
	  ("GT Air 20", 32, 567.34),
      ("Bullet Freestyle 20", 25, 235.69),
      ("Olmo Graffito 20", 33, 800.99),
      ("Scott Volt X20", 50, 1000.0),
      ("Regina Urban Freestyle 20", 15, 540.56),
      ("Montana Wax S500 20", 35, 1800.00);
      
insert into raw_materials(name, supplier_id, quantity, price) 
values ("plastic", 4, 47, 0.25),
	   ("metal", 3, 32, 1.2),
       ("wood", 3, 17, 3.7),
       ("Plastic", 3, 47, 3.25),
	   ("Titanium", 1, 32, 15.2),
       ("Steel", 4, 7, 3.7),
       ("Aluminum", 2, 7, 5.67),
       ("Carbon fiber", 5, 10, 9.67),
       ("Magnesium", 4, 3, 35.79);

insert into s_orders(supplier_id,status)
values (3,'delivered'),
       (1,'delivered'),
       (2, 'pending'),
       (4, 'delivered'),
       (5, 'pending');
     
insert into Customers (full_name,address,phonenumber,email)
values ("Papadopoulos", "Mousitsa 56", 345678, "papadopoulos@gmail.com"),
       ("Mouzouris", "Markou 14", 987560, "mouz@gmail.com");

-- select * from products;
-- select * from S_Orders;
-- select * from Customers;
-- select * from raw_materials;
-- select * from suppliers;
-- select * from users;
     
insert into users(full_name, user_name, password, role)
values  ("athina", "ath", aes_encrypt("asdfg","prod"), 'admin'),
        ("natalia", "nat", aes_encrypt("12345", "prod"),'simpleuser'),
        ("maria","maria", aes_encrypt("1234","prod"),'admin');
     
insert into Customers (full_name,address,phonenumber,email)
values ("Ora Gia Podilato", "Tositsa 45", 2109237849, "info@oragiapodilato.com"),
       ("Mouzouris", "Markou 14", 2104534790, "info@mouzouris.com"),
       ("BikeMall", "Patision 18", 2136789267, "info@bikemall.com"),
	   ("BikeCompany", "Chamosternas 12", 2109046784, "info@bikecompany.com"),
       ("Marios Papachristou Bikes", "Aiolou 178", 2139037562, "info@mpapbikes.com"),
       ("SuperBikes", "Peiraios 17", 2104828947, "info@superbikes.com"),
       ("Smart Fitness", "Trion Ierarxon 86", 210829894, "info@smartfitness.com");
       
insert into c_orders(customer_id, status, user_name)
values (6, 'preparing', "ath"),
       (7, 'ready', "maria"),
       (1, 'delivered', "maria"),
       (5, 'ready', "nat"),
       (4, 'ready', "ath");
       
insert into s_order_items(s_order_id, raw_material_id, quantity)
values (1, 4, 50),
	   (2, 3, 90),
       (5, 2, 100),
       (3, 1, 27);
       
insert into c_order_items(c_order_id, product_id, quantity)
values (3,  5, 100),
       (3, 2, 49),
       (5, 4, 50),
       (1, 1, 35);
       
insert into p_materials(product_id, raw_material_id, quantity_of_raw_material)
values (5, 5, 80),
       (3, 4, 50),
       (1, 3, 180),
       (4, 2, 39),
       (2, 1, 78);
       
select * from users;
select * from products;
select * from customers;
select * from c_orders;
select last_insert_id();
select * from S_orders;
select * from S_order_items;  
select * from Suppliers;   
Select * from raw_materials;
SELECT max(id) FROM S_Orders;
select full_name, user_name, aes_decrypt( password,"prod"), role from users;
SELECT full_name, user_name, role FROM users WHERE user_name = "nat";