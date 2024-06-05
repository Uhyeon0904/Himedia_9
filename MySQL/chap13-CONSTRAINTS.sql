/* constraints */
-- 제약조건으로 테이블에 데이터가 입력되거나 수정될 때 규칙 정의

-- 1. not null
create table if not exists user_notNull (
	user_no int not null,
    user_id varchar(255) not null,
    user_pwd varchar(255) not null,
    user_name varchar(255) not null,
    gender varchar(3),
    phone varchar(255) not null,
    email varchar(255)
) engine = InnoDB;

insert into user_notNull
(user_no, user_id, user_pwd, user_name, gender, phone, email)
values
(1, 'user01', 'pass01', '홍길동', '남', '010-1234-5678', 'hong123@gmail.com'),
(2, 'user02', 'pass02', '판다', '여', '010-7777-7777', 'pan77@gmail.com');

DELETE FROM user_notnull
WHERE user_no = 3;

SHOW VARIABLES LIKE 'sql_safe_updates';

SET sql_safe_updates = 1;

select * from user_notNull;

-- not null 제약조건 에러 발생(null값 적용)
insert into user_notNull
(user_no, user_id, user_pwd, user_name, gender, phone, email)
values
(3, 'user03', null, '이순신', '남', '010-7777-7777', 'pan77@gmail.com');

-- 2. unique: 중복값을 허용하지 않는 제약조건
create table if not exists user_unique (
	user_no int not null unique,
    -- 단일 유니크 생성
    user_id varchar(255) not null,
    user_pwd varchar(255) not null,
    user_name varchar(255) not null,
    gender varchar(3),
    phone varchar(255) not null,
    email varchar(255),
    unique (phone)
    -- 이렇게도 할 수 있다.
) engine = InnoDB;

insert into user_unique
(user_no, user_id, user_pwd, user_name, gender, phone, email)
values
(1, 'user01', 'pass01', '홍길동', '남', '010-1234-5678', 'hong123@gmail.com'),
(2, 'user02', 'pass02', '판다', '여', '010-7777-7777', 'pan77@gmail.com');

select * from user_unique;

-- unique 제약조건 에러 발생
insert into user_unique
(user_no, user_id, user_pwd, user_name, gender, phone, email)
values
(3, 'user02', 'pass03', '이순신', '남', '010-7777-7777', 'lee222@gmail.com');
-- Error Code: 1062/ 중복값 발견(phone)

-- 3. primary key
/* 테이블에 대한 식별자 역할을 한다. (한 행씩 구분하는 역할)
	not null + unique 제약조건의 의미이다.
    한 테이블당 한 개만 설정할 수 있다.
    한 개 컬럼에 설정할 수도 있고, 여러 개의 컬럼을 묶어 설정할 수 있다. */
create table if not exists user_primarykey (
	-- user_no int primary key,
    user_no int,
    user_id varchar(255) not null,
    user_pwd varchar(255) not null,
    user_name varchar(255) not null,
    gender varchar(3),
    phone varchar(255) not null,
    email varchar(255),
    primary key (user_no)
) engine = InnoDB;

insert into user_primarykey
(user_no, user_id, user_pwd, user_name, gender, phone, email)
values
(1, 'user01', 'pass01', '홍길동', '남', '010-1234-5678', 'hong123@gmail.com'),
(2, 'user02', 'pass02', '판다', '여', '010-7777-7777', 'pan77@gmail.com');

select * from user_primarykey;

-- primary key 제약조건 에러 발생(null값 적용)
insert into user_primarykey
(user_no, user_id, user_pwd, user_name, gender, phone, email)
values
(null, 'user03', 'pass03', '이순신', '남', '010-7777-7777', 'lee222@gmail.com');

insert into user_primarykey
(user_no, user_id, user_pwd, user_name, gender, phone, email)
values
(2, 'user03', 'pass03', '이순신', '남', '010-7777-7777', 'lee222@gmail.com');

-- foreign key
/* 참조(references)된 다른 테이블에서 제공하는 값만 사용할 수 있다.
	foreign key 제약조건에 의해 테이블 간의 관계가 형성된다.
    제공되는 값 외에는 null을 사용할 수 있다. */
create table if not exists user_grade(
	grade_code int not null unique,
    grede_name varchar(255) not null
) engine = innodb;

DROP TABLE user_grade;

insert into user_grade
values
(10, '일반회원'),
(20, '우수회원'),
(30, '특별회원');

select * from user_grade;

create table if not exists user_foreignkey5 (
	-- user_no int primary key,
    user_no int,
    user_id varchar(255) not null,
    user_pwd varchar(255) not null,
    user_name varchar(255) not null,
    gender varchar(3),
    phone varchar(255) not null,
    email varchar(255),
    grade_code int,
    primary key (user_no),
    foreign key(grade_code) references user_grade (grade_code)
    -- grade_code를 foreign key로 설정할건데 user_grade 테이블에 grade_code를 참조하겠다.
) engine = InnoDB;

insert into user_foreignkey5
(user_no, user_id, user_pwd, user_name, gender, phone, email, grade_code)
values
(1, 'user01', 'pass01', '홍길동', '남', '010-1234-5678', 'hong123@gmail.com', 10),
(2, 'user02', 'pass02', '판다', '여', '010-7777-7777', 'pan77@gmail.com', 20);
select * from user_foreignkey2;

insert into user_foreignkey5
(user_no, user_id, user_pwd, user_name, gender, phone, email, grade_code)
values
(3, 'user03', 'pass03', '이순신', '남', '010-7777-7777', 'lee222@gmail.com', 50);
select * from user_foreignkey5;

create table if not exists user_foreignkey1 (
    user_no int,
    user_id varchar(255) not null,
    user_pwd varchar(255) not null,
    user_name varchar(255) not null,
    gender varchar(3),
    phone varchar(255) not null,
    email varchar(255),
    grade_code int,
    primary key (user_no),
    foreign key(grade_code) references user_grade (grade_code)
    on update set null
    -- user_grade 테이블의 'grade_code' 값이 변경될 경우
    -- 외래 키를 가진 테이블의 'grade_code' 값을 null로 설정
    on delete set null
    -- user_grade 테이블의 'grade_code' 값이 삭제될 경우 null로 설정
) engine = InnoDB;
ALTER TABLE user_foreignkey1 DROP FOREIGN KEY user_foreignkey1_ibfk_1;
-- 제약조건을 삭제하는 명령문

insert into user_foreignkey1
(user_no, user_id, user_pwd, user_name, gender, phone, email, grade_code)
values
(1, 'user01', 'pass01', '홍길동', '남', '010-1234-5678', 'hong123@gmail.com', 10),
(2, 'user02', 'pass02', '판다', '여', '010-7777-7777', 'pan77@gmail.com', 20);
select * from user_foreignkey1;

drop table if exists user_foreignkey1;
SET sql_safe_updates = 1;

update user_grade
set grade_code = null
where grade_code = 10;
select * from user_grade;
select * from user_foreignkey1;

delete from user_grade
where grade_code = 20;
select * from user_grade;
select * from user_foreignkey6;

-- 5. check: 제약 조건 위반할 시 허용하지 않는 제약조건
create table if not exists user_check(
	user_no int auto_increment primary key,
    user_name varchar(255) not null,
    gender varchar(3) check (gender in ('남', '여')),
    -- 둘 중 하나 체크할 수 있는 
    age int check ( age >= 19)
) engine = InnoDB;

insert into user_check
values
	(null, '홍길동', '남', 25),
	(null, '이순신', '남', 33);
    
select * from user_check;

-- gender 컬럼 check 제약 조건 에러 발생
insert into user_check
values (null, '안중근', '남성', 27);

-- age 컬럼 check 제약 조건 에러 발생
insert into user_check
values (null, '유관순', '여', 17);

-- default
/* 컬럼에 null 대신 기본 값 적용
	컬럼 타입이 date일 시 current_date만 가능
    컬럼 타입이 datetime일 시 current_time과
    current_timestamp, now() 모두 사용 가능 */
create table if not exists tbl_country (
	country_code int auto_increment primary key,
    country_name varchar(255) default '한국',
    population varchar(255) default '0명',
    add_day date default (current_date),
    -- 년/월/일 날짜 출력
    add_time datetime default (current_time)
    -- 년/월/일, 시/분/초 출력
) engine = InnoDB;

select * from tbl_country;

insert into tbl_country
values (null, default, default, default, default);