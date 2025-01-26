/*Retrive products that were never sold use left join*/

SELECT p.product_id, p.product_name
FROM products p
LEFT JOIN sales s
ON p.product_id = s.product_id
WHERE s.product_id IS NULL;
