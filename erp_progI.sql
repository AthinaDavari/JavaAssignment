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
  `id` int PRIMARY KEY,
  `name` varchar(255),
  `supplier_id` int NOT NULL,
  `quantity` int,
  `price` double
);

CREATE TABLE `Products` (
  `id` int PRIMARY KEY,
  `name` varchar(255),
  `created_at` datetime DEFAULT (now()),
  `quantity` int,
  `price` double
);

CREATE TABLE `S_Orders` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `supplier_id` int UNIQUE NOT NULL,
  `status` ENUM ('delivered', 'pending'),
  `created_at` datetime DEFAULT (now())
);

CREATE TABLE `C_Orders` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `customer_id` int UNIQUE NOT NULL,
  `status` ENUM ('preparing', 'ready', 'delivered'),
  `created_at` datetime DEFAULT (now())
);

CREATE TABLE `C_order_items` (
  `c_order_id` int,
  `product_id` int,
  `quantity` int DEFAULT 1
);

CREATE TABLE `S_order_items` (
  `s_order_id` int,
  `raw_material_id` int,
  `quantity` int DEFAULT 1
);

CREATE TABLE `P_Materials` (
  `product_id` int,
  `raw_material_id` int,
  `quantity_of_raw_material` int
);

ALTER TABLE `Raw_Materials` ADD FOREIGN KEY (`supplier_id`) REFERENCES `Suppliers` (`id`);

ALTER TABLE `S_Orders` ADD FOREIGN KEY (`supplier_id`) REFERENCES `Suppliers` (`id`);

ALTER TABLE `C_Orders` ADD FOREIGN KEY (`customer_id`) REFERENCES `Customers` (`id`);

ALTER TABLE `C_order_items` ADD FOREIGN KEY (`c_order_id`) REFERENCES `C_Orders` (`id`);

ALTER TABLE `C_order_items` ADD FOREIGN KEY (`product_id`) REFERENCES `Products` (`id`);

ALTER TABLE `S_order_items` ADD FOREIGN KEY (`s_order_id`) REFERENCES `S_Orders` (`id`);

ALTER TABLE `S_order_items` ADD FOREIGN KEY (`raw_material_id`) REFERENCES `Raw_Materials` (`id`);

ALTER TABLE `P_Materials` ADD FOREIGN KEY (`product_id`) REFERENCES `Products` (`id`);

ALTER TABLE `P_Materials` ADD FOREIGN KEY (`raw_material_id`) REFERENCES `Raw_Materials` (`id`);
