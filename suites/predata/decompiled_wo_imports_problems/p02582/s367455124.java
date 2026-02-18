public final class Main
{
    private static void main$3231c38a() {
        final String[] split = new Scanner(System.in).nextLine().split("", -1);
        int n = 0;
        for (int i = 0; i < 3; ++i) {
            if (split[i].equals("R")) {
                ++n;
            }
        }
        if (n == 3) {
            System.out.println("3");
            return;
        }
        if (n == 2 && split[1].equals("R")) {
            System.out.println("2");
            return;
        }
        if (n == 0) {
            System.out.println("0");
            return;
        }
        System.out.println("1");
    }
}