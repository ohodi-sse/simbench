public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final int[] a = new int[nextInt2];
        boolean b = false;
        for (int i = 0; i < nextInt2; ++i) {
            a[i] = scanner.nextInt();
            if (a[i] == nextInt) {
                b = true;
            }
        }
        Arrays.sort(a);
        if (a.length == 0) {
            System.out.println(nextInt);
            return;
        }
        if (!b) {
            System.out.println(nextInt);
            return;
        }
        int n = 0;
        for (int j = 0; j < a.length; ++j) {
            if (a[j] == nextInt) {
                n = j;
            }
        }
        int n2 = n + 1;
        int n3 = n - 1;
        int n4 = 1;
        while (n2 != a.length && n3 != -1) {
            if (a[n3] != nextInt - n4) {
                System.out.println(nextInt - n4);
                return;
            }
            if (a[n2] != nextInt + n4) {
                System.out.println(nextInt + n4);
                return;
            }
            ++n4;
            --n3;
            ++n2;
        }
        if (n2 != a.length) {
            System.out.println(nextInt - n4);
            return;
        }
        if (n3 == -1) {
            System.out.println(a[0] - 1);
            return;
        }
        if (a[n3] == nextInt - n4) {
            System.out.println(nextInt + n4);
            return;
        }
        System.out.println(nextInt - n4);
    }
}