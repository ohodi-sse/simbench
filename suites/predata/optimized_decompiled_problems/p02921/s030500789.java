import java.util.ArrayList;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() throws Exception {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final ArrayList list = new ArrayList();
        for (String s = bufferedReader.readLine(); s != null; s = bufferedReader.readLine()) {
            list.add(s);
        }
        final String s2 = (String)list.get(0);
        final String s3 = (String)list.get(1);
        int x = 0;
        for (int i = 0; i < s2.length(); ++i) {
            final String s4 = s2;
            final int beginIndex = i;
            final String substring = s4.substring(beginIndex, beginIndex + 1);
            final String s5 = s3;
            final int beginIndex2 = i;
            if (substring.equals(s5.substring(beginIndex2, beginIndex2 + 1))) {
                ++x;
            }
        }
        System.out.println(x);
    }
}
