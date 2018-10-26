public class test{
	
	public static void main(String[] args){
		
		System.out.println(dreierReihe(30));
		
	}
	
	public static String dreierReihe(int limit){
		String result = "";
		for(int counter = 3; counter <= limit; counter += 3){
			result = result + counter + " ";
		}
		return result;
	}
		
}
