import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.io.PrintWriter;





public class Main
{
    static PrintWriter out;
    
    public static void main(final String[] array) throws Exception {
        final FastReader fastReader = new FastReader(System.in);
        int n = 1;
        while (n-- > 0) {
            final String next = fastReader.next();
            final HashMap hashMap = new HashMap();
            hashMap.put("SSS", 0);
            hashMap.put("SSR", 1);
            hashMap.put("SRS", 1);
            hashMap.put("SRR", 2);
            hashMap.put("RSS", 1);
            hashMap.put("RSR", 1);
            hashMap.put("RRS", 2);
            hashMap.put("RRR", 3);
            Main.out.println(hashMap.get(next));
        }
        Main.out.flush();
        Main.out.close();
    }
    
    static {
        Main.out = new PrintWriter(new OutputStreamWriter(System.out));
    }
    
    static class FastReader
    {
        byte[] buf;
        int index;
        int total;
        InputStream in;
        
        FastReader(final InputStream in) {
            this.buf = new byte[2048];
            this.in = in;
        }
        
        int scan() throws IOException {
            if (this.index >= this.total) {
                this.index = 0;
                this.total = this.in.read(this.buf);
                if (this.total <= 0) {
                    return -1;
                }
            }
            return this.buf[this.index++];
        }
        
        String next() throws IOException {
            int i;
            for (i = this.scan(); i <= 32; i = this.scan()) {}
            final StringBuilder sb = new StringBuilder();
            while (i > 32) {
                sb.append((char)i);
                i = this.scan();
            }
            return sb.toString();
        }
        
        int nextInt() throws IOException {
            int n = 0;
            int i;
            for (i = this.scan(); i <= 32; i = this.scan()) {}
            final boolean b = i == 45;
            if (i == 45 || i == 43) {
                i = this.scan();
            }
            while (i >= 48 && i <= 57) {
                n = (n << 3) + (n << 1) + (i & 0xF);
                i = this.scan();
            }
            return b ? (-n) : n;
        }
        
        long nextLong() throws IOException {
            long n = 0L;
            int i;
            for (i = this.scan(); i <= 32; i = this.scan()) {}
            final boolean b = i == 45;
            if (i == 45 || i == 43) {
                i = this.scan();
            }
            while (i >= 48 && i <= 57) {
                n = (n << 3) + (n << 1) + (i & 0xF);
                i = this.scan();
            }
            return b ? (-n) : n;
        }
    }
}