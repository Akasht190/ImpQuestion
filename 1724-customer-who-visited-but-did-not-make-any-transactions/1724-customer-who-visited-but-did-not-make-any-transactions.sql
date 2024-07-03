# Write your MySQL query statement below

-- select v.customer_id ,count(customer_id) as count_no_trans
-- from visits v left join transactions t on v.visit_id = t.visit_id
-- where t.transaction_id is null
-- group by v.customer_id

select a.customer_id,count(a.customer_id) as count_no_trans from visits a left join transactions b on 
a.visit_id=b.visit_id  where b.transaction_id is null  group by a.customer_id