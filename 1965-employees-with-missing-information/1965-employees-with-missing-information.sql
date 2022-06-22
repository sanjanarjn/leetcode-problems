# Write your MySQL query statement below
select E1.employee_id
from Employees E1 left join Salaries S1
on E1.employee_id=S1.employee_id
where E1.name is null or S1.salary is null

union distinct

select S2.employee_id
from Employees E2 right join Salaries S2
on E2.employee_id=S2.employee_id
where E2.name is null or S2.salary is null

order by employee_id;