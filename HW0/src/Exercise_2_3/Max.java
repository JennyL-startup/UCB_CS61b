package Exercise_2_3;

public class Max {
    /** Returns the maximum value from m. */
    public static int max(int[] m) {
    	int max_num = m[0];
        for (int i = 0; i < m.length; i++) {
        	if (m[i]>max_num) {
        		max_num = m[i];
        	}
        }
        return max_num;
    }
    public static void main(String[] args) {
       int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};  
       Max.max(numbers);
       System.out.println(Max.max(numbers));
    }
}