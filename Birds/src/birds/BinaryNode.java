/*
 * DataKeyo change this license header, choose License Headers in Project Properties.
 * DataKeyo change this template file, choose DataKeyools | DataKeyemplates
 * and open the template in the editor.
 */
package birds;

/**
 *
 * @author Mickey
 * @param <DataKey>
 */
public class BinaryNode <DataKey> {
    private DataKey data;
    private BinaryNode<DataKey> left;
    private BinaryNode<DataKey> right;
    
    public BinaryNode () {


this (null); // call next constructor
} // end default constructor
public BinaryNode (DataKey dataPortion) {
this (dataPortion, null, null); // call next constructor
} // end constructor


public BinaryNode (DataKey dataPortion, BinaryNode < DataKey > leftChild, BinaryNode < DataKey > rightChild) {

data = dataPortion;
left = leftChild;
right = rightChild;
} // end constructor
public DataKey getData () {
return data;
} // end getData
public void setData (DataKey newData) {
data = newData;
} // end setData
public BinaryNode < DataKey > getLeftChild () {
return left;
} // end getLeftChild

public void setLeftChild (BinaryNode< DataKey > leftChild) {
left = (BinaryNode < DataKey> ) leftChild;



} // end setLeftChild
public boolean hasLeftChild () {
return left != null;
} // end hasLeftChild

public BinaryNode < DataKey > getRightChild () {
return left;
} 
public void setRightChild (BinaryNode< DataKey > rightChild) {
right = (BinaryNode < DataKey> ) rightChild;
} 
public boolean hasRightChild () {
return right != null;
} 
public boolean isLeaf () {
return (left == null) && (right == null);
} // end isLeaf
// Implementations of getRightChild, setRightChild, and hasRightChild are analogous to
// their left-child counterparts.


public BinaryNode < DataKey > copy () {
BinaryNode < DataKey > newRoot = new BinaryNode < DataKey > (data);
if (left != null)
newRoot.left = (BinaryNode < DataKey > ) left.copy ();
if (right != null)
newRoot.right = (BinaryNode < DataKey > ) right.copy ();
return newRoot;
} // end copy
public int getHeight () {
return getHeight (this); // call private getHeight
} // end getHeight
private int getHeight (BinaryNode < DataKey > node) {
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

return rightNumber + 1 + leftNumber;
} // end getNumberOfNodes

}
