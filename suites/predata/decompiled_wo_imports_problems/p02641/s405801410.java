public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2 = scanner.nextInt();
        final ArrayList list = new ArrayList();
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        if (!list.contains(nextInt)) {
            System.out.println(nextInt);
            System.exit(0);
        }
        for (int j = 1; j < list.size(); ++j) {
            if (!list.contains(nextInt - j)) {
                System.out.println(nextInt - j);
                System.exit(0);
            }
            else if (!list.contains(nextInt + j)) {
                System.out.println(nextInt + j);
                System.exit(0);
            }
        }
        System.out.println(0);
        scanner.close();
    }
}