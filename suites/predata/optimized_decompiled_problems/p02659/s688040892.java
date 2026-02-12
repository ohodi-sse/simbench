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
        final String[] split = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
        System.out.println(Long.parseLong(split[0]) * (long)(Double.parseDouble(split[1]) * 100.0 + 0.001) / 100L);
    }
}
