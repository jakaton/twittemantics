import java.util.*;
import java.io.*;

public class Clusters{
/*	
	recibe una lista de textos
	for each texto
		para cada otro texto saca DISTANCE, y hace cluster con indices de textos

	regresa lista de clusters (lista de listas de índices)
*/
	public static ArrayList<ArrayList<Integer>> getClusters(ArrayList<String> textList){
		ArrayList<ArrayList<Integer>> clusters = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> clusterList = new ArrayList<Integer>();
		int n = textList.size();
		for(int i = 0; i < n; i++){
			if(textList.get(i).equals("010")){
				continue;
			}
			clusterList.add(i);
			for(int j = 0; j < i; j++){
				if(textList.get(j).equals("010")){
					continue;
				} else if(Distance.distance(textList.get(i), textList.get(j)) < 0.61){
					clusterList.add(j);
					textList.set(j, "010");
				}
			}
			for(int j = (i + 1); j < n; j++){
				if(textList.get(j).equals("010")){
					continue;
				} else if(Distance.distance(textList.get(i), textList.get(j)) < 0.61){
					clusterList.add(j);
					textList.set(j, "010");
				}
			}
			clusters.add(clusterList);
			clusterList = new ArrayList<Integer>();
			textList.set(i, "010");
		}
		return clusters;
	}
}
	
	
