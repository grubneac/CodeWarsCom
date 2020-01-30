
public class TrafficLightsMultipleCars {

	public static void main(String[] args) {
		String[] result=TrafficLightsMultipleCars.trafficLights("CCC.G...R...", 16);

	}
	public static String[] trafficLights(String road, int n) {
		n++;
		String[] result = new String[n];
		
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
		
		//we have array with traffic rules
		char[][] trafficLightRules = new char[maps.length][maps[0].length];
		//repeat first row
		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps[i].length; j++) {
				trafficLightRules[i][j]=maps[0][j];
			}
		}
		
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
