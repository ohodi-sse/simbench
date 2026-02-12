import java.util.HashSet;
import java.util.StringTokenizer;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static void main$3231c38a() throws Exception {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer;
        final int int1 = Integer.parseInt((stringTokenizer = new StringTokenizer(bufferedReader.readLine())).nextToken());
        final int int2 = Integer.parseInt(stringTokenizer.nextToken());
        final StringTokenizer stringTokenizer2 = new StringTokenizer(bufferedReader.readLine());
        final HashSet set = new HashSet();
        for (int i = 0; i < int2; ++i) {
            set.add(Integer.parseInt(stringTokenizer2.nextToken()));
        }
        int abs = 500;
        int x = 0;
        for (int j = 0; j < 200; ++j) {
            if (!set.contains(j) && Math.abs(j - int1) < abs) {
                abs = Math.abs(j - int1);
                x = j;
            }
        }
        System.out.println(x);
    }
}
