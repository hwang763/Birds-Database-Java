/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package birds;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Abdelkader
 */
public class BirdsController implements Initializable {

    @FXML
    private MenuBar mainMenu;
    
    @FXML 
    private Button delete;
    @FXML
    private Button first;
    @FXML
    private Button next;
    @FXML
    private Button previous;
    @FXML
    private Button last;
    @FXML
    private Button play;
    @FXML
    private Button exit;
    @FXML
    private Button stop;
    @FXML
    private Button find;
    @FXML
    private TextField birdName;
    @FXML
    private TextArea descrip;
    @FXML
    private ImageView pic;
    @FXML
    private TextField findName;
    @FXML
    private ComboBox birdSize;
    @FXML 
    private AnchorPane display;
    @FXML 
    private MenuItem fillDictionary;
    
    OrderedDictionary Birds=new OrderedDictionary();
    DataKey currentB;
    
    @FXML
    public void exit() {
        Stage stage = (Stage) mainMenu.getScene().getWindow();
        stage.close();
    }

   @FXML
   public void showBirds() throws IOException, DictionaryException {
      display.setOpacity(1);
      loadDictionary();
      System.out.println(Birds.smallest().getDataKey().getbirdName());
      showItems();
   }
   
   
   private void showItems() throws DictionaryException
   {
   currentB=Birds.smallest().getDataKey();
   birdName.setText(Birds.smallest().getDataKey().getbirdName());
   descrip.setText(Birds.smallest().getAbout());
   Image picture=new Image(Birds.smallest().getImage());
   pic.setImage(picture);
   }
   
   
   
   @FXML
   public void nextBird() throws DictionaryException
   {
   BirdRecord temp=Birds.successor(currentB);
   birdName.setText(temp.getDataKey().getbirdName());
   descrip.setText(temp.getAbout());
   Image picture=new Image(temp.getImage());
   pic.setImage(picture);
   currentB=temp.getDataKey();
   }
   
   @FXML
    public void prevBird() throws DictionaryException
   {
   BirdRecord temp=Birds.predecessor(currentB);
   birdName.setText(temp.getDataKey().getbirdName());
   descrip.setText(temp.getAbout());
   Image picture=new Image(temp.getImage());
   pic.setImage(picture);
   currentB=temp.getDataKey();
   }
   
   @FXML
   public void firstBird() throws DictionaryException
   {
   BirdRecord temp=Birds.smallest();
   birdName.setText(temp.getDataKey().getbirdName());
   descrip.setText(temp.getAbout());
   Image picture=new Image(temp.getImage());
   pic.setImage(picture);
   currentB=temp.getDataKey();
   }
   
   @FXML
   public void delete() throws DictionaryException
   {
   DataKey temp=currentB;
   Birds.remove(currentB);
   showBird(temp);
   
   
   }
   
   private void showBird(BirdRecord b)
   {
       birdName.setText(b.getDataKey().getbirdName());
   descrip.setText(b.getAbout());
   Image picture=new Image(b.getImage());
   pic.setImage(picture);
   currentB=b.getDataKey();
   
   }
   
   @FXML
   public void showFirst(){
   
   }
   
   private void loadDictionary() throws FileNotFoundException, IOException, DictionaryException{
  
   DataKey key[]=new DataKey [20];
           
   BirdRecord bird[]=new BirdRecord[20];
   BufferedReader in= new BufferedReader(new FileReader("BirdsDatabase.txt"));
   
   for(int i=0;i<20;i++)
   {
        
        int birdSize= Integer.parseInt(in.readLine());
        String tempName=in.readLine();
        String tempAbout=in.readLine();
        String images="file:src/images/"+tempName+".jpg";
        String sound= "file:src/sounds/"+tempName+".png";
        DataKey temp = new DataKey (tempName,birdSize);
        key[i]=temp;
        BirdRecord tempRecord= new BirdRecord (temp, tempAbout, sound, images);//key about sound image
        bird[i]=tempRecord;
        Birds.insert(tempRecord);
        //System.out.println(tempName);
   }
   }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

}
