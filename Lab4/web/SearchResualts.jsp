<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="us.Lab4.model.Item" %><%--
  Created by IntelliJ IDEA.
  User: mgreen14
  Date: 9/27/18
  Time: 8:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <title>Lab 4</title>
    <meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;" />
    <link href="CSS/CSS.css" type="text/css" rel="stylesheet" media="screen" />
</head>

<body>
    <div class="WrapperStripes HeaderWrapper">
        <header>
           <h1>Lab 1</h1>
           <div id="CartMenu">
                <div>
                    <form>
                        <input type="text" name="search" placeholder="Find an item">
                    </form>
                </div>
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
        <h2>Search Results</h2>
        <ul id="ProductList">
            <form action="cartplace.go">
            <%

            %>
        </ul>
        <div><input type="submit" value="Purchase"></div>
        </form>
    </div>
</div>
<div class="WrapperStripes FooterWrapper">
    <footer>


    </footer>
</div>
</body>

</html>