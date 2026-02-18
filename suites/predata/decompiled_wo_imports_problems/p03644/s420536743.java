public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        int nextInt = (scanner = new Scanner(System.in)).nextInt();
        int x = 1;
        while (nextInt / 2 > 0) {
            x <<= 1;
            nextInt /= 2;
        }
        System.out.println(x);
        scanner.close();
    }
}