package suiri2_3;

public class Main {
	public static void main(String... args) {
		
		//Read GEO2D.DAT
		FileRead fr = new FileRead();
		FileGeo2dRead fGeo2dRead = new FileGeo2dRead();
		int IMAX = fGeo2dRead.getIMAX();
		int JMAX = fGeo2dRead.getJMAX();
		
		char[][] IP = fGeo2dRead.getIP();
		double[][] ZB = fGeo2dRead.getZB();
		double[][] RN = fGeo2dRead.getRN();
		
//		System.out.println("Main java2:"+IP[18][10]+" "+ZB[18][10]+" "+RN[18][10]);
//		System.out.printf("Main.java :IMAX:%d, JMAX:%d\n", IMAX, JMAX);
		
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
		IP[IBR][JBR]= 'B';
		
		
		//Read FLOOD.DAT
		FileFloodRead ffRead = new FileFloodRead();
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
