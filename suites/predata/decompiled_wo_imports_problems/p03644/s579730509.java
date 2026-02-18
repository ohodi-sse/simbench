public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        int n = 2;
        final int nextInt = scanner.nextInt();
        for (int n2 = 0; n2 < 7 && nextInt != 1 && nextInt >= n; n <<= 1, ++n2) {}
        if (nextInt == 1) {
            System.out.println(1);
        }
        else {
            System.out.println(n / 2);
        }
        scanner.close();
    }
}