public class Main
{
    static Scanner sc;
    
    public static void main(final String[] array) {
        final int nextInt = Main.sc.nextInt();
        final int nextInt2 = Main.sc.nextInt();
        if (nextInt2 == 0) {
            System.out.println(nextInt);
            return;
        }
        final ArrayList list = new ArrayList();
        for (int i = 0; i < nextInt2; ++i) {
            list.add(Main.sc.nextInt());
        }
        int abs = Integer.MAX_VALUE;
        int x = 101;
        for (int j = 0; j <= 101; ++j) {
            for (int k = 0; k < nextInt2; ++k) {
                if (!list.contains(j) && abs > Math.abs(j - nextInt)) {
                    abs = Math.abs(j - nextInt);
                    x = j;
                }
            }
        }
        System.out.println(x);
    }
    
    static {
        Main.sc = new Scanner(System.in);
    }
}