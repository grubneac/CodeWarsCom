
public class The_Fusc_Function_Part_1 {

	public static void main(String[] args) {
		System.out.println(fusc(85));
	}
	public static int fusc(int n) {
		if(n<=1) return n;
		int result = 0;
		if(n%2==0)result=fusc(n/2);
		else result= fusc(n/2)+fusc(n-n/2);
		
	    return result;
	  }
}
