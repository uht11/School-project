/* Uzzul Hussain cs435 9813 mp */

public class Tree9813<T> {
    Tree9813<T> left, right;
    T value;

    public Tree9813() { }
    public Tree9813(T value) {
        setValue(value);
    }
    public Tree9813(T value, Tree9813<T> left, Tree9813<T> right) {
        setValue(value);
        setLeft(left);
        setRight(right);
    }
    
    public boolean isLeaf() { return left == null && right == null; }
    
    public T getValue() { return value; }
    public void setValue(T value) { this.value = value; }
    
    public Tree9813<T> getLeft() { return left; }
    public void setLeft(Tree9813<T> left) { this.left = left; }
    
    public Tree9813<T> getRight() { return right; }
    public void setRight(Tree9813<T> right) { this.right = right; }
}