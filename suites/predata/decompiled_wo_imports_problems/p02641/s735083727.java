public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        if (nextInt2 == 0) {
            System.out.println(nextInt);
            System.exit(0);
        }
        int x = 0;
        int x2 = 0;
        final ArrayList list = new ArrayList();
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        while (n2 == 0 && n3 == 0) {
            if (!list.contains(nextInt + n)) {
                n2 = 1;
                x = nextInt + n;
            }
            if (!list.contains(nextInt - n)) {
                n3 = 1;
                x2 = nextInt - n;
            }
            ++n;
        }
        if (n3 != 0) {
            System.out.println(x2);
        }
        else {
            System.out.println(x);
        }
    }
}