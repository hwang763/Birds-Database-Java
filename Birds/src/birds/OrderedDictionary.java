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
    private BinaryNode<BirdRecord> root= null;
   
    public BirdRecord find(DataKey k) throws DictionaryException 
    { BinaryNode<BirdRecord> current=root; 
   
     
  /* while ((current.left!=null)&&(current.right!=null)){
       System.out.println("hi");
      if ((current.getData().getDataKey().compareTo(k))== 0){
           return current.getData();
      }
      System.out.println("sup "+current.left.getData().getDataKey().getbirdName());
      if ((current.left.getData().getDataKey().compareTo(k))== 0){
           return current.left.getData();
      }
      if ((current.right.getData().getDataKey().compareTo(k))== 0){
           return current.right.getData();
      }
      current=current.left;
    }
    current = root;
        while ((current.left!=null)&&(current.right!=null)){
      if ((current.data.getDataKey().compareTo(k))== 0){
           return current.getData();
      }
      if ((current.left.data.getDataKey().compareTo(k))== 0){
           return current.left.getData();
      }
      if ((current.right.data.getDataKey().compareTo(k))== 0){
           return current.right.getData();
      }
      current=current.right;
    }*/
  
  while (current!=null){
      
      if (current.getData().getDataKey().compareTo(k)==0){
          
          return current.getData();
      }
      else if (current.getData().getDataKey().compareTo(k)==-1){
          
          current=current.right;
          
      }
      else if (current.getData().getDataKey().compareTo(k)==1){
          current=current.left;
      }
  }
 
    throw new DictionaryException ("There is no record that matches this given key!");
  }
      
    private BinaryNode<BirdRecord> findNode(DataKey k){
        BinaryNode<BirdRecord> current=root; 
  /* while ((current.left!=null)&&(current.right!=null)){
      if ((current.data.getDataKey().compareTo(k))== 0){
           return current;
      }
      if ((current.left.data.getDataKey().compareTo(k))== 0){
           return current.left;
      }
      if ((current.right.data.getDataKey().compareTo(k))== 0){
           return current.right;
      }
      current=current.left;
    }
    current = root;
        while ((current.left!=null)&&(current.right!=null)){
      if ((current.data.getDataKey().compareTo(k))== 0){
           return current;
      }
      if ((root.left.data.getDataKey().compareTo(k))== 0){
           return current.left;
      }
      if ((root.right.data.getDataKey().compareTo(k))== 0){
           return current.right;
      }
      current=current.right;
    }*/
  while (current!=null){
     
      if (current.getData().getDataKey().compareTo(k)==0){
          
          return current;
      }
      else if (current.getData().getDataKey().compareTo(k)==-1){
          
          current=current.right;
          
      }
      else if (current.getData().getDataKey().compareTo(k)==1){
          current=current.left;
     }
  }
    return null;
    }

    
    public void insert(BirdRecord r) throws DictionaryException
    {   BinaryNode<BirdRecord> x, y;
    BinaryNode<BirdRecord> node= new BinaryNode(r);
    
          // root is a global variable and is the root of the tree
    x = y = root; // Assume root is initialized to null
    
    while (x != null)
    {
        
        if (x.getData().getDataKey().compareTo(node.getData().getDataKey())==1)   
        {
            y = x;
            x = x.left;
        }
        else
        {
            y = x;
            x = x.right;
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
    public void remove(DataKey k) throws DictionaryException
    {BinaryNode <BirdRecord> node=findNode(k);
    
     // Case 1: node does not have a child, just delete it
    if ((node.left == null) &&( node.right == null))
    {
        if (node.getParentNode() != null && node.getParentNode().getLeftChild() == node)
            node.setLeftChild(null);
        else if (node.getParentNode() != null && node.getParentNode().getRightChild() == node)
            node.setRightChild(null);            
    }
    // Case 2: node has only one child, splice the child with its parent
    else if (node.getLeftChild() == null || node.getRightChild() == null)
    {
        if (node.getParentNode() != null)
        {
            BinaryNode<BirdRecord> x = node.getLeftChild() == null ? node.getRightChild() : node.getLeftChild();
            if (node.getParentNode().getLeftChild() == node)
                node.getParentNode().setLeftChild(x);
            else
                node.getParentNode().setRightChild(x);
        }            
    }
    // Case 3: node has both children, set the successor of the node to its parent
    else
    {
        BinaryNode<BirdRecord> x = successorNode(findNode(k)); // x will have at most one child
        // Instead of deleting we can just copy the successor's data over to the node to be deleted
        node.setData(x.getData());
        // Now delete the successor and set its child (if any) to its parent
        BinaryNode<BirdRecord> nodeChild = x.getLeftChild() == null ? x.getRightChild() : x.getLeftChild();
        if (x.getLeftChild() != null)
        {
            if (x.getParentNode().getLeftChild() == x)
                x.getParentNode().setLeftChild(nodeChild);
            else
                x.getParentNode().setRightChild(nodeChild);
        }
        else
        {
            if (x.getParentNode().getLeftChild() == x)
                x.getParentNode().setLeftChild(nodeChild);
            else
                x.getParentNode().setRightChild(nodeChild);
        }
    }
    }
    
    public BirdRecord successor(DataKey k)throws DictionaryException
    {
    
    BinaryNode<BirdRecord> node= findNode(k);
    //BirdRecord record;
    
    //k.
    if (node == null)
        return null;
    if (node.right != null)
        return smallestNode(node.right).getData();
   
    BinaryNode <BirdRecord>y = node.getParentNode();
    BinaryNode <BirdRecord>x = node;
    while (y != null && x == y.right)
    {
        x = y;
        y = y.getParentNode();
    }
    BirdRecord record=y.getData();
    return record;
}
    private BinaryNode <BirdRecord> successorNode(BinaryNode <BirdRecord> node){
         if (node == null)
        return null;
    
    if (node.right != null)
        return smallestNode(node.right);
   
    BinaryNode<BirdRecord> y = node.getParentNode();
    BinaryNode<BirdRecord> x = node;
    while (y != null && x == y.right)
    {
        x = y;
        y = y.getParentNode();
    }

    return y;
    }
        
    
    public BirdRecord predecessor(DataKey k) throws DictionaryException
    {
      BinaryNode<BirdRecord> node= findNode(k);
      if (node == null)
        return null;
    
      if (node.left != null)
        return largestNode(node.left).getData();
   
       BinaryNode <BirdRecord>y = node.getParentNode();
       BinaryNode <BirdRecord>x = node;
    while (y != null && x == y.left)
    {
        x = y;
        y = y.getParentNode();
    }

    BirdRecord record=y.getData();
    return record;
    }
    
    public BirdRecord smallest() throws DictionaryException
    {
     if (root == null)
        return null;
  
    if (root.left != null)
        return smallestNode(root.left).getData();
  
    return root.getData();
    }
    
    private BinaryNode<BirdRecord> smallestNode(BinaryNode<BirdRecord> root)
    {
       if (root == null)
        return null;
  
    if (root.left != null)
        return smallestNode(root.left);
  
    return root;
    }
    
    
    public BirdRecord largest() throws DictionaryException
    {
      if (root == null)
        return null;
   
    if (root.right != null)
        return largestNode(root.right).getData();
   
    return root.getData();
    }
    
    private BinaryNode<BirdRecord> largestNode(BinaryNode<BirdRecord> root)
    {
         if (root == null)
        return null;
   
    if (root.right != null)
        return largestNode(root.right);
   
    return root;  
    }
    
    public boolean isEmpty()
    {
    if (root.isLeaf()){
            return true;}
    else return false;
    }
    

}
