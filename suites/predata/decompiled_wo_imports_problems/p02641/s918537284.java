public class Main
{
    private static StringBuilder builder;
    
    public static void main(final String[] array) {
        final int int1 = readInt();
        final int int2 = readInt();
        final ArrayList list = new ArrayList<Integer>(int2);
        for (int i = 0; i < int2; ++i) {
            list.add(readInt());
        }
        int n = 0;
        while (list.contains(int1 - n)) {
            if (!list.contains(int1 + n)) {
                System.out.print(int1 + n);
            }
            else {
                list.remove((Object)(int1 - n));
                list.remove((Object)(int1 + n));
                if (int1 + n != Integer.MAX_VALUE) {
                    if (int1 - n != Integer.MIN_VALUE) {
                        ++n;
                        continue;
                    }
                }
            }
            return;
        }
        System.out.print(int1 - n);
    }
    
    private static void read() {
        Main.builder.setLength();
        try {
            while (true) {
                final int read = System.in.read();
                if (read == 32 || read == 10 || read == -1) {
                    break;
                }
                Main.builder.appendCodePoint(read);
            }
        }
        catch (final IOException ex) {}
    }
    
    private static int readInt() {
        read();
        return Integer.parseInt(Main.builder.toString());
    }
    
    private static int readInt(final int radix) {
        read();
        return Integer.parseInt(Main.builder.toString(), radix);
    }
    
    private static long readLong() {
        read();
        return Long.parseLong(Main.builder.toString());
    }
    
    private static long readLong(final int radix) {
        read();
        return Long.parseLong(Main.builder.toString(), radix);
    }
    
    private static BigInteger readBigInteger() {
        read();
        return new BigInteger(Main.builder.toString());
    }
    
    private static BigInteger readBigInteger(final int radix) {
        read();
        return new BigInteger(Main.builder.toString(), radix);
    }
    
    private static void skipLine() {
        try {
            int read;
            do {
                read = System.in.read();
            } while (read != 10 && read != -1);
        }
        catch (final IOException ex) {}
    }
    
    private static void skip() {
        try {
            int read;
            do {
                read = System.in.read();
            } while (read != 32 && read != 10 && read != -1);
        }
        catch (final IOException ex) {}
    }
    
    static {
        Main.builder = new StringBuilder();
    }
}