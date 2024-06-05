-- MEMBER 테이블 생성
USE comprehensive;

CREATE TABLE IF NOT EXISTS tbl_member(
                                         member_no INT AUTO_INCREMENT,
                                         member_id VARCHAR(20) UNIQUE NOT NULL,
    member_pwd VARCHAR(255) NOT NULL,
    nickname VARCHAR(255) NOT NULL,
    phone VARCHAR(20),
    email VARCHAR(50),
    address VARCHAR(255),
    enroll_date DATETIME DEFAULT NOW() NOT NULL,
    member_role VARCHAR(15) DEFAULT 'ROLE_MEMBER' NOT NULL,
    member_status VARCHAR(2) DEFAULT 'Y' NOT NULL,
    PRIMARY KEY (member_no)
    ) ENGINE=INNODB;


-- 관리자 계정 추가
INSERT INTO tbl_member (member_id, member_pwd, nickname, phone, email, address, member_role)
VALUES ('admin', '$2a$10$7NqnZ0pUQh2RDLDkcEmubOSWB2DSewpDNs7q7xwxgZHHvMgZGJ.rW', '관리자', '01012345678', 'admin@ohgiraffers.com', '$$', 'ROLE_ADMIN');
-- 일반 계정 추가
INSERT INTO tbl_member (member_id, member_pwd, nickname, phone, email, address, member_role)
VALUES ('user01', '$2a$10$N34MRj4tKVD0AxwvEcC8eOLUyBpXloPKE7Yw.S4/kj5fD1OU5BWsi', '홍길동', '01087654321', 'user01@ohgiraffers.com', '$$', 'ROLE_MEMBER');
COMMIT;

-- 카테고리 테이블 생성
CREATE TABLE IF NOT EXISTS tbl_category(
                                           category_code INT AUTO_INCREMENT,
                                           category_name VARCHAR(30),
    PRIMARY KEY(category_code)
    ) ENGINE=INNODB;

-- 카테고리 테이블에 카테고리 추가
INSERT INTO tbl_category (category_name) VALUES('공통');
INSERT INTO tbl_category (category_name) VALUES('운동');
INSERT INTO tbl_category (category_name) VALUES('등산');
INSERT INTO tbl_category (category_name) VALUES('게임');
INSERT INTO tbl_category (category_name) VALUES('낚시');
INSERT INTO tbl_category (category_name) VALUES('요리');
INSERT INTO tbl_category (category_name) VALUES('기타');
COMMIT;

-- 게시판 테이블 생성
CREATE TABLE IF NOT EXISTS tbl_board (
                                         board_no INT AUTO_INCREMENT,
                                         board_type INT NOT NULL,
                                         category_code INT,
                                         board_title VARCHAR(100),
    board_body VARCHAR(4000) NOT NULL,
    board_writer_member_no INT NOT NULL,
    board_count INT DEFAULT 0 NOT NULL,
    created_date DATETIME DEFAULT NOW(),
    modified_date DATETIME DEFAULT NOW(),
    board_status CHAR(1) DEFAULT 'Y',
    PRIMARY KEY(board_no),
    FOREIGN KEY (board_writer_member_no) REFERENCES TBL_MEMBER(member_no),
    FOREIGN KEY (category_code) REFERENCES TBL_CATEGORY(category_code)
    ) ENGINE=INNODB;

-- 게시물 샘플 추가
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '1 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '2 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '3 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '4 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '5 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '6 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '7 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '8 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '9 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '10 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);

INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '11 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '12 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '13 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '14 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '15 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '16 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '17 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '18 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '19 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '20 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);

INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '21 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '22 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '23 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '24 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '25 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '26 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '27 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '28 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '29 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '30 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);

INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '31 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '32 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '33 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '34 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '35 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '36 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '37 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '38 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '39 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '40 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);

INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '41 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '42 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '43 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '44 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '45 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '46 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '47 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '48 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '49 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '50 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);

INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '51 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '52 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '53 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '54 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '55 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '56 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '57 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '58 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '59 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '60 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);

INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '61 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '62 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '63 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '64 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '65 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '66 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '67 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '68 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '69 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '70 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);

INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '71 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '72 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '73 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '74 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '75 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '76 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '77 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '78 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '79 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '80 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);

INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '81 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '82 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '83 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '84 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '85 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '86 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '87 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '88 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '89 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '90 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);

INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '91 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '92 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '93 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '94 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '95 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '96 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '97 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '98 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '99 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '100 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);

INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '101 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '102 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '103 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '104 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '105 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '106 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '107 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '108 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '109 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '110 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);

INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '111 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '112 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '113 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '114 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '115 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '116 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '117 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '118 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '119 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '120 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);

INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '121 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '122 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);
INSERT INTO tbl_board (board_type, category_code, board_title, board_body, board_writer_member_no)
VALUES ( 1, 1, '123 번째 게시물 입니다.', '내용은 없습니다. WE CAN DO IT!~', 1);

COMMIT;

-- REPLY 테이블 생성
CREATE TABLE IF NOT EXISTS tbl_reply (
                                         reply_no INT AUTO_INCREMENT,
                                         ref_board_no INT,
                                         reply_body VARCHAR(4000),
    reply_writer_member_no INT,
    reply_status CHAR(1) DEFAULT 'Y',
    created_date DATETIME DEFAULT NOW(),
    PRIMARY KEY(REPLY_NO),
    FOREIGN KEY (ref_board_no) REFERENCES TBL_BOARD(board_no),
    FOREIGN KEY (reply_writer_member_no) REFERENCES TBL_MEMBER(member_no)
    ) ENGINE=INNODB;

-- 첨부파일 테이블 생성
CREATE TABLE IF NOT EXISTS tbl_attachment (
                                              attachment_no INT AUTO_INCREMENT,
                                              ref_board_no INT NOT NULL,
                                              original_name VARCHAR(255) NOT NULL,
    saved_name VARCHAR(255) NOT NULL,
    save_path VARCHAR(1000) NOT NULL,
    file_type VARCHAR(5),
    thumbnail_path VARCHAR(255),
    attachment_status CHAR(1) DEFAULT 'Y',
    PRIMARY KEY(attachment_no),
    FOREIGN KEY (ref_board_no) REFERENCES TBL_BOARD(board_no)
    ) ENGINE=INNODB;