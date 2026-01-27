public class Main {
	
	public static class FastReader {
		BufferedReader br;
		StringTokenizer st;
	

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception r) {
					r.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (Exception r) {
				r.printStackTrace();
			}
			return str;
		}
	}
	
	public static PrintWriter out = new PrintWriter (new BufferedOutputStream(System.out));
    
    public final static int MAX = (int)1e5;
  
   static List<Integer>[] edge;
   private static int N = (int) (2e5 + 11);
	public static void main(String[] args) {
	   
	 FastReader sc = new FastReader();

	 char[] s = sc.next().toCharArray();
	 char[] t = sc.next().toCharArray();
	 int ans = 0;
	 for(int i=0;i<3;++i) if(s[i] == t[i]) ++ans;
	 out.print(ans);
	 out.close();
	}
}