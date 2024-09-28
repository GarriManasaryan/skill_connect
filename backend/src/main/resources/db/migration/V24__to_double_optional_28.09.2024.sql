alter table sc_features_numeric ALTER COLUMN to_value drop not null;
ALTER TABLE sc_features_numeric
ALTER COLUMN to_value TYPE float8 USING to_value::float8;
ALTER TABLE sc_features_numeric
ALTER COLUMN from_value TYPE float8 USING from_value::float8;