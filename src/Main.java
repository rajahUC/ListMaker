import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    static ArrayList<String> list = new ArrayList<>();
    static Scanner console = new Scanner(System.in);
    static boolean done = false;

    public static void main(String[] args)
    {
        final String menu = "A - Add  D - Delete  P - Print  Q - Quit";
        String cmd = "";

        do {
            displayList();
            cmd = SafeInput.getRegExString(console, menu, "[AaDdPpQq]");
            cmd = cmd.toUpperCase();

            switch(cmd)
            {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "P":
                    break;
                case "Q":
                    quitProgram();
                    break;
            }
        } while (!done);
    }

    private static void displayList()
    {
        SafeInput.prettyHeader("List");
        if (list.size() != 0)
        {
            for (int i = 0; i < list.size(); i++)
            {
                System.out.printf("\n%d. %s", i + 1, list.get(i));
            }
        }
        else
        {
            System.out.println("\nLIST IS EMPTY");
        }
    }

    private static void addItem()
    {
        String itemAdd = SafeInput.getNonZeroLenString(console, "Enter a list item to add: ");
        list.add(itemAdd);
    }

    private static void deleteItem()
    {
        int itemDelete = SafeInput.getRangedInt(console, "What item would you like to delete?", 1, list.size());
        itemDelete--;
        list.remove(itemDelete);
    }

    private static void quitProgram()
    {
        boolean confirmExit = SafeInput.getYNConfirm(console, "Are you sure?");
        if (confirmExit) {
            done = true;
        }
    }
}