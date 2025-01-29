/*write a SQL query to count how many employees share same salary*/

SELECT salary, COUNT(*) AS employee_count
FROM employees
GROUP BY salary
HAVING COUNT(*) > 1;


/*************OR************/

SELECT e.*
FROM employees e
WHERE e.salary IN (
    SELECT salary
    FROM employees
    GROUP BY salary
    HAVING COUNT(*) > 1
);
