import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class JDBC {
    private Connection conn;
    private String TABLE_NAME = "Question_Set";
    int batchSize = 20;
    String csvFile = "/home/bhavesh/Workspace/JDBC/src/Question and Answers";

    // TODO : refactor table name
    public Connection connect(String dbname, String user, String pass) {
        // TODO: Make a data config driven
        // TODO: Use log framework
//        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, pass);
            conn.setAutoCommit(false);

            if (conn != null) {
                System.out.println("\n Connection Established");
                createTable(conn, TABLE_NAME);
            } else {
                System.out.println("\n Connection Failed");
            }
            Statement stmt = conn.createStatement();
            String query = String.format("select count(*) from %s", TABLE_NAME);
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            int count = rs.getInt(1);
            System.out.println("\n Number of question in the Question_Set table: " + count + "\n");

//            String sql = String.format("insert into %s(question,answer) values(?,?);", TABLE_NAME);
//
//            PreparedStatement statement = conn.prepareStatement(sql);
//
//            BufferedReader lineReader = new BufferedReader(new FileReader(csvFile));
//
//            String lineText = null;
////            int count = 0;
//
//            lineReader.readLine();
//            while ((lineText = lineReader.readLine()) != null) {
//                String[] data = lineText.split(",");
//
//                String question = data[0];
//                String answer = data[1];
//
//                statement.setString(1, question);
//                statement.setString(2, answer);
//                statement.addBatch();
//                if (count % batchSize == 0) {
//                    statement.executeBatch();
//                }
//            }
//            lineReader.close();
//            statement.executeBatch();
//            conn.commit();
//            conn.close();
//            System.out.println("Data has been inserted successfully.");

        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }

    //    For create table in Database.
    private void createTable(Connection conn, String table_name) {
        Statement statement;
        try {
            // TODO: Refactor query to support to create if not exist.
            String query = "CREATE TABLE IF NOT EXISTS " + table_name + "(question_id SERIAL,question varchar(200) unique,answer varchar(200),primary key(question_id))";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Created");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void setTABLE_NAME(String TABLE_NAME) {
        this.TABLE_NAME = TABLE_NAME;
    }

    //    Insert data into table
    public void insertQuestion(String question, String answer) {
        Statement statement;
        try {
            String query = String.format("insert into %s(question,answer) values('%s','%s');", TABLE_NAME, question, answer);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row Inserted");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //    read all data from table
    public void readQuestion(int count) {
        Statement statement;
        ResultSet rs = null;
        try {
            String query = String.format("select * from Question_Set LIMIT %s", count);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            Scanner scanner = new Scanner(System.in);
            while (rs.next()) {
                System.out.print(rs.getString("question_id") + " ");
                System.out.println(rs.getString("question") + " ");
                System.out.println("plases enter the answer");
                String answer = scanner.nextLine();
                System.out.println(checkAnswer(rs.getString("answer"), answer));
                System.out.println(rs.getString("answer") + " ");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //    search data from table
    public void getQuestionById(int question_id) {
        Statement statement;
        ResultSet rs = null;
        try {
            String query = String.format("select * from %s where question_id= '%s'", TABLE_NAME, question_id);
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

    // TODO : Get count of all the questions.z
    // TODO : Create a function to seed question and answer  -- here i used Csv file to seed a question and answer
    // TODO : Think about reading question and answer from CSV file
    public static boolean checkAnswer(String databaseAnswer, String userAnswer) {

        if (databaseAnswer == null || userAnswer == null) {
            return false;
        }
        return userAnswer.toLowerCase().contains(databaseAnswer.trim().toLowerCase());
    }
}