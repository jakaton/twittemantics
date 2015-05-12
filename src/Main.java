import java.io.*;
import java.util.*;
import java.lang.*;		

public class Main{
/*
	lee y mete lista sinonimos
	lee y mete lista tweets *

	stemiza sinonimos -StemmerEs.stemm(word)-
	pasa a minusculas todos los tweets
	quita stopwords de tweets -stopwords-
	stemiza tweets -StemmerEs.stemm(word)-
	sustituye sinonimos

	hace clusters
	hace un txt para cada cluster, agregando al txt el tweet con el índice en dicha lista. *
*/
	public static void main(String[] args){
		try {
//todos_origenes_mexico.txt
		Scanner scanner = new Scanner(new File("final/prueba.txt"));
		ArrayList<String> listaDeTweets1 = new ArrayList<String>();
		String tweet = scanner.nextLine();
		while(tweet != null){
			listaDeTweets1.add(tweet);
			try{
				tweet = scanner.nextLine();
			} catch (NoSuchElementException e){
				break;
			}
		}
		scanner.close();
		ArrayList<String> listaDeTweets2 = new ArrayList<String>();
		for(String t : listaDeTweets1){
			t = t.replaceAll("@\\p{L}+", "");
			t = t.replaceAll("http\\p{L}+", "");
			t = t.replaceAll("RT", "");
			t = t.replaceAll("#", "");
			t = t.replaceAll("[^a-zA-Z ]", "").toLowerCase().trim();
			listaDeTweets2.add(t);
		}
		ArrayList<String> listaDeTweets3 = new ArrayList<String>();
		for(String t : listaDeTweets2){
			t = StopWords.removeStopWords(t);
			listaDeTweets3.add(t);		
		}
		ArrayList<String> listaDeTweets = new ArrayList<String>();
		for(String t : listaDeTweets3){
			String[] tarray = t.split(" ");
			for(String word : tarray){
				word = StemmerEs.stemm(word);
			}
			String sentence = "";
			for(String word : tarray){
				sentence = sentence + " " + word;
			}
			sentence = sentence.trim();
			listaDeTweets.add(sentence);
		}
//
/*		Scanner scanner1 = new Scanner(new File("sinonimos.txt"));
		ArrayList<String> sinonimos1 = new ArrayList<String>();
		String grupo = scanner1.nextLine();
		while(grupo != null){
			sinonimos1.add(grupo);
			try{
				grupo = scanner1.nextLine();
			} catch (NoSuchElementException e){
				break;
			}
		}
		scanner1.close();

		ArrayList<String> sinonimos2 = new ArrayList<String>();
		for(String t : sinonimos1){
			t = t.replaceAll(",", "");
			t = t.replaceAll(":", "");
			t = t.replaceAll("[^a-zA-Z ]", "").toLowerCase().trim();
			sinonimos2.add(t);
		}
		ArrayList<String> sinonimos = new ArrayList<String>();
		for(String t : sinonimos2){
			String[] tarray = t.split(" ");
			for(String word : tarray){
				word = StemmerEs.stemm(word);
			}
			String sentence = "";
			for(String word : tarray){
				sentence = sentence + " " + word;
			}
			sentence = sentence.trim();
			sinonimos.add(sentence);
		}

		ArrayList<String> listaDeTweetsF = new ArrayList<String>();
		for(String twit : listaDeTweets){
			String oracion = "";
			for(String word : twit.split(" ")){
				for(String synonimGroup : sinonimos){
					String[] AsynonimGroup = synonimGroup.split(" ");
					if(/*synonimGroup.contains(word + " ") ||*/
					   /*synonimGroup.contains(" " + word + " ") /*||
					   /*synonimGroup.contains(" " + word)){

						oracion = oracion + " " + AsynonimGroup[0];
						break;
					}
				}
				oracion = oracion + " " + word;
			}
			oracion = oracion.trim();
			listaDeTweetsF.add(oracion);
		}
*/		
//clusteriza
		ArrayList<ArrayList<Integer>> clusters = Clusters.getClusters(listaDeTweets);
		PrintWriter o = new PrintWriter("clusters.txt");	
		for(ArrayList<Integer> cluster : clusters){
			o.print("[ ");		
			for(Integer i : cluster){
				o.print(i + " ");
			}
			o.print("]");
			o.println();
		}
		o.close();
		} catch (FileNotFoundException e){
			System.out.println(e);
		}
	}
}

