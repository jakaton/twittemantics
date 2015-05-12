import java.util.*;
import java.io.*;
import java.lang.*;

public class InferenceRule{
/*
	recibe dos textos y saca sus distancias
*/
	public static double distance(String s111, String s222){
		
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
