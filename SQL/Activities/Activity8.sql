select customer_id, max(purchase_amount) as "Maximum  Purchase" from orders group by customer_id;

select salesman_id, order_date, max(purchase_amount) as "Maximum  Purchase" from orders
where order_date =To_DATE('2012/08/17', 'YYYY/MM/DD') group by salesman_id,order_date;

select customer_id, order_date, max(purchase_amount) as "Maximum  Purchase" from orders
group by customer_id,order_date having max(purchase_amount) in (2030, 3450, 5760, 6000) ;