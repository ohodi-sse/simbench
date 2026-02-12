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
        final Long value = Long.parseLong((stringTokenizer = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine())).nextToken());
        final String nextToken;
        final String substring = (nextToken = stringTokenizer.nextToken()).substring(0, nextToken.indexOf(46));
        final String s = nextToken;
        System.out.println(value * Long.parseLong(substring + s.substring(s.indexOf(46) + 1)) / 100L);
    }
}
