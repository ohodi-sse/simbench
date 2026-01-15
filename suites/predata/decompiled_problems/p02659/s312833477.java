import java.math.BigDecimal;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    static In in;
    static Out out;
    static final long mod = 1000000007L;
    static final long inf = 2305843009213693951L;
    static final int iinf = 1073741823;
    static final int[] da;
    
    void solve() {
        Main.out.println(BigDecimal.valueOf(Main.in.nextLong()).multiply(BigDecimal.valueOf(Double.parseDouble(Main.in.next()))).longValue());
    }
    
    public static void main(final String[] array) {
        new Main().solve();
        Main.out.flush();
    }
    
    static {
        Main.in = new In();
        Main.out = new Out();
        da = new int[] { -1, 0, 1, 0, -1, 1, 1, -1, -1 };
    }
}
