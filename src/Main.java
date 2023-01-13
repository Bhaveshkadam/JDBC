
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        JDBC db = new JDBC();
        // TODO: see all naming conventions

        Connection conn = db.connect("question_answer", "postgres", "qwerty1201");
//        db.setTABLE_NAME("QuestionSet");

//        db.insertQuestion("what is the year of independence day?","1947");
//        db.insertQuestion("Who among the following was the Prime Minister of Britain at the time of Independence?","Clement Attlee");
        db.readQuestion(50);
        for (int i = 0; i < 4; i++) {
            db.getQuestionById(i);
        }
    }
}