import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    public static void main(final String[] array) throws Exception {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        final String next2 = scanner.next();
        int i = 0;
        for (int j = 0; j < next.length(); ++j) {
            final int index = j;
            if (index < next2.length() && next.charAt(j) == next2.charAt(index)) {
                ++i;
            }
        }
        System.out.print(i);
    }
}
