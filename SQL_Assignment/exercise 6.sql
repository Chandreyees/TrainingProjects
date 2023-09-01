--ques 6
/*
Write a trigger for the Product table to ensure the list price can never be raised more than 15 Percent in a single change. Modify the 
above trigger to execute its check code only if the ListPrice column is updated (Use AdventureWorks Database)
*/

GO
CREATE OR ALTER TRIGGER [Production].UpTrigger
ON Production.Product
INSTEAD OF UPDATE AS SET NOCOUNT ON
BEGIN
	IF UPDATE(ListPrice)					
	DECLARE @OldListPrice money
	DECLARE @InsertedListPrice money
	DECLARE @ID int
	SELECT @OldListPrice = p.ListPrice,
		   @InsertedListPrice=inserted.ListPrice,
		   @ID = inserted.ProductID
	FROM Production.Product p, inserted
	WHERE p.ProductID = inserted.ProductID;

	IF( @InsertedListPrice > ( @OldListPrice + (0.15*@OldListPrice) ) ) 
	BEGIN
		RAISERROR('LIST PRICE MORE THAN 15 PERCENT, TRANSACTION FAILED',16,0)
		ROLLBACK TRANSACTION
	END
	ELSE
	BEGIN
		Update Production.Product SET ListPrice=@InsertedListPrice 
		WHERE Production.Product.ProductID = @ID;
	END
	
END;
SELECT Production.Product.ProductID,
	   Production.Product.ListPrice
FROM PRODUCTION.Product;

UPDATE PRODUCTION.Product 
SET ListPrice=2
WHERE Product.ProductID=4;