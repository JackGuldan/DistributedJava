package us.Lab4;

import java.sql.*;

public class CreateCatologDB
{
    public CreateCatologDB()
    {

        try
        {
            // Create a named constant for the URL.
            // NOTE: This value is specific for Java DB.
            final String DB_URL = "jdbc:derby:CatologDB;create=true";
            final String DB_URL2 = "jdbc:derby:CartDB;create=true";

            // Create a connection to the database.
            Connection conn =
                    DriverManager.getConnection(DB_URL);
            Connection conn2 =
                    DriverManager.getConnection(DB_URL2);

            // If the DB already exists, drop the tables.
            dropTables(conn);

            // Build the Catolog table.
            CreateCatologTable(conn);

            // Build the Customer table.
            buildCustomerTable(conn);

            // Build the Customer table.
            CreateCartTable(conn);

            // Close the connection.
            conn.close();
            conn2.close();
        } catch (Exception e)
        {
            System.out.println("Error Creating the Catolog Table");
            System.out.println(e.getMessage());
        }

    }

    /**
     * The dropTables method drops any existing
     * in case the database already exists.
     */
    public static void dropTables(Connection conn)
    {
        System.out.println("Checking for existing tables.");

        try
        {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            try
            {
                // Drop the Customer table.
                stmt.execute("DROP TABLE Customer");
                System.out.println("Customer table dropped.");
            } catch (SQLException ex)
            {
                // No need to report an error.
                // The table simply did not exist.
            }

            try
            {
                // Drop the item table.
                stmt.execute("DROP TABLE Items");
                System.out.println("Item table dropped.");
            } catch (SQLException ex)
            {
                // No need to report an error.
                // The table simply did not exist.
            }
            try
            {
                // Drop the item table.
                stmt.execute("DROP TABLE Cart");
                System.out.println("us.Lab4.Cart table dropped.");
            } catch (SQLException ex)
            {
                // No need to report an error.
                // The table simply did not exist.
            }
        } catch (SQLException ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * The buildItemsTable method creates the
     * Items table and adds some rows to it.
     */
    public static void CreateCatologTable(Connection conn)
    {
        try
        {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            // Create the table.
            stmt.execute("CREATE TABLE Items (" +
                    "Description CHAR(25), " +
                    "ProdNum CHAR(10) NOT NULL PRIMARY KEY, " +
                    "Price DOUBLE " +
                    ")");

            // Insert row #1.
            stmt.execute("INSERT INTO Items VALUES ( " +
                    "'Gardevoir Plush', " +
                    "'14-001', " +
                    "29.99 )");

            // Insert row #2.
            stmt.execute("INSERT INTO Items VALUES ( " +
                    "'Homework Cheeats', " +
                    "'14-002', " +
                    "4.99 )");

            // Insert row #3.
            stmt.execute("INSERT INTO Items VALUES ( " +
                    "'Nintendo Switch', " +
                    "'15-001', " +
                    "299.99 )");

            // Insert row #4.
            stmt.execute("INSERT INTO Items VALUES ( " +
                    "'Xbox Controller', " +
                    "'15-002', " +
                    "59.99 )");

            // Insert row #5.
            stmt.execute("INSERT INTO Items VALUES ( " +
                    "'Hue 2', " +
                    "'15-003', " +
                    "29.99 )");



            System.out.println("Item table created.");
        } catch (SQLException ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    public static void CreateCartTable(Connection conn) {
        try {
            // Get a Statement object.
            Statement stmt = conn.createStatement();


            // Create the table.
            stmt.execute("CREATE TABLE Cart" +
                    "(ID INTEGER PRIMARY KEY NOT NULL," +
                    "ProdNum INT NOT NULL, " +
                    "Quanity double )");


            System.out.println("us.Lab4.Cart created.");
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }


    /**
     * The buildCustomerTable method creates the
     * Customer table and adds some rows to it.
     */
    public static void buildCustomerTable(Connection conn)
    {
        try
        {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            // Create the table.
            stmt.execute("CREATE TABLE Customer" +
                    "( CustomerNumber CHAR(10) NOT NULL PRIMARY KEY, " +
                    "  Name CHAR(25)," +
                    "  Address CHAR(25)," +
                    "  City CHAR(12)," +
                    "  State CHAR(2)," +
                    "  Zip CHAR(5) )");

            // Add some rows to the new table.
            stmt.executeUpdate("INSERT INTO Customer VALUES" +
                    "('101', 'Downtown Cafe', '17 N. Main Street'," +
                    " 'Asheville', 'NC', '55515')");

            stmt.executeUpdate("INSERT INTO Customer VALUES" +
                    "('102', 'Main Street Grocery'," +
                    " '110 E. Main Street'," +
                    " 'Canton', 'NC', '55555')");

            stmt.executeUpdate("INSERT INTO Customer VALUES" +
                    "('103', 'The Coffee Place', '101 Center Plaza'," +
                    " 'Waynesville', 'NC', '55516')");

            System.out.println("Customer table created.");
        } catch (SQLException ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

}