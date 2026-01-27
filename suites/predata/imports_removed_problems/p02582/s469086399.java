public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        
        String s = sc.next();
		
        int max=0;
      	
      	int now=0;
      
      	for(int i=0;i<s.length();i++){
          if(s.charAt(i)=='R'){
            now+=1;
          }else{
            now=0;
          }
          if(now>=max){
            max=now;
          }
        }
      System.out.println(max);
    }
}