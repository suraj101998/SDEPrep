/*how would you retrive only duplicate records form a table*/
SELECT column1, column2, ..., columnN, COUNT(*)
FROM table_name
GROUP BY column1, column2, ..., columnN
HAVING COUNT(*) > 1;


/************OR************/

SELECT e1.*
FROM employees e1
JOIN (
    SELECT name, salary
    FROM employees
    GROUP BY name, salary
    HAVING COUNT(*) > 1
) e2
ON e1.name = e2.name AND e1.salary = e2.salary;
