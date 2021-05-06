DROP TABLE IF EXISTS field CASCADE;
DROP TABLE IF EXISTS crop;
DROP TABLE IF EXISTS soil_humidity;
DROP TABLE IF EXISTS saturated_over_water;

CREATE TABLE IF NOT EXISTS field
(
    id INT,
    longitude DOUBLE PRECISION NOT NULL,
    latitude  DOUBLE PRECISION NOT NULL,
    soil_type VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS crop
(
    id            INT GENERATED ALWAYS AS IDENTITY,
    field_id      INT          NOT NULL,
    start_date    BIGINT       NOT NULL,
    culture       VARCHAR(255) NOT NULL,
    type          VARCHAR(255) NOT NULL,
    current_stage INT          NOT NULL,
    depth         INT          NOT NULL,
    fngcd         BOOLEAN      NOT NULL,
    rate          INT          NOT NULL,
    strt          INT          NOT NULL,
    pod           INT          NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_field FOREIGN KEY (field_id) REFERENCES field (id)
);

CREATE TABLE IF NOT EXISTS soil_humidity
(
    id         INT GENERATED ALWAYS AS IDENTITY,
    soil_name  VARCHAR(255) NOT NULL,
    moisture   FLOAT        NOT NULL,
    wilting    FLOAT        NOT NULL,
    water      FLOAT        NOT NULL,
    saturation FLOAT        NOT NULL
);

CREATE TABLE IF NOT EXISTS saturated_over_water
(
    temp  INT UNIQUE NOT NULL,
    zero  FLOAT      NOT NULL,
    one   FLOAT      NOT NULL,
    two   FLOAT      NOT NULL,
    three FLOAT      NOT NULL,
    four  FLOAT      NOT NULL,
    five  FLOAT      NOT NULL,
    six   FLOAT      NOT NULL,
    seven FLOAT      NOT NULL,
    eight FLOAT      NOT NULL,
    nine  FLOAT      NOT NULL,
    PRIMARY KEY (temp)
);