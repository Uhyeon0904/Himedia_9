-- Q1
select EMP_id, EMP_NAME, PHONE, HIRE_DATE, ENT_YN
from employee
where ENT_YN = 'N' and PHONE like '__________2'
order by HIRE_DATE desc
limit 3;

-- Q2
select EMP_NAME, JOB_NAME, SALARY, EMP_id, EMAIL, PHONE, HIRE_DATE
from employee e
left join job j on e.JOB_CODE = j.JOB_CODE
where j.JOB_NAME like '대리'
order by SALARY desc;

-- Q3
select DEPT_TITLE as 부서명, count(dept_code) as 인원, sum(SALARY) as 급여합계, avg(SALARY) as 급여평균
from employee
left join department on DEPT_CODE = DEPT_ID
where department.DEPT_TITLE is not null
group by DEPT_TITLE
order by DEPT_TITLE;

-- Q4
select emp_name, emp_no, phone, dept_title, job_name
from employee e
left join department on dept_code = dept_id
left join job j on e.JOB_CODE = j.JOB_CODE
order by hire_date;

-- Q5-1
select count(emp_name)
from employee
where MANAGER_ID is not null;

-- Q5-2
select count(e2.emp_name)
from employee e1
left join employee e2 on e1.EMP_ID = e2.MANAGER_ID
where e2.MANAGER_ID is not null;

-- Q5-3
select e1.emp_name as 직원명, e2.EMP_NAME as 관리자
from employee e1
left join employee e2 on e1.MANAGER_ID = e2.EMP_ID
order by e1.EMP_NAME;

-- Q5-4
select e1.EMP_NAME as 직원명, e2.EMP_NAME, d1.DEPT_TITLE as 부서명,
e2.EMP_NAME as 관리자명, d2.DEPT_TITLE as 관리자부서명
from employee e1
left join employee e2 on e2.EMP_ID = e1.MANAGER_ID
left join department d1 on e1.DEPT_CODE = d1.DEPT_ID
left join department d2 on e2.DEPT_CODE = d2.DEPT_ID
where e2.EMP_NAME is not null
order by e1.EMP_NAME;

-- Q5-4-re
select e1.emp_name as 직원명,
dept_title as 부서명,
emp_name as 관리자직원명,
dept_title as 관리자부서명
from employee e1
left join employee e2 on e1.MANAGER_ID = e2.EMP_ID
left join department d1 on e1.MANAGER_ID = d1.DEPT_ID