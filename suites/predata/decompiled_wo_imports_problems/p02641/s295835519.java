public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        if (nextInt2 == 0) {
            System.out.println(nextInt);
            return;
        }
        final ArrayList list = new ArrayList();
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        int x = Integer.MAX_VALUE;
        for (int j = 1; j <= nextInt2; ++j) {
            final int k = nextInt + j;
            if (!list.contains(k)) {
                x = k;
                break;
            }
        }
        int x2 = Integer.MAX_VALUE;
        for (int l = 0; l <= nextInt2; ++l) {
            final int m = nextInt - l;
            if (!list.contains(m)) {
                x2 = m;
                break;
            }
        }
        if (Math.abs(nextInt - x2) <= Math.abs(nextInt - x)) {
            System.out.println(x2);
        }
        else {
            System.out.println(x);
        }
    }
}