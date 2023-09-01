--exercise 4
/*Create a function that takes as inputs a SalesOrderID, a Currency Code, and a date, and returns a table of all the SalesOrderDetail rows 
for that Sales Order including Quantity, ProductID, UnitPrice, and the unit price converted to the target currency based on the end of 
day rate for the date provided. Exchange rates can be found in the Sales.CurrencyRate table. (Use AdventureWorks)
*/

go
create function SalesnewFun
(@SalesOrderId int,@CurrencyCode nchar(3),@OrderDate datetime)
returns table as
return
select sod.ProductID as 'Product Id',
sod.OrderQty as 'Order Quantity',
sod.UnitPrice as 'Unit Price',
sod.UnitPrice*scr.EndOfDayRate as 'Target Price'
from Sales.SalesOrderDetail sod,Sales.CurrencyRate scr
where scr.ToCurrencyCode=@CurrencyCode and
sod.ModifiedDate=@OrderDate and
sod.SalesOrderID=@SalesOrderId 
go

select * from SalesnewFun(43871,'USD','2005-08-01 00:00:00.000')

