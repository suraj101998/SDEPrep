/*write the query to find the most frequently occuring value in column*/
SELECT column_name, COUNT(column_name) AS frequency
FROM table_name
GROUP BY column_name
ORDER BY frequency DESC
LIMIT 1;


/*******OR*******/

SELECT column_name, COUNT(column_name) AS frequency
FROM table_name
GROUP BY column_name
HAVING COUNT(column_name) = (
    SELECT MAX(frequency)
    FROM (
        SELECT COUNT(column_name) AS frequency
        FROM table_name
        GROUP BY column_name
    ) subquery
);
