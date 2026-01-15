import java.io.OutputStream;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.InputStream;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    InputStream is;
    int __t__;
    int __f__;
    int __FILE_DEBUG_FLAG__;
    String __DEBUG_FILE_NAME__;
    FastScanner in;
    PrintWriter out;
    
    public Main() {
        this.__t__ = 1;
        this.__f__ = 0;
        this.__FILE_DEBUG_FLAG__ = this.__f__;
        this.__DEBUG_FILE_NAME__ = "src/D3";
    }
    
    public void solve() {
        final long nextLong = this.in.nextLong();
        final String[] split = this.in.next().split("[.]");
        System.out.println(nextLong * (Integer.valueOf(split[0]) * 100 + Integer.valueOf(split[1])) / 100L);
    }
    
    public void run() {
        if (this.__FILE_DEBUG_FLAG__ == this.__t__) {
            try {
                this.is = new FileInputStream(this.__DEBUG_FILE_NAME__);
            }
            catch (final FileNotFoundException ex) {
                ex.printStackTrace();
            }
            System.out.println("FILE_INPUT!");
        }
        else {
            this.is = System.in;
        }
        this.in = new FastScanner(this.is);
        this.out = new PrintWriter(System.out);
        this.solve();
    }
    
    public static void main(final String[] array) {
        new Main().run();
    }
}
