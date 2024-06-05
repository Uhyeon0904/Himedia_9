/* WHERE */

select 
	menu_name,
    menu_price,
    orderable_status
from	
	tbl_menu
where
	orderable_status = 'y';
-- y를 찾아라
    
select
	menu_name,
    menu_price,
    orderable_status
from 
	tbl_menu
where
	menu_price = 13000;
-- 13000을 찾아라
    
select
	menu_name,
    menu_price,
    orderable_status
from 
	tbl_menu
where
	-- orderable_status <> 'y';
-- 같지 않다는 뜻
    orderable_status != 'y';
-- 같지 않다는 뜻
    
        
select
	menu_name,
    menu_price,
    orderable_status
from 
	tbl_menu
where
	menu_price >= 20000;
-- >=: ~이상
    
select 1 and 1;
select 1 and 0, 0 and 1, 0 and 0, 0 and null;    
select 1 and null, null and null;

select 
	menu_name,
    menu_price,
    category_code,
    orderable_status
from 
	tbl_menu
where
	orderable_status = 'y' and
    category_code = 10;
    
select
	menu_code,
    menu_name,
    menu_price,
    category_code,
    orderable_status
from 
	tbl_menu
where
	menu_price > 5000 and
	category_code = 10;

-- or 같은 경우는 한쪽에 true 가 있으면 true가 반환된다.
-- 게다가 시작부터 true가 나오면 그 뒤는 연산하지 않기 때문에 연산 속도가 빨라지는 효과가 있다.

select 1 or 1, 1 or 0, 0 or 1;		
select 0 or 0;
select 1 or null, 0 or null , null or null;

select
	menu_name,
    menu_price,
    category_code,
    orderable_status
from 
	tbl_menu
where
	orderable_status = 'y' OR
    category_code = 10
order by
	category_code;
    
select 
	*
from 
	tbl_menu
where
	menu_price > 5000 or
	category_code = 10;

-- and의 우선순위가 더 높음

select 1 or 0 and 0; 			-- = 1 or (0 and 0)
select (1 or 0) and 0;

select 
	*
from 
	tbl_menu
where
	category_code = 4 or
    menu_price = 9000 and
    menu_code > 10;
    # catgory_code = 4 or (menu_price = 9000 and menu_code > 10);

select
	menu_name,
    menu_price,
    category_code
from 
	tbl_menu
where
	menu_price >= 10000 and
    menu_price <= 25000
order by
menu_price;

select
	menu_name,
    menu_price,
    category_code
from 
	tbl_menu
where
	menu_price between 10000 and 25000
order by
	menu_price;

select
	menu_name,
    menu_price,
    category_code
from 
	tbl_menu
where
	menu_price not between 10000 and 25000
    #between 앞에 not을 붙여서 저 사이가 아닌 값을 나타낼 수도 있다.
order by
	menu_price;
    
select
	menu_name,
	menu_price
from 
	tbl_menu
where
	menu_name like '%마늘%';
/* '%' : 0개 이상의 임의의 문자
앞뒤로 사용하거나 앞/뒤 둘 중 하나만 사용한다면, 사용 시점으로부터 찾을 값 or
찾을 값 이후 모두 가능 */
/* '_' : 하나의 임의의 문자
앞/뒤 또는 앞, 뒤 따로 해서 1개의 문자만을 기준으로 값을 찾는다 */
    
select 
	*
from
	tbl_menu
where
	menu_price > 5000 and 
	category_code = 10 and
    menu_name like '%갈치%';
    
select 
	menu_name,
    menu_price
from 
	tbl_menu
where
	menu_name not like '%마늘%'
order by
	menu_name;
    
select
	menu_name,
    category_code
from 
	tbl_menu
where
	category_code = 4 or
    category_code = 5 or
    category_code = 6
order by
	category_code;
    
select
	menu_name,
    category_code
from 
	tbl_menu
where
	# category_code in (4, 5, 6)
-- in문자만 나타내는 함수? 임
    category_code not in (4, 5, 6)
-- not을 써서 반대의 경우도 나타낼 수 있음
order by
	category_code;
    
select
	category_code,
    category_name,
    ref_category_code
from
	tbl_category
where
	# ref_category_code is null;					
    ref_category_code is not null;
    # is not null을 해서 null값이 아닌 값을 나타낼 수도 있다