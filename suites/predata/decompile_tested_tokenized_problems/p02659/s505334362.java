import java.io.IOException;
import java.util.StringTokenizer;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) throws IOException {
        final StringTokenizer stringTokenizer = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        final Long value = Long.parseLong(stringTokenizer.nextToken());
        final String nextToken = stringTokenizer.nextToken();
        System.out.println(value * Long.parseLong(nextToken.substring(0, nextToken.indexOf(46)) + nextToken.substring(nextToken.indexOf(46) + 1)) / 100L);
    }
}
