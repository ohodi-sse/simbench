import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;





public class Main
{
    static List<Integer> list;
    static int x;
    
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        Main.x = scanner.nextInt();
        for (int nextInt = scanner.nextInt(), i = 0; i < nextInt; ++i) {
            Main.list.add(scanner.nextInt());
        }
        System.out.println(dfs(0));
    }
    
    private static int dfs(int n) {
        if (!Main.list.contains(Main.x - n)) {
            return Main.x - n;
        }
        if (!Main.list.contains(Main.x + n)) {
            return Main.x + n;
        }
        return dfs(++n);
    }
    
    static {
        Main.list = new ArrayList<Integer>();
        Main.x = 0;
    }
}