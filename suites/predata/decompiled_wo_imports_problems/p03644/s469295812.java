public class Main
{
    static Scanner sc;
    
    public static void main(final String[] array) {
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