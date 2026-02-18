public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final Long value = Long.parseLong((scanner = new Scanner(System.in)).next());
        final String[] split = scanner.next().split("\\.", -1);
        System.out.println(value * Long.parseLong(split[0]) + value * Integer.parseInt(split[1]) / 100L);
    }
}