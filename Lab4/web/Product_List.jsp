<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="us.Lab4.model.Item" %>
<%@ page import="us.Lab4.RunDataBase" %>
<%@ page import="us.Lab4.model.ItemCatalog" %><%--
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
    <title>Lab </title>
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
        <h2>Products</h2>
        <ul id="ProductList">
            <form action="cartplace.go">
                <table>
                    <thead>
                    <td>
                        ID
                    </td>
                    <td>
                        Price
                    </td>
                    <td>
                        Distrcption
                    </td>
                    </thead>
            <%

            List recs = (List) request.getAttribute("catalog");
            Iterator it = recs.iterator();
            while (it.hasNext()) {
            // Notice we're outputting some HTML. Is that a good idea?
            // Also, notice we do not cast the object returned by the
            // iterator to a String. Why?
            Item item = (Item) it.next();
            //Item item = new Item();
            out.print("<tr>" +
                    "<td> " +
                    item.getProductNumer() +
                    " </td>" +
                    "<td> " +
                    item.getPrice() +
                    "</td>" +
                    "<td> " +
                    item.getDescription() +
                    " </td>" +
                    "</tr>");

            /*
            out.print("<li class=\"ItemLink\">" +
                    "<a class=\"ItemLink\" href=\"PRoduct_Details.html\"> " + item.getName() + "</a>" +
                    "<div class=\"ProductListPrice\">$" + item.getPrice() + "</div>" +
                    "<span>" + "Add to us.Lab4.Cart <input type='checkbox' name='cartItem' value="
                    + item.getProductNumer()+ ">"
                    + "</span> </li>");
                    */
            }

            %>
                </table>
        <div><input class="Button" type="submit" value="Purchase"></div>
        </form>
    </div>
</div>
<div class="WrapperStripes FooterWrapper">
    <footer>


    </footer>
</div>
</body>

</html>