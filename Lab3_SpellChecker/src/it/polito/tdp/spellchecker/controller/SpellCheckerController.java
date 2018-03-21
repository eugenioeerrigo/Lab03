/**
 * Sample Skeleton for 'SpellChecker.fxml' Controller Class
 */

package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class SpellCheckerController {
	
	private Dictionary model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="chsBox"
    private ChoiceBox<String> chsBox; // Value injected by FXMLLoader

    @FXML // fx:id="txtIn"
    private TextArea txtIn; // Value injected by FXMLLoader

    @FXML // fx:id="btnCheck"
    private Button btnCheck; // Value injected by FXMLLoader

    @FXML // fx:id="txtOut"
    private TextArea txtOut; // Value injected by FXMLLoader

    @FXML // fx:id="txtErr"
    private Text txtErr; // Value injected by FXMLLoader

    @FXML // fx:id="btnClear"
    private Button btnClear; // Value injected by FXMLLoader

    @FXML // fx:id="txtTime"
    private Text txtTime; // Value injected by FXMLLoader

    @FXML
    void handleCheck(ActionEvent event) {
    	String[] arr = txtIn.getText().split(" ");
       	model.loadDictionary(chsBox.getValue());
       	List<RichWord> wrong = model.spellCheckTest(Arrays.asList(arr));
       	for(RichWord rw : wrong)
       		txtOut.appendText(rw.getWord()+"\n");
     }

    @FXML
    void handleClear(ActionEvent event) {
    	txtIn.clear();
    	txtOut.clear();
    	txtErr.setText("");
    	txtTime.setText("");
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert chsBox != null : "fx:id=\"chsBox\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtIn != null : "fx:id=\"txtIn\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnCheck != null : "fx:id=\"btnCheck\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtOut != null : "fx:id=\"txtOut\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtErr != null : "fx:id=\"txtErr\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'SpellChecker.fxml'.";

        chsBox.getItems().addAll("Italian", "English"); 
    }

	public void setModel(Dictionary model2) {
		this.model = model2;
	}
    
}
