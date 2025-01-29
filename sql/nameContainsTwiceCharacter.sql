/*Write a SQL query to fetch all the employees whose name contains twice the letter 'a'*/
SELECT *
FROM employees
WHERE name LIKE '%a%a%' 
  AND name NOT LIKE '%a%a%a%';

/*********OR***********/

SELECT *
FROM employees
WHERE LENGTH(name) - LENGTH(REPLACE(name, 'a', '')) = 2;
