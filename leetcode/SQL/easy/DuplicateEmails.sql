/**Write a SQL query to find all duplicate emails in a table named Person.

**/

select email FROM 
(
SELECT email, count(1) as ct FROM Person
group by email
) where ct > 1;
