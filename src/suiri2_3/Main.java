package suiri2_3;

import java.util.concurrent.Callable;

import javax.xml.parsers.DocumentBuilder;

public class Main {

	// Global variables for qbreak()
	static int NHT;
	static double TRLX;
	static double[] QHYD;

	// Global variables for indflw()
	static int IMAX, JMAX;
	static double DT, DX, DY, G, EPS, DT2DX, DT2DY, DTGDX, DTGDY, DT2, DXDY;
	static int IBR, JBR, IBRD, JBRD;
	static double QBR;

	static char[][] IP;
	static double[][] ZB;
	static double[][] RN;
	
	static double[][] SMO;
	static double[][] SNO;
	static double[][] HO;
	static double[][] ZS;
	static double[][] SMN;
	static double[][] SNN;
	static double[][] HN;
	static double[][] SMXCV;
	static double[][] SNYCV;
	static double[][] HCV;
	static double[][] CUM;
	static double[][] CVM;
	static double[][] CUN;
	static double[][] CVN;
	static char[][] IFROF;
	static char[][] JFROF;
	static double[][] RNGX;
	static double[][] RNGY;

	
	public static void main(String... args) {

		// NPRINT : INTERVAL for PRINT OUTPUT
		// NFILE : INTERVAL for FILE OUTPUT
		// NFILE must be integer times of NPRINT
		int NPRINT = 180;
		int NFILE = 360;

		// BEGIN of Subroutine START
		// Read GEO2D.DAT
		FileGeo2dRead fGeo2dRead = new FileGeo2dRead();
		IMAX = fGeo2dRead.getIMAX();
		JMAX = fGeo2dRead.getJMAX();

		char[][] IP = fGeo2dRead.getIP();
		double[][] ZB = fGeo2dRead.getZB();
		double[][] RN = fGeo2dRead.getRN();

		// System.out.println("Main java2:"+IP[18][10]+" "+ZB[18][10]+" "+RN[18][10]);
		// System.out.printf("Main.java :IMAX:%d, JMAX:%d\n", IMAX, JMAX);

		// Data block
		DX = 285.44;
		DY = 231.0;
		G = 9.8;
		EPS = 0.001;
		DT = 2.5;
		IBR = 29 - 1;
		JBR = 42 - 1;
		IBRD = -1;
		JBRD = 0;
		QBR = 0.0;

		// Set Break Point
		// Change of IP for LEVEE-Break Point
		IP[IBR][JBR] = 'B';

		// Read FLOOD.DAT
		FileFloodRead ffRead = new FileFloodRead();
		NHT = ffRead.getNHT();
		// System.out.println("NHT: " + NHT);
		TRLX = ffRead.getTRLX();
		QHYD = ffRead.getFloodQ();

		// Initialization of Variables
		SMO = new double[IMAX][JMAX];
		SNO = new double[IMAX][JMAX];
		HO = new double[IMAX][JMAX];
		ZS = new double[IMAX][JMAX];
		SMN = new double[IMAX][JMAX];
		SNN = new double[IMAX][JMAX];
		HN = new double[IMAX][JMAX];
		SMXCV = new double[IMAX][JMAX];
		SNYCV = new double[IMAX][JMAX];
		HCV = new double[IMAX][JMAX];
		CUM = new double[IMAX][JMAX];
		CVM = new double[IMAX][JMAX];
		CUN = new double[IMAX][JMAX];
		CVN = new double[IMAX][JMAX];
		IFROF = new char[IMAX][JMAX];
		JFROF = new char[IMAX][JMAX];
		RNGX = new double[IMAX][JMAX];
		RNGY = new double[IMAX][JMAX];
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
		// Constants
		DT2 = DT * 2.0;
		DT2DX = DT * 2.0 / DX;
		DT2DY = DT * 2.0 / DY;
		DTGDX = DT * G / DX * 2.0;
		DTGDY = DT * G / DY * 2.0;
		DXDY = DX * DY;
		// END of Subroutine START

		double NFINAL = (NHT - 1) * 3600. / DT2; // original
		// double NFINAL = (NHT)*3600./DT2;

		// int NSTEP = 0;
		// double TIME = NSTEP*DT2;

		// OUTPUTFILE
		//
		// coding later

		// Check of water volume
		double VIN = 0.0;
		double S0 = 0.0;
		// GOTO 400
		// int N1 = NSTEP/NPRINT;
		for (int NSTEP = 0; NSTEP < NFINAL; NSTEP++) {
			double TIME = NSTEP * DT2;
			QBR = qbreak(TIME, QBR);

		}
		// if(NSTEP != N1*NPRINT) {
		// //GOTO 450
		// if(NSTEP < NFINAL) {
		// // GOTO 300
		// NSTEP += 1;
		// TIME = NSTEP * DT2;
		// qbreak(TIME,QBR);
		// indflw(NSTEP,TIME);
		// VIN += QBR*DT2;
		//
		// }else {
		// System.out.println("Successfully ended.");
		// }
		// }else {
		// //Check of water volume
		// double SN = 0.0;
		// for(int i = 0;i<IMAX;i++) {
		// for(int j = 0;j<JMAX;j++) {
		// if(IP[i][j]=='M' || IP[i][j]=='B') {
		// //GOTO 10
		// continue;
		// }else {
		// SN = SN + HO[i][j];
		// }
		// }
		// }
		// SN = SN*DXDY;
		// double SOVIN = S0 + VIN;
		//
		// }

	}

	static double qbreak(double TIME, double QBR) {
		// System.out.println("Start qbreak().");
		// for(double d : QHYD) {
		// System.out.println(d);
		// }
		// System.out.println("End qbreak()");
		if (TIME < TRLX) {
			QBR = QHYD[0] / TRLX * TIME;
		} else {
			double THR = TIME / 3600.;
			double IT = THR + 1.0;
			if (IT >= NHT) {
				IT = NHT - 1.;
			}
			double THR0 = IT - 1.;
			int it = (int) IT;
			QBR = (QHYD[it] - QHYD[it - 1]) * (THR - THR0) + QHYD[it - 1];
		}
		// System.out.println("TIME: " + TIME + " QBR: "+ QBR);
		// if(TIME<4000) System.out.println("TIME: " + TIME + " QBR: "+ QBR);
		return QBR;
	}

	static void indflw(int NSTEP, double TIME) {
		frovf();
		convx();
		convy();
	}
	
	//’i—Ž‚¿•”•ª‚Ì—¬—ÊŒvŽZ
	static void frovf() {
		for(int i=0;i<IMAX;i++) {
			for(int j=0;j<JMAX;j++) {
				if(i==1 || j==1) continue;
				if(IP[i][j]=='M' || IP[i][j]=='B') continue;
			}
		}
		
	}
	
	static void convx() {
		
	}
	
	static void convy() {
		
	}
	
}
