DROP DATABASE IF EXISTS ORGANISATION;

CREATE DATABASE ORGANISATION;
USE ORGANISATION;

-- Drop tables from top to maintain foriegn key constraint
DROP TABLE IF EXISTS EMP;
DROP TABLE IF EXISTS DEPT;

CREATE TABLE DEPT(
DEPTNO INTEGER NOT NULL,
DNAME VARCHAR(50),
LOC VARCHAR(50),
CONSTRAINT DEPT_PRIMARY_KEY PRIMARY KEY (DEPTNO)
);

CREATE TABLE EMP(
EMPNO INTEGER NOT NULL,
ENAME VARCHAR(50),
JOB VARCHAR(50),
MGR INTEGER,
HIREDATE datetime,
SAL DECIMAL(10,2),
COMM DECIMAL(10,2),
DEPTNO INTEGER NOT NULL,
CONSTRAINT EMP_FOREIGN_KEY FOREIGN KEY(DEPTNO) REFERENCES DEPT(DEPTNO),
CONSTRAINT EMP_PRIMARY_KEY PRIMARY KEY(EMPNO)
);

INSERT INTO DEPT VALUES (10,'ACCOUNTING','NEW YORK');
INSERT INTO DEPT VALUES (20,'RESEARCH','DALLAS');
INSERT INTO DEPT VALUES (30,'SALES','CHICAGO');
INSERT INTO DEPT VALUES (40,'OPERATIONS','BOSTON');

INSERT INTO EMP VALUES (7839,'KING','PRESIDENT',NULL,'1981-11-17',5000,NULL,10);
INSERT INTO EMP VALUES (7698,'BLAKE','MANAGER',7839,'1981-05-1',2850,NULL,30);
INSERT INTO EMP VALUES (7782,'CLARK','MANAGER',7839,'1981-06-9',2450,NULL,10);
INSERT INTO EMP VALUES (7566,'JONES','MANAGER',7839,'1981-4-2',2975,NULL,20);
INSERT INTO EMP VALUES (7654,'MARTIN','SALESMAN',7698,'1981-9-28',1250,1400,30);
INSERT INTO EMP VALUES (7499,'ALLEN','SALESMAN',7698,'1981-2-20',1600,300,30);
INSERT INTO EMP VALUES (7844,'TURNER','SALESMAN',7698,'1981-9-8',1500,0,30);
INSERT INTO EMP VALUES (7900,'JAMES','CLERK',7698,'1981-12-3',950,NULL,30);
INSERT INTO EMP VALUES (7521,'WARD','SALESMAN',7698,'1981-2-22',1250,500,30);
INSERT INTO EMP VALUES (7902,'FORD','ANALYST',7566,'1981-12-3',3000,NULL,20);
INSERT INTO EMP VALUES (7369,'SMITH','CLERK',7902,'1980-12-17',800,NULL,20);
INSERT INTO EMP VALUES (7788,'SCOTT','ANALYST',7566,'1982-12-09',3000,NULL,20);
INSERT INTO EMP VALUES (7876,'ADAMS','CLERK',7788,'1983-1-12',1100,NULL,20);
INSERT INTO EMP VALUES (7934,'MILLER','CLERK',7782,'1982-1-23',1300,NULL,10);

CREATE TABLE REGIONS
( REGION_ID INTEGER NOT NULL,
REGION_NAME VARCHAR(20),
PRIMARY KEY(REGION_ID)
);

CREATE TABLE COUNTRIES 
    ( COUNTRY_ID      CHAR(2)
    , COUNTRY_NAME    VARCHAR(40) 
    , REGION_ID       INTEGER 
    , PRIMARY KEY (COUNTRY_ID),
	  CONSTRAINT COUNTR_REG_FK FOREIGN KEY (REGION_ID) REFERENCES REGIONS(REGION_ID)
    ) ;
    
CREATE TABLE LOCATIONS
    ( LOCATION_ID    INTEGER not null
    , STREET_ADDRESS VARCHAR(40)
    , POSTAL_CODE    VARCHAR(12)
    , CITY       VARCHAR(30) NOT NULL
    , STATE_PROVINCE VARCHAR(25)
    , COUNTRY_ID     CHAR(2),
    PRIMARY KEY (LOCATION_ID),
    FOREIGN KEY (COUNTRY_ID) REFERENCES COUNTRIES(COUNTRY_ID)
    ) ;

INSERT INTO regions VALUES( 1, 'Europe');
INSERT INTO regions VALUES( 2, 'Americas');
INSERT INTO regions VALUES( 3, 'Asia');
INSERT INTO regions VALUES( 4, 'Middle East and Asia');

INSERT INTO countries VALUES( 'IT', 'Italy', 1);
INSERT INTO countries VALUES( 'JP', 'Japan', 3);
INSERT INTO countries VALUES( 'US', 'USA', 2);
INSERT INTO countries VALUES( 'CA', 'Canada', 2);
INSERT INTO countries VALUES( 'CN', 'China', 3);
INSERT INTO countries VALUES( 'IN', 'India', 3);
INSERT INTO countries VALUES( 'AU', 'Australia', 3);
INSERT INTO countries VALUES( 'ZW', 'Zimbabwe',4);
INSERT INTO countries VALUES( 'SG', 'Singapore', 3);
INSERT INTO countries VALUES( 'UK', 'United Kingdom', 1);
INSERT INTO countries VALUES( 'FR', 'France', 1);
INSERT INTO countries VALUES( 'DE', 'Germany', 1);
INSERT INTO countries VALUES( 'ZM', 'Zambia', 4);
INSERT INTO countries VALUES( 'EG', 'Egypt', 4);
INSERT INTO countries VALUES( 'BR', 'Brazil', 2);
INSERT INTO countries VALUES( 'CH', 'Switzerland', 1);
INSERT INTO countries VALUES( 'NL', 'Netherlands', 1);
INSERT INTO countries VALUES( 'MX', 'Mexico', 2);
INSERT INTO countries VALUES( 'KW', 'Kuwait', 4);
INSERT INTO countries VALUES( 'IL', 'Israel', 4);
INSERT INTO countries VALUES( 'DK', 'Denmark', 1);
INSERT INTO countries VALUES( 'HK', 'HongKong', 3);
INSERT INTO countries VALUES( 'NG', 'Nigeria', 4);
INSERT INTO countries VALUES( 'AR', 'Argentina', 2);
INSERT INTO countries VALUES( 'BE', 'Belgium', 1);

INSERT INTO locations VALUES( 1000, '1297 Via Cola di Rie', '00989', 'Roma', NULL, 'IT');
INSERT INTO locations VALUES( 1100, '93091 Calle della Testa', '10934', 'Venice', NULL, 'IT');
INSERT INTO locations VALUES( 1200, '2017 Shinjuku-ku', '1689', 'Tokyo', 'Tokyo Prefecture', 'JP');
INSERT INTO locations VALUES( 1300, '9450 Kamiya-cho', '6823', 'Hiroshima', NULL, 'JP');
INSERT INTO locations VALUES( 1400, '2014 Jabberwocky Rd', '26192', 'Southlake', 'Texas', 'US');
INSERT INTO locations VALUES( 1500, '2011 Interiors Blvd', '99236', 'South San Francisco', 'California', 'US');
INSERT INTO locations VALUES( 1600, '2007 Zagora St', '50090', 'South Brunswick', 'New Jersey', 'US');
INSERT INTO locations VALUES( 1700, '2004 Charade Rd', '98199', 'Seattle', 'Washington', 'US');
INSERT INTO locations VALUES( 1800, '147 Spadina Ave', 'M5V 2L7', 'Toronto', 'Ontario', 'CA');
INSERT INTO locations VALUES( 1900, '6092 Boxwood St', 'YSW 9T2', 'Whitehorse', 'Yukon', 'CA');


-- 1) Display all employee names in ascending order
select ENAME from EMP 
order by ename asc;

-- 2) Display all employees(all columns) in department 20 and 30
select * from EMP where DEPTNO = 20 or DEPTNO = 30;

-- 3) Display all the employees who are managers
select * from EMP where JOB like "MANAGER";

-- 4) Display all the employees whose salary is between 2000 and 5000
select * from EMP where SAL between 2000 and 5000;

-- 5) Display all the employees whose commission is null
select * from EMP where COMM is NULL;

-- 6) Display emp_name,salary,comission,ctc(calculated column)
select ENAME, SAL , coalesce(COMM, 0) as COMM, (SAL + coalesce(COMM, 0)) as CTC from EMP;

-- 7) Display hire_date, current_date, tenure(calculated col) of the emp
select 
HIREDATE, 
curdate() as CURRDATE , 
concat(
TIMESTAMPDIFF(YEAR, HIREDATE, curdate()), ' years ',
TIMESTAMPDIFF(MONTH, HIREDATE, curdate())%12, ' months'
) as TENURE

from EMP;

-- 8) Display all the employees whose name starts with s
select * from EMP where ENAME like 's%';

-- 9) Display unique department numbers from the employee table
select distinct DEPTNO from EMP;

-- 10) Display emp_name and job in lower case
select lower(ENAME) as ENMAE, lower(JOB) as JOB from EMP;

-- 11) Select top 3 salary earning employee
select * from EMP 
order by SAL desc limit 3;

-- 12) Select clerks and Managers in department 10
select * from EMP
where JOB in ('CLERK','MANAGER') and DEPTNO=10;

-- 13) Display all clerks in asscending order of the department number
select * from EMP where JOB like 'CLERK'
order by DEPTNO asc;

-- 16) Display All employees in the same dept of 'SCOTT'
select * from EMP where DEPTNO = (select DEPTNO from EMP where ENAME like 'SCOTT');

#17. Employees having same designation of SMITH
select * from EMP where JOB like (select JOB from EMP where ENAME like 'SMITH');

#18. Employee who are reproting under KING
select * from EMP where MGR = (select EMPNO from EMP where ENAME like 'KING');

#19. Employees who have same salary of BLAKE
select * from EMP where SAL = (select SAL from EMP where ENAME like 'BLAKE');

#20. Display departmentwise number of employees
select DNAME, count(*) as NUMOFEMPLYEES 
from EMP e JOIN DEPT d
ON e.DEPTNO = d.DEPTNO
group by DNAME;

#21. Display jobwise number of employees
select JOB, count(*) from EMP
group by JOB;

#22. Display deptwise jobwise number of employees
select d.DNAME, e.JOB, count(*) as NUMOFEMPLYEES 
from EMP e JOIN DEPT d
ON e.DEPTNO = d.DEPTNO
group by d.DNAME, e.JOB;

#23. Display deptwise employees greater than  3 
select DNAME, count(*) as NUMOFEMPLYEES 
from EMP e JOIN DEPT d
ON e.DEPTNO = d.DEPTNO
group by DNAME
having count(*) > 3;

#24. Display designation wise employees count greater than 3 
select JOB, count(*) as NUMOFEMPLYEES
from EMP
group by JOB
having count(*) > 3;

#25. Display Employee name,deptname and location
select ENAME, DNAME, LOC
from EMP e JOIN DEPT d
on e.DEPTNO = d.DEPTNO;

#26. display all deptnames and corresponding employees if ANY
select d.DNAME, e.ENAME
from EMP e LEFT JOIN DEPT d
on e.DEPTNO = d.DEPTNO;

#27. dipslay all deptnames where there are no employees
select d.DNAME
from EMP e LEFT JOIN DEPT d
on e.DEPTNO = d.DEPTNO
where e.ENAME IS NULL;

#28. display deptname wise employee count greater than 3, display in descending order of deptname
select DNAME, count(*) as NUMOFEMPLYEES 
from EMP e JOIN DEPT d
ON e.DEPTNO = d.DEPTNO
group by DNAME
having count(*) > 3
order by DNAME desc;

#29. Display all the empname and their manager names
select e.ENAME as EMPNAME, m.ENAME as MNAME
from EMP e JOIN EMP m
on e.MGR = m.EMPNO;		#Selecting employee's manager's number which shud be equal to emp_num of employee who is manager 

#30. Display empname,deptname and manager name as bossname , order by bossname
select e.ENAME, d.DNAME, m.ENAME as BOSSNAME
from EMP e 
JOIN EMP m on e.MGR = m.EMPNO
JOIN DEPT d on d.DEPTNO = e.DEPTNO
order by BOSSNAME;

#31. Display Dname, employee name and names of their managers
select d.DNAME, e.ENAME, m.ENAME as MANAGER
from EMP e 
JOIN EMP m on e.MGR = m.EMPNO
JOIN DEPT d on d.DEPTNO = e.DEPTNO
order by d.DNAME;



