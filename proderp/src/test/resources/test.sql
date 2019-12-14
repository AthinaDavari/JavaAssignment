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
insert into suppliers(full_name, address, phonenumber, email) 
values ('SideroA.E.', 'A.Papadreou 30', 2105678934, 'info@sidero.gr'),
       ('PetaloudaA.E.', 'Palaiologou 156', 2103789023, 'info@petalouda.gr');
insert into users(full_name, user_name, password, role)
values  ("athina", "ath", aes_encrypt("asdfg","prod"), 'admin'),
        ("maria","maria", aes_encrypt("1234","prod"),'admin'),
        ("natalia", "nat", aes_encrypt("12345", "prod"),'simpleuser');
