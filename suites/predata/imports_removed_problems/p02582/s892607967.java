class Main{
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    char R = 'R';
    char[] chars = s.toCharArray();
    int count;
    if(chars[0] == R && chars[1] == R && chars[2] == R){
      count =3;
    }
    else if( (chars[0] == R && chars[1] == R) || (chars[1] == R && chars[2] == R)){
      count =2;
    }
    else if( chars[0] == R || chars[1] == R || chars[2] == R){
      count =1;
    }
    else{
      count = 0;
    }
    System.out.println(count);
  }

  static class Scanner {
    StringTokenizer st;
    BufferedReader br;

    public Scanner(InputStream s) {
      br = new BufferedReader(new InputStreamReader(s));
    }

    public Scanner(FileReader s) throws FileNotFoundException {
      br = new BufferedReader(s);
    }

    public String next() throws IOException {
      while (st == null || !st.hasMoreTokens())
        st = new StringTokenizer(br.readLine());
      return st.nextToken();
    }

    public int nextInt() throws IOException {
      return Integer.parseInt(next());
    }

    public long nextLong() throws IOException {
      return Long.parseLong(next());
    }

    public String nextLine() throws IOException {
      return br.readLine();
    }

    public double nextDouble() throws IOException {
      return Double.parseDouble(next());
    }

    public boolean ready() throws IOException {
      return br.ready();
    }
  }
}