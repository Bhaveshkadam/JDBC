import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC {
    public Connection connect(String dbname, String user, String pass) {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, pass);
            if (conn != null) {
                System.out.println("Connection Established");
            } else {
                System.out.println("Connection Failed");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }

//    For create table in Database.
    public void createTable(Connection conn, String table_name) {
        Statement statement;
        try {
            String query = "create table " + table_name + "(question_id SERIAL,question varchar(200),answer varchar(200),primary key(question_id));";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Created");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

//    Insert data into table
    public void insertQuestion(Connection conn, String table_name, String question, String answer) {
        Statement statement;
        try {
            String query = String.format("insert into %s(question,answer) values('%s','%s');", table_name, question, answer);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row Inserted");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

//    read all data from table
    public void readQuestion(Connection conn, String table_name) {
        Statement statement;
        ResultSet rs = null;
        try {
            String query = String.format("select * from %s", table_name);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.print(rs.getString("question_id") + " ");
                System.out.print(rs.getString("question") + " ");
                System.out.println(rs.getString("answer") + " ");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

//    search data from table
    public void searchByQuestion(Connection conn, String table_name, String question) {
        Statement statement;
        ResultSet rs = null;
        try {
            String query = String.format("select * from %s where question= '%s'", table_name, question);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.print(rs.getString("question_id") + " ");
                System.out.print(rs.getString("question") + " ");
                System.out.println(rs.getString("answer") + " ");

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}