public class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        int x = 0;
        for (int n = 2, n2 = 0; n2 <= nextInt && Math.pow(n, n2) <= nextInt; ++n2) {
            x = (int)Math.pow(n, n2);
        }
        System.out.println(x);
    }
}