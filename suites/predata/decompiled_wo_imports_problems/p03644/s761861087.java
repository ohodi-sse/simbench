public final class Main
{
    private static void main$3231c38a() {
        final int nextInt = new Scanner(System.in).nextInt();
        int x = 2;
        if (nextInt == 1) {
            System.out.println(1);
            return;
        }
        while (x << 1 <= nextInt) {
            x <<= 1;
        }
        System.out.println(x);
    }
}