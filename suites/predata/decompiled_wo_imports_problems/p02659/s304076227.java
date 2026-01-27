class Solver
{
    public void run() {
        final Scanner scanner = new Scanner(System.in);
        final long nextLong = scanner.nextLong();
        final String[] split = scanner.next().split("\\.");
        System.out.println(nextLong * (Integer.parseInt(split[0]) * 100 + Integer.parseInt(split[1])) / 100L);
    }
}class Main
{
    public static void main(final String[] array) {
        new Solver().run();
    }
}