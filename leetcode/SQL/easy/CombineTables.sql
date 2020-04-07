/**
Write a SQL query for a report that provides the following information for each person in the Person table, regardless if there is an address for each of those people:


**/

select p.FirstName, p.LastName, address.City, address.State
FROM Person p left outer join Address address
ON p.personId = address.PersonId;
