public final class Main
{
    private static void main$3231c38a() {
        final int nextInt;
        int x;
        if ((nextInt = new Scanner(System.in).nextInt()) < 2) {
            x = 1;
        }
        else if (nextInt < 4) {
            x = 2;
        }
        else if (nextInt < 8) {
            x = 4;
        }
        else if (nextInt < 16) {
            x = 8;
        }
        else if (nextInt < 32) {
            x = 16;
        }
        else if (nextInt < 64) {
            x = 32;
        }
        else {
            x = 64;
        }
        System.out.println(x);
    }
}