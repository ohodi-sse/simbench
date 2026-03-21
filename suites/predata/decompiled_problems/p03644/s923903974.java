import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        int n = 0;
        int x = 1;
        for (int i = 1; i <= nextInt; ++i) {
            final int divCnt = divCnt(i);
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
    
    private static int divCnt(int n, int divCnt) {
        if (n / 2 >= 1 && n % 2 == 0) {
            n /= 2;
            divCnt = divCnt(n, divCnt);
            ++divCnt;
        }
        return divCnt;
    }
}