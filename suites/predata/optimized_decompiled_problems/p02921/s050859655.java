import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() throws IOException {
        final BufferedReader bufferedReader;
        final String line = (bufferedReader = new BufferedReader(new InputStreamReader(System.in))).readLine();
        final String line2 = bufferedReader.readLine();
        final String[] convertArr = convertArr(line);
        final String[] convertArr2 = convertArr(line2);
        final PrintStream out = System.out;
        final String[] array = convertArr;
        final String[] array2 = convertArr2;
        final String[] array3 = array;
        int x = 0;
        for (int i = 0; i < array3.length; ++i) {
            if (array3[i].equals(array2[i])) {
                ++x;
            }
        }
        out.println(x);
    }
    
    private static String[] convertArr(final String s) {
        final String[] array = new String[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            final String[] array2 = array;
            final int n = i;
            final int beginIndex = i;
            array2[n] = s.substring(beginIndex, beginIndex + 1);
        }
        return array;
    }
    
    private static int checkTenki(final String[] array, final String[] array2) {
        int n = 0;
        for (int i = 0; i < array.length; ++i) {
            if (array[i].equals(array2[i])) {
                ++n;
            }
        }
        return n;
    }
}
