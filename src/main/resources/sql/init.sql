CREATE TABLE s_product
(
    id     BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name   VARCHAR(255)                            NOT NULL,
    price  DECIMAL                                 NOT NULL,
    image  VARCHAR(255),
    amount DOUBLE PRECISION                        NOT NULL,
    CONSTRAINT pk_s_product PRIMARY KEY (id)
);


CREATE TABLE s_user
(
    id    BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    phone VARCHAR(255)                            NOT NULL,
    name  VARCHAR(255)                            NOT NULL,
    CONSTRAINT pk_s_user PRIMARY KEY (id)
);

ALTER TABLE s_user
    ADD CONSTRAINT uc_s_user_phone UNIQUE (phone);

CREATE TABLE s_position
(
    id         BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    product_id BIGINT                                  NOT NULL,
    count      DOUBLE PRECISION,
    order_id   BIGINT,
    CONSTRAINT pk_s_position PRIMARY KEY (id)
);

ALTER TABLE s_position
    ADD CONSTRAINT FK_S_POSITION_ON_ORDER FOREIGN KEY (order_id) REFERENCES s_order (id);

ALTER TABLE s_position
    ADD CONSTRAINT FK_S_POSITION_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES s_product (id);

CREATE TABLE s_order
(
    id      BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    user_id BIGINT                                  NOT NULL,
    status  INTEGER                                 NOT NULL,
    address VARCHAR(255)                            NOT NULL,
    CONSTRAINT pk_s_order PRIMARY KEY (id)
);

ALTER TABLE s_order
    ADD CONSTRAINT FK_S_ORDER_ON_USER FOREIGN KEY (user_id) REFERENCES s_user (id);