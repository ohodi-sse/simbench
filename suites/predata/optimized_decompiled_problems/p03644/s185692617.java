import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() throws IOException {
        try (final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            final int int1 = Integer.parseInt(bufferedReader.readLine());
            int n = 0;
            int x = 0;
            for (int i = 1; i <= int1; ++i) {
                int n2;
                int n3;
                for (n2 = i, n3 = 0; n2 > 0 && (n2 & 0x1) != 0x1; n2 >>= 1, ++n3) {}
                if (n <= n3) {
                    n = n3;
                    x = i;
                }
            }
            System.out.println(x);
        }
    }
}
