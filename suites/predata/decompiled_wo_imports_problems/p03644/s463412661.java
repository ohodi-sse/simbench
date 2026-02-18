final class Main
{
    private static void main$3231c38a() throws IOException {
        final int nextInt;
        if ((nextInt = new Scanner(System.in).nextInt()) == 1) {
            System.out.println("1");
            return;
        }
        int i;
        for (i = 1; i <= nextInt; i <<= 1) {}
        System.out.println(i / 2);
    }
}