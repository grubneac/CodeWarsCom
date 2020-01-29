import java.util.ArrayList;

/*Write a simple parser that will parse and run Deadfish.

Deadfish has 4 commands, each 1 character long:

i increments the value (initially 0)
d decrements the value
s squares the value
o outputs the value into the return array
Invalid characters should be ignored.

parse("iiisdoso") => [ 8, 64 ]
*/

public class MakeTheDeadfishSwim {

	public static void main(String[] args) {
		int[] tt=parse("iiisdosodddddiso");
		for (int i : tt) {
			System.out.println(i);
		}

	}
	 
	public static int[] parse(String data) {
		int n =0;
		char[] cArray =data.toCharArray();
		ArrayList<Integer> result= new ArrayList<Integer>();
		for (char c : cArray) {
			switch (c) {
			case 'i':
				n++;
				break;
			case 'd':
				n--;
				break;
			case 's':
				n=n*n;
				break;
			case 'o':
				result.add(n);
//				n=0;
				break;
			}
		}
		int[] resultArr =result.stream().mapToInt(i-> (int)i).toArray();
		return resultArr;
	 }
}
