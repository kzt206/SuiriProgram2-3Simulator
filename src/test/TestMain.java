package test;

public class TestMain {
	
	static int a = 0;
	static int b[][];
	
	public static void main(String... args) {
		
		System.out.println(a);
		
		b = new int[2][2];
		
		for(int i = 0;i<2;i++) {
			for(int j=0;j<2;j++) {
				b[i][j] = i*j;
				System.out.println("i:" + i + " j:" +j + " b: " + b[i][j]);
			}
		}
		
		testMethod();
		
		System.out.println(a);
		
		for(int i = 0;i<2;i++) {
			for(int j=0;j<2;j++) {
				System.out.println("i:" + i + " j:" +j + " b: " + b[i][j]);
			}
		}
	}

	static void testMethod() {
		a += 1;
		
		for(int i = 0;i<2;i++) {
			for(int j=0;j<2;j++) {
				b[i][j] += 1;
			}
		}
	}
}
