/**
There is a table courses with columns: student and class

Please list out all classes which have more than or equal to 5 students.
**/

SELECT class FROM 
( SELECT class, count(distinct student ) as ct FROM courses
group by class 
)
where ct >= 5;
