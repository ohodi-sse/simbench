final class FastScanner
{
    private int BUFFER_SIZE;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer;
    private int bytesRead;
    
    public FastScanner() {
        this.BUFFER_SIZE = 65536;
        this.din = new DataInputStream(System.in);
        this.buffer = new byte[this.BUFFER_SIZE];
        final int n = 0;
        this.bytesRead = n;
        this.bufferPointer = n;
    }
    
    private FastScanner(final String name) throws IOException {
        this.BUFFER_SIZE = 65536;
        this.din = new DataInputStream(new FileInputStream(name));
        this.buffer = new byte[this.BUFFER_SIZE];
        final int n = 0;
        this.bytesRead = n;
        this.bufferPointer = n;
    }
    
    private String readLine() throws IOException {
        final byte[] bytes = new byte[64];
        int length = 0;
        byte read;
        while ((read = this.read()) != -1 && read != 10) {
            bytes[length++] = read;
        }
        return new String(bytes, 0, length);
    }
    
    private String next() throws IOException {
        byte codePoint;
        for (codePoint = this.read(); Character.isWhitespace(codePoint); codePoint = this.read()) {}
        final StringBuilder sb;
        (sb = new StringBuilder()).append((char)codePoint);
        for (byte codePoint2 = this.read(); !Character.isWhitespace(codePoint2); codePoint2 = this.read()) {
            sb.append((char)codePoint2);
        }
        return sb.toString();
    }
    
    private int nextInt() throws IOException {
        int n = 0;
        byte b;
        for (b = this.read(); b <= 32; b = this.read()) {}
        final boolean b2;
        if (b2 = (b == 45)) {
            b = this.read();
        }
        do {
            n = n * 10 + b - 48;
        } while ((b = this.read()) >= 48 && b <= 57);
        if (b2) {
            return -n;
        }
        return n;
    }
    
    private int[] nextIntArray(final int n) throws IOException {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            final int[] array2 = array;
            final int n2 = i;
            int n3 = 0;
            byte b;
            for (b = this.read(); b <= 32; b = this.read()) {}
            final boolean b2;
            if (b2 = (b == 45)) {
                b = this.read();
            }
            do {
                n3 = n3 * 10 + b - 48;
            } while ((b = this.read()) >= 48 && b <= 57);
            array2[n2] = (b2 ? (-n3) : n3);
        }
        return array;
    }
    
    private long nextLong() throws IOException {
        long n = 0L;
        byte b;
        for (b = this.read(); b <= 32; b = this.read()) {}
        final boolean b2;
        if (b2 = (b == 45)) {
            b = this.read();
        }
        do {
            n = n * 10L + b - 48L;
        } while ((b = this.read()) >= 48 && b <= 57);
        if (b2) {
            return -n;
        }
        return n;
    }
    
    private long[] nextLongArray(final int n) throws IOException {
        final long[] array = new long[n];
        for (int i = 0; i < n; ++i) {
            final long[] array2 = array;
            final int n2 = i;
            long n3 = 0L;
            byte b;
            for (b = this.read(); b <= 32; b = this.read()) {}
            final boolean b2;
            if (b2 = (b == 45)) {
                b = this.read();
            }
            do {
                n3 = n3 * 10L + b - 48L;
            } while ((b = this.read()) >= 48 && b <= 57);
            array2[n2] = (b2 ? (-n3) : n3);
        }
        return array;
    }
    
    private char nextChar() throws IOException {
        byte codePoint;
        for (codePoint = this.read(); Character.isWhitespace(codePoint); codePoint = this.read()) {}
        return (char)codePoint;
    }
    
    private double nextDouble() throws IOException {
        double n = 0.0;
        double n2 = 1.0;
        byte b;
        for (b = this.read(); b <= 32; b = this.read()) {}
        final boolean b2;
        if (b2 = (b == 45)) {
            b = this.read();
        }
        do {
            n = n * 10.0 + b - 48.0;
        } while ((b = this.read()) >= 48 && b <= 57);
        if (b == 46) {
            byte read;
            while ((read = this.read()) >= 48 && read <= 57) {
                n += (read - 48) / (n2 *= 10.0);
            }
        }
        if (b2) {
            return -n;
        }
        return n;
    }
    
    private double[] nextDoubleArray(final int n) throws IOException {
        final double[] array = new double[n];
        for (int i = 0; i < n; ++i) {
            final double[] array2 = array;
            final int n2 = i;
            double n3 = 0.0;
            double n4 = 1.0;
            byte b;
            for (b = this.read(); b <= 32; b = this.read()) {}
            final boolean b2;
            if (b2 = (b == 45)) {
                b = this.read();
            }
            do {
                n3 = n3 * 10.0 + b - 48.0;
            } while ((b = this.read()) >= 48 && b <= 57);
            if (b == 46) {
                byte read;
                while ((read = this.read()) >= 48 && read <= 57) {
                    n3 += (read - 48) / (n4 *= 10.0);
                }
            }
            array2[n2] = (b2 ? (-n3) : n3);
        }
        return array;
    }
    
    private void fillBuffer() throws IOException {
        final DataInputStream din = this.din;
        final byte[] buffer = this.buffer;
        final int n = 0;
        this.bufferPointer = n;
        this.bytesRead = din.read(buffer, n, this.BUFFER_SIZE);
        if (this.bytesRead == -1) {
            this.buffer[0] = -1;
        }
    }
    
    final byte read() throws IOException {
        if (this.bufferPointer == this.bytesRead) {
            this.fillBuffer();
        }
        return this.buffer[this.bufferPointer++];
    }
    
    private void close() throws IOException {
        if (this.din == null) {
            return;
        }
        this.din.close();
    }
}






public final class Main
{
    private static void main$3231c38a() throws IOException {
        FastScanner fastScanner;
        byte codePoint;
        for (codePoint = (fastScanner = new FastScanner()).read(); Character.isWhitespace(codePoint); codePoint = fastScanner.read()) {}
        final StringBuilder sb;
        (sb = new StringBuilder()).append((char)codePoint);
        for (byte codePoint2 = fastScanner.read(); !Character.isWhitespace(codePoint2); codePoint2 = fastScanner.read()) {
            sb.append((char)codePoint2);
        }
        final String string = sb.toString();
        int max = 0;
        int n = 0;
        for (int i = 0; i < string.length(); ++i) {
            if (string.charAt(i) == 'R') {
                ++n;
            }
            else {
                max = Math.max(n, max);
                n = 0;
            }
        }
        System.out.println(Math.max(n, max));
    }
}