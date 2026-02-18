public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt;
        if ((nextInt = (scanner = new Scanner(System.in)).nextInt()) == 1) {
            System.out.println(1);
        }
        else {
            int i;
            for (i = 2; i <= nextInt; i <<= 1) {}
            System.out.println(i / 2);
        }
        scanner.close();
    }
}