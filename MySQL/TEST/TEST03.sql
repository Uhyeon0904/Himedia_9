-- Q1
select sum(SALARY) as sumSalary
from employee
group by DEPT_CODE
order by sumSalary desc
limit 1;

-- Q2
select EMP_ID as 사원번호, EMP_NAME as 이름, DEPT_CODE as 코드, SALARY as 급여
from employee 
where DEPT_CODE in (
	select DEPT_ID
    from department
    where DEPT_TITLE like '%영업%');
    
-- Q3
select e1.EMP_ID as 사원번호, e1.EMP_NAME as 이름, d1.DEPT_TITLE as 부서, e1.SALARY as 급여
from (
	select DEPT_ID
    from department
    where DEPT_TITLE like '%영업%') as subquery
left join employee e1 on subquery.DEPT_ID = e1.DEPT_CODE
left join department d1 on e1.DEPT_CODE = d1.DEPT_ID;

-- Q4-1
select d1.DEPT_ID, d1.DEPT_TITLE, l1.LOCAL_NAME, n1.NATIONAL_NAME
from department d1
left join location l1 on d1.LOCATION_ID = l1.LOCAL_CODE
left join nation n1 on l1.NATIONAL_CODE = n1.NATIONAL_CODE;

-- Q4-2
	select EMP_ID, EMP_NAME, SALARY, sb1.DEPT_TITLE, sb1.NATIONAL_NAME
    from employee e1
    left join (
		select d1.DEPT_ID, d1.DEPT_TITLE, l1.LOCAL_NAME, n1.NATIONAL_NAME
		from department d1
		left join location l1 on d1.LOCATION_ID = l1.LOCAL_CODE
		left join nation n1 on l1.NATIONAL_CODE = n1.NATIONAL_CODE) as sb1 on e1.DEPT_CODE = sb1.DEPT_ID
	order by sb1.NATIONAL_NAME desc;
    
-- Q5
select e.EMP_ID, e.EMP_NAME, e.SALARY, sb1.DEPT_TITLE, sb1.NATIONAL_NAME, e.SALARY + s.MIN_SAL as 위로금, e.SAL_LEVEL
from employee e
left join (
	select d1.DEPT_ID, d1.DEPT_TITLE, l1.LOCAL_NAME, n1.NATIONAL_NAME
	from department d1
	left join location l1 on d1.LOCATION_ID = l1.LOCAL_CODE
	left join nation n1 on l1.NATIONAL_CODE = n1.NATIONAL_CODE) as sb1
on e.DEPT_CODE = sb1.DEPT_ID
left join sal_grade s on e.SAL_LEVEL = s.SAL_LEVEL
where sb1.NATIONAL_NAME = '러시아'