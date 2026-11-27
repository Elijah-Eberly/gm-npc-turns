import java.util.Random;
import java.util.ArrayList;

public class QuickTurn {
    private static String action;
    private static String name;
    private static int hitMod;
    private static int numberOfSides;
    private static int numberOfDice;
    private static int damageMod;
    private static int hitRoll;
    private static int damageRoll;

    public static void main(String[] args) {
        begin();
    }

    public static void begin() {
        while (true) {
            action = IO.readln("Enter Command:\n1.CREATE\n2.USE\n3.EXIT\n");
            if (action.equals("1") || action.equals("CREATE")) {
                name = IO.readln("Enter a name for this template:\n");
                while (true) {
                    try {
                        hitMod = Integer.parseInt(IO.readln("Enter the hit modifier:\n"));
                        if (hitMod > 100 || hitMod < -10) {
                            throw new NumberFormatException();
                        }
                        break;
                    } catch (NumberFormatException e) {
                        IO.println("Invalid Hit Modifier");
                        IO.readln("");
                    }
                }
                while (true) {
                    try {
                        numberOfSides = Integer.parseInt(IO.readln("Enter number of sides on the damage dice:\n"));
                        if (numberOfSides > 12 || numberOfSides < 4 || numberOfSides % 2 == 1) {
                            throw new NumberFormatException();
                        }
                        break;
                    } catch (NumberFormatException e) {
                        IO.println("Invalid Damage Die");
                        IO.readln("");
                    }
                }
                while (true) {
                    try {
                        numberOfDice = Integer.parseInt(IO.readln("Enter number of damage dice:\n"));
                        if (numberOfDice > 50 || numberOfDice < 0) {
                            throw new NumberFormatException();
                        }
                        break;
                    } catch (NumberFormatException e) {
                        IO.println("Invalid Number of Damage Dice");
                        IO.readln("");
                    }
                }
                while (true) {
                    try {
                        damageMod = Integer.parseInt(IO.readln("Enter the damage modifier:\n"));
                        if (damageMod > 100 || damageMod < -10) {
                            throw new NumberFormatException();
                        }
                        break;
                    } catch (NumberFormatException e) {
                        IO.println("Invalid Damage Modifier");
                        IO.readln("");
                    }
                }
            } else if (action.equals("2") || action.equals("USE")) {
                if (numberOfSides == 0) {
                    IO.println("No Template");
                    IO.readln("");
                } else {
                    IO.println("\n" + name);
                    hitRoll = (int) ((Math.random() * 20) + 1 + hitMod);
                    IO.println("Hit (+" + hitMod + "): " + hitRoll);
                    damageRoll = 0;
                    for (int i = 0; i < numberOfDice; i++) {
                        damageRoll += (int) ((Math.random() * numberOfSides) + 1 + damageMod);
                    }
                    IO.println("Damage (" + numberOfDice + "D" + numberOfSides + "+" + damageMod + "): " + damageRoll);
                    IO.readln("");
                }
            } else if (action.equals("3") || action.equals("EXIT")) {
                break;
            } else {
                IO.println("Invalid Command");
            }
        }
    }
}