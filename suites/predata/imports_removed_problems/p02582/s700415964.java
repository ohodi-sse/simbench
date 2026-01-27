public class Main{
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();

        
        char[] str1 = new char[str.length()];
        for(int i=0; i<str.length(); i++){
            str1[i] = str.charAt(i);
            
        }


        int count = -1;
        
        if(str1[0] != 'R' && str1[1] != 'R' && str1[2] != 'R'){
            count = 0;
        }
        else if((str1[0] == 'S' && str1[1] == 'S') || (str1[1] == 'S' && str1[2] == 'S') || (str1[2] == 'S' && str1[0] == 'S') || (str1[0] == 'R' && str1[1] == 'S' && str1[2] == 'R')){
            count = 1;
        }
        else if((str1[0] == 'R' && str1[1] == 'R' && str1[2] == 'S') || (str1[0] == 'S' && str1[1] == 'R' && str1[2] == 'R')){
            count = 2;
        }
        else if(str1[0] == 'R' && str1[1] == 'R' && str1[2] == 'R'){
            count = 3;
        }

        System.out.println(count);

    }
}