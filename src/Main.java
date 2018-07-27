import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logic logic = new Logic();
        System.out.println("   ||Guss Word Game||\n\n to start press Enter");
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        if (scanner.hasNextLine() == true) {
            int numberQuestion = 0 + random.nextInt(5);
            logic.start(numberQuestion);
        }
    }
}
