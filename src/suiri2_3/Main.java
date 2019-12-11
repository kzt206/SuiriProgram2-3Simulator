package suiri2_3;

import java.util.ArrayList;

public class Main {
	public static void main(String... args) {
		FileRead fr = new FileRead();
		FileGeo2dRead fGeo2dRead = new FileGeo2dRead();
		fGeo2dRead.getData();
		
		ArrayList<ArrayList<FloodCell>> arrayFC = new ArrayList<ArrayList<FloodCell>>();
		int IMAX,JMAX;
		
		
		arrayFC = fr.getData();
		IMAX = fr.getIMAX();
		JMAX = fr.getJMAX();
		
		System.out.println("Test via hp");
		
//		System.out.println(arrayFC);
		System.out.println("Main.java :"+arrayFC.get(10).get(18)); //get(j or y).get(i or x)
//		IMAX = arrayFC.get(0).size();
//		JMAX = arrayFC.size();
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
		
		FileFloodRead ffRead = new FileFloodRead();
		ffRead.readData();
		int NHT = ffRead.getNHT();
		double TRLX = ffRead.getTRLX();
		double[] QHYD = ffRead.getFloodQ();
		
		//Initialization of Variavles
		double[][] SMO = new double[IMAX][JMAX];
		double[][] SNO = new double[IMAX][JMAX];
		double[][] HO = new double[IMAX][JMAX];
		double[][] ZS = new double[IMAX][JMAX];
		double[][] SMN = new double[IMAX][JMAX];
		double[][] SNN = new double[IMAX][JMAX];
		double[][] HN = new double[IMAX][JMAX];
		double[][] SMXCV = new double[IMAX][JMAX];
		double[][] SNYCV = new double[IMAX][JMAX];
		double[][] HCV = new double[IMAX][JMAX];
		double[][] CUM = new double[IMAX][JMAX];
		double[][] CVM = new double[IMAX][JMAX];
		double[][] CUN = new double[IMAX][JMAX];
		double[][] CVN = new double[IMAX][JMAX];
		char[][] IFROF = new char[IMAX][JMAX];
		char[][] JFROF = new char[IMAX][JMAX];
		double[][] RNGX = new double[IMAX][JMAX];
		
	}
}
