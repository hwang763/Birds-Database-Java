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
   while ((current.left!=null)&&(current.right!=null)){
      if ((current.data.getDataKey().compareTo(k))== 0){
           return current.data;
      }
      if ((current.left.data.getDataKey().compareTo(k))== 0){
           return current.left.data;
      }
      if ((current.right.data.getDataKey().compareTo(k))== 0){
           return current.right.data;
      }
      current=current.left;
    }
    current = root;
        while ((current.left!=null)&&(current.right!=null)){
      if ((current.data.getDataKey().compareTo(k))== 0){
           return current.data;
      }
      if ((current.left.data.getDataKey().compareTo(k))== 0){
           return current.left.data;
      }
      if ((current.right.data.getDataKey().compareTo(k))== 0){
           return current.right.data;
      }
      current=current.right;
    }
    return null;
  }
      
    private BinaryNode<BirdRecord> findNode(DataKey k){
        BinaryNode<BirdRecord> current=root; 
   while ((current.left!=null)&&(current.right!=null)){
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
    }
    return null;
    }

    
    public void insert(BirdRecord r) 
    {   BinaryNode<BirdRecord> x, y;
    BinaryNode<BirdRecord> node= new BinaryNode(r);
    
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
    {BinaryNode <BirdRecord> node= null;
    node = findNode(k);
     // Case 1: node does not have a child, just delete it
    if (node.getLeftChild() == null && node.getRightChild() == null)
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
        BinaryNode<BirdRecord> x = successorNode(node); // x will have at most one child
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
    
    public BirdRecord successor(DataKey k)
    {
    
    BinaryNode<BirdRecord> node= findNode(k);
    //BirdRecord record;
    
    //k.
    if (node == null)
        return null;
    if (node.getRightChild() != null)
        return smallestNode(node.getRightChild()).getData();
   
    BinaryNode <BirdRecord>y = node.getParentNode();
    BinaryNode <BirdRecord>x = node;
    while (y != null && x == y.getRightChild())
    {
        x = y;
        y = y.getParentNode();
    }
    BirdRecord record=y.getData();
    return record;
}
        
    
    public BirdRecord predecessor(DataKey k)
    {
      BinaryNode<BirdRecord> node= findNode(k);
      if (node == null)
        return null;
    
      if (node.getLeftChild() != null)
        return largestNode(node.getLeftChild()).getData();
   
       BinaryNode <BirdRecord>y = node.getParentNode();
       BinaryNode <BirdRecord>x = node;
    while (y != null && x == y.getLeftChild())
    {
        x = y;
        y = y.getParentNode();
    }

    BirdRecord record=y.getData();
    return record;
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
    
    private BinaryNode<BirdRecord> smallestNode(BinaryNode<BirdRecord> root)
    {
       if (root == null)
        return null;
  
    if (root.getLeftChild() != null)
        return smallestNode(root.getLeftChild());
  
    return root;
    }
    
    
    public BirdRecord largest()
    {
    if()
    }
    
    private BinaryNode<BirdRecord> largestNode(BinaryNode<BirdRecord> root)
    {
         if (root == null)
        return null;
   
    if (root.getRightChild() != null)
        return largestNode(root.getRightChild());
   
    return root;  
    }
    
    public boolean isEmpty()
    {
    if (root.isLeaf()){
            return true;}
    else return false;
    }
    

}
