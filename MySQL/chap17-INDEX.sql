/* INDEX */
CREATE TABLE phone (
	phone_code INT PRIMARY KEY,
    phone_name VARCHARACTER(100),
    phone_price DECIMAL(10, 2));
    -- DECIMAL(사용가능한 숫자 길이, 소수점 아래 자리 길이)
    
INSERT INTO phone (phone_code, phone_name, phone_price)
VALUES	(1, 'GalaxyS24', 1200000),
		(2, 'IPhone', 1400000),
        (3, 'GalaxyZfold5', 2300000);
        
SELECT * FROM phone;

EXPLAIN SELECT * FROM phone
-- EXPLAIN: 쿼리 실행 계획 확인 명령문.
WHERE phone_name = 'GalaxyS24';

CREATE INDEX idx_name
ON phone (phone_name);
-- 인덱스 생성

SHOW INDEX FROM phone;

CREATE INDEX idx_name_price
ON phone(phone_name, phone_price);
-- 복합 인덱스 생성(두 개의 열을 하나의 인덱스로 묶는다.)

SELECT * FROM phone
WHERE phone_name = 'IPhone';

EXPLAIN SELECT * FROM phone
WHERE phone_name = 'IPhone';

/* 인덱스 최적화(재구성)
인덱스가 파편화되었거나, 데이터의 대부분이 변경된 경우 유용하다.
인덱스의 성능을 개선하고, 디스코 공간을 더 효율적으로 사용하게 한다.
단, 재구성하는 동안 테이블은 잠겨있을 수 있다. 주의해서 수행
ALTER TABLE 명령어 사용해서 재구성한다.*/
ALTER TABLE phone DROP INDEX idx_name;
ALTER TABLE phone ADD INDEX idx_name(phone_name);

OPTIMIZE TABLE phone;
-- OPTIMIZE를 이용한 최적화

DROP INDEX idx_name ON phone;
-- 인덱스를 삭제하는 방법: 인덱스 이름 on 테이블 이름
SHOW INDEX FROM phone;