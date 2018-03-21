package it.polito.tdp.spellchecker.model;

public class RichWord {

	private String word;
	private boolean isCorrect;
	
	public RichWord(String word, boolean isCorrect) {
		this.word = word;
		this.isCorrect = isCorrect;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	
	
	
}
