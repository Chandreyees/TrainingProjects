--ques 5
/*
Write a Procedure supplying name information from the Person.Person table and accepting a filter for the first name. Alter the above 
Store Procedure to supply Default Values if user does not enter any value. ( Use AdventureWorks
*/

create procedure Display_PersonInfo
@FirstName nvarchar(25)='Default'
as
Begin
select p.BusinessEntityID as 'Id',
p.FirstName+p.LastName as 'Name',
p.PersonType
from Person.Person p where FirstName=@FirstName
End

exec Display_PersonInfo
exec Display_PersonInfo @FirstName='Ed'