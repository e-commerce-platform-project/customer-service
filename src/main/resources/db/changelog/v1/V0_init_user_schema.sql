CREATE TABLE user.addresses
(
    id       UUID PRIMARY KEY,
    active   boolean      NOT NULL DEFAULT TRUE,
    created  TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT (now() AT TIME ZONE 'utc'),
    updated  TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT (now() AT TIME ZONE 'utc'),
    address  VARCHAR(128) NOT NULL,
    zip_code varchar(32)  NOT NULL,
    city     varchar(64)
);

CREATE TABLE user.users
(
    id         UUID PRIMARY KEY,
    active     boolean       not null DEFAULT TRUE,
    created    TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT (now() AT TIME ZONE 'utc'),
    updated    TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT (now() AT TIME ZONE 'utc'),
    email      VARCHAR(1024) NOT NULL,
    first_name VARCHAR(64)   NOT NULL,
    last_name  VARCHAR(64)   NOT NULL,
    address_id UUID NOT NULL REFERENCES user.addresses (id)
);

