<%@page import="com.entities.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<title>Displaying Result</title>
</head>
<body>

<%
List<Product> products=(List<Product>)request.getAttribute("products");
if(products.size()==0){
%>
<div>No product as per choice available</div>
<%} 
else{
%>

<table class="table table-striped">
  <thead>
    <tr>
      
      <th scope="col">Id</th>
      <th scope="col">Name</th>
      <th scope="col">Colour</th>
      <th scope="col">Gender-Recomendation</th>
      <th scope="col">Size</th>
      <th scope="col">Price</th>
      <th scope="col">Rating</th>
      <th scope="col">Availability</th>
    </tr>
  </thead>
  <tbody>
  <%
  for(Product pro:products){
  %>
    <tr>
     
      <th scope="col"><% out.println(pro.getId()); %></th>
      <th scope="col"><% out.println(pro.getName()); %></th>
      <th scope="col"><% out.println(pro.getColor()); %></th>
      <th scope="col"><% out.println(pro.getGender()); %></th>
      <th scope="col"><% out.println(pro.getSize()); %></th>
      <th scope="col"><% out.println(pro.getPrice()); %></th>
      <th scope="col"><% out.println(pro.getRating()); %></th>
      <th scope="col"><% out.println(pro.getAvail()); %></th>
      <%} %>
    </tr>
   
  </tbody>
</table>
<%} %>
</body>
</html>