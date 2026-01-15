import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        for (int i = new Scanner(System.in).nextInt(); i > 0; --i) {
            if ((i & i - 1) == 0x0) {
                System.out.println(i);
                break;
            }
        }
    }
}
