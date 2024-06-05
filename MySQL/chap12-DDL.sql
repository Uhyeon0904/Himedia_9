/* DDL(Data Definition Language) */
-- 데이터베이스의 스키마(테이블) 정의하거나 수정하는데 사용되는 SQL의 한 부분

-- 1. create: 테이블 생성을 위한 구문
/* 컬럼 설정 방법
column_name data_type(length) [not null] [default value] [auto_increment] column_constraint*/

create table if not exists tb1 (
-- tb1 이라는 테이블 이름이 존재하지 않는다면, 생성하겠다.
	pk int primary key,
    /* primary key는 디폴트 값으로 null 값을 가질 수 없다.
    고유한 값, 순서를 정할 때 많이 사용, 각 행을 식별할 수 있게한다. */
    fk int,
    col1 varchar(255),
    -- 문자열, 길이 255
    check(col1 in ('Y', 'N'))
) engine = InnoDB;
/* 테이블을 만들 때 마다 innoDB 엔진을 사용하겠다.
기본 스토리지 엔진으로 설정이 되어있어, 명시적으로 설정을 안 해줘도 자동으로 설정이된다. */

describe tb1;
-- 테이블 구조를 확인하는 명령어

insert into tb1 values (1, 20, 'Y');

select * from tb1;

-- 2. auto_increment
/* insert 시 primary키에 해당하는 컬럼에 자동으로 중복되지 않는 번호를 발생시켜 저장할 수 있다.
컬럼 번호순을 중복되지 않게 자동으로 넘어가준다. */

create table if not exists tb2 (
	pk int auto_increment primary key,
    fk int,
    col1 varchar(255),
    check(col1 in ('Y', 'N'))
) engine = InnoDB;

insert into tb2 values(null, 10, 'Y');
insert into tb2 values(null, 20, 'Y');

select * from tb2;

-- 3. alter
-- 테이블에 추가/변경/수정/삭제하는 모습은 그것은 alter 명령어를 사용해 적용한다.

-- 열(column) 추가alter
-- alter table 테이블명 add 컬럼명 컬럼정의
-- col2 컬럼 추가 (int형, not null 제약조건 존재)

alter table tb2
add col2 int not null;
-- ADD COLUMN이 기본 형식이지만 COLUMN은 생략이 가능하다

describe tb2;

-- 열(column)삭제
-- alter table 테이블명 drop column 컬럼명
alter table tb2
drop column col2;

describe tb2;

-- 열(column) 이름 및 데이터 형식 변경
-- alter table 테이블명 change column 기존컬럼명 바꿀컬럼명 컬럼정의
-- fr 컬럼을 change_fk 컬럼으로 변경(not null 제약조건 존재)
alter table tb2 change column fk  change_fk int not null;
-- 한 구문에 하나의 열만 변경이 가능하다.

-- 열 제약 조건 추가 및 삭제(이후 챕터에서 다룰 내용)
-- alter table 테이블명 drop 제약조건
-- tb2 테이블의 primary key 제약조건 제거
alter table tb2 drop primary key;
-- 에러 발생
-- auto_increment가 걸려있는 컬럼은 primary key 제거가 안 되므로
-- auto_incriment를 modify(컬럼의 정의를 바꿈) 명령어로 제거한다.

alter table tb2
modify pk int;

describe tb2;

alter table tb2
drop primary key;

-- 다시 primary key 제약조건 추가
alter table  tb2r
add primary key(pk);