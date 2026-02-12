import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static InputIterator ii;
    private static PrintWriter out;
    
    private static void flush() {
        Main.out.flush();
    }
    
    private static void myout(final Object x) {
        Main.out.println(x);
    }
    
    private static void myerr(final Object x) {
        System.err.println(x);
    }
    
    private static String next() {
        final InputIterator ii;
        final InputIterator inputIterator = ii = Main.ii;
        if (inputIterator.index < inputIterator.max) {
            final String s = ii.inputLine.get(ii.index);
            final InputIterator inputIterator2 = ii;
            ++inputIterator2.index;
            return s;
        }
        throw new IndexOutOfBoundsException("\u3053\u308c\u4ee5\u4e0a\u5165\u529b\u306f\u306a\u3044\u3088\u3002");
    }
    
    private static int nextInt() {
        return Integer.parseInt(next());
    }
    
    private static long nextLong() {
        return Long.parseLong(next());
    }
    
    private static ArrayList<String> nextStrArray() {
        return new ArrayList<String>(Arrays.asList(next().split(" ")));
    }
    
    private static ArrayList<String> myHanSpSplit(final String s) {
        return new ArrayList<String>(Arrays.asList(s.split(" ")));
    }
    
    private static ArrayList<String> nextCharArray() {
        return new ArrayList<String>(Arrays.asList(next().split("")));
    }
    
    private static ArrayList<String> mySingleSplit(final String s) {
        return new ArrayList<String>(Arrays.asList(s.split("")));
    }
    
    private static ArrayList<Integer> nextIntArray() {
        final ArrayList list = new ArrayList();
        final ArrayList<String> nextStrArray = nextStrArray();
        for (int i = 0; i < nextStrArray.size(); ++i) {
            list.add(Integer.parseInt((String)nextStrArray.get(i)));
        }
        return list;
    }
    
    private static ArrayList<Long> nextLongArray() {
        final ArrayList list = new ArrayList();
        final ArrayList<String> nextStrArray = nextStrArray();
        for (int i = 0; i < nextStrArray.size(); ++i) {
            list.add(Long.parseLong((String)nextStrArray.get(i)));
        }
        return list;
    }
    
    private static String kaigyoToStr(final String[] elements) {
        return String.join("\n", (CharSequence[])elements);
    }
    
    private static String kaigyoToStr(final ArrayList<String> elements) {
        return String.join("\n", elements);
    }
    
    private static String hanSpToStr(final String[] elements) {
        return String.join(" ", (CharSequence[])elements);
    }
    
    private static String hanSpToStr(final ArrayList<String> elements) {
        return String.join(" ", elements);
    }
    
    private static void main$3231c38a() {
        final ArrayList<String> nextStrArray = nextStrArray();
        Main.out.println((Object)new BigDecimal(nextStrArray.get(0)).multiply(new BigDecimal(nextStrArray.get(1))).longValue());
        Main.out.flush();
    }
    
    private static void solve() {
        final ArrayList<String> nextStrArray = nextStrArray();
        Main.out.println((Object)new BigDecimal(nextStrArray.get(0)).multiply(new BigDecimal(nextStrArray.get(1))).longValue());
    }
    
    static {
        Main.ii = new InputIterator();
        Main.out = new PrintWriter(System.out);
    }
    
    public static final class InputIterator
    {
        ArrayList<String> inputLine;
        int index;
        int max;
        
        InputIterator() {
            this.inputLine = new ArrayList<String>(1024);
            this.index = 0;
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String line;
                try {
                    line = bufferedReader.readLine();
                }
                catch (final IOException ex) {
                    line = null;
                }
                if (line == null) {
                    break;
                }
                this.inputLine.add(line);
            }
            this.max = this.inputLine.size();
        }
        
        private boolean hasNext() {
            return this.index < this.max;
        }
        
        private String next() {
            if (this.index < this.max) {
                final String s = this.inputLine.get(this.index);
                ++this.index;
                return s;
            }
            throw new IndexOutOfBoundsException("\u3053\u308c\u4ee5\u4e0a\u5165\u529b\u306f\u306a\u3044\u3088\u3002");
        }
    }
}
