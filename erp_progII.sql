-- drop schema proderp;
CREATE DATABASE proderp;
USE proderp;

CREATE TABLE `Users`(
`full_name` varchar(255),
`username` varchar(255) primary key,
`password` varchar(255),
`role` int
);

CREATE TABLE `Suppliers` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `full_name` varchar(255),
  `address` varchar(255),
  `phonenumber` int,
  `email` varchar(255)
);

CREATE TABLE `Customers` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `full_name` varchar(255),
  `address` varchar(255),
  `phonenumber` int,
  `email` varchar(255)
);

CREATE TABLE `Raw_Materials` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255),
  `supplier_id` int NOT NULL,
  `quantity` int,
  `price` double,
  FOREIGN KEY (`supplier_id`) REFERENCES `Suppliers` (`id`)
);

CREATE TABLE `Products` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255),
  `quantity` int,
  `price` double
);

CREATE TABLE `S_Orders` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `supplier_id` int UNIQUE NOT NULL,
  `status` ENUM ('delivered', 'pending'),

  `created_at` datetime DEFAULT now(),
  FOREIGN KEY (`supplier_id`) REFERENCES `Suppliers` (`id`)
);

CREATE TABLE `C_Orders` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `customer_id` int UNIQUE NOT NULL,
  `status` ENUM ('preparing', 'ready', 'delivered'),
  `created_at` datetime DEFAULT now(),
  `username` varchar(255) NOT NULL,
  FOREIGN KEY (`customer_id`) REFERENCES `Customers` (`id`),
  FOREIGN KEY (`users_id`) REFERENCES `Users` (`id`)
);

CREATE TABLE `C_order_items` (
  `c_order_id` int,
  `product_id` int,
  `quantity` int DEFAULT 1,
  primary key(c_order_id, product_id),
  FOREIGN KEY (`c_order_id`) REFERENCES `C_Orders` (`id`),
  FOREIGN KEY (`product_id`) REFERENCES `Products` (`id`)
);

CREATE TABLE `S_order_items` (
  `s_order_id` int,
  `raw_material_id` int,
  `quantity` int DEFAULT 1,
  primary key(s_order_id, raw_material_id),
  FOREIGN KEY (`s_order_id`) REFERENCES `S_Orders` (`id`),
  FOREIGN KEY (`raw_material_id`) REFERENCES `Raw_Materials` (`id`)
);

CREATE TABLE `P_Materials` (
  `product_id` int,
  `raw_material_id` int,
  `quantity_of_raw_material` int,
  primary key(product_id, raw_material_id),
  FOREIGN KEY (`product_id`) REFERENCES `Products` (`id`),
  FOREIGN KEY (`raw_material_id`) REFERENCES `Raw_Materials` (`id`)
);



-- INSERTS
insert into suppliers(full_name, address, phonenumber, email) 
values("SideroA.E.", "A.Papadreou 30", 2105678934, "info@sidero.gr"),
	  ("PetaloudaA.E.", "Palaiologou 156", 2103789023, "info@petalouda.gr");
      
insert into products(name, quantity, price)
values("Merenda Pavlidis", 10, 47.65),
	  ("Nucrema ION", 32, 125.34),
      ("Nutella Kinder", 25, "87.69");

insert into raw_materials(name, supplier_id, quantity, price) 
values ("plastic", 2, 47, 0.25),
	   ("metal", 1, 32, 1.2),
       ("wood", 1, 17, 3.7);
       
insert into s_orders(supplier_id,status) 
values (1,'delivered');
       
insert into users(full_name,user_name, password,role)
values  ("athina", "ath", aes_decrypt("asdfg","prod"), 1),
        ("natalia", "nat", aes_decrypt("12345", "prod"), 2);
     
insert into Customers (full_name,address,phonenumber,email)
values ("Papadopoulos", "Mousitsa 56", 345678, "papadopoulos@gmail.com"),
       ("Mouzouris", "Markou 14", 987560, "mouz@gmail.com");

select * from products;
select * from S_Orders;
select * from Customers;