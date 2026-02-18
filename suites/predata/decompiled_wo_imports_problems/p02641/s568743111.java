public final class Main
{
    private static List<Integer> list;
    private static int x;
    
    private static void main$3231c38a() {
        final Scanner scanner;
        Main.x = (scanner = new Scanner(System.in)).nextInt();
        for (int nextInt = scanner.nextInt(), i = 0; i < nextInt; ++i) {
            Main.list.add(scanner.nextInt());
        }
        if (!Main.list.contains(Main.x)) {
            System.out.println(Main.x);
            return;
        }
        final PrintStream out = System.out;
        while (true) {
            int n;
            for (n = 1; Main.list.contains(Main.x - n); ++n) {
                if (!Main.list.contains(Main.x + n)) {
                    final int x = Main.x + n;
                    out.println(x);
                    return;
                }
            }
            final int x = Main.x - n;
            continue;
        }
    }
    
    private static int dfs(int n) {
        while (Main.list.contains(Main.x - n)) {
            if (!Main.list.contains(Main.x + n)) {
                return Main.x + n;
            }
            ++n;
        }
        return Main.x - n;
    }
    
    static {
        Main.list = new ArrayList<Integer>();
        Main.x = 0;
    }
}