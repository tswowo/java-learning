SELECT *
FROM emp
WHERE gender = 1
  AND job = 2
ORDER BY entry_date;

SELECT *
FROM emp
ORDER BY entry_date, id DESC;

SELECT *
FROM emp
WHERE gender = 1
  AND salary > 6000
ORDER BY entry_date, id DESC;

SELECT *
FROM emp
WHERE gender = 1
  AND entry_date BETWEEN '2005-10-01' AND '2018-10-01'
ORDER BY entry_date,
         id DESC;

SELECT *
FROM emp
WHERE name LIKE '阮%'
  AND entry_date > '2010-10-01'
ORDER BY entry_date
LIMIT 5 OFFSET 0;