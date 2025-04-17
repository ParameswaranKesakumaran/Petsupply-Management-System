
package pawsshopsystem;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ExportReport {
    public static void exportToCSV() {
        String filePath = "PetSupplies_Report.csv"; // File name for the CSV

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM PetSupplies");
             FileWriter writer = new FileWriter(filePath)) {

            // Write the CSV headers
            writer.write("ID,Name,Category,Price\n");

            // Write data from the database
            while (rs.next()) {
                writer.write(rs.getInt("id") + "," +
                        rs.getString("name") + "," +
                        rs.getString("category") + "," +
                        rs.getDouble("price") + "\n");
            }

            JOptionPane.showMessageDialog(null, "Report exported successfully to: " + filePath);
        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "Error exporting report: " + e.getMessage());
        }
    }
}
