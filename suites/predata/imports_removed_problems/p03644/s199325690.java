public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    
    static int[] inputval() throws Exception {
        String[] strarray = br.readLine().trim().split(" ");
        int[] intarray = new int[strarray.length];
        for (int i = 0; i < intarray.length; i++) {
            intarray[i] = Integer.parseInt(strarray[i]);
        }
        return intarray;
    }

    
    static Integer[] inputvalInteger() throws Exception {
        String[] strarray = br.readLine().trim().split(" ");
        Integer[] intarray = new Integer[strarray.length];
        for (int i = 0; i < intarray.length; i++) {
            intarray[i] = Integer.parseInt(strarray[i]);
        }
        return intarray;
    }

    public static void main(String[] args) throws Exception {
        
        int n = Integer.parseInt(br.readLine().trim());
        for(int i=n; i>0; i--){
            int tmp = i;
            while (tmp> 0){
                if (tmp == 1){
                    System.out.println(i);
                    return;
                }
                else if (tmp %2 != 0){
                    break;
                }
                tmp /= 2;
            }
        }

    }

}