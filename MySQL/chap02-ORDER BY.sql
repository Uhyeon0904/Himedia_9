/* ORDER BY */

select 
	menu_code,
    menu_name,
    menu_price
from 
	tbl_menu
order by
	menu_price asc;
-- asc는 오름차순 
    
select 
	menu_code,
    menu_name,
    menu_price
from
	tbl_menu
order by
	menu_price desc;
-- desc는 내림차순
    
select
	menu_code,
    menu_name,
    menu_price
from
    tbl_menu
order by
	menu_price desc,
    menu_name asc;
    
select 
	menu_code,
    menu_price,
    menu_code * menu_price
from
	tbl_menu
order by
	menu_code * menu_price ;
	
select field('A',      'A', 'B', 'C');
-- 첫 번째 인자 이후에 나열된 여러 값들 중에서 첫 번째 인자와 일치하는 값의 순서를 찾는 것
select field('B',      'A', 'B', 'C'); 		

select
	field(orderable_status, 'N', 'Y')
from
	tbl_menu;
    
select
-- select는 결과를 보여달라는 명령문
	menu_name,
    orderable_status
from
    tbl_menu
order by field(orderable_status, 'N', 'Y') ;

select 
	category_code,
    category_name,
    ref_category_code
from 
	tbl_category
order by
-- ref_category_code;
-- 오름차순 시 null 값이 가장 위에 나타난다.(default)
	ref_category_code is null ;
-- is null : null값이 가장 아래로 간다.

select 
	category_code,
    category_name,
    ref_category_code
from 
	tbl_category
order by
-- ref_category_code desc;
-- null값이 아래에 있음(default)
	ref_category_code is null desc;
-- is null desc 는 null에 대한 정렬이기 때문에 null
-- 값만 위로 오고 ref_category_code는 1 - 2 -3 순서로 정렬이 됨
--    ref_category_code desc ;
-- null - 3 - 2 - 1 순서로 정렬을 하려면 조건을 2개 써줘야 한다.        
-- null값이 가장 위로 온다. desc 생략 불가능