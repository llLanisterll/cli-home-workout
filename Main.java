import controller.Controller;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Controller controller = new Controller(input);
        controller.mulai();
    }
}
