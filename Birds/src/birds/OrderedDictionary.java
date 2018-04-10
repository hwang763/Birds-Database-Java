/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package birds;

/**
 *
 * @author Mickey
 */



public class OrderedDictionary extends BinaryNode {
    private BirdRecord record; 
    private BinaryNode<BirdRecord> root=new BinaryNode();
    private BinaryNode<BirdRecord> current=root; 
    public BirdRecord find(DataKey k) 
    {
    if (root==null){
        return null;}
    while ((root.left!=null)&&(root.right!=null)){
      if ((root.data.getDataKey().compareTo(k))== 0){
           return root.data;
      }
      if ((root.left.data.getDataKey().compareTo(k))== 0){
           return root.left.data;
      }
      if ((root.right.data.getDataKey().compareTo(k))== 0){
           return root.right.data;
      }
      current=current.left;
    }
    current = root;
        while ((root.left!=null)&&(root.right!=null)){
      if ((root.data.getDataKey().compareTo(k))== 0){
           return root.data;
      }
      if ((root.left.data.getDataKey().compareTo(k))== 0){
           return root.left.data;
      }
      if ((root.right.data.getDataKey().compareTo(k))== 0){
           return root.right.data;
      }
      current=current.right;
    }

}
    }
    public void insert(BirdRecord r)
    {
        
    }
    public void remove(DataKey k)
    {
    
    }
    
    public BirdRecord successor(DataKey k)
    {
    
    }
    
    public BirdRecord predecessor(DataKey k)
    {
    
    }
    
    public BirdRecord smallest()
    {
    BirdRecord record;
    DataKey j, k;
    if (k.getBirdSize()==1)
    {
    
    }
    return record;
    }
    
    public BirdRecord largest()
    {
    if()
    }
    public boolean isEmpty()
    {
    return true;
    }
    

}
