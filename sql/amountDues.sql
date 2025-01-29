/* we have two tables cutstomers and transactions.

tbl_customer: id, first_name, last_name, interest(rate of intersest)
tbl_transactions: txn_id, cust_id(refers to the id in the customer table), Amount

Note: Any customer may have done multiple transactions also.

output: first name + last name as full name along with amount due( total txn amount + interest on that amount) where interest_rate > 12%
order by desc. 

Write a sql query.

Sample Data:
tbl_customer:
id	first_name	last_name	interest
1	John	        Doe	        15
2	Jane	        Smith	    10
3	Mike	        Johnson	    18


tbl_transactions:
txn_id	cust_id	    Amount
101	        1	    100
102	        1	    200
103	        2	    300
104	        3	    400
105	        3	    100

Final Output:
full_name	    amount_due
Mike Johnson	    590
John Doe	        345
*/

SELECT 
    CONCAT(c.first_name, ' ', c.last_name) AS full_name,
    SUM(t.Amount) + (SUM(t.Amount) * c.interest / 100) AS amount_due
FROM 
    tbl_customer c
JOIN 
    tbl_transactions t ON c.id = t.cust_id
WHERE 
    c.interest > 12
GROUP BY 
    c.id, c.first_name, c.last_name, c.interest
ORDER BY 
    amount_due DESC;