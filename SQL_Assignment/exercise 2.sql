--Exercise 2

/*
Write separate queries using a join, a subquery, a CTE, and then an EXISTS to list all AdventureWorks customers who have not placed 
an order.
*/

--   using join
select p.FirstName,p.LastName as CustomerName from Person.Person p
inner join Sales.Customer on p.BusinessEntityID=Sales.Customer.CustomerID 
left join Sales.SalesOrderHeader ss on ss.CustomerID=Sales.Customer.CustomerID
where ss.SalesOrderID is null;

--   using cte
with ss as(select Sales.SalesOrderHeader.CustomerID,Sales.SalesOrderHeader.SalesOrderID 
from Sales.SalesOrderHeader)
select p.FirstName,p.LastName as customername
 from Person.Person p inner join Sales.Customer on 
 p.BusinessEntityID=Sales.Customer.CustomerID
 left join ss on Sales.Customer.CustomerID=ss.CustomerID
where ss.SalesOrderID is null

--   using sub query
select p.FirstName,p.LastName as CustomerName from Person.Person p 
where p.BusinessEntityID in
(select sc.CustomerID from Sales.Customer sc where sc.CustomerID not in
(select soh.CustomerID from Sales.SalesOrderHeader soh));

--   using exist
select p.FirstName,p.LastName as CustomerName from Person.Person p where exists
(select Sales.Customer.CustomerID from Sales.Customer where p.BusinessEntityID=Sales.Customer.CustomerID
and not exists(select Sales.SalesOrderHeader.CustomerID from Sales.SalesOrderHeader 
where Sales.SalesOrderHeader.CustomerID=Sales.Customer.CustomerID));



