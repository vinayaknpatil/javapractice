/**
A country is big if it has an area of bigger than 3 million square km or a population of more than 25 million.

Write a SQL solution to output big countries' name, population and area.
**/

select name, population, area
from world
where (area > 3000000 || population > 25000000);
