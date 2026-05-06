import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        final String[] array2 = { next.substring(0, 1), next.substring(1, 2), next.substring(2, 3) };
        int x = 0;
        if (array2[0].equals("R")) {
            ++x;
        }
        for (int i = 1; i <= array2.length - 1; ++i) {
            if (array2[i].equals("R") && array2[i - 1].equals("R")) {
                ++x;
            }
            if (array2[i].equals("R") && array2[i - 1].equals("S")) {
                x = 1;
            }
        }
        System.out.println(x);
        scanner.close();
    }
}
