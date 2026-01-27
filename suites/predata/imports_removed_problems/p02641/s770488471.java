public class Main {

	static Scanner scanner;

	public static void main(String[] args) {
	    scanner = new Scanner(System.in);

	    int X=gi();
	    int N=gi();
	    int[] P=new int[N];

        for(int i=0;i<N; i++) {
        	P[i]=gi();
	    }
        int q=0;
        int Y=X;
        while(true) {
        	Y+=Math.pow(-1, q)*q;
        	boolean flg=false;
        	for(int i=0;i<N; i++) {
            	if (P[i]==Y) {
            		q++;
            		flg=true;
            		break;
            	}
    	    }
        	if (!flg) {
        	    break;
        	}
        }

        System.out.println(Y);







	}

	
	public static String gs() {
		return scanner.next();
	}

	
	public static int gi() {
		return Integer.parseInt(scanner.next());
	}

	
	public static long gl() {
		return Long.parseLong(scanner.next());
	}

	
	public static double gd() {
		return Double.parseDouble(scanner.next());
	}
}