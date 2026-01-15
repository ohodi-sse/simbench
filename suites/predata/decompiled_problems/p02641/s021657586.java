import java.util.HashSet;

// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    static final long MOD = 1000000007L;
    static final int MAX = 2147483646;
    static final int INF = 1000000000;
    
    public static void main(final String[] array) throws Exception {
        final hayami hayami = new hayami();
        final int saori_hayami = hayami.saori_hayami();
        final int saori_hayami2 = hayami.saori_hayami();
        if (saori_hayami2 == 0) {
            System.out.println(saori_hayami);
            return;
        }
        final HashSet set = new HashSet();
        for (int i = 0; i < saori_hayami2; ++i) {
            set.add(hayami.saori_hayami());
        }
        int x = 2147483646;
        for (int j = 0; j <= 101; ++j) {
            if (!set.contains(j)) {
                if (Math.abs(j - saori_hayami) < Math.abs(x - saori_hayami)) {
                    x = j;
                }
            }
        }
        System.out.println(x);
        hayami.close();
    }
}
