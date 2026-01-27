public class Main {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        boolean flag = false;
        int counter = 0;
        char[] work = new char[S.length()];
        for(int i = 0; i < S.length(); i++){
            work[i] = S.charAt(i);
            if(work[i] == 'R'){
                counter++;
                flag = true;
            }
            if(work[i] == 'S' && flag){
                break;
            }
        }
        System.out.println(counter);
    }
}