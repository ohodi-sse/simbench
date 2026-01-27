public class Main {	

	private static void solve(){
		
		int X = ni();
		int N = ni();
		List<Integer> p = new ArrayList<Integer>();
		for(int i = 0; i < N; i++)p.add(ni());
		Map<Integer,Boolean> map = new HashMap<>();
		for(int i:p)map.put(i,true);
		int result = -1;
		for(int dist = 0; dist <= 100; dist++) {
			int bpos = X - dist;
			int fpos = X + dist;

			if(!map.containsKey(bpos)) {
				result = bpos;
				break;
			}
			if(!map.containsKey(fpos)) {
				result = fpos;
				break;
			}
		}
		System.out.println(result);



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
		solve();
		boolean hasNext = true;














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