public final class Main
{
    private static void main$3231c38a() {
        int nextInt = new Scanner(System.in).nextInt();
        final List<Integer> list = Arrays.asList(2, 4, 8, 16, 32, 64);
        while (1 < nextInt) {
            if (list.contains(nextInt)) {
                System.out.println(nextInt);
                System.exit(0);
            }
            --nextInt;
        }
        System.out.println(1);
    }
}