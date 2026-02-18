public final class Main
{
    private static void main$3231c38a() {
        for (int i = new Scanner(System.in).nextInt(); i > 0; --i) {
            if (i == 2 || i == 4 || i == 8 || i == 16 || i == 32 || i == 64) {
                System.out.println(i);
                return;
            }
            if (i == 1) {
                System.out.println(i);
                return;
            }
        }
    }
}