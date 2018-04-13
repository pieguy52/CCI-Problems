package ch1;
import java.lang.StringBuilder;

public class Ch1Probs {
	
	public static boolean oneAway(String s1, String s2){
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
	
	public static String sCompression(String s){
		if(s == null || s.length() == 1)
			return s;
		int count = 1;
		char[] charArray = s.toCharArray();
		StringBuilder fin = new StringBuilder(s.length());
		char curr = charArray[0];
		char prev = curr;
		fin.append(curr);
		fin.append(count);
		for(int i = 1; i < charArray.length; i++){
			curr = charArray[i];
			if(curr == prev){
				count++;
				if(count >10)
					fin.deleteCharAt(fin.length()-1);
				fin.deleteCharAt(fin.length()-1);
				fin.append(count);
			}else{
				count = 1;
				fin.append(curr);
				fin.append(count);
			}
			prev = curr;
		}
		if(fin.length() > s.length())
			return s;
		return fin.toString();
	}
	
	private static void oneAwayTests() {
		String[][] tests = {
				{"pale", "ple"},
				{"pale", "pal"},
				{"pales", "pale"},
				{"palse", "pale"},
				{"pale", "bale"},
				{"pale", "bake"}
		};
		for(int i = 0; i < tests.length; i++)
			System.out.printf("Test %d: (%s, %s) %b\n", i, tests[i][0], tests[i][1], oneAway(tests[i][0], tests[i][1]));
	}
	
	private static void sCompressionTests(){
		String[] tests = {"a", "aaaaabccccaaa", "rmbrthyyyylm","aaaaaaaaaaaaaaaaaaaaab", "abababababbababababab"};
		for(String s: tests)
			System.out.printf("String: %s, compressed: %s\n", s, sCompression(s));
	}
	
	public static void main(String[] args){
		oneAwayTests();
		sCompressionTests();
	}
}
