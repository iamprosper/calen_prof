/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author delaCruz
 */
public class MainController implements Initializable {

    @FXML
    private BorderPane content;
    @FXML
    private JFXButton profbtn;
    @FXML
    private VBox centerBox;
    @FXML
    private HBox top;
    @FXML
    private HBox week;
    @FXML
    private VBox day;
    @FXML
    private Label dayTitle;
    @FXML
    private VBox coursesList;
    @FXML
    private VBox course;
    @FXML
    private Label time;
    @FXML
    private Label courseTitle;
    @FXML
    private HBox bottom;
    @FXML
    private HBox profPicker;
    @FXML
    private ImageView addProf;
    @FXML
    private Label c_profName;
    @FXML
    private Label d_profName;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void manageProfs(MouseEvent event) throws IOException {
        Parent profUi = null;
        profUi = FXMLLoader.load(getClass().getResource("profs.fxml"));
    }
    
    @FXML
    private void addProf(MouseEvent event) throws IOException {
        
    }
    
    public Parent loadDay() throws IOException{
        return FXMLLoader.load(getClass().getResource("day.fxml"));
    }
    
    public Parent loadCourse() throws IOException{
        return FXMLLoader.load(getClass().getResource("course.fxml"));
    }

    @FXML
    private void program(MouseEvent event) throws IOException {
    }


    @FXML
    private void handleProfDragDetected(MouseEvent event) {
        Dragboard db = addProf.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cb = new ClipboardContent();
        String target = event.getTarget().toString();
//        String id = source.getChildren().get(0).toString();
//        String target  = event.getTarget().toString();
//        System.out.println(id + "\n" + target);
//        ObservableList<Node> childrens = source.getChildren();
//        for(Node child : childrens){
//            String desc = child.toString();
//            System.out.println(desc);
//            if (target.equals(desc)){
//                imageView = (ImageView) child;
//                break ;
//            }
//        }
        
        cb.putString(d_profName.getText());
//        imageView.setOnDragDone(end ->{
//            
//        });
        db.setContent(cb);
        event.consume();
    }

    @FXML
    private void handleProfDragOver(DragEvent event) {
        if(event.getDragboard().hasString()){
            event.acceptTransferModes(TransferMode.MOVE);
        }
    }

    @FXML
    private void handleProfDragDropped(DragEvent event) throws IOException {
        Parent parent = loadCourse();
        coursesList.getChildren().add(parent);
        String profName = event.getDragboard().getString();
        System.out.println(parent.getChildrenUnmodifiable());
    }
    
    
    
}
