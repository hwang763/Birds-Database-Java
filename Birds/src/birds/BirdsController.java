/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package birds;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import static java.nio.file.Files.delete;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import static javafx.scene.media.MediaPlayer.Status.READY;
import javafx.stage.Modality;
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
    ObservableList<String> data = FXCollections.observableArrayList(
            "1",
            "2",
            "3"
    );
    
    DataKey currentB;
    MediaPlayer mediaPlayer;
    
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
   public void nextBird() 
   {   
       
       
     try{
   BirdRecord temp=Birds.successor(currentB);
   birdName.setText(temp.getDataKey().getbirdName());
   descrip.setText(temp.getAbout());
   Image picture=new Image(temp.getImage());
   pic.setImage(picture);
   currentB=temp.getDataKey();
   System.out.println(temp.getDataKey().getbirdName());
     }catch (DictionaryException ex)
     {
       {displayAlert("ERROR: There are no more birds");}
     }
      if(mediaPlayer.getStatus().equals(Status.PLAYING));
       {
       stopSound();
       }

   }
   
   @FXML
    public void prevBird()
   {
   try{
   BirdRecord temp=Birds.predecessor(currentB);
   birdName.setText(temp.getDataKey().getbirdName());
   descrip.setText(temp.getAbout());
   Image picture=new Image(temp.getImage());
   pic.setImage(picture);
   currentB=temp.getDataKey();
    if(mediaPlayer.getStatus().equals(Status.PLAYING));
       {
       stopSound();
       }
   }catch (DictionaryException ex)
   {
    displayAlert("ERROR: There are no more birds");
   }
   }
   
   @FXML
   public void firstBird()
   {
      try{
   BirdRecord temp=Birds.smallest();
   birdName.setText(temp.getDataKey().getbirdName());
   descrip.setText(temp.getAbout());
   Image picture=new Image(temp.getImage());
   pic.setImage(picture);
   currentB=temp.getDataKey();
    if(mediaPlayer.getStatus().equals(Status.PLAYING));
       {
       stopSound();
       }
      }catch(DictionaryException ex)
       {
        displayAlert("ERROR: There are no more birds");
       }
   }
   
   @FXML
   public void lastBird() 
   {
       try{
   BirdRecord temp=Birds.largest();
   birdName.setText(temp.getDataKey().getbirdName());
   descrip.setText(temp.getAbout());
   Image picture=new Image(temp.getImage());
   pic.setImage(picture);
   currentB=temp.getDataKey();
    if(mediaPlayer.getStatus().equals(Status.PLAYING));
       {
       stopSound();
       }
       }catch(DictionaryException ex){
       displayAlert("ERROR: There are no more birds");
       }
   }
   
   @FXML
   public void delete() 
   {
       try{
   DataKey temp=currentB;
   BirdRecord nextBird= Birds.successor(temp);
   showBird(nextBird);
   Birds.remove(currentB);
   System.out.println(Birds.smallest().getDataKey().getbirdName());
   //currentB=null;
   currentB=nextBird.getDataKey();
       }catch(DictionaryException ex)
       {
       displayAlert("ERROR: There are no more birds");
     }
   }
   
  @FXML
  public void findBird() throws DictionaryException{
  
     DataKey findThis=new DataKey(findName.getText(), Integer.parseInt((String) birdSize.getValue()));
     
    System.out.println(findThis.getBirdSize());
     System.out.println(findThis.getbirdName());
    // currentB=Birds.find(findThis).getDataKey();
     System.out.println("hello");
    System.out.println(findThis.getBirdSize());
    
    showBird(findThis);
     
     System.out.println("helllllllo"); 
  }
  
  public void showBird(DataKey b) throws DictionaryException
  {
     birdName.setText(b.getbirdName());
     descrip.setText(Birds.find(b).getAbout());
     Image picture=new Image(Birds.find(b).getImage());
     System.out.println(Birds.find(b).getAbout());
     pic.setImage(picture);
     currentB=b;
      
  }
  
  
   @FXML
   public void sound() throws DictionaryException
   {
     loadSound();
   }
   
   
   public void loadSound()
   {
   String path= "src/sounds/"+currentB.getbirdName()+".mp3";
   Media media=new Media(new File(path).toURI().toString());
   mediaPlayer= new MediaPlayer(media);
   mediaPlayer.setAutoPlay(true);
   mediaPlayer.play(); 
   }
  
   @FXML
   public void stop()
   {
   stopSound();
   }
   
   public void stopSound()
   {
   mediaPlayer.pause();
   }
   
   
   private void showBird(BirdRecord b)
   {
   birdName.setText(b.getDataKey().getbirdName());
   descrip.setText(b.getAbout());
   Image picture=new Image(b.getImage());
   pic.setImage(picture);
   currentB=b.getDataKey();
   
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
        String sound= "file:src/sounds/"+tempName+".mp3";
        DataKey temp = new DataKey (tempName,birdSize);
        key[i]=temp;
        BirdRecord tempRecord= new BirdRecord (temp, tempAbout, sound, images);//key about sound image
        bird[i]=tempRecord;
        Birds.insert(tempRecord);
        //System.out.println(tempName);
   }
   }
    private void displayAlert(String msg) {
        try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Alert.fxml"));
            Parent ERROR = loader.load();
            AlertController controller = (AlertController) loader.getController();

            Scene scene = new Scene(ERROR);
            Stage stage = new Stage();
            stage.setScene(scene);

            stage.getIcons().add(new Image("file:src/birds/WesternLogo.png"));
            System.out.println("dgfdg");
            controller.setAlertText(msg);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

        } catch (IOException ex1) {
        
        }
    }

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        birdSize.setItems(data);
    }

}
