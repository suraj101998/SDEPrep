/*write a query to calculate the running total of sales by date*/

SELECT 
    sales_date,
    SUM(sales_amount) AS daily_sales,
    SUM(sales_amount) OVER (ORDER BY sales_date) AS running_total
FROM sales
ORDER BY sales_date;


/*******OR**********/

SELECT 
    s1.sales_date,
    SUM(s1.sales_amount) AS daily_sales,
    (SELECT SUM(s2.sales_amount) 
     FROM sales s2 
     WHERE s2.sales_date <= s1.sales_date) AS running_total
FROM sales s1
GROUP BY s1.sales_date
ORDER BY s1.sales_date;
