public final class Main
{
    private static void main$3231c38a() {
        final String next = new Scanner(System.in).next();
        System.out.println(next.equals("RRR") ? 3 : (next.contains("RR") ? 2 : next.contains("R")));
    }
}