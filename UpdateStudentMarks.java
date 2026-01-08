import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateStudentMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Connect to Oracle database
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "system",
                    "oracle"
            );

            // Take input from user
            System.out.print("Enter Student ID to update: ");
            int id = sc.nextInt();

            System.out.print("Enter new marks: ");
            int marks = sc.nextInt();

            // Form UPDATE query
            String sql = "UPDATE students SET marks = " + marks + " WHERE id = " + id;

            // Execute query
            Statement stmt = con.createStatement();
            int result = stmt.executeUpdate(sql);

            // Success message
            if (result > 0) {
                System.out.println(" Student marks updated successfully!");
            } else {
                System.out.println(" Student ID not found.");
            }

            // Close connection
            con.close();

        } catch (Exception e) {
            System.out.println(" Error: " + e);
        }

        sc.close();
    }
}