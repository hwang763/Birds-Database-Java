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
   
    public BirdRecord find(DataKey k) 
    { BinaryNode<BirdRecord> current=root; 
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
    return null;
  }
      
    

    
    public void insert(BirdRecord r)
    {   BinaryNode<BirdRecord> x, y,node = null;
    node.setData(r);
          // root is a global variable and is the root of the tree
    x = y = root; // Assume root is initialized to null
    
    while (x != null)
    {
        if (x.getData().getDataKey().compareTo(node.getData().getDataKey())==1)   
        {
            y = x;
            x = x.getLeftChild();
        }
        else
        {
            y = x;
            x = x.getRightChild();
        }
    }
    
    // y will be the parent of node
    if (y == null) 
    {
        root = node;
        return;
    }
    
    if (y.getData().getDataKey().compareTo(node.getData().getDataKey())==1)
        y.setLeftChild(node);
    else
        y.setRightChild(node);
    
    node.setParentNode(y);
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
