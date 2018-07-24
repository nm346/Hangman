import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
public class Game{

	public static String word = "worder";
	public static LinkedList<Integer> indexes = new LinkedList<Integer>();
	public static  String dashesForWord = dashes(word);	
	public static  String result= dashesForWord;
	public static String lastResult="";
	public static  boolean contain;
	public static int lives = 9;
	public static HashSet<Character> alreadyUsed = new HashSet<Character>();
	
	
	
	
	public static void main(String[] arg){

		theGame();

	}
	

	public static void theGame(){
			//dashesForWord 
Scanner scanner = new Scanner(System.in);
	
	while(true){
		if(lives == 0) {
			System.out.println("You lose");
			return;
		}
		if(containsDashes(result)==false){
			System.out.println("You win");
			return;
		}
		System.out.println("Lives left:"+lives);
	System.out.println("Enter a letter");
		char c = scanner.next().charAt(0);
			System.out.println(place(c));
		
		
		if(contain==false && alreadyUsed.contains(c)){
			System.out.println("This letter was already entered");
		}
		if(contain==false && !alreadyUsed.contains(c)){
			lives--;
			alreadyUsed.add(c);
			}
		}
	}
	
	
	
	public static  void contains(char c ){ //marks the indexes of the word the letter is located.
		String s = word;
		String copy = s;
		contain = false;
	for(int i = 0; i < s.length();i++){
		//int i = 10;
		if(copy.equals("") && contain == true) return;
			if(copy.equals("")) return;
			if(copy.charAt(0) == c){ 
				contain = true;
				indexes.add(i);
				
			}
			
			copy = copy.substring(1);
	}}
	
	public static boolean containsDashes(String s){
		while(true){
			if(s.isEmpty()) return false;
			if(s.charAt(0) == '-') return true;
			s = s.substring(1);
		}
	}

	public static String place(char c){
		
		contains(c);
		char[] resultArray = result.toCharArray();
		
		int b = indexes.size();
		for(int i = 0; i < b; i++){
			//i in result should be swapped to = c
			int a = indexes.get(i);
			resultArray[a] = c;
		}
		result = String.valueOf(resultArray);
		indexes.clear();
	//	LastResult = result;
		return result;
	} 

	public static String dashes(String s){
		int dash = s.length();
		String wordSoFar ="";
		for(int i = 0; i < dash; i++){
			wordSoFar = wordSoFar+='-';
		}
		return wordSoFar;
	}

}