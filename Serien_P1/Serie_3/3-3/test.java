public class test{
	
	public static void main(String[] args){
		
		System.out.println(dreierReihe(3));
		
	}
	
	public static String dreierReihe(int limit){
		String result = "";
		int counter = 3; 
		for(counter != limit ){
			result = result + counter + " ";
			counter += 3;
		}
		return result;
	}
		
}
