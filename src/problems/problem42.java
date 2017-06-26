import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

//nth lexicographic prime 987654321
class problem42 {
	public static void main(String... ignored) {
		long startTime = System.nanoTime();
		
		List<String> words = new ArrayList<String>();
		List<Integer> triangles = new ArrayList<Integer>();
		
		for (int i = 1; i <= 10000; i++) triangles.add((i*(i+1))/2);
		
		try (Stream<String> stream = Files.lines(Paths.get("C:\\Users\\Craig\\OneDrive - University Of Cambridge\\Code\\Java\\ProjectEuler\\src\\problem42.txt"))) {
	        stream.forEach(line -> words.add(line));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String word;
		int value,total = 0;
		
		while (!words.isEmpty()) {
			word = words.get(0);
			value = 0;
			for (int i = 0; i < word.length(); i++) {
				value += (int)(word.charAt(i))-64; //Convert char to int
			}
			if (triangles.contains(value)) total++;
			words.remove(0);
		}
		
		System.out.println(total);
		System.out.println("Process completed in "+(System.nanoTime()-startTime)/1000/1000.00+"ms.");
	}


}