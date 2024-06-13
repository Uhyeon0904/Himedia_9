USE comprehensive;

CREATE TABLE IF NOT EXISTS tbl_category
(
    category_code    BIGINT AUTO_INCREMENT COMMENT '카테고리코드',
    category_name    VARCHAR(50) NOT NULL COMMENT '카테고리명',
    CONSTRAINT pk_category_code PRIMARY KEY (category_code)
) ENGINE=INNODB COMMENT '상품카테고리';

CREATE TABLE IF NOT EXISTS tbl_member
(
    member_code         BIGINT AUTO_INCREMENT COMMENT '회원코드',
    member_id           VARCHAR(100) UNIQUE NOT NULL COMMENT '아이디',
    member_password     VARCHAR(500) NOT NULL COMMENT '비밀번호',
    member_name         VARCHAR(100) NOT NULL COMMENT '회원이름',
    member_email        VARCHAR(100) COMMENT '이메일',
    member_role         VARCHAR(100) DEFAULT 'ROLE_USER' NOT NULL COMMENT '권한',
    created_at          DATETIME NOT NULL DEFAULT now() COMMENT '생성일시',
    modified_at         DATETIME NOT NULL DEFAULT now() COMMENT '수정일시',
    status              VARCHAR(10) NOT NULL DEFAULT 'ACTIVE' COMMENT '상태',
		refresh_token       VARCHAR(300) COMMENT '리프레시토큰',
    CONSTRAINT pk_member_code PRIMARY KEY (member_code)
) ENGINE=INNODB COMMENT '회원';


CREATE TABLE IF NOT EXISTS tbl_product
(
    product_code        BIGINT AUTO_INCREMENT COMMENT '상품코드',
    product_name        VARCHAR(100) NOT NULL COMMENT '상품명',
    product_price       VARCHAR(100) NOT NULL COMMENT '상품가격',
    product_description VARCHAR(1000) NOT NULL COMMENT '상품설명',
    category_code       BIGINT COMMENT '카테고리코드',
    product_image_url   VARCHAR(100) NOT NULL COMMENT '상품이미지경로',
    product_stock       BIGINT NOT NULL COMMENT '상품재고',
    created_at          DATETIME NOT NULL DEFAULT now() COMMENT '생성일시',
    modified_at         DATETIME NOT NULL DEFAULT now() COMMENT '수정일시',
    status              VARCHAR(10) NOT NULL DEFAULT 'USABLE' COMMENT '상태',
    CONSTRAINT pk_product_code PRIMARY KEY (product_code),
    CONSTRAINT fk_category_code FOREIGN KEY (category_code) REFERENCES tbl_category (category_code)
) ENGINE=INNODB COMMENT '상품';

CREATE TABLE IF NOT EXISTS tbl_order
(
    order_code      BIGINT AUTO_INCREMENT COMMENT '주문코드',
    product_code    BIGINT NOT NULL COMMENT '상품코드',
    member_code    BIGINT NOT NULL COMMENT '회원코드',
    order_phone     VARCHAR(100) NOT NULL COMMENT '핸드폰번호',
    order_email     VARCHAR(100) NOT NULL COMMENT '이메일주소',
    order_receiver  VARCHAR(100) NOT NULL COMMENT '수령인',
    order_address   VARCHAR(500) NOT NULL COMMENT '배송지',
    order_amount    VARCHAR(50) NOT NULL COMMENT '주문수량',
    order_date      DATETIME NOT NULL COMMENT '주문일자',
    CONSTRAINT pk_order_code PRIMARY KEY (order_code),
    CONSTRAINT fk_product_code FOREIGN KEY (product_code) REFERENCES tbl_product (product_code),
    CONSTRAINT fk_member_code FOREIGN KEY (member_code) REFERENCES tbl_member (member_code)
) ENGINE=INNODB COMMENT '주문';

CREATE TABLE IF NOT EXISTS tbl_review
(
    review_code     BIGINT AUTO_INCREMENT COMMENT '리뷰코드',
    order_code      BIGINT NOT NULL COMMENT '주문코드',
    review_title    VARCHAR(100) NOT NULL COMMENT '제목',
    review_content  VARCHAR(1000) NOT NULL COMMENT '내용',
    created_at      DATETIME NOT NULL DEFAULT now() COMMENT '생성일시',
    modified_at     DATETIME NOT NULL DEFAULT now() COMMENT '수정일시',
    status          VARCHAR(10) NOT NULL DEFAULT 'USABLE' COMMENT '상태',
    CONSTRAINT pk_review_code PRIMARY KEY (review_code),
    CONSTRAINT fk_order_code FOREIGN KEY (order_code) REFERENCES tbl_order (order_code)
) ENGINE=INNODB COMMENT '상품리뷰';