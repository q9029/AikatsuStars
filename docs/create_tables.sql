create table volumes_cards (
id serial PRIMARY KEY,
volume_id int NOT NULL,
card_id int NOT NULL,
display_order int,
valid boolean,
created_at timestamp,
modified_at timestamp
);

create table cards (
id serial PRIMARY KEY,
brand_id int NOT NULL,
no varchar(50),
name varchar(50),
rarity int,
url varchar(200),
valid boolean,
created_at timestamp,
modified_at timestamp
);

create table brands (
id serial PRIMARY KEY,
name varchar(50),
display_order int,
valid boolean,
created_at timestamp,
modified_at timestamp
);

create table volumes (
id serial PRIMARY KEY,
name varchar(50),
display_order int,
valid boolean,
created_at timestamp,
modified_at timestamp
);

create table lists_cards (
id serial PRIMARY KEY,
list_id int NOT NULL,
card_id int NOT NULL,
message varchar(200),
quantity int,
display_order int,
valid boolean,
created_at timestamp,
modified_at timestamp
);

create table notifications (
id serial PRIMARY KEY,
head varchar(50),
body varchar(200),
valid boolean,
created_at timestamp,
modified_at timestamp
);

create table accounts (
id bigint PRIMARY KEY,
name varchar(50),
screen_name varchar(50),
access_token varchar(50),
access_token_secret varchar(50),
currently_signed_in_at timestamp,
message varchar(200),
good_estimate_count int,
bad_estimate_count int,
administrative boolean,
valid boolean,
created_at timestamp,
modified_at timestamp
);

create table lists (
id serial PRIMARY KEY,
account_id bigint NOT NULL,
type int,
name varchar(50),
message varchar(200),
display_order int,
public boolean,
valid boolean,
created_at timestamp,
modified_at timestamp
);

create table system_settings (
id serial PRIMARY KEY,
key varchar(50),
value varchar(50),
valid boolean,
created_at timestamp,
modified_at timestamp
);
