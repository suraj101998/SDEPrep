/*
SQL query to fetch the names of all activities with neither the maximum nor the minimum number of participants.

Table Structures:
friends Table:
ID (INTEGER) - The ID of a friend (Primary Key)
NAME (STRING) - The name of the friend
ACTIVITY (STRING) - The name of the activity that the friend participates in

activities Table:
ID (INTEGER) - The ID of the activity (Primary Key)
NAME (STRING) - The name of the activity

Objective:
We need to select the activities that have neither the maximum nor the minimum number of participants.
*/

SELECT a.NAME AS activity_name
FROM activities a
WHERE (
    SELECT COUNT(f.ID)
    FROM friends f
    WHERE f.ACTIVITY = a.NAME
) NOT IN (
    SELECT MAX(participant_count) FROM (
        SELECT COUNT(f.ID) AS participant_count
        FROM friends f
        GROUP BY f.ACTIVITY
    ) AS participant_counts
    UNION
    SELECT MIN(participant_count) FROM (
        SELECT COUNT(f.ID) AS participant_count
        FROM friends f
        GROUP BY f.ACTIVITY
    ) AS participant_counts
);
