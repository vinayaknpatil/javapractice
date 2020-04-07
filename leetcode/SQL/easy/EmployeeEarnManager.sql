/**
Given the Employee table, write a SQL query that finds out employees who earn more than their managers. For the above table, Joe is the only employee who earns more than his manager.
**/
select name as Employee from employee e1
where e1.salary >
(select e2.salary from employee e2
where e1.managerid = e2.id);
