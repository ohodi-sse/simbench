public final class Main
{
    private static void main$3231c38a() {
        try (final Scanner scanner = new Scanner(System.in)) {
            int nextInt;
            int x;
            for (nextInt = scanner.nextInt(), x = 1; x << 1 <= nextInt; x <<= 1) {}
            System.out.println(x);
        }
    }
}