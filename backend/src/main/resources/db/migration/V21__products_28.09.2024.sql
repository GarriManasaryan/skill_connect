create table if not exists sc_categories(
    id varchar(40) not null,
    name text not null,
    description text,
    parent_id varchar(40),
    primary key (id),
    constraint fk_category_parent_id foreign key(parent_id) references sc_categories(id)
);

create table if not exists sc_features(
    id varchar(40) not null,
    name text not null,
    description text,
    parent_id varchar(40),
    discriminator varchar(56) not null,
    primary key (id),
    constraint fk_features_parent_id foreign key(parent_id) references sc_features(id)
);

create table if not exists sc_features_text(
    id varchar(40) not null,
    value text not null,
    constraint fk_features_text_id_to_base foreign key(id) references sc_features(id)
);

create table if not exists sc_features_numeric(
    id varchar(40) not null,
    from_value integer not null,
    to_value integer not null,
    unit varchar(256) not null,
    less_than_text varchar(128) not null,
    more_than_text varchar(128) not null,
    constraint fk_features_numeric_id_to_base foreign key(id) references sc_features(id)
);

create table if not exists sc_feature_categories(
    feature_id varchar(40) not null,
    category_id varchar(40) not null,
    constraint fk_feature_categories_feature_id foreign key(feature_id) references sc_features(id),
    constraint fk_feature_categories_category_id foreign key(category_id) references sc_categories(id)
);

create index feature_id_i_feature_categories on sc_feature_categories (feature_id);
create index category_id_i_feature_categories on sc_feature_categories (category_id);
create unique index feature_id_category_id_ui_feature_categories on sc_feature_categories (feature_id, category_id);

create table if not exists sc_products(
    id varchar(40) not null,
    name text not null,
    description text,
    price jsonb not null,
    master_id varchar(40) not null,
    primary key (id),
    constraint fk_products_master_id foreign key(master_id) references sc_users(id)
);


create table if not exists sc_product_categories(
    product_id varchar(40) not null,
    category_id varchar(40) not null,
    constraint fk_product_categories_product_id foreign key(product_id) references sc_products(id),
    constraint fk_product_categories_category_id foreign key(category_id) references sc_categories(id)
);

create index product_id_i_product_categories on sc_product_categories (product_id);
create index category_id_i_product_categories on sc_product_categories (category_id);
create unique index product_id_category_id_ui_product_categories on sc_product_categories (product_id, category_id);

create table if not exists sc_product_features(
    product_id varchar(40) not null,
    feature_id varchar(40) not null,
    constraint fk_product_features_product_id foreign key(product_id) references sc_products(id),
    constraint fk_product_features_feature_id foreign key(feature_id) references sc_features(id)
);

create index product_id_i_product_features on sc_product_features (product_id);
create index feature_id_i_product_features on sc_product_features (feature_id);
create unique index product_id_feature_id_ui_product_features on sc_product_features (product_id, feature_id);