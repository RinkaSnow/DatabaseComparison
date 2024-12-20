import java.sql.*;

public class connecter {
    static public Connection con=null;

    public static void getConnection() {

        String host = "localhost";
        String dbname = "postgres";
        String user = "rinka";
        String pwd = "123456";
        String port = "5432";

        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (Exception e) {
            System.err.println("Cannot find the PostgreSQL driver. Check CLASSPATH.");
            System.exit(1);
        }

        try {
            String url = "jdbc:postgresql://" + host + ":" + port + "/" + dbname;
            con = DriverManager.getConnection(url, user, pwd);

        } catch (SQLException e) {
            System.err.println("Database connection failed");
            System.err.println(e.getMessage());
            System.exit(1);
        }

    }
}
