// Source code file DisplayKids.java
// Display data from games table
// given the id.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DisplayGames {
	public static void main(String[] args) {
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;
        String sql = null;
        int id = 0;
        String name = null, rating = null, wear = null, platform = null;
        double price = 0.0;
        
        Scanner fromKeyboard = new Scanner(System.in);
        
        try {
            // Define Connection and Statement objects.
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:games.db");
            s = c.createStatement();
            
            while (id != -1) {
                // Read id and display corresponding table row.
                System.out.print("Enter desired id: ");
                id = fromKeyboard.nextInt( ); 
                sql = "select name, rating, wear, platform, price from games " +
                    "where gameid = " + id + ";";
                System.out.println(sql);
                rs = s.executeQuery(sql);
                while (rs.next( )) {
                    name = rs.getString("name");
                    rating = rs.getString("rating");
                    wear = rs.getString("wear");
                    platform = rs.getString("platform");
                    price = rs.getDouble("price");
                    System.out.println("Name: " + name);
                    System.out.println("Rating: " + rating);
                    System.out.println("wear: " + wear);
                    System.out.println("Platform: " + platform);
                    System.out.println("Price: " + price);
                    System.out.println(""); //debugging test line

                }
            }
        }
        catch(SQLException e) {
            System.out.println("SQLException.");
            System.err.println( e.getClass().getName() + 
                ": " + e.getMessage() );
        }
        catch (ClassNotFoundException e ) {
            System.err.println( e.getClass().getName() + 
                ": " + e.getMessage() );
        }
        finally {
            fromKeyboard.close( );
        }

    }
}
