package exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AlgorithmsUsingStreams {

	/* Count the eggs that are not cracked. */
	public static long countGoodEggs(List<String> eggs) {
		return eggs.stream()				// 1. create stream
		.filter(egg -> egg.equals("whole")) // 2. intermediate filter operation
		.count();							// 3. terminal operation: reduce to an int
	}
	
	/* Find the height of the tallest person. */
	public static Object findTallest(List<Double> peeps) {
		return peeps.stream().sorted(Comparator.reverseOrder()).findFirst().get();
	}

	/* Add all numbers in a String. */
	public static long addStringOfNumbers(String numbers) {
		return numbers
		.chars()		
		.mapToObj(c -> Character.toString(c))	
		.mapToInt(num -> Integer.parseInt(num))
		.sum();
	}

	/* Count how many oysters contain pearls. */	
	public static long countPearls(List<Boolean> oysters) {
		return oysters.stream()
		.filter(oyster -> oyster.booleanValue())
		.count();
	}

	/* Create a method that will find the longest word. */
	public static Object findLongestWord(List<String> words) {
	    return words.stream()
//		.sorted(Comparator.comparingInt(String::length).reversed())
	    .sorted((s1, s2) -> s2.length() - s1.length())
	    .findFirst()
	    .get();
	}

	/* Sort the exam results from lowest to highest. */
	public static List<Double> sortScores(List<Double> results) {
		Collections.sort(results);
		return results;
	}

	/* Sort the DNA sequences by length from shortest to longest. */
	public static Object sortDNA(List<String> unsortedSequences) {
		Collections.sort(unsortedSequences, Comparator.comparing(String::length));
		return unsortedSequences;
	}

	/* Sort the words in alphabetical order. */
	public static List<String> sortWords(List<String> words) {
	    return words.stream()
	    .sorted()
	    .collect(Collectors.toList());
	}

	/* Remove the duplicate spells from a list, and alphabetize them. */
	public static Object getDistinctSpellsInAlphabeticalOrder(List<String> spellsCastThisWeek) {
	    return spellsCastThisWeek.stream()
	    .sorted()
	    .distinct()
	    .collect(Collectors.toList());
	}

	/* Search the String array for instances of "bam" and "pow", then capitalize them. */
	public static Object getBatPhrases(String[] batmanScript) {
		return Arrays.stream(batmanScript)
		.filter (e -> (e.contains("Bam") || e.contains("Pow")))
		.map(x -> x.toUpperCase().trim())
		.collect(Collectors.toList());
	}
	
	/* Count the number of X's in a String. */
	public static long countXs(String xString) {
		return xString
		.chars()
		.filter(a -> a == 'x')
		.count();
	}

	/* Add all the even numbers. */
	public static Object addEven(String numbers) {
		return numbers			
		.chars()		
		.filter(e -> e % 2 == 0)
		.mapToObj(c -> Character.toString(c))	
		.mapToInt(num -> Integer.parseInt(num))
		.sum();
	}

	/* Get the average of an array of numbers. */
	public static Object getAverage(int[] numbers) {
		return Arrays.stream(numbers)
		.average()
		.orElse(0.0);
	}

	public static long countOccurrences(String[] strArr, String string) {
		return Arrays.stream(strArr)
			.filter(s -> s.contentEquals(string))
			.count();
	}
	
}