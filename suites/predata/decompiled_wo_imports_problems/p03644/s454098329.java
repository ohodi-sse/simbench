public final class Main
{
    private static void main$3231c38a() {
        new Main();
        final Scanner scanner;
        final int nextInt;
        if ((nextInt = (scanner = new Scanner(System.in)).nextInt()) == 0) {
            System.out.println(0);
        }
        else if (nextInt == 1) {
            System.out.println(1);
        }
        else if (nextInt > 1 && nextInt <= 3) {
            System.out.println(2);
        }
        else if (nextInt > 3 && nextInt <= 7) {
            System.out.println(4);
        }
        else if (nextInt > 7 && nextInt <= 15) {
            System.out.println(8);
        }
        else if (nextInt > 15 && nextInt <= 31) {
            System.out.println(16);
        }
        else if (nextInt > 31 && nextInt <= 63) {
            System.out.println(32);
        }
        else if (nextInt > 63 && nextInt <= 100) {
            System.out.println(64);
        }
        scanner.close();
    }
    
    private static void solve(final Scanner scanner) {
        final int nextInt;
        if ((nextInt = scanner.nextInt()) == 0) {
            System.out.println(0);
            return;
        }
        if (nextInt == 1) {
            System.out.println(1);
            return;
        }
        if (nextInt > 1 && nextInt <= 3) {
            System.out.println(2);
            return;
        }
        if (nextInt > 3 && nextInt <= 7) {
            System.out.println(4);
            return;
        }
        if (nextInt > 7 && nextInt <= 15) {
            System.out.println(8);
            return;
        }
        if (nextInt > 15 && nextInt <= 31) {
            System.out.println(16);
            return;
        }
        if (nextInt > 31 && nextInt <= 63) {
            System.out.println(32);
            return;
        }
        if (nextInt > 63 && nextInt <= 100) {
            System.out.println(64);
        }
    }
}