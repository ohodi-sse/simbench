import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() throws Exception {
        int int1;
        int x;
        for (int1 = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine()), x = 1; x << 1 <= int1; x <<= 1) {}
        System.out.println(x);
    }
}
