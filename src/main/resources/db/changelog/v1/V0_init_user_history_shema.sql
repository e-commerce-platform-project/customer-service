CREATE TABLE user_history.revinfo
(
    rev       BIGSERIAL PRIMARY KEY,
    revtmstmp BIGINT
);

CREATE TABLE user_history.addresses_history
(
    id            UUID         NOT NULL,
    revision      BIGINT       NOT NULL,
    revision_type SMALLINT     NOT NULL,
    active        BOOLEAN      NOT NULL DEFAULT TRUE,
    created       TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT (now() AT TIME ZONE 'utc'),
    updated       TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT (now() AT TIME ZONE 'utc'),
    address       VARCHAR(128) NOT NULL,
    zip_code VARCHAR(32) NOT NULL ,
    city VARCHAR(128) NOT NULL,

    CONSTRAINT pk_addresses_history PRIMARY KEY (id, revision),
    CONSTRAINT fk_addresses_history_rev FOREIGN KEY (revision) REFERENCES user_history.addresses_history (revision)
);

CREATE INDEX IF NOT EXISTS idx_addresses_history_revision ON user_history.addresses_history (revision);

CREATE TABLE user_history.users_history
(

)