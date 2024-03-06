CREATE TABLE client (
                        id serial not null primary key,
                        name varchar(70) not null,
                        email varchar(70) not null unique,
                        password varchar(100) not null
);

CREATE TABLE product (
                         id serial not null primary key,
                         name varchar(70) not null,
                         type varchar(70) not null,
                         description varchar(100) not null,
                         price numeric(10,2) not null
);

CREATE TABLE cart (
                      id serial not null primary key,
                      total numeric(10,2) not null,
                      id_client int not null,
                      FOREIGN KEY (id_client) REFERENCES client (id)
);

CREATE TABLE productquantity (
                         id serial not null primary key,
                         quantity int not null,
                         id_cart int not null,
                         id_product int not null,
                         FOREIGN KEY (id_cart) REFERENCES cart (id),
                         FOREIGN KEY (id_product) REFERENCES product (id)
);

