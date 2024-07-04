SELECT * FROM organisation.emp;

#1)Display all employee names in ascending order
select ENAME from EMP 
order by ename asc;

#2)Display all employee names, salary, commision of employees in dept 10
select ENAME, SAL, COMM from EMP where DEPTNO=10;

#3)Display all employees in deptno 20 and 30
select * from EMP where DEPTNO in (20,30);

#4)Display all employees who are managers(job title)
select * from EMP where JOB like 'MANAGER';

#5)Display all employees whose salary is between 2000 to 5000
select * from EMP where SAL between 2000 and 5000;

#6)Display all employees whose commision is NULL
select * from emp where COMM is null;

#7)Display employee name, salary, commission in descending order based on salary
select ENAME, SAL, coalesce(COMM, 0) as COMM from EMP 
order by SAL desc;

#8)Display average, max, min and sum of salaries of employees
select avg(SAL) as AVGSAL, max(SAL) as MAXSAL, min(SAL) as MINSAL, sum(SAL) as SUMSAL from EMP;

#9)Display hire date, current date and tenure(in months) of the employees
select 
HIREDATE, 
curdate() as CURRDATE , 
concat(TIMESTAMPDIFF(MONTH, HIREDATE, curdate()), ' months') as TENURE
from EMP;

#10)Display all employees whose name starts with 'S'.
select * from EMP where ENAME like 's%';

#11)Display unique deptno from emp table
select distinct DEPTNO from EMP;

#12)Display employee's job in lower case
select lower(JOB) as Designation from EMP;

#13)Select top 3 salary earning employees(employees can be more than 3)
SELECT ENAME, JOB, SAL
FROM EMP e
WHERE (
    SELECT COUNT(DISTINCT SAL)
    FROM EMP
    WHERE SAL > e.SAL
) < 3
ORDER BY SAL DESC;

#14)Select all clerks and managers in dept 10
select * from EMP where JOB in ('CLERK','MANAGER');

#15)Display all clerks in ascending order of deptno
select * from EMP 
where JOB like 'CLERK'
order by DEPTNO asc;

#16)Display all employees department wise
select * from EMP
order by DEPTNO;

#17)Display how many employees are there for each job
select count(*) as NumOfEmployees, JOB from EMP 
group by JOB;

#18)Display what jobs are there for each department and number of employees for each job
SELECT DEPTNO, JOB, COUNT(*) AS NumOfEmployees
FROM EMP
GROUP BY DEPTNO, JOB
ORDER BY DEPTNO, JOB;

#20)Display how many employees are there for each department
select count(*) as NumOfEmployees, DEPTNO from EMP 
group by DEPTNO;

#21)Display the rank of each employee with respect to their salary (highest salary will be rank 1)
select e1.ENAME, e1.JOB, e1.SAL, (select count(e2.SAL)+1 from EMP e2 where e2.SAL > e1.SAL) as SalaryRank from EMP e1
order by e1.SAL desc;