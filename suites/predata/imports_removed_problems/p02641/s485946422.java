public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt();
		int N = sc.nextInt();
		Integer p[] = new Integer [N];
		for(int i=0;i<N;i++) {
			p[i] = sc.nextInt();
		}
		/*for(int i=0;i<N;i++) {
			System.out.println(p[i]);
		}*/
	    int min=Integer.MAX_VALUE;
		for(int j=-1000;j<1000;j++) {
			if(Arrays.asList(p).contains(j)) {
				
				continue;
			}
			
		  min = Math.min(min, Math.abs(X-j));
		}
		int a = X-min;
		if(Arrays.asList(p).contains(a)) {
			System.out.println(X+min);
		}else {
			System.out.println(a);
		}
	}
}