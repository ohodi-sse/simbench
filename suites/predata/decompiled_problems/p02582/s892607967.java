import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.IOException;

// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    public static void main(final String[] array) throws IOException {
        final String next = new Scanner(System.in).next();
        final char c = 'R';
        final char[] charArray = next.toCharArray();
        int x;
        if (charArray[0] == c && charArray[1] == c && charArray[2] == c) {
            x = 3;
        }
        else if ((charArray[0] == c && charArray[1] == c) || (charArray[1] == c && charArray[2] == c)) {
            x = 2;
        }
        else if (charArray[0] == c || charArray[1] == c || charArray[2] == c) {
            x = 1;
        }
        else {
            x = 0;
        }
        System.out.println(x);
    }
    
    static class Scanner
    {
        StringTokenizer st;
        BufferedReader br;
        
        public Scanner(final InputStream in) {
            this.br = new BufferedReader(new InputStreamReader(in));
        }
        
        public Scanner(final FileReader in) throws FileNotFoundException {
            this.br = new BufferedReader(in);
        }
        
        public String next() throws IOException {
            while (this.st == null || !this.st.hasMoreTokens()) {
                this.st = new StringTokenizer(this.br.readLine());
            }
            return this.st.nextToken();
        }
        
        public int nextInt() throws IOException {
            return Integer.parseInt(this.next());
        }
        
        public long nextLong() throws IOException {
            return Long.parseLong(this.next());
        }
        
        public String nextLine() throws IOException {
            return this.br.readLine();
        }
        
        public double nextDouble() throws IOException {
            return Double.parseDouble(this.next());
        }
        
        public boolean ready() throws IOException {
            return this.br.ready();
        }
    }
}
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.BufferedReader;
import java.util.StringTokenizer;

// 
// Decompiled by Procyon v0.6.0
// 

static class Scanner
{
    StringTokenizer st;
    BufferedReader br;
    
    public Scanner(final InputStream in) {
        this.br = new BufferedReader(new InputStreamReader(in));
    }
    
    public Scanner(final FileReader in) throws FileNotFoundException {
        this.br = new BufferedReader(in);
    }
    
    public String next() throws IOException {
        while (this.st == null || !this.st.hasMoreTokens()) {
            this.st = new StringTokenizer(this.br.readLine());
        }
        return this.st.nextToken();
    }
    
    public int nextInt() throws IOException {
        return Integer.parseInt(this.next());
    }
    
    public long nextLong() throws IOException {
        return Long.parseLong(this.next());
    }
    
    public String nextLine() throws IOException {
        return this.br.readLine();
    }
    
    public double nextDouble() throws IOException {
        return Double.parseDouble(this.next());
    }
    
    public boolean ready() throws IOException {
        return this.br.ready();
    }
}
