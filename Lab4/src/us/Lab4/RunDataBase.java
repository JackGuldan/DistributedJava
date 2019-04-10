package us.Lab4;

import java.sql.*;
import java.util.Scanner;


public class RunDataBase {

    public static void SetUpDBConnection(){
        CreateCatologDB cc = new CreateCatologDB();


        /*
        outputDB();
        addContent();
        System.out.println("==========================");
        outputDB();
        */
    }


    public static void ViewCart(){
        System.out.println("========== \n");

        /* Set up the us.Lab4.Cart list to fill the cart out.
                                    If it is filled. */

        final String DB_URL2 = "jdbc:derby:CatologDB";
        Statement stmt = null;
        Connection conn2 = null;
        try{
            conn2 = DriverManager.getConnection(DB_URL2);
            stmt = conn2.createStatement();
            String sql;
            sql = "SELECT ID, ProdNum, Quanity FROM Cart";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                //Retrieve by column name
                int ID = rs.getInt("ID");
                String idNum  = rs.getString("ProdNum");
                double Quanity = rs.getDouble("Quanity");

                //Display values
                System.out.print("ID: " + ID + " ");
                System.out.print("Num ID: "+ idNum + " ");
                System.out.print("Quanity: " + Quanity + "\n ");
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn2.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn2!=null)
                    conn2.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }

    public static void RunDataBase(String[] args) throws SQLException {
        Cart Cart = new Cart();
        System.out.println("==========================\n" +
                "Checking database...");

        Scanner Keyboard = new Scanner(System.in);
        SetUpDBConnection();


        System.out.println("==========================\n" +
                "Main Menu\n" +
                "1: View Items\n" +
                "2: View us.Lab4.Cart\n" +
                "4: Close\n");
        int input = 0;
        while (input != 4) {
            int inputY = Keyboard.nextInt();
            if (inputY == 1) {
                outputDB();
                int X =1;
                while(input != 69){
                    System.out.println("===========\n" +
                            "Do you want to?\n" +
                            "1: dd an item to kart\n" +
                            "2: Return to main menu");
                    input = Keyboard.nextInt();
                    if(input == 1){
                    System.out.println("Which item is to be added to the kart.\n" +
                            "Please select it based on the Row number.");
                        input = Keyboard.nextInt();
                        System.out.println("How many are you going to add?");
                        int input2 = Keyboard.nextInt();
                            Cart.AddItem(X, input, input2);
                            X++;
                    }else if(input == 2) {
                        System.out.println("\n\n===\n" +
                                "Returning to main menu\n" +
                                "===\n\n");
                        input = 69;
                    }
                }

            } else if (inputY == 2) {
                ViewCart();
                System.out.println("\n\n" +
                        "Options\n" +
                        "1: Remove an item\n" +
                        "2: Empty us.Lab4.Cart\n" +
                        "3: Main menu");
                int inputX = Keyboard.nextInt();
                if(inputX == 1){
                    System.out.println("\n\n" +
                            "What item do you want removed? Select it with the Row number");
                    int SelectedItem = Keyboard.nextInt();
                    Cart.RemoveItem(SelectedItem);
                }else if(inputX == 2){
                    Cart.EmptyCart();
                    System.out.println("Emptied us.Lab4.Cart");
                }else if(inputX == 3){
                     input = 0;
                }

            }
            System.out.println("==========================\n" +
                    "Main Menu\n" +
                    "1: View Items\n" +
                    "2: View us.Lab4.Cart\n" +
                    "4: Close\n");
        }



    }


    public static void outputDB() {
        final String DB_URL = "jdbc:derby:CatologDB";
        Statement stmt = null;
        Connection conn = null;
        try{
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT ProdNum, Description, Price FROM Items";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                //Retrieve by column name
                String id  = rs.getString("ProdNum");
                double price = rs.getDouble("Price");
                String description = rs.getString("Description");

                //Display values
                System.out.print("ID: " + id.trim());
                System.out.print(", Price: " + price);
                System.out.println(", Description: " + description);
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }
}
