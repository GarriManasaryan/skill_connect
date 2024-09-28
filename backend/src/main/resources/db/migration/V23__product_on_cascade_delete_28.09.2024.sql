--fk_category_parent_id
ALTER TABLE sc_categories
DROP CONSTRAINT fk_category_parent_id;

ALTER TABLE sc_categories
ADD constraint fk_category_parent_id foreign key(parent_id) references sc_categories(id) ON DELETE SET NULL;

--fk_features_parent_id
ALTER TABLE sc_features
DROP CONSTRAINT fk_features_parent_id;

ALTER TABLE sc_features
ADD constraint fk_features_parent_id foreign key(parent_id) references sc_features(id) ON DELETE SET NULL;

--fk_features_text_id_to_base
ALTER TABLE sc_features_text
DROP CONSTRAINT fk_features_text_id_to_base;

ALTER TABLE sc_features_text
ADD constraint fk_features_text_id_to_base foreign key(id) references sc_features(id) ON DELETE cascade;

--fk_features_numeric_id_to_base
ALTER TABLE sc_features_numeric
DROP CONSTRAINT fk_features_numeric_id_to_base;

ALTER TABLE sc_features_numeric
ADD constraint fk_features_numeric_id_to_base foreign key(id) references sc_features(id) ON DELETE cascade;

--fk_feature_categories_feature_id
ALTER TABLE sc_feature_categories
DROP CONSTRAINT fk_feature_categories_feature_id;

ALTER TABLE sc_feature_categories
ADD constraint fk_feature_categories_feature_id foreign key(feature_id) references sc_features(id) ON DELETE cascade;

--fk_feature_categories_category_id
ALTER TABLE sc_feature_categories
DROP CONSTRAINT fk_feature_categories_category_id;

ALTER TABLE sc_feature_categories
ADD constraint fk_feature_categories_category_id foreign key(category_id) references sc_categories(id) ON DELETE cascade;

--fk_products_master_id
ALTER TABLE sc_products
DROP CONSTRAINT fk_products_master_id;

ALTER TABLE sc_products
ADD constraint fk_products_master_id foreign key(master_id) references sc_users(id) ON DELETE cascade;

--fk_product_categories_product_id
ALTER TABLE sc_product_categories
DROP CONSTRAINT fk_product_categories_product_id;

ALTER TABLE sc_product_categories
ADD constraint fk_product_categories_product_id foreign key(product_id) references sc_products(id) ON DELETE cascade;

--fk_product_categories_category_id
ALTER TABLE sc_product_categories
DROP CONSTRAINT fk_product_categories_category_id;

ALTER TABLE sc_product_categories
ADD constraint fk_product_categories_category_id foreign key(category_id) references sc_categories(id) ON DELETE cascade;

--fk_product_features_product_id
ALTER TABLE sc_product_features
DROP CONSTRAINT fk_product_features_product_id;

ALTER TABLE sc_product_features
ADD constraint fk_product_features_product_id foreign key(product_id) references sc_products(id) ON DELETE cascade;

--fk_product_features_feature_id
ALTER TABLE sc_product_features
DROP CONSTRAINT fk_product_features_feature_id;

ALTER TABLE sc_product_features
ADD constraint fk_product_features_feature_id foreign key(feature_id) references sc_features(id) ON DELETE cascade;

