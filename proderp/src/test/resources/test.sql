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
       ('PetaloudaA.E.', 'Palaiologou 156', 2103789023, 'info@petalouda.gr'),
       ('Titanium Fabrication Corporation', 'Palaiologou 156', 2103789023, 'info@tfc.gr');
insert into users(full_name, user_name, password, role)
values  ('athina', 'ath', aes_encrypt('asdfg','prod'), 'admin'),
        ('maria','maria', aes_encrypt('1234','prod'),'admin'),
        ('natalia', 'nat', aes_encrypt('12345', 'prod'),'simpleuser');
insert into s_orders(supplier_id, status, created_at)
values (1, 'pending', '2019-12-14 20:02:43'),
       (2, 'delivered', '2018-11-13 11:04:45'),
       (2, 'pending', '2019-08-12 21:02:01'),
       (1, 'delivered', '2019-08-16 09:02:43');
insert into Customers (full_name,address,phonenumber,email)
values ('Ora Gia Podilato', 'Tositsa 45', 2109237849, 'info@oragiapodilato.com'),
       ('Mouzouris', 'Markou 14', 2104534790, 'info@mouzouris.com'),
       ('BikeMall', 'Patision 18', 2136789267, 'info@bikemall.com');
insert into products(name, quantity, price)
values('Orient City Classic', 10, 479.65),
      ('GT Air 20', 32, 567.34),
      ('Bullet Freestyle 20', 25, 235.69),
      ('Olmo Graffito 20', 33, 800.99),
      ('Scott Volt X20', 50, 1000.0);
insert into raw_materials(name, supplier_id, quantity, price) 
values ('plastic', 1, 47, 0.25),
       ('metal', 2, 32, 1.2),
       ('wood', 2, 17, 3.7),
       ('Plastic', 2, 47, 3.25),
       ('Titanium', 1, 32, 15.2);
insert into c_orders(customer_id, status, user_name, created_at)
values (3, 'preparing', 'nat', '2019-01-12 08:02:01'),
       (1, 'ready', 'nat', '2019-05-12 11:02:59'),
       (1, 'delivered', 'nat', '2017-02-28 17:02:01');
insert into c_order_items(c_order_id, product_id, quantity)
values (3,  5, 100),
       (3, 2, 49);
insert into p_materials(product_id, raw_material_id, quantity_of_raw_material)
values (3, 4, 50),
       (1, 3, 180),
       (1, 4, 20),
       (4, 2, 39),
       (2, 1, 78);