import java.io.IOException;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) throws IOException {
        final int int1 = new InputReader(System.in).readInt();
        int x = 0;
        for (int i = 0, n = 0; i <= int1; i = (int)Math.pow(2.0, n), x = (int)Math.pow(2.0, n - 1), ++n) {}
        System.out.println(x);
    }
}
