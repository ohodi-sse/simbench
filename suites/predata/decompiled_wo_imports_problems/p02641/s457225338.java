public class Main
{
    public static void main(final String[] array) throws Exception {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final ArrayList list = new ArrayList();
        int n = 101;
        int n2 = 101;
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        int j = nextInt;
        for (int k = 0; k < 100; ++k) {
            if (!list.contains(j)) {
                n = j;
                break;
            }
            ++j;
        }
        int l = nextInt - 1;
        for (int n3 = 0; n3 < 100; ++n3) {
            if (!list.contains(l)) {
                n2 = l;
                break;
            }
            --l;
        }
        if (list == null || list.size() == 0) {
            System.out.println(nextInt);
        }
        else if (Math.abs(n - nextInt) < Math.abs(n2 - nextInt)) {
            System.out.println(n);
        }
        else if (Math.abs(n - nextInt) > Math.abs(n2 - nextInt)) {
            System.out.println(n2);
        }
        else if (n < n2) {
            System.out.println(n);
        }
        else if (n2 < n) {
            System.out.println(n2);
        }
    }
}