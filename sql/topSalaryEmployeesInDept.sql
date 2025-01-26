/*fetch all employees whose salary falls within the top 10% of their department.*/

SELECT employee_id, name, department, salary
FROM (
    SELECT employee_id, name, department, salary,
           PERCENT_RANK() OVER (PARTITION BY department ORDER BY salary DESC) AS rank
    FROM employees
) AS ranked_employees
WHERE rank <= 0.1;
