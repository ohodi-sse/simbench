import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        System.out.println((int)Math.pow(2.0, (int)(Math.log10(new Scanner(System.in).nextInt()) / Math.log10(2.0))));
    }
}
