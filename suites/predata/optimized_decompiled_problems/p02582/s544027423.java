import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.util.HashMap;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static HashMap<Integer, String> CONVSTR;
    private static InputIterator ii;
    private static PrintWriter out;
    
    private static void flush() {
        Main.out.flush();
    }
    
    private static void myout(final Object x) {
        Main.out.println(x);
    }
    
    private static void myerr(final Object x) {
        System.err.print("debug:");
        System.err.println(x);
    }
    
    private static String next() {
        final InputIterator ii;
        if ((ii = Main.ii).hasNext()) {
            return ii.inputLine.get(ii.index++);
        }
        throw new IndexOutOfBoundsException("There is no more input");
    }
    
    private static boolean hasNext() {
        return Main.ii.hasNext();
    }
    
    private static int nextInt() {
        return Integer.parseInt(next());
    }
    
    private static long nextLong() {
        return Long.parseLong(next());
    }
    
    private static double nextDouble() {
        return Double.parseDouble(next());
    }
    
    private static ArrayList<String> nextStrArray() {
        return myconv(next(), 8);
    }
    
    private static ArrayList<String> nextCharArray() {
        return myconv(next(), 0);
    }
    
    private static ArrayList<Integer> nextIntArray() {
        final ArrayList<String> nextStrArray = nextStrArray();
        final ArrayList list = new ArrayList<Integer>(nextStrArray.size());
        for (int i = 0; i < nextStrArray.size(); ++i) {
            list.add(Integer.parseInt((String)nextStrArray.get(i)));
        }
        return (ArrayList<Integer>)list;
    }
    
    private static ArrayList<Long> nextLongArray() {
        final ArrayList<String> nextStrArray = nextStrArray();
        final ArrayList list = new ArrayList<Long>(nextStrArray.size());
        for (int i = 0; i < nextStrArray.size(); ++i) {
            list.add(Long.parseLong((String)nextStrArray.get(i)));
        }
        return (ArrayList<Long>)list;
    }
    
    private static String myconv(final Object o, final int i) {
        final String s = Main.CONVSTR.get(i);
        if (o instanceof final String[]array) {
            return String.join(s, array);
        }
        if (o instanceof ArrayList) {
            return String.join(s, (Iterable<? extends CharSequence>)o);
        }
        throw new ClassCastException("Don't join");
    }
    
    private static ArrayList<String> myconv(final String s, final int i) {
        return new ArrayList<String>(Arrays.asList(s.split(Main.CONVSTR.get(i))));
    }
    
    private static void main$3231c38a() {
        Main.CONVSTR.put(8, " ");
        Main.CONVSTR.put(9, "\n");
        Main.CONVSTR.put(0, "");
        final ArrayList<String> myconv = myconv(next(), 0);
        int max = 0;
        int n = 0;
        for (int i = 0; i < myconv.size(); ++i) {
            if (((String)myconv.get(i)).equals("R")) {
                ++n;
            }
            else {
                max = Math.max(max, n);
                n = 0;
            }
        }
        Main.out.println((Object)Math.max(max, n));
        Main.out.flush();
    }
    
    private static void solve() {
        final ArrayList<String> myconv = myconv(next(), 0);
        int max = 0;
        int n = 0;
        for (int i = 0; i < myconv.size(); ++i) {
            if (((String)myconv.get(i)).equals("R")) {
                ++n;
            }
            else {
                max = Math.max(max, n);
                n = 0;
            }
        }
        Main.out.println((Object)Math.max(max, n));
    }
    
    static {
        Main.CONVSTR = new HashMap<Integer, String>();
        Main.ii = new InputIterator();
        Main.out = new PrintWriter(System.out);
    }
    
    static final class InputIterator
    {
        ArrayList<String> inputLine;
        int index;
        private int max;
        private String read;
        
        InputIterator() {
            this.inputLine = new ArrayList<String>(1024);
            this.index = 0;
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            try {
                while (true) {
                    final String line = bufferedReader.readLine();
                    this.read = line;
                    if (line == null) {
                        break;
                    }
                    this.inputLine.add(this.read);
                }
            }
            catch (final IOException ex) {}
            this.max = this.inputLine.size();
        }
        
        final boolean hasNext() {
            return this.index < this.max;
        }
        
        private String next() {
            if (this.hasNext()) {
                return this.inputLine.get(this.index++);
            }
            throw new IndexOutOfBoundsException("There is no more input");
        }
    }
}
