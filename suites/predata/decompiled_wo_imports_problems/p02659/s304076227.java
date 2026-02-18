final class Main
{
    private static void main$3231c38a() {
        new Solver();
        final Scanner scanner;
        final long nextLong = (scanner = new Scanner(System.in)).nextLong();
        final String[] split = scanner.next().split("\\.");
        System.out.println(nextLong * (Integer.parseInt(split[0]) * 100 + Integer.parseInt(split[1])) / 100L);
    }
}






final class Solver
{
    private static void run() {
        final Scanner scanner;
        final long nextLong = (scanner = new Scanner(System.in)).nextLong();
        final String[] split = scanner.next().split("\\.");
        System.out.println(nextLong * (Integer.parseInt(split[0]) * 100 + Integer.parseInt(split[1])) / 100L);
    }
}