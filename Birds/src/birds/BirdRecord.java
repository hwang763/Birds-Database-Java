package birds;

/**
 * This class represents a bird record in the database. Each record consists of two
 * parts: a DataKey and the data associated with the DataKey.
 */
public class BirdRecord {
    private String about;
    private String image;
    private DataKey key;
    private String sound;
 

    // default constructor
    public BirdRecord() {
       
        
    }

     // Other constructors
 
    public BirdRecord(DataKey k, String a, String s, String i ){
        about=a;
        image=i;
        sound=s;
        key=k;
    }
     public String getAbout(){
         return about;
     }
     public String getSound(){
         return sound;
     }
     public String getImage(){
         return image;
     }
     public DataKey getDataKey(){
         return key;
     }
}
