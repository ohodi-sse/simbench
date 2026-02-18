public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        final String value;
        if ((value = String.valueOf(scanner.nextLong() * (long)(scanner.nextDouble() * 100.0 + 0.5))).length() <= 2) {
            System.out.println("0");
            return;
        }
        System.out.println(value.substring(0, value.length() - 2));
    }
}