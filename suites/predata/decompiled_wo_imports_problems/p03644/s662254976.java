public final class Main
{
    private static void main$3231c38a() {
        int i = new Scanner(System.in).nextInt();
        for (int n = 2; i >= n; i = n, n <<= 1) {}
        System.out.println(i);
    }
}