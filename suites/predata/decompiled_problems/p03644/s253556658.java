import java.util.Scanner;
import java.io.IOException;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    int[] inputArray;
    
    public static void main(final String[] array) throws IOException {
        new Main().run();
    }
    
    void run() {
        int nextInt;
        int i;
        for (nextInt = new Scanner(System.in).nextInt(), i = 1; i <= nextInt; i *= 2) {}
        final int x = i / 2;
        if (nextInt == 1) {
            System.out.println(1);
        }
        else {
            System.out.println(x);
        }
    }
}
