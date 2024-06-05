CREATE DATABASE (생성할 스키마 이름);
-- 스키마 생성

-- DROP SCHEMA (삭제할 스키마 이름);
-- 스키마 삭제

GRANT ALL PRIVILEGES ON (생성한 스키마 이름).* TO 'ohgiraffers'@'%';
-- 사용자에게 데이터베이스에 대한 모든 권한을 부여하는 명령문

SHOW GRANTS FOR 'ohgiraffers'@'%';

USE (생성할 스키마 이름);
-- 어떤 스키마를 사용할지 선택 명령어