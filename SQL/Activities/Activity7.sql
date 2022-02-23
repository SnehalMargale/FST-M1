select sum(purchase_amount) as "Total Purchase" from orders;
select avg(purchase_amount) as "Average  Purchase" from orders;
select max(purchase_amount) as "Maximum  Purchase" from orders;
select min(purchase_amount) as "Minimum  Purchase" from orders;
select count(distinct salesman_id) as "Number of Salesman" from orders;