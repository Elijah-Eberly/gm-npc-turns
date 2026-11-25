import java.util.Random;
import java.util.ArrayList;

public class QuickTurn {
    private static String action;
    private static int hitMod;
    private static int numberOfSides;
    private static int numberOfDice;
    private static int damageMod;

    public static void main(String[] args) {
        begin();
    }

    public static void begin() {
        while (true) {
            action = IO.readln("Enter Command:\n1.CREATE\n2.USE\n3.EXIT\n");
            if (action.equals("1") || action.equals("CREATE")) {
                hitMod = Integer.parseInt(IO.readln("Enter the hit modifier:\n"));
                numberOfSides = Integer.parseInt(IO.readln("Enter number of sides on the damage dice:\n"));
                numberOfDice = Integer.parseInt(IO.readln("Enter number of damage dice:\n"));
                damageMod = Integer.parseInt(IO.readln("Enter the damage modifier:\n"));
            } else if (action.equals("2") || action.equals("USE")) {
                IO.println("Not Finished");
            } else if (action.equals("3") || action.equals("EXIT")) {
                break;
            } else {
                IO.println("Invalid Command");
            }
        }
    }
}