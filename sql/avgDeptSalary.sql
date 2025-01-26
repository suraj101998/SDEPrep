/*
we have two tables Department and Professors.

tbl_Department: id, Department
tbl_Professors: id, department_id(refers to the id in the Department table), name, salary

Note: multiple Professors can belong from same department also.
output: find the department with highest average salary. If two despartment have same average as highest show them both. 
Write a sql query.

Sample Data:

tbl_Department:

id	Department
1	Computer Science
2	Physics
3	Mathematics

tbl_Professors:

id	department_id	name	    salary
1	    1	        Dr. Allen	100000
2	    1	        Dr. Blake	90000
3	    2	        Dr. Carol	110000
4	    2	        Dr. David	115000
5	    3	        Dr. Eve	    105000

Query Output:
Calculation:
Computer Science: (100000 + 90000) / 2 = 95000
Physics: (110000 + 115000) / 2 = 112500
Mathematics: 105000 (only one professor)

Output:

Department	avg_salary
Physics	      112500

*/

SELECT 
    d.Department, 
    AVG(p.salary) AS avg_salary
FROM 
    tbl_Department d
JOIN 
    tbl_Professors p ON d.id = p.department_id
GROUP BY 
    d.id, d.Department
HAVING 
    AVG(p.salary) = (
        SELECT MAX(avg_salary)
        FROM (
            SELECT AVG(salary) AS avg_salary
            FROM tbl_Professors
            GROUP BY department_id
        ) AS dept_avg
    );