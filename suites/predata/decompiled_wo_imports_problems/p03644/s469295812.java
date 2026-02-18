public final class Main
{
    private static Scanner sc;
    
    private static void main$3231c38a() {
        final int nextInt = Main.sc.nextInt();
        int x = 0;
        int numberOfTrailingZeros = -1;
        for (int i = 1; i <= nextInt; ++i) {
            if (Integer.numberOfTrailingZeros(i) > numberOfTrailingZeros) {
                numberOfTrailingZeros = Integer.numberOfTrailingZeros(i);
                x = i;
            }
        }
        System.out.println(x);
    }
    
    static {
        Main.sc = new Scanner(System.in);
    }
}