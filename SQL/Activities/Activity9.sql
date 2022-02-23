create table customers (
    customer_id int primary key, customer_name varchar(32),
    city varchar(20), grade int, salesman_id int);
    
insert all
into customers values (3002, 'Nick Rimando', 'New York', 100, 5001) 
into customers values (3007, 'Brad Davis', 'New York', 200, 5001)
into customers values (3005, 'Graham Zusi', 'California', 200, 5002) 
into customers values(3008, 'Julian Green', 'London', 300, 5002)
into customers values(3004, 'Fabian Johnson', 'Paris', 300, 5006)
into customers values(3009, 'Geoff Cameron', 'Berlin', 100, 5003)
into customers values (3003, 'Jozy Altidor', 'Moscow', 200, 5007)
into customers values(3001, 'Brad Guzan', 'London', 300, 5005)
SELECT 1 FROM DUAL;

select a.customer_name as "Cust Name", b.salesman_name as "Salesman Name"
from customers a
inner join salesman b
on a.salesman_id = b.salesman_id;

SELECT a.customer_name, a.grade, b.salesman_name AS "Salesman" 
FROM customers a 
LEFT OUTER JOIN salesman b 
ON a.salesman_id=b.salesman_id WHERE a.grade<300 
ORDER BY a.customer_id;

SELECT a.customer_name, b.salesman_name AS "Salesman" ,b.commission
FROM customers a 
inner join salesman b 
ON a.salesman_id=b.salesman_id WHERE b.commission<12;

select a.order_no, a.order_date, a.purchase_amount, b.customer_name, c.salesman_name,c.commission
from orders a
inner join customers b on a.customer_id= b.customer_id 
inner join salesman c on a.salesman_id=c.salesman_id;