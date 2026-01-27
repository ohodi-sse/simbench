public class Main {

	static Scanner scanner;

	public static void main(String[] args) {
	    scanner = new Scanner(System.in);

	    int N=gi();

	    int m= 1;
	    
int i=0;
           while(true) {
        	   if(Math.pow(2, i)<=N) {
        		   m=(int)Math.pow(2, i);
        		   i++;
        	   }else {
        		   break;
        	   }
           }


	   
	    System.out.print(m);










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