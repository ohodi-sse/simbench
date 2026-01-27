static class MyScanner
{
    BufferedReader reader;
    StringTokenizer tokenizer;
    
    MyScanner() {
        this.reader = new BufferedReader(new InputStreamReader(System.in), 32768);
    }
    
    String next() {
        try {
            while (this.tokenizer == null || !this.tokenizer.hasMoreTokens()) {
                this.tokenizer = new StringTokenizer(this.reader.readLine());
            }
        }
        catch (final IOException ex) {}
        return this.tokenizer.nextToken();
    }
    
    int nextInt() {
        return Integer.parseInt(this.next());
    }
    
    long nextLong() {
        return Long.parseLong(this.next());
    }
}public class Main
{
    public static void main(final String[] array) {
        final MyScanner myScanner = new MyScanner();
        final long nextLong = myScanner.nextLong();
        final String next = myScanner.next();
        System.out.println(nextLong * (Integer.parseInt(next.substring(0, 1)) * 100 + Integer.parseInt(next.substring(2, 4))) / 100L);
    }
    
    static class MyScanner
    {
        BufferedReader reader;
        StringTokenizer tokenizer;
        
        MyScanner() {
            this.reader = new BufferedReader(new InputStreamReader(System.in), 32768);
        }
        
        String next() {
            try {
                while (this.tokenizer == null || !this.tokenizer.hasMoreTokens()) {
                    this.tokenizer = new StringTokenizer(this.reader.readLine());
                }
            }
            catch (final IOException ex) {}
            return this.tokenizer.nextToken();
        }
        
        int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        long nextLong() {
            return Long.parseLong(this.next());
        }
    }
}