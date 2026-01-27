public class Main {
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
        String someString = sc.next();
		char rChar = 'R';
        int rCount = 0;
      
		for (int i = 0; i < someString.length(); i++) {
        if(rCount==0 && someString.charAt(i) == rChar){
          rCount = 1;
        }
        if (someString.charAt(i) == rChar) {
          if(i>0 && someString.charAt(i-1) == rChar){
           rCount++;
          }
        }         
        }
      
      System.out.println(rCount);
      
	}
}