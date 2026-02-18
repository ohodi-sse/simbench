public final class Main
{
    private static void main$3231c38a() {
        final int nextInt = new Scanner(System.in).nextInt();
        int n = 0;
        int x = 1;
        for (int i = 1; i <= nextInt; ++i) {
            final int divCnt = divCnt(i, 0);
            if (n < divCnt) {
                n = divCnt;
                x = i;
            }
        }
        System.out.println(x);
    }
    
    private static int divCnt(final int n) {
        return divCnt(n, 0);
    }
    
    private static int divCnt(final int n, int divCnt) {
        if (n / 2 > 0 && n % 2 == 0) {
            divCnt = divCnt(n / 2, divCnt);
            ++divCnt;
        }
        return divCnt;
    }
}