package ch1;

public class Problems59 {
	
	public static boolean prob5(String s1, String s2){
		if(s1 == null || s2 == null || Math.abs((s1.length() - s2.length())) > 1)
			return false;
		if(s1.length() == s2.length()){
			int numDiff = 0;
			for(int i = 0; i < s1.length(); i++){
				numDiff += (s1.charAt(i) == s2.charAt(i)) ? 0 : 1;
				if(numDiff > 1)
					return false;
			}
		}else{
			int length = (s1.length() < s2.length()) ? s1.length() : s2.length();
			int numDiff = 0;
			for(int i = 0; i < length; i++)
				numDiff += (s1.charAt(i) == s2.charAt(i)) ? 0 : 1;
			if(numDiff > length)
				return false;
		}
		return true;
	}
	
	private static void prob5Tests() {
		String[][] tests = {
				{"pale", "ple"},
				{"pale", "pal"},
				{"pales", "pale"},
				{"palse", "pale"},
				{"pale", "bale"},
				{"pale", "bake"}
		};
		for(int i = 0; i < tests.length; i++)
			System.out.printf("Test %d: (%s, %s) %b\n", i, tests[i][0], tests[i][1], prob5(tests[i][0], tests[i][1]));
	}
	
	public static void main(String[] args){
		prob5Tests();
	}
}
