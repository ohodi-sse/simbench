public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final HashSet set = new HashSet();
        for (int i = 0; i < nextInt2; ++i) {
            set.add(scanner.nextInt());
        }
        int n = 0;
        int x;
        while (true) {
            final int j = nextInt - n;
            if (!set.contains(j)) {
                x = j;
                break;
            }
            final int k = nextInt + n;
            if (!set.contains(k)) {
                x = k;
                break;
            }
            ++n;
        }
        System.out.println(x);
    }
}