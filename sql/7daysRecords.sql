/*fetch records where the date is within the last 7 days from today*/
SELECT *
FROM table_name
WHERE date_column >= CURDATE() - INTERVAL 7 DAY;
