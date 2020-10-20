
INSERT INTO users(userid,enabled, password, role, username) VALUES (1,true, '$2a$10$as2nHg1n.VMRKsdsbbwHLu0FF9ETOGIZbibun0.cJDcZGoFkZZiF2', 'ROLE_ADMIN','admin' );
INSERT INTO users(userid,enabled, password, role, username) VALUES (2,true, '$2a$10$rogFUcz/km4zg0P/Xb87Te4g1AlHtstVXZ6JhobQMYdqoubJm13tq', 'ROLE_BUYER','buyer' );
INSERT INTO users(userid,enabled, password, role, username) VALUES (3,true, '$2a$10$1oLXiDTTH8HsSGYt9CLy/OmcZwoTTNKcai0kTV0dr2lm5x96XI4f6', 'ROLE_SELLER','seller' );


INSERT INTO PERSON(person_id,first_name,last_name,user_account_id) VALUES (1,'Dereje','Kenno',1);
INSERT INTO PERSON(person_id,first_name,last_name,user_account_id) VALUES (2,'Alex','Michu',2);
INSERT INTO PERSON(person_id,first_name,last_name,user_account_id) VALUES (3,'Brian','Emile',3);


INSERT INTO product(category, description, product_name, unit_price) VALUES ( 'electronics', 'Mac16GB', 'MacLaptop',1600 );
INSERT INTO product(category, description, product_name, unit_price) VALUES ( 'dressing', 'men pants', 'blue jeans',150 );