public class Main {
	private static Scanner sc = new Scanner(System.in);
	
	
	
	

	
	/*for ( キーのデータ型 key : マップの名前.keySet() ) {
		データのデータ型 data = マップの名前.get( key );
		
		// keyやdataを使った処理;
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		
		
		String S=sc.next();
		String T=sc.next();
		char a[]=S.toCharArray();
		char b[]=T.toCharArray();
		int ans=0;
		for(int i=0;i<3;i++) {
			if(a[i]==b[i])ans++;
			
		}
		p(ans);
		
		
		
		
		
		
		}
		
		
	
	
	
	public static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
	}
	
	public static long gcd(long a, long b) {
        return b == 0 ? a: gcd(b, a % b);
	}

	


	
	static void p(String ans) {System.out.println(ans);};
	static void p(int ans) {System.out.println(ans);};
	static void p() {System.out.println();};
	static void p(long ans) {System.out.println(ans);};
	static void p(double ans) {System.out.println(ans);};
	
}