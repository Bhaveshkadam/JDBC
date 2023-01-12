
import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JDBC db = new JDBC();
        Connection conn = db.connect("questionanswer", "postgres", "qwerty1201");
        db.createTable(conn,"Question_Answer");
        db.insertQuestion(conn,"Question_Answer","what is the year of independence day?","1947");
        db.insertQuestion(conn,"Question_Answer","Who among the following was the Prime Minister of Britain at the time of Independence?","Clement Attlee");
        db.readQuestion(conn, "Question_Answer");
        db.getQuestionById(conn, "Question_Answer", 1);

    }

}