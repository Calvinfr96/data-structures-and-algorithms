public class BsTNode<T> {
    public T value;
    public BsTNode<T> left;
    public BsTNode<T> right;

    public BsTNode(T value) {
        this.value = value;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        return String.format(" { value : %d, left : %s, right : %s } ", value, left, right);
    }
}