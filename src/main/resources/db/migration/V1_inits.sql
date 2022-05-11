CREATE TABLE IF NOT EXISTS genres
(
    genre_id  SERIAL PRIMARY KEY,
    genre_name      VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS countries
(
    country_id  SERIAL PRIMARY KEY,
    country_name        VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS movie_countries
(
    movie_id  SERIAL PRIMARY KEY,
    country_id       PRIMARY KEY
);

create table movie (
                       movie_id SERIAL primary key,
                       name_target VARCHAR (150) UNIQUE NOT NULL,
                       name_origin VARCHAR (150) UNIQUE NOT NULL,
                       year_of_realise VARCHAR (150),
                       description VARCHAR (1024),
                       rating NUMERIC(3, 1),
                       price NUMERIC(6, 2),
                       picture_path VARCHAR (1024),
                       genres VARCHAR REFERENCES genre(genre_id),
                       countries VARCHAR REFERENCES country(country_id),
                       reviews VARCHAR REFERENCES review(review_id)
);