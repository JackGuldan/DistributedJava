<%--
  Created by IntelliJ IDEA.
  User: JackG
  Date: 2/20/2019
  Time: 7:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <link href="./CSS/CSS.css" type="text/css" rel="stylesheet" media="screen" />
  </head>
  <body>
  <div class="WrapperStripes HeaderWrapper">
    <header>
      <h1>Lab </h1>
      <div id="CartMenu">
        <form action="Search.go">
          <input type="text" name="search" placeholder="Find an item">
          <input class="Button" type="submit" value="Search">
        </form>

      </div>

    </header>
    <div id="NavWrapper">
      <nav>
        <ul>
          <li><a href="index.jsp">Home</a></li>
          <li><a href="Product_List.go">Product List</a></li>
          <li><a href="Shopping_Cart.go">View Shopping Cart</a></li>
          <div class="ClearFloat"></div>
        </ul>
      </nav>
    </div>
  </div>
  <div class="WrapperStripes">
    <div id="SiteBody">
      <h2>Popular items!</h2>
      <div id="Slider">

      </div>
    </div>
  </div>
  <div class="WrapperStripes FooterWrapper">
    <footer>
      Site is a educatioal project all &copy;Copyrights belong to their respective owers.
    </footer>
  </div>
  </body>
</html>
