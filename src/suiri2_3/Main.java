package suiri2_3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void main(String... args) {
		int IMAX,JMAX;
		double DX,DY;
		
		try {
			File file = new File("GEO2D.DAT");
			BufferedReader br = new BufferedReader(new FileReader(file));
			if(file.exists()) {
				
				// Read file.
				String dataString[];
//				while((dataString = br.readLine()) != null) {
//					System.out.println(dataString);
//				}
				// line 1.
				dataString = br.readLine().split("\\s+");
				IMAX = Integer.parseInt(dataString[1]);
				JMAX = Integer.parseInt(dataString[2]);
				DX = Double.parseDouble(dataString[3]);
				DY = Double.parseDouble(dataString[4]);
				
				System.out.printf("%d,%d,%f,%f\n",IMAX,JMAX,DX,DY);
//				
				
				
				// Close file.
				br.close();
			}else {
				System.out.println("File does not exist.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
