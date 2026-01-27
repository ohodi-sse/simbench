public class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        int x = 1;
        for (int n = 0; n < 10 && 2 * x <= nextInt; x *= 2, ++n) {}
        System.out.println(x);
    }
}