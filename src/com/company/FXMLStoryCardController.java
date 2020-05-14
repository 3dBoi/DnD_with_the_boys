/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author Janis
 */
public class FXMLStoryCardController implements Initializable {
    
   
    // Die labels, die im Menü benutzt wurden
    @FXML private Label labelStoryCardSub;
    @FXML private Label labelStoryCardMain;
    @FXML private Label labelSubline;
    @FXML private Label labelStoryCardID;
    
    //Die Buttons, die im Menü benutzt werden
    @FXML private Button buttonStoryCardOptA;
    @FXML private Button buttonStoryCardOptB;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
