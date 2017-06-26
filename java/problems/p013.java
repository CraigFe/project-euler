import static java.lang.System.out;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

//https://projecteuler.net/problem=13
class problem13 {
	public static BigInteger sum = BigInteger.ZERO;
	
	public static void main(String[] args) {
		try (Stream<String> stream = Files.lines(Paths.get("C:\\Users\\Craig\\OneDrive - University Of Cambridge\\Code\\Java\\ProjectEuler\\src\\problem13.txt"))) {
	        stream.forEach(line -> process(line));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void process(String n) {
		sum = sum.add(new BigInteger(n));
		out.println(sum.toString());
	}
}