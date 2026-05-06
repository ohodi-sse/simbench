import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) throws Exception {
        final int int1 = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        if (int1 == 1) {
            System.out.println(int1);
        }
        else {
            int i;
            for (i = 1; i <= int1; i *= 2) {}
            System.out.println(i / 2);
        }
    }
}
