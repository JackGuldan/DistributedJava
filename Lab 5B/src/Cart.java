import java.sql.*;

public class Cart {



    /**
     * The buildItemsTable method creates the
     * Items table and adds some rows to it.
     */

    private static int CheckCatologListSize() throws SQLException {
        int x = 0;
        // NOTE: This value is specific for Java DB.
        final String DB_URL = "jdbc:derby:CatologDB;";

        // Create a connection to the database.
        Connection conn =
                DriverManager.getConnection(DB_URL);

        // Get a Statement object.
        Statement stmt = conn.createStatement();
        //stmt.execute("INSERT INTO Cart (ProdNum, Quanity) VALUES ( " +
        stmt.execute("SELECT COUNT(*) AS rowcount FROM Cart");

        return x;
    }

    public static void AddItem(int X, int ItemNumber, int Quanity) throws SQLException {
        // Create a named constant for the URL.
        // NOTE: This value is specific for Java DB.
        final String DB_URL = "jdbc:derby:CatologDB;";

        // Create a connection to the database.
        Connection conn =
                DriverManager.getConnection(DB_URL);

        // Get a Statement object.
        Statement stmt = conn.createStatement();
        //stmt.execute("INSERT INTO Cart (ProdNum, Quanity) VALUES ( " +
        stmt.execute("INSERT INTO Cart VALUES(" +
                X + ", " +
                ItemNumber + ", " +
                Quanity + ")");
        }

    public static void RemoveItem(int ItemNumber) throws SQLException {
        // Create a named constant for the URL.
        // NOTE: This value is specific for Java DB.
        final String DB_URL = "jdbc:derby:CatologDB;create=true";

        // Create a connection to the database.
        Connection conn =
                DriverManager.getConnection(DB_URL);


        // Get a Statement object.
        Statement stmt = conn.createStatement();
        stmt.execute("DELETE ID, NumbID, Quanity FROM Cart where ID = " + ItemNumber);
    }

    public void EmptyCart() throws SQLException {
        // Create a named constant for the URL.
        // NOTE: This value is specific for Java DB.
        final String DB_URL = "jdbc:derby:CatologDB;create=true";

        // Create a connection to the database.
        Connection conn =
                DriverManager.getConnection(DB_URL);


        // Get a Statement object.
        Statement stmt = conn.createStatement();
        stmt.execute("DELETE FROM Cart");
    }


}
