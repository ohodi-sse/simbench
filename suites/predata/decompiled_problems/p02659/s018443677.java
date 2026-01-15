import java.math.BigDecimal;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final FastScanner fastScanner = new FastScanner();
        System.out.println(BigDecimal.valueOf(fastScanner.nextLong()).multiply(new BigDecimal(String.valueOf(fastScanner.nextDoutble()))).longValue());
    }
    
    public static int calcMin(final int[] array) {
        int n = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (n > array[i]) {
                n = array[i];
            }
        }
        return n;
    }
}
