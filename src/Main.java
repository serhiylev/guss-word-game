import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logiс logic = new Logiс();
        System.out.println("   ||Guss Word Game||\n\n to start press Enter");
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        if (scanner.hasNextLine()) {
            int numberQuestion = 1+ random.nextInt(6);
            logic.start(numberQuestion);
        }
    }
}
