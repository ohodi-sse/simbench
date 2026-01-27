public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        int n = 0;
        int n2 = 1;
        int n3 = 1;
        int n4 = 1;
        final int[] array2 = new int[nextInt2];
        if (nextInt2 == 0) {
            System.out.println(nextInt);
            System.exit(0);
        }
        for (int i = 0; i < array2.length; ++i) {
            if ((array2[i] = scanner.nextInt()) == nextInt) {
                ++n;
            }
        }
        if (n == 0) {
            System.out.println(nextInt);
            System.exit(0);
        }
        while (true) {
            final int x = nextInt - n2;
            final int x2 = nextInt + n2;
            for (int j = 0; j < array2.length; ++j) {
                if (x == array2[j]) {
                    n3 = 0;
                }
                if (x2 == array2[j]) {
                    n4 = 0;
                }
            }
            if (n3 == 1) {
                System.out.println(x);
                break;
            }
            if (n4 == 1) {
                System.out.println(x2);
                break;
            }
            ++n2;
            n3 = 1;
            n4 = 1;
        }
    }
}