CREATE TABLE movies
(
    id            SERIAL PRIMARY KEY,
    name_translate          VARCHAR(30)   NOT NULL,
    price         NUMERIC(9, 2) NOT NULL,
    creation_at DATE DEFAULT Now()
);

INSERT INTO movies (name_translate, price, creation_at)
VALUES ('Spider-Man', '9.99', '2009-01-01');
INSERT INTO movies (name_translate, price, creation_at)
VALUES ('Venom', '0.99', '2013-11-08');
INSERT INTO movies (name_translate, price, creation_at)
VALUES ('Loki', '1000', '2015-08-11');