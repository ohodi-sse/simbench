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
        final String[] split = hayami.nextHayami().split("");
        final String[] split2 = hayami.nextHayami().split("");
        int x = 0;
        for (int i = 0; i < split.length; ++i) {
            if (split[i].equals(split2[i])) {
                ++x;
            }
        }
        System.out.println(x);
        hayami.close();
    }
}
