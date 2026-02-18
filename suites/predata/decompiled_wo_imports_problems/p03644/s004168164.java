final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        scanner.close();
        System.out.println(1 << Integer.toBinaryString(nextInt).length() - 1);
    }
}