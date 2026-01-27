public class Main
{
    static final int[] EVEN;
    
    public static void main(final String[] array) {
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
        EVEN = new int[] { 1, 2, 4, 8, 16, 32, 64 };
    }
}