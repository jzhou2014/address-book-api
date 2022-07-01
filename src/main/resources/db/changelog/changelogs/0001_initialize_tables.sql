CREATE TABLE contact_address (
  id integer PRIMARY KEY,
  name character varying (32) NOT NULL,
  phone_number character varying (16),
  email_address character varying (32),
  address_type character varying (32),
  default_address boolean default false,
  messenger_account character varying (32),
  website character varying (32)
);