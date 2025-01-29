/*rank products by sales in decending order for each region.*/

SELECT product_id, region, sales, 
       ROW_NUMBER() OVER (PARTITION BY region ORDER BY sales DESC) AS rank
FROM products
ORDER BY region, rank;