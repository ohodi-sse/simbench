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
        int saori_hayami;
        int x;
        for (saori_hayami = hayami.saori_hayami(), x = 1; x * 2 <= saori_hayami; x *= 2) {}
        System.out.println(x);
        hayami.close();
    }
}
