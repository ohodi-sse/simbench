public final class Main
{
    private static int[] EVEN;
    
    private static void main$3231c38a() {
        final int nextInt = new Scanner(System.in).nextInt();
        int x = 0;
        for (int i = 0; i < Main.EVEN.length; ++i) {
            if (Main.EVEN[i] <= nextInt) {
                x = Main.EVEN[i];
            }
        }
        System.out.println(x);
    }
    
    static {
        Main.EVEN = new int[] { 1, 2, 4, 8, 16, 32, 64 };
    }
}