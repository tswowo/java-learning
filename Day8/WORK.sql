-- 1. 查询员工的姓名 , 及所属的部门名称 (隐式内连接实现)
SELECT e.name,
       d.name
FROM tb_emp AS e,
     tb_dept AS d
WHERE e.dept_id = d.id;

-- 2. 查询员工的姓名 , 及所属的部门名称 (显式内连接实现)
SELECT e.name,
       d.name
FROM tb_emp AS e
         INNER JOIN tb_dept AS d ON e.dept_id = d.id;

-- 3. 查询员工的 姓名、性别、职位、部门名称 （隐式内连接）
SELECT e.name, e.gender, e.job, d.name
FROM tb_emp AS e,
     tb_dept AS d
WHERE e.dept_id = d.id;

-- 4. 查询 薪资 高于 10000 的员工的姓名、性别、职位、部门名称（显式内连接）
SELECT e.name, e.gender, e.job, d.name
FROM tb_emp AS e
         INNER JOIN tb_dept AS d
                    ON e.dept_id = d.id
WHERE e.salary > 10000;

-- 5. 查询员工表 所有 员工的姓名, 和对应的部门名称 (左外连接)
SELECT e.name, d.name
FROM tb_emp AS e
         LEFT OUTER JOIN tb_dept AS d ON e.dept_id = d.id;

-- 6. 查询员工表 所有 员工的姓名, 和对应的部门名称 (右外连接)
SELECT e.name, d.name
FROM tb_dept AS d
         RIGHT OUTER JOIN tb_emp AS e ON e.dept_id = d.id;


-- 7. 查询部门表 所有 部门的名称, 和对应的员工名称 (右外连接)
SELECT d.name, e.name
FROM tb_emp AS e
         RIGHT OUTER JOIN tb_dept AS d ON d.id = e.dept_id;

-- 8. 查询 "教研部" 的所有员工信息 （标量子查询）
SELECT *
FROM tb_emp
WHERE dept_id = (SELECT id FROM tb_dept WHERE name = '教研部');

-- 9. 查询在 "方东白" 入职之后的员工信息 （标量子查询）
SELECT *
FROM tb_emp AS e1
WHERE e1.entrydate > (SELECT e2.entrydate FROM tb_emp AS e2 WHERE e2.name = '方东白');


-- 10. 查询 "教研部" 和 "咨询部" 的所有员工信息 （列子查询）
SELECT *
FROM tb_emp AS e
WHERE e.dept_id IN (SELECT id FROM tb_dept WHERE name = '教研部' OR name = '咨询部');

-- 11. 查询与 "韦一笑" 的入职日期 及 职位都相同的员工信息 （行子查询）
SELECT *
FROM tb_emp AS e
WHERE (e.entrydate, e.job) = (SELECT entrydate, job FROM tb_emp WHERE name = '韦一笑');

-- 12. 查询入职日期是 "2006-01-01" 之后的员工信息 , 及其部门信息 （表子查询）
SELECT t1.*, d.*
FROM (SELECT * FROM tb_emp AS e WHERE e.entrydate > '2006-01-01') AS t1
         LEFT JOIN tb_dept AS d ON t1.dept_id = d.id;

-- 13. 查询 拥有员工的 部门ID、部门名称 (没有员工的部门无需展示)
SELECT DISTINCT d.id, d.name
FROM tb_dept AS d
         INNER JOIN tb_emp AS e ON d.id = e.dept_id;

-- 14. 查询所有 在 2010-01-01 之后入职的员工, 及其归属的部门名称; 如果员工没有分配部门, 也需要展示出来
SELECT e.name, d.name
FROM tb_emp AS e
         LEFT OUTER JOIN tb_dept AS d ON e.dept_id = d.id
WHERE e.entrydate > '2010-01-01';

-- 15. 查询 "教研部" 员工的平均工资
SELECT AVG(e.salary)
FROM tb_emp AS e
WHERE e.dept_id = (SELECT id FROM tb_dept WHERE name = '教研部');

-- 16. 查询工资比 "俞莲舟" 高的员工信息。
SELECT *
FROM tb_emp AS e
WHERE e.salary > (SELECT e2.salary FROM tb_emp AS e2 WHERE name = '俞莲舟');

-- 17. 查询 工资 比该企业员工的平均薪资 还要高的员工信息
SELECT *
FROM tb_emp AS e
WHERE e.salary > (SELECT AVG(salary) FROM tb_emp);

-- 18. 查询所有的部门信息, 并统计部门的员工人数
SELECT d.id, d.name, COUNT(e.id) AS 人数
FROM tb_dept AS d
         LEFT JOIN tb_emp AS e ON d.id = e.dept_id
GROUP BY d.id;

-- 19. 查询所有员工的 姓名, 工资 , 及 工资等级 (有难度的哦)
SELECT e.name,
       e.salary,
       CASE
           WHEN e.salary >= 5000 THEN '5000级'
           WHEN e.salary >= 4000 THEN '4000级'
           WHEN e.salary >= 3000 THEN '3000级'
           WHEN e.salary >= 2000 THEN '2000级'
           WHEN e.salary >= 1000 THEN '1000级'
           ELSE '500级'
           END AS level
FROM tb_emp AS e;

-- 20. 查询 "教研部" 所有员工的信息 及 工资等级 (有难度的哦)
SELECT e.*,
       CASE
           WHEN e.salary >= 5000 THEN '5000级'
           WHEN e.salary >= 4000 THEN '4000级'
           WHEN e.salary >= 3000 THEN '3000级'
           WHEN e.salary >= 2000 THEN '2000级'
           WHEN e.salary >= 1000 THEN '1000级'
           ELSE '500级'
           END AS level
FROM tb_emp AS e
WHERE e.dept_id = (SELECT d.id FROM tb_dept AS d WHERE name = '教研部');

-- 21. 查询 工资 低于 本部门平均工资的员工信息 (有难度的哦)
SELECT *
FROM tb_emp AS e
WHERE e.salary < (SELECT AVG(e1.salary) FROM tb_emp AS e1 WHERE e1.dept_id = e.dept_id);

-- 22. 列出所有部门的详细信息(包括部门ID, 部门名称)和人数
SELECT d.id, d.name, COUNT(e.id) AS 人数
FROM tb_dept AS d
         LEFT JOIN tb_emp AS e ON d.id = e.dept_id
GROUP BY d.id;

-- 23、取得每个薪资等级有多少员工  (有难度的哦)
SELECT CASE
           WHEN e.salary >= 5000 THEN '5000级'
           WHEN e.salary >= 4000 THEN '4000级'
           WHEN e.salary >= 3000 THEN '3000级'
           WHEN e.salary >= 2000 THEN '2000级'
           WHEN e.salary >= 1000 THEN '1000级'
           ELSE '500级'
           END  AS level,
       COUNT(*) AS 人数
FROM tb_emp AS e
GROUP BY CASE -- 不能直接用别名level，需重复CASE表达式（或用子查询）
             WHEN e.salary >= 5000 THEN '5000级'
             WHEN e.salary >= 4000 THEN '4000级'
             WHEN e.salary >= 3000 THEN '3000级'
             WHEN e.salary >= 2000 THEN '2000级'
             WHEN e.salary >= 1000 THEN '1000级'
             ELSE '500级'
             END;

-- 24. 取得每个部门最高薪水的人员名称
SELECT d.name, e.name, e.salary
FROM tb_dept AS d
         LEFT JOIN tb_emp AS e ON d.id = e.dept_id
WHERE (d.id, e.salary) IN (SELECT dept_id, MAX(salary) FROM tb_emp WHERE dept_id IS NOT NULL GROUP BY dept_id)
ORDER BY d.id;

