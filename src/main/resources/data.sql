

INSERT INTO ROLE(role_id,role)values (1,'ROLE_BUYER');
INSERT INTO ROLE(role_id,role)values (2,'ROLE_SELLER');
INSERT INTO ROLE(role_id,role)values (3,'ROLE_ADMIN');

INSERT INTO users(userid,active, password, role, username) VALUES (1,true, '$2a$10$rogFUcz/km4zg0P/Xb87Te4g1AlHtstVXZ6JhobQMYdqoubJm13tq', 1,'buyer' );
INSERT INTO users(userid,active, password, role, username) VALUES (2,true, '$2a$10$1oLXiDTTH8HsSGYt9CLy/OmcZwoTTNKcai0kTV0dr2lm5x96XI4f6', 2,'seller' );
INSERT INTO users(userid,active, password, role, username) VALUES (3,true, '$2a$10$as2nHg1n.VMRKsdsbbwHLu0FF9ETOGIZbibun0.cJDcZGoFkZZiF2', 3,'admin' );

INSERT INTO PERSON(person_id,first_name,last_name,user_account_id) VALUES (1,'Alex','Michu',1);
INSERT INTO PERSON(person_id,first_name,last_name,user_account_id) VALUES (2,'Brian','Emile',2);
INSERT INTO PERSON(person_id,first_name,last_name,user_account_id) VALUES (3,'Dereje','Kenno',3);

INSERT INTO product(category, description, product_name, unit_price) VALUES ( 'electronics', 'Mac16GB', 'MacLaptop',1600 );
INSERT INTO product(category, description, product_name, unit_price) VALUES ( 'dressing', 'men pants', 'blue jeans',150 );