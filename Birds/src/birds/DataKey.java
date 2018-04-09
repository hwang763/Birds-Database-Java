package birds;

public class DataKey {
    private String birdName;
    private int birdSize;
    
	// default constructor
	public DataKey() {
	 
	}
        
	// other constructors
         public DataKey(String name, int size){
             birdName=name;
             birdSize=size;
         }
	/**
	 * Returns 0 if this DataKey is equal to k, returns -1 if this DataKey is smaller
	 * than k, and it returns 1 otherwise. 
	 */
	public int compareTo(DataKey k) {
            if (birdName==k.birdName&&birdSize==k.birdSize){
                return 0;
            }
            else if (birdSize<k.birdSize){
                return -1;
            }
           return 1;
            
	}
        public String getbirdName(){
            return birdName;
        }
        public int getBirdSize(){
            return birdSize;
        }
}