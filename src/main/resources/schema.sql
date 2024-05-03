CREATE TABLE IF NOT EXISTS products
(
    id               TEXT PRIMARY KEY,
    chip_image       TEXT NOT NULL,
    more_description TEXT,
    price            TEXT,
    installments     TEXT,
    short_spec       TEXT,
    colors           TEXT
);