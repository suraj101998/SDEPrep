/*find the employees who earn more that the average salary in their department*/
SELECT e.employee_id, e.name, e.salary, e.department_id
FROM employees e
WHERE e.salary > (
    SELECT AVG(e2.salary)
    FROM employees e2
    WHERE e2.department_id = e.department_id
);


/********OR*********/

SELECT employee_id, name, salary, department_id
FROM (
    SELECT 
        employee_id, 
        name, 
        salary, 
        department_id, 
        AVG(salary) OVER (PARTITION BY department_id) AS avg_salary
    FROM employees
) sub
WHERE salary > avg_salary;
