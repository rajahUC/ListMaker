import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        final String menu = "A - add  D - Delete  P - Print  Q - Quit";
        boolean done = false;
        String cmd = "";

        do {
            displayList();
            cmd = SafeInput.getRegExString(console, menu, "[AaDdPpQq]");
            cmd = cmd.toUpperCase();

            // execute the choice
            switch(cmd)
            {
                case "A":
                    String item = SafeInput.getNonZeroLenString(console, "Enter a list item to add: ");
                    list.add(item);
                    break;
                case "D":
                    // prompt the user for the number of the item to delete
                    // translate the number to an index by substracting 1
                    // remove the item from the list
                    break;
                case "P":
                    break;
                case "Q":
                    System.exit(0);
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
                System.out.printf("%3d%35s", i+1, list.get(i));
            }
        }
        else
        {
            System.out.println("LIST IS EMPTY");
        }
    }
}