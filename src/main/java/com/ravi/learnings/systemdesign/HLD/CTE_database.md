CTE: Common Table Expression
When we have complex query and want to break it in temporary table that will be used in another query we use CTE there
with CTE we create a temporary table in the memory that will present till query completes.

WITH cte_name AS (
    SELECT query
)
SELECT *
FROM cte_name;

I.E If we want to get the employees which has salary greater than average salary we can do that:
1. select * from employee where salary > (select avg(salary) from employee); -- We created subquery
2.  with average_salary (avg_salary) as (select avg(employee.salary) from employee)
    select e.*
    from employee e,
         average_salary ab
    where salary > ab.avg_salary;

Main difference between 1 and 2nd approach is reusability and maintainability, in CTE we can use average_salary multiple
times
But in subquery we need to calculate it again if we want to use it again in query or somewhere else


