<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" import="java.util.List,com.phoenix.entities.Product"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>
</head>
<body bgcolor="yellow">

     <%
     HttpSession ss=request.getSession(false);
     if(ss != null ) { %>
     <%@ include file="header.html" %>
      <mark>Select products of your choice</mark></p> 
    <% List<Product> products = (List<Product>)ss.getAttribute("products"); %>
    <table border="1">
       <tr>
          <td>ProductId</td>
          <td>Name</td>
       <td>Brand</td>
       <td>Price</td>
       </tr>
    <% for(Product product:products){ %>
      <tr>
      
      <td><%= product.getId() %></td>
      <td><%= product.getName()%></td>
      <td><%= product.getBrand()%></td>
      <td><%= product.getPrice()%></td>
      </tr>
      <%} %>
    </table>
    
     
     
     
     
   <%   
     }  
    else
    {    %>
       <h2 style="color:red;">Sorry ! Your session is expired</h2> 
     <% } %>
     <%@ include file="footer.html" %>
</body>
</html>