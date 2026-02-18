public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final long nextLong = (scanner = new Scanner(System.in)).nextLong();
        final double n2;
        final long n = (long)(n2 = scanner.nextDouble() + 0.001);
        final double n4;
        final long n3 = (long)(n4 = (n2 - n) * 10.0);
        System.out.println(nextLong * (100L * n + 10L * n3 + (long)((n4 - n3) * 10.0)) / 100L);
    }
}