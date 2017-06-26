import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

//Extension of problem 18
class problem67 {
	
	public static int size = 100;
	public static int[][] triangle = new int[size][size];

	
	public static void main(String... ignored) {
		for (int[] row: triangle) Arrays.fill(row, -1);
		
		try (Stream<String> stream = Files.lines(Paths.get("C:\\Users\\Craig\\OneDrive - University Of Cambridge\\Code\\Java\\ProjectEuler\\src\\problem67.txt"))) {
	        stream.forEach(line -> processInput(line));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Initial array configuration:");
		printArr();
		
		for (int i=size-2;i>=0;i--) {
			System.out.println("Reducing the array:");
			reduceArr(i);
			printArr();
		}
		
	}
	
	public static void processInput(String line) {
		int row = 0;
		while (triangle[row][0]!=-1) row++;
		for (int col = 0; line.length()>=2; col++) {
			triangle[row][col] = Integer.valueOf(line.substring(0,2));
			if(line.length() > 3) line = line.substring(3);
			else line = "";
		}
	}
	
	public static void printArr() {
		for (int row=0;row<triangle.length;row++) {
			for (int col=0;col < triangle[0].length && triangle[row][col] != -1; col++) {
				String n = "";
				if      (triangle[row][col]/10   == 0) n="000";
				else if (triangle[row][col]/100  == 0) n="00";
				else if (triangle[row][col]/1000 == 0) n="0";
				System.out.print(n + triangle[row][col] + " ");
			}
			System.out.println();
		}
	}
	
	public static void reduceArr(int row) {
		for (int col=0;col < triangle[row].length && triangle[row][col] != -1; col++) {
			int a = triangle[row+1][col];
			int b = triangle[row+1][col+1];
			
			triangle[row][col] += (a>b) ? a:b;
		}
		Arrays.fill(triangle[row+1], -1);
	}
}