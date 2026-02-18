public final class Main
{
    private static void main$3231c38a() {
        try (final Scanner scanner = new Scanner(System.in)) {
            final String[] split = scanner.next().split("S");
            int max = 0;
            for (int length = split.length, i = 0; i < length; ++i) {
                max = Math.max(split[i].length(), max);
            }
            System.out.println(max);
        }
    }
}