/*
 * BirdRecordo change this license header, choose License Headers in Project Properties.
 * BirdRecordo change this template file, choose BirdRecordools | BirdRecordemplates
 * and open the template in the editor.
 */
package birds;

/**
 *
 * @author Mickey
 * @param <BirdRecord>
 */
public class BinaryNode <BirdRecord> {
    public BirdRecord data;
    public BinaryNode<BirdRecord> left;
    public BinaryNode<BirdRecord> right;
    public BinaryNode <BirdRecord> parent;
    
    public BinaryNode () {


this (null); // call next constructor
} // end default constructor
public BinaryNode (BirdRecord dataPortion) {
this (dataPortion, null, null); // call next constructor
} // end constructor


public BinaryNode (BirdRecord dataPortion, BinaryNode < BirdRecord > leftChild, BinaryNode < BirdRecord > rightChild) {

data = dataPortion;
left = leftChild;
right = rightChild;
} // end constructor
public BirdRecord getData () {
return data;
} // end getData
public void setData (BirdRecord newData) {
data = newData;
} // end setData
public BinaryNode < BirdRecord > getLeftChild () {
return left;
} // end getLeftChild

public void setLeftChild (BinaryNode< BirdRecord > leftChild) {
left = (BinaryNode < BirdRecord> ) leftChild;

} // end setLeftChild

public boolean hasLeftChild () {
    return left != null;
} // end hasLeftChild


public BinaryNode < BirdRecord > getRightChild () {
return left;
} 
public void setRightChild (BinaryNode< BirdRecord > rightChild) {
right = (BinaryNode < BirdRecord> ) rightChild;
} 
public boolean hasRightChild () {
return right != null;
} 


public void setParentNode(BinaryNode<BirdRecord> node){
    parent = node;
}

public BinaryNode<BirdRecord> getParentNode(){
    return parent;
}
public boolean isLeaf () {
    return (left == null) && (right == null);
} // end isLeaf

// Implementations of getRightChild, setRightChild, and hasRightChild are analogous to
// their left-child counterparts.


public BinaryNode < BirdRecord > copy () {
BinaryNode < BirdRecord > newRoot = new BinaryNode < BirdRecord > (data);
if (left != null)
newRoot.left = (BinaryNode < BirdRecord > ) left.copy ();
if (right != null)
newRoot.right = (BinaryNode < BirdRecord > ) right.copy ();
return newRoot;

} // end copy

public int getHeight () {
    return getHeight (this); // call private getHeight
} // end getHeight



private int getHeight (BinaryNode < BirdRecord > node) {
int height = 0;
if (node != null)
height = 1 + Math.max (getHeight (node.left), getHeight (node.right));
return height;

} // end getHeight

public int getNumberOfNodes () {
    int leftNumber = 0;
    int rightNumber = 0;
    if (left != null)
        leftNumber = left.getNumberOfNodes ();
    if (right != null)
        rightNumber = right.getNumberOfNodes ();
    return 1 + leftNumber + rightNumber;
} // end getNumberOfNodes 


}
