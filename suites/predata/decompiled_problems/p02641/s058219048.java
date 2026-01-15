import java.io.IOException;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) throws IOException {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final int[] array2 = new int[nextInt2];
        final int[] array3 = new int[102];
        for (int i = 0; i < nextInt2; ++i) {
            array2[i] = scanner.nextInt();
            final int[] array4 = array3;
            final int n = array2[i];
            ++array4[n];
        }
        int x = 0;
        int abs = Integer.MAX_VALUE;
        for (int j = 0; j <= 101; ++j) {
            if (array3[j] == 0 && Math.abs(nextInt - j) < abs) {
                abs = Math.abs(nextInt - j);
                x = j;
            }
        }
        System.out.println(x);
    }
}
