<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <style>
      h1 {
        display: flex;
        justify-content: center;
        align-items: center;
        margin: 50px;
      }
      div {
        display: flex;
        justify-content: center;
        align-items: center;
        margin: 50px;
      }
      a {
        text-decoration-line: none;
        font-size: 10px;
        color: black;
        margin-left: 20px;
      }
      img {
        height: 10rem;
        width: 10rem;
      }
      h2 {
        display: flex;
        justify-content: center;
        align-items: center;
        margin: 50px;
      }
    </style>
  </head>
  <body>
    <h1>Fruit Total List</h1>
    <div>
      <a href="itemView.jsp"
        ><img alt="" src="img/berry.jpg" /><br />
        <span id="berry">
          상품명: <%= %><br />
          가격: <%= %>
        </span></a
      >
      <a href="itemView.jsp"
        ><img alt="" src="img/grape.jpg" /><br />
        <span id="grape">
           상품명: <%= %><br />
          가격: <%= %>
          </span
        ></a
      >
      <a href="itemView.jsp"
        ><img alt="" src="img/gual.jpg" /><br />
        <span id="gual">
          상품명: <%= %><br />
          가격: <%= %></span
        ></a
      >
      <a href="itemView.jsp"
        ><img alt="" src="img/kiwi.jpg" /><br />
        <span id="kiwi">
           상품명: <%= %><br />
          가격: <%= %></span
        ></a
      >
      <a href="itemView.jsp"
        ><img alt="" src="img/lemon.jpg" /><br />
        <span id="lemon">
           상품명: <%= %><br />
          가격: <%= %></span
        ></a
      >
    </div>
    <hr />
    <h2>오늘 본 상품들</h2>
    <a href=""></a>
    <a href=""></a>
    <a href=""></a>
    <a href=""></a>
    <a href=""></a>
  </body>
</html>
