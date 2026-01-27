public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final LinkedList list = new LinkedList();
        final int nextInt = scanner.nextInt();
        for (int nextInt2 = scanner.nextInt(), i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        int n;
        for (n = 0; list.contains(nextInt - n); ++n) {
            if (!list.contains(nextInt + n)) {
                System.out.println(nextInt + n);
                return;
            }
        }
        System.out.println(nextInt - n);
    }
}