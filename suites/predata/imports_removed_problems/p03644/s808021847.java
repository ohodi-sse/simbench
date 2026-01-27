public class Main {
	public static int N,K,a=-1;
	public static String ans="";
	

	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		for(int i=1;i<=N;i++) {
			int get=0;int tri=i;
			for(;;) {
				if(tri%2==0) {
					tri/=2;
					get++;
				}else {
					break;
				}
			}
			if(a<get) {
				a=get;
				ans=""+i;
			}
		}
		System.out.println(ans);
	}
}