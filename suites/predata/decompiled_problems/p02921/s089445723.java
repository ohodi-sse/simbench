import java.util.ArrayList;
import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final ArrayList list = new ArrayList();
        while (scanner.hasNext()) {
            list.add(scanner.nextLine());
        }
        int i = 0;
        if (((String)list.get(0)).charAt(0) == ((String)list.get(1)).charAt(0)) {
            ++i;
        }
        if (((String)list.get(0)).charAt(1) == ((String)list.get(1)).charAt(1)) {
            ++i;
        }
        if (((String)list.get(0)).charAt(2) == ((String)list.get(1)).charAt(2)) {
            ++i;
        }
        System.out.print(i);
    }
}