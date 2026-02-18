public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        final ArrayList list;
        (list = new ArrayList()).add(2);
        list.add(4);
        list.add(8);
        list.add(16);
        list.add(32);
        list.add(64);
        for (int i = scanner.nextInt(); i > 0; --i) {
            if (list.contains(i)) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(1);
        scanner.close();
    }
}