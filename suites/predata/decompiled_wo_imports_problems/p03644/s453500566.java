public class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        final List<Integer> list = Arrays.asList(2, 4, 8, 16, 32, 64);
        for (int n = nextInt; 1 < n; --n) {
            if (list.contains(n)) {
                System.out.println(n);
                System.exit(0);
            }
        }
        System.out.println(1);
    }
}