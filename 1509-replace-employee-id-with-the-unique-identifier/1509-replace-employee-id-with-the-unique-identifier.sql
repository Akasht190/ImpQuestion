# Write your MySQL query statement below

-- select a.unique_id,b.name from employees b left join EmployeeUNI  a
-- on a.id=b.id 

select a.unique_id,b.name from employees b   left join employeeUNI a on a.id=b.id