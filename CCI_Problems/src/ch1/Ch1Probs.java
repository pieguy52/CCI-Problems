package ch1;
import java.lang.StringBuilder;
import java.util.Arrays;

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
			for(int i = 0; i < length; i++){
				if(s1.charAt(i) != s2.charAt(i))
					return deleteChar(s1, s2, i);
			}
		}
		return true;
	}
	
	private static boolean deleteChar(String s1, String s2, int index){
		StringBuilder ns1 = new StringBuilder(s1);
		StringBuilder ns2 = new StringBuilder(s2);
		
		if(ns1.length() < ns2.length())
			ns2.deleteCharAt(index);
		else
			ns1.deleteCharAt(index);
		
		if(ns2.length() != ns1.length())
			return false;
				
		return ns1.toString().equals(ns2.toString());
	}
	
	public static void oneAwayTests() {
		String[][] tests = {
				{"pale", "ple"},
				{"pale", "pal"},
				{"pales", "pale"},
				{"palse", "pale"},
				{"pasle", "pale"},
				{"spale", "pale"},
				{"pale", "bale"},
				{"pale", "bake"}
		};
		for(int i = 0; i < tests.length; i++)
			System.out.printf("Test %d: (%s, %s) %b\n", i, tests[i][0], tests[i][1], oneAway(tests[i][0], tests[i][1]));
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
	
	public static void sCompressionTests(){
		String[] tests = {"a", "aaaaabccccaaa", "rmbrthyyyylm","aaaaaaaaaaaaaaaaaaaaab", "abababababbababababab"};
		for(String s: tests)
			System.out.printf("String: %s, compressed: %s\n", s, sCompression(s));
	}
	
	public static int[][] rotateMatrix(int[][] m){
		if(m == null)
			return m;
		int[][] rotatedM = new int[m.length][m.length];
		for(int i = 0; i < m.length; i++)
			for(int j = 0; j < m.length; j++)
				rotatedM[i][j] = m[(m.length-1)-j][i];
		return rotatedM;
	}
	
	public static void rotatedMatrixTests(){
		int[][] test = {
				{0, 1, 2},
				{3, 4, 5},
				{6, 7, 8}
		};
		int[][] rTest = rotateMatrix(test);
		System.out.println(Arrays.deepToString(rTest));
	}
	
	public static int[][] zeroMatrix(int[][] m){
		if(m == null)
			return m;
		int[][] zeroMatrix = new int[m.length][m[0].length];
		boolean[] zeroRows = new boolean[m.length];
		boolean[] zeroCols = new boolean[m[0].length];
		for(int i = 0; i < m.length; i++)
			for(int j = 0; j < m[0].length; j++){
				zeroMatrix[i][j] = m[i][j];
				if(m[i][j] == 0){
					zeroRows[i] = true;
					zeroCols[j] = true;
				}
			}
		zeroMatrix = bomberMan(zeroMatrix, zeroRows, zeroCols);
		return zeroMatrix;
	}
	
	private static int[][] bomberMan(int[][] m, boolean[] zeroR, boolean[] zeroC){
		for(int i = 0; i < zeroR.length; i++)
			if(zeroR[i])
				for(int j = 0; j < m[i].length; j++)
					m[i][j] = 0;
		for(int j = 0; j < zeroC.length; j++)
			if(zeroC[j])
				for(int i = 0; i < m.length; i++)
					m[i][j] = 0;
		return m;
	}
	
	public static void zeroMatrixTests(){
		int[][] test = {
				{1,1,1},
				{1,0,1},
				{1,1,1}
		};
		test = zeroMatrix(test);
		System.out.println(Arrays.deepToString(test));
		int[][] test2 = {
				{0,1,1},
				{1,1,1},
				{1,1,0}
		};
		test2 = zeroMatrix(test2);
		System.out.println(Arrays.deepToString(test2));
		int[][] test3 = {
				{1,0,1},
				{1,0,1},
				{1,1,1}
		};
		test3 = zeroMatrix(test3);
		System.out.println(Arrays.deepToString(test3));
	}
	
	public static boolean stringRotation(String s1, String s2){
		if(s1 == null || s2 == null || s1.length() != s2.length())
			return false;
		char c;
		StringBuilder s = new StringBuilder(s2);
		for(int i = 0; i < s1.length(); i++){
			c = s.charAt(0);
			s.deleteCharAt(0);
			s.append(c);
			if(s.toString().equals(s1))
				return true;
		}
		return false;
	}
	
	public static void stringRotationTest(){
		String[][] tests = {
				{"waterbottle", "erbottlewat"},
				{"wassup", "supwas"},
				{"hey", "hey"}
		};
		for(int i = 0; i < tests.length; i++)
			System.out.printf("String 1: %s, String 2: %s, rotated: %b\n", tests[i][0], tests[i][1], stringRotation(tests[i][0], tests[i][1]));
	}
	
	public static void main(String[] args){
		//oneAwayTests();
		//sCompressionTests();
		//rotatedMatrixTests();
		//zeroMatrixTests();
		stringRotationTest();
	}
}
