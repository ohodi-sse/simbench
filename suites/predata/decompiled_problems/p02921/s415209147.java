import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        final String next2 = scanner.next();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (next.charAt(i) != 'S' && next.charAt(i) != 'C' && next.charAt(i) != 'R') {
                break;
            }
            if (next2.charAt(i) != 'S' && next2.charAt(i) != 'C' && next2.charAt(i) != 'R') {
                break;
            }
            if (next.charAt(i) == next2.charAt(i)) {
                ++x;
            }
        }
        System.out.println(x);
    }
}
