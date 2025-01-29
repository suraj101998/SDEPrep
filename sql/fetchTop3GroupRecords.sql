/*How would you fetch top 3 records for each group in a table*/
SELECT *
FROM (
    SELECT 
        column1, column2, group_column, 
        ROW_NUMBER() OVER (PARTITION BY group_column ORDER BY column_to_sort DESC) AS row_num
    FROM table_name
) sub
WHERE row_num <= 3;


/**********OR*********/

SELECT t1.*
FROM table_name t1
WHERE (
    SELECT COUNT(*) 
    FROM table_name t2
    WHERE t2.group_column = t1.group_column
          AND t2.column_to_sort >= t1.column_to_sort
) <= 3;
