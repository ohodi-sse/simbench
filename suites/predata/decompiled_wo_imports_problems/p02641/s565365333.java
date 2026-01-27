public class Main
{
    public static void main(final String[] array) throws Exception {
        final Reader reader = new Reader();
        int n = 1;
        while (n-- > 0) {
            final int nextInt = reader.nextInt();
            final int nextInt2 = reader.nextInt();
            final int[] array2 = new int[nextInt2];
            final ArrayList list = new ArrayList();
            final HashSet<Integer> set = new HashSet<Integer>();
            for (int i = 1; i <= 100; ++i) {
                set.add(i);
            }
            for (int j = 0; j < nextInt2; ++j) {
                array2[j] = reader.nextInt();
                set.remove(array2[j]);
            }
            int min = Integer.MAX_VALUE;
            final Iterator<Integer> iterator = set.iterator();
            while (iterator.hasNext()) {
                min = Math.min(min, Math.abs(iterator.next() - nextInt));
            }
            final TreeSet<Integer> set2 = new TreeSet<Integer>();
            for (final int intValue : set) {
                if (Math.abs(intValue - nextInt) == min) {
                    set2.add(intValue);
                }
            }
            final int abs = Math.abs(nextInt);
            final int abs2 = Math.abs(nextInt - 101);
            final int min2 = Math.min(abs, abs2);
            if (min2 <= min && min2 == abs) {
                if (min2 == abs) {
                    System.out.println(0);
                }
                return;
            }
            if (min2 < min && min2 == abs2) {
                System.out.println(101);
                return;
            }
            if (set.size() == 0) {
                System.out.println(Math.min(Math.abs(nextInt), Math.abs(nextInt - 101)));
                return;
            }
            System.out.println(set2.first());
        }
    }
    
    static int countInRange(final int[] array, final int n, final int n2, final int n3) {
        return upperIndex(array, n, n3) - lowerIndex(array, n, n2) + 1;
    }
    
    static int lowerIndex(final int[] array, final int n, final int n2) {
        int i = 0;
        int n3 = n - 1;
        while (i <= n3) {
            final int n4 = (i + n3) / 2;
            if (array[n4] >= n2) {
                n3 = n4 - 1;
            }
            else {
                i = n4 + 1;
            }
        }
        return i;
    }
    
    static int upperIndex(final int[] array, final int n, final int n2) {
        int i = 0;
        int n3 = n - 1;
        while (i <= n3) {
            final int n4 = (i + n3) / 2;
            if (array[n4] <= n2) {
                i = n4 + 1;
            }
            else {
                n3 = n4 - 1;
            }
        }
        return n3;
    }
    
    public static StringBuilder dec_to_bin(long n) {
        if (n == 0L) {
            final StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 30; ++i) {
                sb.append("0");
            }
            return sb;
        }
        final StringBuilder sb2 = new StringBuilder("");
        while (n != 0L) {
            sb2.append(n % 2L);
            n /= 2L;
        }
        final StringBuilder reverse = sb2.reverse();
        final StringBuilder sb3 = new StringBuilder("");
        for (int j = reverse.length(); j != 30; ++j) {
            sb3.append("0");
        }
        sb3.append((CharSequence)reverse);
        return sb3;
    }
    
    private static int binarySearchPM(final int[] array, final int n) {
        final int length = array.length;
        int i = 0;
        int n2 = length;
        while (i <= n2) {
            final int n3 = (i + n2) / 2;
            if (n3 == length) {
                return length;
            }
            if (n < array[n3]) {
                n2 = n3 - 1;
            }
            else {
                if (n <= array[n3]) {
                    return n3;
                }
                i = n3 + 1;
            }
        }
        return -i;
    }
    
    static class Reader
    {
        private final int BUFFER_SIZE = 65536;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer;
        private int bytesRead;
        
        public Reader() {
            this.din = new DataInputStream(System.in);
            this.buffer = new byte[65536];
            final int n = 0;
            this.bytesRead = n;
            this.bufferPointer = n;
        }
        
        public Reader(final String name) throws IOException {
            this.din = new DataInputStream(new FileInputStream(name));
            this.buffer = new byte[65536];
            final int n = 0;
            this.bytesRead = n;
            this.bufferPointer = n;
        }
        
        public String readLine() throws IOException {
            final byte[] bytes = new byte[64];
            int length = 0;
            byte read;
            while ((read = this.read()) != -1 && read != 10) {
                bytes[length++] = read;
            }
            return new String(bytes, 0, length);
        }
        
        public int nextInt() throws IOException {
            int n = 0;
            byte b;
            for (b = this.read(); b <= 32; b = this.read()) {}
            final boolean b2 = b == 45;
            if (b2) {
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
        
        public long nextLong() throws IOException {
            long n = 0L;
            byte b;
            for (b = this.read(); b <= 32; b = this.read()) {}
            final boolean b2 = b == 45;
            if (b2) {
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
        
        public double nextDouble() throws IOException {
            double n = 0.0;
            double n2 = 1.0;
            byte b;
            for (b = this.read(); b <= 32; b = this.read()) {}
            final boolean b2 = b == 45;
            if (b2) {
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
        
        private void fillBuffer() throws IOException {
            final DataInputStream din = this.din;
            final byte[] buffer = this.buffer;
            final int n = 0;
            this.bufferPointer = n;
            this.bytesRead = din.read(buffer, n, 65536);
            if (this.bytesRead == -1) {
                this.buffer[0] = -1;
            }
        }
        
        private byte read() throws IOException {
            if (this.bufferPointer == this.bytesRead) {
                this.fillBuffer();
            }
            return this.buffer[this.bufferPointer++];
        }
        
        public void close() throws IOException {
            if (this.din == null) {
                return;
            }
            this.din.close();
        }
    }
}static class Reader
{
    private final int BUFFER_SIZE = 65536;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer;
    private int bytesRead;
    
    public Reader() {
        this.din = new DataInputStream(System.in);
        this.buffer = new byte[65536];
        final int n = 0;
        this.bytesRead = n;
        this.bufferPointer = n;
    }
    
    public Reader(final String name) throws IOException {
        this.din = new DataInputStream(new FileInputStream(name));
        this.buffer = new byte[65536];
        final int n = 0;
        this.bytesRead = n;
        this.bufferPointer = n;
    }
    
    public String readLine() throws IOException {
        final byte[] bytes = new byte[64];
        int length = 0;
        byte read;
        while ((read = this.read()) != -1 && read != 10) {
            bytes[length++] = read;
        }
        return new String(bytes, 0, length);
    }
    
    public int nextInt() throws IOException {
        int n = 0;
        byte b;
        for (b = this.read(); b <= 32; b = this.read()) {}
        final boolean b2 = b == 45;
        if (b2) {
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
    
    public long nextLong() throws IOException {
        long n = 0L;
        byte b;
        for (b = this.read(); b <= 32; b = this.read()) {}
        final boolean b2 = b == 45;
        if (b2) {
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
    
    public double nextDouble() throws IOException {
        double n = 0.0;
        double n2 = 1.0;
        byte b;
        for (b = this.read(); b <= 32; b = this.read()) {}
        final boolean b2 = b == 45;
        if (b2) {
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
    
    private void fillBuffer() throws IOException {
        final DataInputStream din = this.din;
        final byte[] buffer = this.buffer;
        final int n = 0;
        this.bufferPointer = n;
        this.bytesRead = din.read(buffer, n, 65536);
        if (this.bytesRead == -1) {
            this.buffer[0] = -1;
        }
    }
    
    private byte read() throws IOException {
        if (this.bufferPointer == this.bytesRead) {
            this.fillBuffer();
        }
        return this.buffer[this.bufferPointer++];
    }
    
    public void close() throws IOException {
        if (this.din == null) {
            return;
        }
        this.din.close();
    }
}