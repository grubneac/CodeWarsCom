/*
 * Traffic Light Rules
Traffic lights change colour as follows:

GREEN for 5 time units... then
ORANGE for 1 time unit... then
RED for 5 time units....
... and repeat the cycle
Car Rules
Cars travel left to right on the road, moving 1 character position per time unit
Cars can move freely until they come to a traffic light. Then:
if the light is GREEN they can move forward (temporarily occupying the same cell as the light)
if the light is ORANGE then they must stop (if they have already entered the intersection they can continue through)
if the light is RED the car must stop until the light turns GREEN again
Kata Task
Given the initial state of the road, return the states for all iterations of the simiulation.

Input
road = the road array
n = how many time units to simulate (n >= 0)
Output
An array containing the road states at every iteration (including the initial state)
Note: If a car occupies the same position as a traffic light then show only the car
Notes
There is only one car
For the initial road state
the car is always at the first character position
traffic lights are either GREEN or RED, and are at the beginning of their countdown cycles
There are no reaction delays - when the lights change the car drivers will react immediately!
If the car goes off the end of the road it just disappears from view
There will always be some road between adjacent traffic lights
Example
Run simulation for 10 time units

Input

road = "C...R............G......"
n = 10
Result

[
  "C...R............G......", // 0 initial state as passed
  ".C..R............G......", // 1
  "..C.R............G......", // 2
  "...CR............G......", // 3
  "...CR............G......", // 4
  "....C............O......", // 5 show the car, not the light
  "....GC...........R......", // 6
  "....G.C..........R......", // 7
  "....G..C.........R......", // 8
  "....G...C........R......", // 9
  "....O....C.......R......"  // 10
]
 */
public class TrafficLightsOneCar {

	public static void main(String[] args) {
		String[] result=TrafficLightsOneCar.trafficLights("C...R.....O.....G......", 30);


	}
	public static String[] trafficLights(String road, int n) {
		String[] result = new String[road.length()];
		n++;
		
		//create and fill first row
		char[][] maps =new char[n][road.length()];
		maps[0]= road.toCharArray();
		
		//add Traffic Light Rules
		maps = addTrafficLightRules(maps);
		
		//add Cars Rule
		maps = addCarsRule(maps);
		
		
		result = convertCharArr2ToStringArrAndPrint(maps,true);  
	    return result;
	}
	
	private static char[][] addCarsRule(char[][] maps) {
		//analysis from second row and second column
		for (int i = 1; i < maps.length; i++) {
			for (int j = 1; j < maps[i].length; j++) {
				 if(maps[i-1][j-1]=='C') {
					 if(maps[i][j]!='R' && maps[i][j]!='O')maps[i][j]='C';
					 else maps[i][j-1]='C';
				 }
			}
		}
		return maps;
	}
	private static char[][] addTrafficLightRules(char[][] maps) {
		char[][] result = new char[maps.length][maps[0].length];
		//repeat first row
		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps[i].length; j++) {
				result[i][j]=maps[0][j];
			}
		}
		// Apply Traffic Light Rules from second row
		for (int i = 1; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				switch (result[i-1][j]) {
				case 'C':
					result[i][j]='.';
					break;
				case '.':
					result[i][j]='.';
					break;
				case 'R':
					//count previous R
					int countR = 0;
					int k=i;
					while(true){
						k--;
						if(k>=0 && result[k][j]=='R')countR++;
						else break;
					}
					if(countR>=5)result[i][j]='G';
					else result[i][j]='R';
					break;
				case 'G':
					//count previous R
					int countG = 0;
					int kG=i;
					while(true){
						kG--;
						if(kG>=0 && result[kG][j]=='G')countG++;
						else break;
					}
					if(countG>=5)result[i][j]='O';
					else result[i][j]='G';
					break;
				case 'O':
					result[i][j]='R';
					break;
				}
			}
		}
		
		return result;
	}
	private static String[] convertCharArr2ToStringArrAndPrint(char[][] maps, Boolean isPrint) {
		String[] result = new String[maps.length];
		
		int i=0;
		for (char[] chrArr : maps) {
			result[i++]= new String(chrArr);
		}
		if(isPrint) 
			for (String string : result) 
				if(string.length()>0)
					System.out.println("'"+string+"'");
		
		
		return result;
	}
}
