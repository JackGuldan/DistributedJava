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
<script>
    function clearCookies (names) {
        var i = 0, namesLength = names.length;
        for (i; i < namesLength; i += 1) {
            document.cookie = names[i] + '=; expires=Thu, 01 Jan 1970 00:00:01 GMT; path=/';
        }
    };

    document.getElementById("EmptyCart").onclick = function() {clearCookies()};
</script>
</head>

<body>
<div class="WrapperStripes HeaderWrapper">
    <header>
        <h1>Lab 4</h1>
        <div id="CartMenu">

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
            <h2>Your Cart</h2>
            <form action="cartplace.go">
                <ul id="ShopingCart">
                    <%
                        List recs = (List) request.getAttribute("catalog");
                        Iterator it = recs.iterator();
                        double total = 0;
                        while (it.hasNext()) {
                            Item item = (Item) it.next();
                            out.print("<li class=\"ItemLink\">" +
                                    "<a class=\"ItemLink\" href=\"Product_Details.html\"> " + item.getName() + "</a>" +
                                    "<div class=\"ProductListPrice\">" + item.getPrice() + "</div>" +
                                    "<span> Remove Item <input type='checkbox' name='cartItem' value="
                                    + item.getProductNumer()+ ">"
                                    + "</span> </li>");
                            total += item.getPrice();
                        }
                        out.print("<div> <p>" +
                                String.format("$%3.2f",total) + "</p> </div>");
                    %>
                </ul>
                <div><input type="submit" value="Empty" id="EmptyCart"></div>
            </form>
    </div>
    <div class="WrapperStripes FooterWrapper">
        <footer>

        </footer>
    </div>
</div>
</body>

</html>