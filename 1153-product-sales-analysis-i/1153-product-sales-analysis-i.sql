# Write your MySQL query statement below

select a.product_name,b.year,b.price from sales b 
 left join product a on a.product_id=b.product_id