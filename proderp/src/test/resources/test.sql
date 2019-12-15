SET FOREIGN_KEY_CHECKS=0;
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
SET FOREIGN_KEY_CHECKS=1;
insert into suppliers(full_name, address, phonenumber, email) 
values ('SideroA.E.', 'A.Papadreou 30', 2105678934, 'info@sidero.gr'),
       ('PetaloudaA.E.', 'Palaiologou 156', 2103789023, 'info@petalouda.gr');
insert into users(full_name, user_name, password, role)
values  ("athina", "ath", aes_encrypt("asdfg","prod"), 'admin'),
        ("maria","maria", aes_encrypt("1234","prod"),'admin'),
        ("natalia", "nat", aes_encrypt("12345", "prod"),'simpleuser');
insert into s_orders(supplier_id, status, created_at)
values (1, "pending", "2019-12-14 20:02:43"),
       (2, "delivered", "2018-11-13 11:04:45"),
       (2, "pending", "2019-08-12 21:02:01"),
       (1, "delivered", "2019-08-16 09:02:43");
insert into Customers (full_name,address,phonenumber,email)
values ("Ora Gia Podilato", "Tositsa 45", 2109237849, "info@oragiapodilato.com"),
       ("Mouzouris", "Markou 14", 2104534790, "info@mouzouris.com"),
       ("BikeMall", "Patision 18", 2136789267, "info@bikemall.com");
