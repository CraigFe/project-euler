package solutions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

//https://projecteuler.net/problem=22
class problem22 {
	public static void main(String... ignored) {
		long startTime = System.nanoTime();
		
		String inputFile = "problem22a.txt";
		List<String> lineList = new ArrayList<String>();
		
		//Read lines from file into the list
		try (Stream<String> stream = Files.lines(Paths.get("problem22a.txt"))) {
	        stream.forEach(line -> lineList.add(line));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Sort list into alphabetical order
		Collections.sort(lineList);
		
		long sum = 0;
		int lineNumber = 1;
		
		for (String line : lineList) {
			System.out.println(line);
			sum+= lineNumber*score(line);
			lineNumber++;
		}
		
		System.out.println("Score: "+sum);
		System.out.println("Process completed in "+(System.nanoTime()-startTime)/1000/1000.00+"ms.");
	}
	
	public static int score(String name) {
		int score = 0;
		for (int i=0; i<name.length();i++) { 
			score += (int)(name.charAt(i))-64;
		}
		return score;
	}

}