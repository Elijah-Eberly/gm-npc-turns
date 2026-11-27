public class QuickTurn {
    private static String action;
    private static RollSet template;

    public static void main(String[] args) {
        template = new RollSet("EMPTY");
        begin();
    }

    public static void begin() {
        while (true) {
            action = IO.readln("Enter Command:\n1.CREATE\n2.USE\n3.EXIT\n");
            if (action.equals("1") || action.equals("CREATE")) {
                while (true) {
                    action = IO.readln("Enter a name for this template:\n");
                    if (action.equals("EMPTY")) {
                        IO.println("Invalid Name");
                        IO.readln("");
                    } else {
                        template = new RollSet(action);
                        break;
                    }
                }
            } else if (action.equals("2") || action.equals("USE")) {
                if (template.getName().equals("EMPTY")) {
                    IO.println("No Template");
                    IO.readln("");
                } else {
                    template.rollDice();
                }
            } else if (action.equals("3") || action.equals("EXIT")) {
                break;
            } else {
                IO.println("Invalid Command");
                IO.readln("");
            }
        }
    }
}