// Source code file LoadGames.java
// Load data from CSV file games.csv
// into the database table games

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LoadGames {

	public static void main(String[] args) {
        Connection c = null;
        Statement s = null;
        Scanner fromFile = null;
        String sql1 = null, sql2 = null;
        String line = null;
        String[] fields;
        String name = null, rating = null, wear = null, platform = null;
        double price = 0.0;

        try {
            // Define Connection and Statement objects.
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:games.db");
            s = c.createStatement();

            // Instantiate scanner to read from file.
            fromFile = new Scanner(new File ("games.csv"));
            
            // Create kids table.
            sql1 = "create table if not exists " +
                "games(gameid integer, " +
                "name varchar(20), " +
                "rating varchar(1), " +
                "wear varchar(5), " +
                "platform varchar(20), " +
                "price double);";
            System.out.println("sql1: " + sql1);
            s.executeUpdate(sql1);
            
            // Read and throw away header line.
            fromFile.nextLine();
            
            // Populate kids table.
            for (int id = 1001; fromFile.hasNextLine(); id++) {
                line = fromFile.nextLine();
                fields = line.split(",");
                name = fields[0].trim();
                rating = fields[1].trim();
                wear = fields[2].trim();
                platform = fields[3].trim();
                price = Double.parseDouble(fields[4].trim());
                sql2 = String.format(
                    "insert into games (gameid, name, rating, wear, platform, price) " +
                    "values (%d, '%s', '%s', '%s', '%s', %.2f);", 
                    id, name, rating, wear, platform, price);
                System.out.println(sql2);
                s.executeUpdate(sql2);
            }
            c.close( );
        }
        catch (FileNotFoundException e) {
            System.out.println("File queries.sql not found.");
            System.err.println( e.getClass().getName() + 
                ": " + e.getMessage() );
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
            fromFile.close( );
        }
    }
}
