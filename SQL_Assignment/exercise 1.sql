--ques 1
/*
Display the number of records in the [SalesPerson] table. (Schema(s) involved: Sales)
*/
select count(*) from Sales.SalesPerson

--ques 2.
/*
Select both the FirstName and LastName of records from the Person table where the FirstName begins with the letter ‘B’. 
(Schema(s) involved: Person)
*/
select FirstName,LastName from Person.Person where FirstName like 'B%';

--ques 3
/*
Select a list of FirstName and LastName for employees where Title is one of Design Engineer, Tool Designer or Marketing 
Assistant. (Schema(s) involved: HumanResources, Person)
*/

select p.FirstName, p.LastName from Person.Person p inner join
HumanResources.Employee on (p.BusinessEntityID=HumanResources.Employee.BusinessEntityID)
where HumanResources.Employee.JobTitle='Tool Designer'
or HumanResources.Employee.JobTitle='Design Engineer'
or HumanResources.Employee.JobTitle='Marketing Assistant';


--ques 4
/*
Display the Name and Color of the Product with the maximum weight. (Schema(s) involved: Production
*/
select top(1) pp.Name,pp.Color 
from Production.Product  pp order by pp.Weight DESC

--ques 5
/*
Display Description and MaxQty fields from the SpecialOffer table. Some of the MaxQty values are NULL, in this case display 
the value 0.00 instead. (Schema(s) involved: Sales)
*/
select sso.Description,
case
when sso.MaxQty Is null then 0.00
else sso.MaxQty
end as MaxQty
from Sales.SpecialOffer sso


--ques 6
/*
Display the overall Average of the [CurrencyRate].[AverageRate] values for the exchange rate ‘USD’ to ‘GBP’ for the year 2005 
i.e. FromCurrencyCode = ‘USD’ and ToCurrencyCode = ‘GBP’. Note: The field [CurrencyRate].[AverageRate] is defined as 
'Average exchange rate for the day.' (Schema(s) involved: Sales)
*/
select AVG(scr.EndOfDayRate) 
from Sales.CurrencyRate scr
where scr.FromCurrencyCode='USD' and scr.ToCurrencyCode='GBP' and 
year(scr.CurrencyRateDate)='2005';

select AVG(scr.AverageRate) 
from Sales.CurrencyRate scr
where scr.FromCurrencyCode='USD' and scr.ToCurrencyCode='GBP' and 
year(scr.CurrencyRateDate)='2005';


--ques 7
/*
Display the FirstName and LastName of records from the Person table where FirstName contains the letters ‘ss’. Display an 
additional column with sequential numbers for each row returned beginning at integer 1. (Schema(s) involved: Person
*/
select p.FirstName,p.LastName,ROW_NUMBER() OVER (ORDER BY p.BusinessEntityID ASC) AS Id
from Person.Person p where p.FirstName like '%ss%';


--ques 8
/*
Sales people receive various commission rates that belong to 1 of 4 bands. (Schema(s) involved: Sales)
Display the [SalesPersonID] with an additional column entitled ‘Commission Band’ indicating the appropriate band as above
*/
select ssp.BusinessEntityID,
case when ssp.CommissionPct=0.00 then 'Band 0'
when ssp.CommissionPct<=0.01 then 'Band 1'
when ssp.CommissionPct<=0.15 then 'Band 2'
when ssp.CommissionPct>0.15 then 'Band 3'
end as CommissionBand
from Sales.SalesPerson ssp


--ques 9
/*
Display the managerial hierarchy from Ruth Ellerbrock (person type – EM) up to CEO Ken Sanchez. Hint: use 
[uspGetEmployeeManagers] (Schema(s) involved: [Person], [HumanResources])
*/
DECLARE @RuthEllerbrockBusinessEntityID INT
SET @RuthEllerbrockBusinessEntityID = (SELECT BusinessEntityID FROM Person.Person
WHERE FirstName = 'Ruth' and LastName = 'Ellerbrock' and PersonType = 'EM')
exec dbo.uspGetEmployeeManagers @BusinessEntityId = @RuthEllerbrockBusinessEntityID



--ques 10
/*
Display the ProductId of the product with the largest stock level. Hint: Use the Scalar-valued function [dbo]. [UfnGetStock]. 
(Schema(s) involved: Production)
*/
select pp.ProductID from Production.Product pp
where pp.SafetyStockLevel=(select max(pp.SafetyStockLevel)
from Production.Product pp);
