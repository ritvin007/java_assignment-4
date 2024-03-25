import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PatientInfoDisplay {
    private static final String JDBC_URL = "jdbc:oracle:thin:@"
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin123";

     public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            String sqlQuery = "SELECT patient_id, name, problem, bill FROM patients";
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            System.out.println("Patient Information:");
            System.out.println("ID\tName\tProblem\tBill");
            while (resultSet.next()) {
                int patientId = resultSet.getInt("patient_id");
                String name = resultSet.getString("name");
                String problem = resultSet.getString("problem");
                double bill = resultSet.getDouble("bill");

                System.out.println(patientId + "\t" + name + "\t" + problem + "\t" + bill);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
