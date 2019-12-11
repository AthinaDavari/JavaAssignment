drop schema erp_progIITest;
CREATE DATABASE erp_progIITest;
USE erp_progIITest;

CREATE TABLE `Users`(
`full_name` varchar(255),
`username` varchar(255) PRIMARY KEY,
`password` varbinary(255),
`role` int
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
  FOREIGN KEY (`supplier_id`) REFERENCES `Suppliers` (`id`)
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
  FOREIGN KEY (`supplier_id`) REFERENCES `Suppliers` (`id`)
);

CREATE TABLE `C_Orders` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  `status` ENUM ('preparing', 'ready', 'delivered'),
  `created_at` datetime DEFAULT now(),
  `username` varchar(255) NOT NULL,
  FOREIGN KEY (`customer_id`) REFERENCES `Customers` (`id`),
  FOREIGN KEY (`username`) REFERENCES `Users` (`username`)

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