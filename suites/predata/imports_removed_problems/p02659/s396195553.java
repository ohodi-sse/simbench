public class Main {	

	private static void solve(){
		
		long A = nl();
		char[] Bca = next().toCharArray();
		long B = 0;
		int dig = 2;
		for(char c:Bca) {
			if(c != '.') {
				B += (long)Character.getNumericValue(c) * (long)Math.pow(10, dig);
				dig--;
			}
		}


		System.out.println(A*B/100L);
	}
	
	
	private static BufferedReader br;
	public static void main(String[] args){
		br = new BufferedReader(new InputStreamReader(System.in));
		String debugDataPath = System.getenv("DD_PATH");        
		if(debugDataPath != null){
			try{
				br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(debugDataPath))));
			}catch(Exception e){
				throw new RuntimeException(e);
			}
		}
		boolean hasNext = true;
		while(hasNext){
			solve();	
			try{
				br.mark(1);
				if(br.read() > 0){
					br.reset();			
					System.out.println("---");
				} else {
					hasNext = false;
				}
			}catch(Exception e){
				throw new RuntimeException(e);
			} 
		}
	}

	
	private static StringTokenizer tokenizer = null;
	public static String next() {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			try {
				tokenizer = new StringTokenizer(br.readLine());
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return tokenizer.nextToken();
	}
	
	private static int ni() {
		return Integer.parseInt(next());
	}
	
	private static long nl() {
		return Long.parseLong(next());
	}
	
	private static double nd() {
		return Double.parseDouble(next());
	}
	
	private static int[] na(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = ni();
		return a;
	}
	
	private static char[] ns() {
		return next().toCharArray();
	}
	
	private static long[] nal(int n) {
		long[] a = new long[n];
		for (int i = 0; i < n; i++)
			a[i] = nl();
		return a;
	}
}