import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        for (int i = new Scanner(System.in).nextInt(); i >= 1; --i) {
            if (i == 2 || i == 4 || i == 8 || i == 16 || i == 32 || i == 64) {
                System.out.println(i);
                break;
            }
            if (i == 1) {
                System.out.println(i);
                break;
            }
        }
    }
}
