import java.util.*;
import java.io.*;

public class StopWords{
/*
	recibe un texto y regresa la oración sin los stopwords
*/
	public static String removeStopWords(String s2){
		String stopwords2 = "﻿\u00e9l \u00e9sta \u00e9stas \u00e9ste \u00e9stos \u00faltima\u00faltimas \u00faltimo \u00faltimos a añadi\u00f3 a\u00fan actualmente adelante adem\u00e1s afirm\u00f3 agreg\u00f3 ah\u00ed ahora al alg\u00fan algo alguna algunas alguno algunos alrededor ambos ante anterior antes apenas aproximadamente aqu\u00ed as\u00ed asegur\u00f3 aunque ayer bajo bien buen buena buenas bueno buenos c\u00f3mo cada casi cerca cierto cinco coment\u00f3 como con conocer consider\u00f3 considera contra eres tambien te cosas creo cual cuales cualquier cuando cuanto cuatro cuenta da dado dan dar de debe deben debido decir dej\u00f3 del dem\u00e1s dentro desde despu\u00e9s dice dicen dicho dieron diferente diferentes dijeron dijo dio donde dos durante e ejemplo el ella ellas ello ellos embargo en entonces entre era eran es esa esas ese eso esos est\u00e1 est\u00e1n esta estaba estaban estamos estar estar\u00e1 estas este esto estos estoy estuvo ex existe existen explic\u00f3 expres\u00f3 fin fue fuera fueron gran grandes ha hab\u00eda hab\u00edan haber habr\u00e1 hace hacen hacer hacerlo hacia haciendo han hasta hay haya he hecho hemos hicieron hizo hoy hubo igual incluso indic\u00f3 inform\u00f3 junto la lado las le les lleg\u00f3 lleva llevar lo los luego lugar m\u00e1s manera manifest\u00f3 mayor me mediante mejor mencion\u00f3 menos mi mientras misma mismas mismo mismos momento mucha muchas mucho muchos muy nada nadie ni ning\u00fan ninguna ningunas ninguno ningunos no nos nosotras nosotros nuestra nuestras nuestro nuestros nueva nuevas nuevo nuevos nunca o ocho otra otras otro otros para parece parte partir pasada pasado pero pesar poca pocas poco pocos podemos podr\u00e1 podr\u00e1n podr\u00eda podr\u00edan poner por porque posible pr\u00f3ximo pr\u00f3ximos primer primera primero primeros principalmente propia propias propio propios pudo pueda puede pueden pues qu\u00e9 que qued\u00f3 queremos qui\u00e9n quien quienes quiere realiz\u00f3 realizado realizar respecto s\u00ed s\u00f3lo se señal\u00f3 sea sean seg\u00fan segunda segundo seis ser ser\u00e1 ser\u00e1n ser\u00eda si sido siempre siendo siete sigue siguiente sin sino sobre sola solamente solas solo solos son su sus tal tambi\u00e9n tampoco tan tanto ten\u00eda tendr\u00e1 tendr\u00e1n tenemos tener tenga tengo tenido tercera tiene tienen toda todas todav\u00eda todo todos total tras trata trav\u00e9s tres tuvo un una unas uno unos usted va vamos van varias varios veces ver vez y ya q w e r t y u i o p a s d f g h j k l z x c v b n m";
		String[] stopwords1 = stopwords2.split(" ");
		List<String> stopwords = new ArrayList<String>();
		for(String word : stopwords1){
			stopwords.add(word);
		}
		String[] s1 = s2.split(" ");
		List<String> s = new ArrayList<String>();
		for(String word : s1){
			s.add(word);
		}

		List<String> sentence = new ArrayList<String>();		
		for(String word : s){
			if(!(stopwords.contains(word))){
				sentence.add(word);
			}
		}

		String sentenceString = "";
		for(String word : sentence){
			sentenceString = sentenceString + " " + word;
		}
		sentenceString = sentenceString.trim();
		return sentenceString;
	}
}
