/*
we have two tables customers and expenditure.
tbl_customers: id, name, date
tbl_expenditure: id, cust_id(refers to the id in the customers table), amount

Note: multiple expenditure may have been done from same customers also.
output: find the average amount spent on a paticular day by the by particular customers.
Write a sql query with sample data.
Sample Data:

tbl_customers:
id	name	date
1	Alice	2024-09-01
2	Bob	    2024-09-02
3	Carol	2024-09-02

tbl_expenditure:
id	cust_id	    amount
1	    1	       50
2	    1	       150
3	    2	       200
4	    2	       100
5	    3	       300
Output Explanation:
Executing the query on the sample data will return the following:

name	    date	        avg_amount_spent
Alice	    2024-09-01	    100
Bob	        2024-09-02	    150
Carol	    2024-09-02	    300
*/

SELECT 
    c.name,
    c.date,
    AVG(e.amount) AS avg_amount_spent
FROM 
    tbl_customers c
JOIN 
    tbl_expenditure e ON c.id = e.cust_id
GROUP BY 
    c.id, c.name, c.date;
