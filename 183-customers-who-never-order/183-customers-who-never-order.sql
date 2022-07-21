# Write your MySQL query statement below
select name as Customers from Customers C LEFT JOIN Orders O on C.id = O.customerId WHERE O.id IS NULL;