public final class Main
{
    private static void main$3231c38a() {
        final int int1 = Integer.parseInt(new Scanner(System.in).next());
        int i = 2;
        if (int1 < 2) {
            System.out.println(1);
            return;
        }
        while (i <= int1) {
            if (i << 1 > int1) {
                System.out.println(i);
                return;
            }
            i <<= 1;
        }
    }
}