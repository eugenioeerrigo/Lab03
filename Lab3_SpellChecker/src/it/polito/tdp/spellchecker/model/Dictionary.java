package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.*;

public class Dictionary {

	List<String> loadDictionary = new LinkedList<String>();
	
	
	public void loadDictionary(String language){
		try{
			FileReader fr = new FileReader("rsc/"+language+".txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			while((word = br.readLine())!=null){
				loadDictionary.add(word);
			}
			br.close();
		} catch(IOException e){
			System.out.println("Errore nella lettura del file!");
		}
	}
	
	public List<RichWord> spellCheckTest(List<String> inputTextList){
		List<RichWord> wrong = new LinkedList<RichWord>();
		for(String s : inputTextList)
			if(!loadDictionary.contains(s))
				wrong.add(new RichWord(s, false));
		return wrong;
	}
	
	
}
