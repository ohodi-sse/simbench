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
        final String[] split;
        final long long1 = Long.parseLong((split = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" "))[0]);
        final char[] charArray = split[1].toCharArray();
        String s = "";
        for (int i = 0; i < charArray.length; ++i) {
            if (charArray[i] != '.') {
                s += charArray[i];
            }
        }
        System.out.println(Long.parseLong(s) * long1 / 100L);
    }
}
