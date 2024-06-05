-- grouping
-- group by 절은 특정 열의 값에 따라 그룹화하는데 사용된다.
-- having: group by 절과 함께 사용해야 하며 그룹에 대한 조건을 적용하는데 사용된다. 

select
	category_code
from
	tbl_menu
group by category_code;
-- 같은 값을 그룹화 한다

select
	category_code,
    count(*)
	-- count: 퓨플(행)의 수를 세는 함수
    -- 그룹화된 행의 개수를 볼 수 있다.
from
	tbl_menu
group by category_code;

select
	category_code,
    sum(menu_price)
    -- 그룹화된 개수만큼 합산되서 반환
from
	tbl_menu
group by category_code;

select
	category_code,
    avg(menu_price)
    -- 위에서 입력받은 금액 합계의 평균
from
	tbl_menu
group by category_code;

select
	menu_price,
    category_code
from
	tbl_menu
group by
	menu_price,
    category_code;
    
select
	menu_price,
    category_code
from
	tbl_menu
group by
	menu_price,
    category_code
having
	category_code >= 5 and category_code <= 8;
    -- 조건을 만족하는 그룹만 반환이 가능 / 카테고리 코드가 
    -- where은 그룹화 전 개별 행에 조건을 거는 것이고
    -- having은 그룹화 후 집계 결과에 대한 조건을 건다.
    
select
	category_code,
    sum(menu_price)
from
	tbl_menu
group by
	category_code
with rollup;
-- 그룹화한 합계와, 테이블 전체의 합계를 반환, 전체를 반환한 코드는 null로 반환

select
	menu_price,
    category_code,
	sum(menu_price)
from
	tbl_menu
group by
	menu_price,
    category_code
with rollup;