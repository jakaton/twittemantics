import java.util.*;
import java.io.*;
import java.lang.*;

public class Distance{
/*
	recibe dos textos y saca sus distancias
*/
	public static double distance(String s111, String s222){
		String[] s11 = s111.split(" ");
		ArrayList<String> s1 = new ArrayList<String>();
		for(String word : s11){
			s1.add(word);
		}
		String[] s22 = s222.split(" ");
		ArrayList<String> s2 = new ArrayList<String>();
		for(String word : s22){
			s2.add(word);
		}
		//
		ArrayList<Integer> vectorS1 = new ArrayList<Integer>();
		for (String word : s1) {
			Integer num = countWords(word, s1);
			vectorS1.add(num);
		}
		ArrayList<Integer> vectorS2 = new ArrayList<Integer>();
		for (String word : s2) {
			Integer num = countWords(word, s1);
			vectorS2.add(num);
		}
		//
		ArrayList<String> wordsInCommon = new ArrayList<String>();
		for(String word1 : s1){
			for(String word2 : s2){
				if (word1.equals(word2)) {
					if (!(wordsInCommon.contains(word1))){
						wordsInCommon.add(word1);
					}
				}
			}
		}			
		double distance = (1 - ((20*(wordsInCommon.size()))/((vectorS1.size()) + (vectorS2.size()))));

//System.out.println(distance);
//System.out.println((1 - ((2*(wordsInCommon.size()))/((vectorS1.size()) + (vectorS2.size())))));

		return distance;
	}
/*
	cuenta la incidencia de la palabra "word" en el string s
*/
	public static int countWords(String word, ArrayList<String> s){
		int n = 0;
		for(String w : s){
			if(w.equals(word)){
				n++;
			}
		}
		return n;
	}
}
