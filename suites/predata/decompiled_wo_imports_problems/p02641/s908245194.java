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
        final ArrayList list = new ArrayList();
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        for (int j = 0; j <= 100; ++j) {
            final int n = nextInt - j;
            final int n2 = nextInt + j;
            if (!list.contains(n)) {
                System.out.println(n);
                break;
            }
            if (!list.contains(n2)) {
                System.out.println(n2);
                break;
            }
        }
        scanner.close();
    }
}