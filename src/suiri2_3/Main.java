package suiri2_3;

public class Main {
	public static void main(String... args) {

		//NPRINT : INTERVAL for PRINT OUTPUT
		//NFILE  : INTERVAL for FILE OUTPUT
		//NFILE must be interger times of NPRINT
		int NPRINT = 180;
		int NFILE = 360;
		
		//BEGIN of Subroutine START
		// Read GEO2D.DAT
		FileGeo2dRead fGeo2dRead = new FileGeo2dRead();
		int IMAX = fGeo2dRead.getIMAX();
		int JMAX = fGeo2dRead.getJMAX();

		char[][] IP = fGeo2dRead.getIP();
		double[][] ZB = fGeo2dRead.getZB();
		double[][] RN = fGeo2dRead.getRN();

//		System.out.println("Main java2:"+IP[18][10]+" "+ZB[18][10]+" "+RN[18][10]);
//		System.out.printf("Main.java :IMAX:%d, JMAX:%d\n", IMAX, JMAX);

		// Data block
		double DX = 285.44;
		double DY = 231.0;
		double G = 9.8;
		double EPS = 0.001;
		double DT = 2.5;
		int IBR = 29 - 1;
		int JBR = 42 - 1;
		int IBRD = -1;
		int JBRD = 0;

		// Set Break Point
		// Change of IP for LEVEE-Break Point
		IP[IBR][JBR] = 'B';

		// Read FLOOD.DAT
		FileFloodRead ffRead = new FileFloodRead();
		int NHT = ffRead.getNHT();
		double TRLX = ffRead.getTRLX();
		double[] QHYD = ffRead.getFloodQ();

		// Initialization of Variavles
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
		double[][] RNGY = new double[IMAX][JMAX];
		for (int i = 0; i < IMAX; i++) {
			for (int j = 0; j < JMAX; j++) {
				SMO[i][j] = 0.0;
				SNO[i][j] = 0.0;
				HO[i][j] = 0.0;
				ZS[i][j] = 0.0;
				SMN[i][j] = 0.0;
				SNN[i][j] = 0.0;
				HN[i][j] = 0.0;
				SMXCV[i][j] = 0.0;
				SNYCV[i][j] = 0.0;
				HCV[i][j] = 0.0;
				CUM[i][j] = 0.0;
				CVM[i][j] = 0.0;
				CUN[i][j] = 0.0;
				CVN[i][j] = 0.0;
				IFROF[i][j] = 'N';
				JFROF[i][j] = 'N';
				if (i != 0) {
					if (IP[i - 1][j] == 'I') {
						RNGX[i][j] = Math.pow(((RN[i][j] + RN[i - 1][j]) / 2.0), 2.) * G * DT;
					} else {
						RNGX[i][j] = Math.pow((RN[i][j]), 2.) * G * DT;
					}
				} else {
					RNGX[i][j] = Math.pow((RN[i][j]), 2.) * G * DT;
				}
				if (j != 0) {
					if (IP[i][j - 1] == 'I') {
						RNGY[i][j] = Math.pow((RN[i][j] + RN[i][j - 1] / 2.0), 2.) * G * DT;
					} else {
						RNGY[i][j] = Math.pow(RN[i][j], 2.) * G * DT;
					}
				} else {
					RNGY[i][j] = Math.pow(RN[i][j], 2.) * G * DT;
				}
			}
		}
		//Constants
		double DT2 = DT*2.0;
		double DT2DX = DT*2.0/DX;
		double DT2DY = DT*2.0/DY;
		double DTGDX = DT*G/DX*2.0;
		double DTGDY = DT*G/DY*2.0;
		double DXDY = DX*DY;
		// END of Subroutine START
		
		double NFINAL = (NHT-1)*3600./DT2;
		
		int NSTEP = 0;
		double TIME = NSTEP*DT2;
		
		//OUTPUTFILE
		//
		// coding later
		
		//Check of water volume
		double VIN = 0.0;
		double S0 = 0.0;
		// GOTO 400
		double N1 = NSTEP/NPRINT;
		

	}
}
