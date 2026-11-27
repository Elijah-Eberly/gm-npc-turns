public class RollSet {
    private String name;
    private int hitMod;
    private int numberOfSides;
    private int numberOfDice;
    private int damageMod;
    private int hitRoll;
    private int damageRoll;

    public RollSet(String name) {
        this.name = name;
        if (!name.equals("EMPTY")) {
            createSet();
        }
    }

    private void createSet() {
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
    }

    public void rollDice() {
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

    public String getName() {
        return name;
    }
}
