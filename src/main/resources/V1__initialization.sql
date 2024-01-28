CREATE TABLE urls (
    url_id int NOT NULL,
    long_url varchar(1024) NOT NULL,
    short_url varchar(80) NOT NULL,
    key_value varchar(30) NOT NULL,
    CONSTRAINT urls_pk PRIMARY KEY (url_id, long_url, key_value)
);

CREATE SEQUENCE url_sequence START 1 INCREMENT 1;