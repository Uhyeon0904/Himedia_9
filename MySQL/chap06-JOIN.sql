/* join
   2개 이상의 테이블을 관련 있는 컬럼을 통해 결합하는데 사용된다. 
   
컬럼 또는 테이블에 별칭을 달아줄 수 있다. 이러한 별칭을 alias라고 한다.
별칭에 띄어쓰기나 특수기호가 없다면 홑따옴표(')와 AS는 생략 가능하다.   */

select
   menu_code as 'code',
    menu_name as name,
    menu_price 'price'
from
   tbl_menu
order by price;

select
   category_code,
    menu_name
from
   # tbl_menu as a      테이블은 별칭을 사용할 때 as 를 빼도 된다.
     tbl_menu a
order by
   a.category_code,
    a.menu_name;
    
/* 1. inner join 
   두 테이블의 교집합을 반호나하는 SQL join 유형
   
   1-1. on을 활용한 join         
   on: 컬럼명이 같거나 다를 경우 on으로 서로 연관있는 컬럼에 대한 조건을 작성하여 join*/
   
select
   a.menu_name,
    b.category_name
from
   tbl_menu a
-- inner join tbl_category b on a.category_code = b.category_code;
-- 테이블a와 테이블b의 join을 하면서 테이블a의 카테고리코드와
-- 테이블b의 카테고리코드가 같은 것을 합친다
join tbl_category b on a.category_code = b.category_code;
-- inner의 생략도 가능하다.

-- 1-2. using을 활용한 join
-- 컬럼명이 같을 경우 using으로 서로 연관있는 컬럼에 대한 조건을 작성하여 join
select
	a.menu_name,
    b.category_name
from
	tbl_menu a
inner join tbl_category b using (category_code);
-- 테이블a와 테이블b를 join하여 카테고리의 코드가 같은 것 끼리 매칭을 시켜서
-- 테이블a의 메뉴이름과 테이블b의 카테고리이름을 반환시킨다.

-- 2. left join
-- 왼쪽 테이블의 모든 레코드와 오른쪽 테이블에서 일치하는 레코드를 반환하는 sql join유형
select
	a.category_name,
    b.menu_name
from
	tbl_category a 
left join
	tbl_menu b on a.category_code = b.category_code;
-- 카테고리 테이블a의 모든 레코드와 카테고리 테이블a 레코드가 매칭된 테이블메뉴b에서 일치하는 레코드
-- 일치하지 않는 값은 null 값으로 나온다

-- 3. right join
-- 오른쪽 테이블의 모든 레코드와 왼쫃 테이블에서 일치하는 레코드를 반환하는 sql join유형
select
	a.menu_name,
    b.category_name
from
	tbl_menu a
right join tbl_category b on a.category_code = b.category_code;

-- 4. cross join
-- 두 테이블의 모든 가능한 조합을 반환하는 sql join유형
select
	a.menu_name,
    b.category_name
from
	tbl_menu a
cross join tbl_category b;
-- 테이블 메뉴 a와 테이블 카테고리 b의 모든 레코드를 합쳐 select한 값을 반환

-- 5. self join
-- 같은 테이블 내에서 행과 행 사이의 관계를 찾기 위해 사용되는 sql join유형
-- 카테고리별 대분류 확인을 위한 self join 조회
select
	a.category_name,
    b.category_name
from
	tbl_category a
join tbl_category b on a.ref_category_code = b.category_code
-- 같은
where a. ref_category_code is not null;
-- null이 아닌 값만

-- join 알고리즘
-- 1. nested loop join
-- 큰 테이블의 각 행에 대해 작은 테이블을 반복적으로 검색하며, 조인 조건에 맞는 행을 찾는다.
-- 인덱스가 잘 구성되어 있는 작은 테이블에 유리하며, 전체 행을 스캔할 필요가 없을 때 효율적이다.
-- 결론: 두 테이블 중 하나가 상대적으로 작을 때 효과적이다.
-- 작은 테이블 조회 유리
select /* + no_hash_join(a) */
	a.menu_name,
    b.category_name
from
	tbl_menu a
join tbl_category b on a.category_code = b.category_code;

-- 2. hash join
-- 두 테이블이 모두 크고, 테이블 간 등가 조인(equal join)이 일어날 때 효과적이다.
-- 먼저 한 테이블의 데이터를 읽어 해시 테이블을 생성하고, 다른 테이블을 읽으며해시 테이블과
-- 매칭되는 데이터를 찾는다.
-- 큰 테이블 조회 유리
select /* + hash_join(a) */
-- 주석처럼 보이지만 해당 부분이 힌트절로 실행을한다.
-- select 옆에 사용해줘야 가능
-- a 라는 별칭을 가진 테이블에 대해 hash_join 사용을 해라 라는 뜻
	a.menu_name,
    b.category_name
from
	tbl_menu a
join tbl_category b on a.category_code = b.category_code;