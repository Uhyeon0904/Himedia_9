DROP USER 'john'@'%';
-- 사용자 계정 삭제

CREATE DATABASE pocketpaldb;
-- CREATE DATABASE(DB 및 스키마 생성): 새로운 데이터베이스를 생성하는 명령문, 이후 자동으로 스키마 생성

CREATE SCHEMA pocketpaldb;
-- CREATE SCHEMA: 새로운 스키마 생성

CREATE USER 'pocketpal'@'%' IDENTIFIED BY 'pocketpal';
-- CREATE USER: 새로운 사용자를 생성하는 데 사용되는 명령어
-- IDENTIFIED BY: 사용자의 암호

SHOW DATABASES;
-- SHOW DATABASES: 현재 MySQL 서버에 있는 모든 데이터베이스를 보여주는 명령문

USE studydb;
/* USE mySQL: MySQL에서 사용할 데이터베이스를 선택하는 명령어, 현재 세션에서 사용할
			데이터베이스를 지정한 데이터베이스로 변경,
            'mysql'이라는 데이터베이스를 사용하겠다는 의미 */

GRANT ALL PRIVILEGES ON pocketpaldb.* TO 'pocketpal'@'%';
-- 사용자에게 'menudb'데이터베이스에 대한 모든 권한을 부여하는 명령문

show grants for 'poketpal'@'%';
/* 사용자에게 부여된 권한을 확인하는 명령어,
	어떤 권한을 가지고 있는지에 대한 정보 표시 */