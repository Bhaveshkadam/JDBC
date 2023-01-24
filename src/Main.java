import java.io.*;
import java.sql.Connection;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JDBC db = new JDBC();
//         TODO: see all naming conventions
//        CSVReader.read("/home/bhavesh/Workspace/JDBC/src/Question and Answers");
        Connection conn = db.connect("question_answer", "postgres", "root");

//         create new table
//        db.setTABLE_NAME("Question_Set");

//         insert data into table
//        db.insertQuestion("what is the year of independence day?","1947");
//        db.insertQuestion("Who among the following was the Prime Minister of Britain at the time of Independence?","Clement Attlee");

//         read data from table
        db.readQuestion(10);
//        for (int i = 0; i < 5; i++) {
//            db.getQuestionById(i);
//        }
    }
}