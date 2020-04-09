/**
Given a Weather table, write a SQL query to find all dates' Ids with higher temperature compared to its previous (yesterday's) dates.
**/

SELECT ID FROM WEATHER w1
WHERE w1.Temperature > (select w2.Temperature from weather w2 where
w2.RecordDate = w1.RecordDate - 1);
