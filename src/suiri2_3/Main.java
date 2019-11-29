package suiri2_3;

import java.util.ArrayList;

public class Main {
	public static void main(String... args) {
		FileRead fr = new FileRead();
		
		ArrayList<ArrayList<FloodCell>> arrayFC = new ArrayList<ArrayList<FloodCell>>();
		int IMAX,JMAX;
		
		
		arrayFC = fr.getData();
		
//		System.out.println(arrayFC);
		System.out.println("Main.java :"+arrayFC.get(10).get(18)); //get(j or y).get(i or x)
		IMAX = arrayFC.get(0).size();
		JMAX = arrayFC.size();
		System.out.printf("Main.java :IMAX:%d, JMAX:%d\n", IMAX, JMAX);
		
		//Data block
		double DX = 285.44;
		double DY = 231.0;
		double G = 9.8;
		double EPS = 0.001;
		double DT = 2.5;
		int IBR = 29-1;
		int JBR = 42-1;
		int IBRD = -1;
		int JBRD = 0;
		
		//Set Break Point
		//Chage of IP for LEVEE-Break Point
		arrayFC.get(JBR).get(IBR).setIp("B");
		
		
	}
}
