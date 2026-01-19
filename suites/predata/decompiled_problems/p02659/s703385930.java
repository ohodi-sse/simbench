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

public class Main
{
    static InputIterator ii;
    static PrintWriter out;
    
    static void flush() {
        Main.out.flush();
    }
    
    static void myout(final Object x) {
        Main.out.println(x);
    }
    
    static void myerr(final Object x) {
        System.err.println(x);
    }
    
    static String next() {
        return Main.ii.next();
    }
    
    static int nextInt() {
        return Integer.parseInt(next());
    }
    
    static long nextLong() {
        return Long.parseLong(next());
    }
    
    static ArrayList<String> nextStrArray() {
        return myHanSpSplit(next());
    }
    
    static ArrayList<String> myHanSpSplit(final String s) {
        return new ArrayList<String>(Arrays.asList(s.split(" ")));
    }
    
    static ArrayList<String> nextCharArray() {
        return mySingleSplit(next());
    }
    
    static ArrayList<String> mySingleSplit(final String s) {
        return new ArrayList<String>(Arrays.asList(s.split("")));
    }
    
    static ArrayList<Integer> nextIntArray() {
        final ArrayList list = new ArrayList();
        final ArrayList<String> nextStrArray = nextStrArray();
        for (int i = 0; i < nextStrArray.size(); ++i) {
            list.add(Integer.parseInt((String)nextStrArray.get(i)));
        }
        return list;
    }
    
    static ArrayList<Long> nextLongArray() {
        final ArrayList list = new ArrayList();
        final ArrayList<String> nextStrArray = nextStrArray();
        for (int i = 0; i < nextStrArray.size(); ++i) {
            list.add(Long.parseLong((String)nextStrArray.get(i)));
        }
        return list;
    }
    
    static String kaigyoToStr(final String[] elements) {
        return String.join("\n", (CharSequence[])elements);
    }
    
    static String kaigyoToStr(final ArrayList<String> elements) {
        return String.join("\n", elements);
    }
    
    static String hanSpToStr(final String[] elements) {
        return String.join(" ", (CharSequence[])elements);
    }
    
    static String hanSpToStr(final ArrayList<String> elements) {
        return String.join(" ", elements);
    }
    
    public static void main(final String[] array) {
        solve();
        flush();
    }
    
    public static void solve() {
        final ArrayList<String> nextStrArray = nextStrArray();
        myout(new BigDecimal(nextStrArray.get(0)).multiply(new BigDecimal(nextStrArray.get(1))).longValue());
    }
    
    static {
        Main.ii = new InputIterator();
        Main.out = new PrintWriter(System.out);
    }
    
    public static class InputIterator
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
        
        public boolean hasNext() {
            return this.index < this.max;
        }
        
        public String next() {
            if (this.hasNext()) {
                final String s = this.inputLine.get(this.index);
                ++this.index;
                return s;
            }
            throw new IndexOutOfBoundsException("\u3053\u308c\u4ee5\u4e0a\u5165\u529b\u306f\u306a\u3044\u3088\u3002");
        }
    }
}
import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 
// Decompiled by Procyon v0.6.0
// 

public static class InputIterator
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
    
    public boolean hasNext() {
        return this.index < this.max;
    }
    
    public String next() {
        if (this.hasNext()) {
            final String s = this.inputLine.get(this.index);
            ++this.index;
            return s;
        }
        throw new IndexOutOfBoundsException("\u3053\u308c\u4ee5\u4e0a\u5165\u529b\u306f\u306a\u3044\u3088\u3002");
    }
}
