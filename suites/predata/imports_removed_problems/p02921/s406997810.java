public class Main {

	static Scanner scanner;

	public static void main(String[] args) {
	    scanner = new Scanner(System.in);
	    String s=gs();
	    String t=gs();
	    int c=0;
	    for (int i=0; i<3;i++) {
	    	if(s.charAt(i)==t.charAt(i))c++;
	    }

	   
	    System.out.print(c);








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