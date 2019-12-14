ALTER TABLE Raw_Materials DROP FOREIGN KEY raw_mat_sup;
ALTER TABLE S_Orders DROP FOREIGN KEY s_orsre_sup;
ALTER TABLE C_Orders DROP FOREIGN KEY c_order_cust;
ALTER TABLE C_Orders DROP FOREIGN KEY c_order_u;
ALTER TABLE C_order_items DROP FOREIGN KEY c_order_i_c_ord;
ALTER TABLE C_order_items DROP FOREIGN KEY c_order_pr;
ALTER TABLE S_order_items DROP FOREIGN KEY s_order_items_s_order;
ALTER TABLE S_order_items DROP FOREIGN KEY s_order_items_r_mat;
ALTER TABLE P_Materials DROP FOREIGN KEY p_mat_pr;
ALTER TABLE P_Materials DROP FOREIGN KEY p_mat_r_mat;
truncate P_Materials;
truncate S_order_items;
truncate C_order_items;
truncate C_orders;
truncate S_Orders;
truncate Products;
truncate Raw_Materials;
truncate Customers;
truncate Suppliers;
truncate Users; 
ALTER TABLE Raw_Materials ADD CONSTRAINT raw_mat_sup FOREIGN KEY (`supplier_id`) REFERENCES `Suppliers` (`id`) on delete cascade;
ALTER TABLE S_Orders ADD CONSTRAINT s_orsre_sup FOREIGN KEY (`supplier_id`) REFERENCES `Suppliers` (`id`) on delete cascade;
ALTER TABLE C_Orders ADD CONSTRAINT c_order_cust FOREIGN KEY (`customer_id`) REFERENCES `Customers` (`id`) on delete cascade;
ALTER TABLE C_Orders ADD CONSTRAINT c_order_u FOREIGN KEY (`user_name`) REFERENCES `Users` (`user_name`) on delete cascade;
ALTER TABLE C_order_items ADD CONSTRAINT c_order_i_c_ord FOREIGN KEY (`c_order_id`) REFERENCES `C_Orders` (`id`) on delete cascade;
ALTER TABLE C_order_items ADD CONSTRAINT c_order_pr FOREIGN KEY (`product_id`) REFERENCES `Products` (`id`) on delete cascade;
ALTER TABLE S_order_items ADD CONSTRAINT s_order_items_s_order FOREIGN KEY (`s_order_id`) REFERENCES `S_Orders` (`id`) on delete cascade;
ALTER TABLE S_order_items ADD CONSTRAINT s_order_items_r_mat FOREIGN KEY (`raw_material_id`) REFERENCES `Raw_Materials` (`id`) on delete cascade;
ALTER TABLE P_Materials ADD CONSTRAINT p_mat_pr FOREIGN KEY (`product_id`) REFERENCES `Products` (`id`) on delete cascade;
ALTER TABLE P_Materials ADD CONSTRAINT p_mat_r_mat FOREIGN KEY (`raw_material_id`) REFERENCES `Raw_Materials` (`id`) on delete cascade;
insert into suppliers(full_name, address, phonenumber, email) 
values ('SideroA.E.', 'A.Papadreou 30', 2105678934, 'info@sidero.gr'),
       ('PetaloudaA.E.', 'Palaiologou 156', 2103789023, 'info@petalouda.gr');
insert into users(full_name, user_name, password, role)
values  ("athina", "ath", aes_encrypt("asdfg","prod"), 'admin'),
        ("maria","maria", aes_encrypt("1234","prod"),'admin'),
        ("natalia", "nat", aes_encrypt("12345", "prod"),'simpleuser');
