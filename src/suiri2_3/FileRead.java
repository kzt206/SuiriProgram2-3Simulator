package suiri2_3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileRead {

	public int getData() {
		int IMAX = 0;
		int JMAX = 0;
		double DX, DY;

		try {
			File file = new File("GEO2D.DAT");
			BufferedReader br = new BufferedReader(new FileReader(file));
			if (file.exists()) {

				// Read file.
				String dataString[];
//			while((dataString = br.readLine()) != null) {
//				System.out.println(dataString);
//			}
				// line 1.
				dataString = br.readLine().split("\\s+");
				IMAX = Integer.parseInt(dataString[1]);
				JMAX = Integer.parseInt(dataString[2]);
				DX = Double.parseDouble(dataString[3]);
				DY = Double.parseDouble(dataString[4]);

				System.out.printf("IMAX:%d, JMAX:%d, DX:%f, DY:%f\n", IMAX, JMAX, DX, DY);
//			
				// line 2. Dummy
				br.readLine();

				// line 3-50 (JMAX 48 lines) IP information
				for (int i = 0; i < JMAX; i++) {
					System.out.println(br.readLine());
				}

				// line 51. Dummy
				br.readLine();

				// line 52-291 (JMAX 48 * 5 lines) ZB information
				for (int i = 0; i < JMAX; i++) {
					for (int j = 0; j < 5; j++) {
						System.out.println(br.readLine());
					}
				}

				// line 292. Dummy
				br.readLine();

				// line 293-532 (JMAX 48 * 5 lines) RN information
				for (int i = 0; i < JMAX; i++) {
					for (int j = 0; j < 5; j++) {
						System.out.println(br.readLine());
					}
				}

				// Close file.
				br.close();
			} else {
				System.out.println("File does not exist.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return IMAX;
	}
}
