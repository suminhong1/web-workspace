<%@page import="model.Item"%> <%@ page language="java" contentType="text/html;
charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
    <% Item item = (Item) request.getAttribute("item"); %>
    <h1><%= item.getItemName() %>의 정보</h1>
    <span>조회수 : </span><br />
    <a href="cartList.jsp">장바구니 담기</a><br />
    <a href="cartList.jsp">장바구니 확인</a><br />
    <a href="itemList.jsp">상품 목록 보기</a><br />
    <ul>
      <li>종류 : <%= item.getItemName() %></li>
      <li>가격 : <%= item.getPrice() %></li>
      <li>설명 : <%= item.getDescription() %></li>
    </ul>
  </body>
</html>
