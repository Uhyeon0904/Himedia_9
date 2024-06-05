/* DML(Data Manipulation Language */
-- 데이터 조작언어, 테이블에 값을 삽입하거나 수정, 삭제하는 SQL의 한 부분

-- 1. insert: 새로운 행 추가하는 구문
select * from tbl_menu;

insert into tbl_menu values (null, '바나나해장국', 8500, 4, 'Y');
-- menu_code는 자동으로 등록이 되서 null 값을 넣어주면 된다.

/* null 허용 가능한(nullable)컬럼이나 auto_increment가 있는 컬럼을 제외한
insert하고 싶은 데이터 컬럼을 지정해서 insert 가능하다. */
insert into tbl_menu(menu_name, menu_price, category_code, orderable_status)
values ('초콜릿죽', 6500, 7, "Y");

select * from tbl_menu;

insert into tbl_menu(orderable_status, category_code, menu_price, menu_name)
values ("N", 5, 100000, '파라지옥볶음');
-- 컬럼을 명시하면 insert시 데이터의 순서를 바꾸는 것도 가능하다.

insert into
	tbl_menu
values
	(null, '참치맛아이스크림', 1700, 12, 'Y'),
	(null, '멸치맛아이스크림', 1500, 11, 'Y'),
	(null, '소시지맛커피', 2500, 8, 'Y');
    
-- 2. update: 테이블에 기록된 컬럼의 값을 수정하는 구문
select *
from tbl_menu
where menu_name = '바나나해장국';

insert into tbl_menu values (23, '취두부된장찌개', 6000, 4, 'Y');

update tbl_menu
set menu_name = '취두부된장찌개'
where menu_code = 23;
-- 메뉴코드 23번의 카테고리 코드를 5로 변경 한다.

select * from tbl_menu;

update tbl_menu
set category_code = 6
where menu_code = (
    select menu_code
	from tbl_menu
	where menu_name = '바나나해장국');
-- 서브쿼리로 update나 delete시 자기 자신 테이블의 데이터를 사용 시 에러 발생

update tbl_menu
set category_code = 6
where menu_code = 22;

update tbl_menu
set category_cod = 6
where menu_code = (
    select menu_code
	from (
		select menu_code
		from tbl_menu
		where menu_name = '바나나해장국')tmp );
    
-- 3. delete: 테이블의 행을 삭제하는 구문
delete from tbl_menu
order by menu_price
limit 2;

-- where절을 활용한 행 삭제
delete from tbl_menu
where menu_code = 23;
    
select * from tbl_menu;

show variables like 'sql_safe_update';

delete from tbl_menu;

set sql_safe_updates = 0;
-- 세이프 업데이트 모드 비활성화

set sql_safe_updates = 1;
-- 세이프 업데이트 모드 활성화

/* 4. repalce: insert시 primary key 또는 unique key가 중복이 발생할 수 있다면 
replace를 통해 중복된 데이터를 덮어 쓸 수 있다. (권장되지는 않는다) */

insert into tbl_menu values (1, '참기름소주', 5000, 10, 'Y');
-- 1번째 위치에는 이미 행이 존재하여 추가가 불가능

select * from tbl_menu;

replace into tbl_menu values (1, '참기름소주', 5000, 10, 'Y');
/* 1번 자리에 행을 새로운 값으로 덮어버림
replace tbl_menu values (1, '참기름소주', 6000, 10, 'Y');
into 생략 가능은 하지만 명시적으로 대상 테이블을 지정하는 것이 좋다 */

select * from tbl_menu;

replace tbl_menu
set menu_code = 2, menu_name = '우럭스무디', menu_price = 2500, category_code = 5, orderable_status = 'N';

select * from tbl_menu;