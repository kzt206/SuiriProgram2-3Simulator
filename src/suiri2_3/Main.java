package suiri2_3;

import java.util.ArrayList;

public class Main {
	public static void main(String... args) {
		FileRead fr = new FileRead();
		
		ArrayList<ArrayList<FloodCell>> arrayFC = new ArrayList<ArrayList<FloodCell>>();
		
		arrayFC = fr.getData();
		
//		System.out.println(arrayFC);
		System.out.println(arrayFC.get(12).get(17)); //get(j or y).get(i or x)
	}
}
