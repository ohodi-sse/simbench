/*for ( キーのデータ型 key : マップの名前.keySet() ) {
	データのデータ型 data = マップの名前.get( key );
	
	// keyやdataを使った処理;
}*/








public class Main {
	static int a1[]= {0,-1,0,1};
	static int b1[]= {-1,0,1,0};
	private static Scanner sc = new Scanner(System.in);
	static void p(String ans) {System.out.println(ans);};
	static void p(int ans) {System.out.println(ans);};
	static void p(long ans) {System.out.println(ans);};
	static void p(double ans) {System.out.println(ans);};
	static int K;
	public static void main(String[] args) {
		int N=sc.nextInt();
		int maxCtn=0;
		int maxAns=1;
		int ctn=0;
		for(int i=1;i<=N;i++) {

			int v=i;
			while(v%2!=1) {
				v=v/2;
				ctn++;
			}
			if(maxCtn<ctn) {
			
			
				maxCtn=ctn;
				maxAns=i;
			}
			ctn=0;
		}
		p(maxAns);
	}
}