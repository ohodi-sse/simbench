import java.io.IOException;
import java.util.StringTokenizer;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() throws IOException {
        final StringTokenizer stringTokenizer;
        final long long1 = Long.parseLong((stringTokenizer = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine())).nextToken());
        final String nextToken = stringTokenizer.nextToken();
        System.out.println(long1 * (Integer.parseInt(nextToken.substring(0, 1)) * 100 + Integer.parseInt(nextToken.substring(2))) / 100L);
    }
}
