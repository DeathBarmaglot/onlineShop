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