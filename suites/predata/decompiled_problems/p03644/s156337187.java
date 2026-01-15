import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    static Scanner scanner;
    
    public static void main(final String[] array) {
        System.out.println(Integer.highestOneBit(Main.scanner.nextInt()));
    }
    
    static {
        Main.scanner = new Scanner(System.in);
    }
}
