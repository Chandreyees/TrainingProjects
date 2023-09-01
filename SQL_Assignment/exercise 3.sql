--exercise 3
/*
Show the most recent five orders that were purchased from account numbers that have spent more than $70,000 with 
AdventureWorks.
*/

select top 5 soh.SalesOrderID as OrderId,
soh.OrderDate as DateOfOrder,
soh.AccountNumber as AccountNumber
from Sales.SalesOrderHeader soh
where soh.TotalDue>70000
order by OrderDate DESC;

