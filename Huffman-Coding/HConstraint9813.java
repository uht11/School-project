/* Uzzul Hussain cs435 9813 mp */

public interface HConstraint9813<T> {
    public static HConstraint9813<Integer> INT_MIN = new IntMinConstraint();
    public static HConstraint9813<Integer> INT_MAX = new IntMaxConstraint();

    boolean isConstraintValid(T parent, T child);

    static class IntMinConstraint implements HConstraint9813<Integer> {
        @Override
        public boolean isConstraintValid(Integer parent, Integer child) {
            return parent <= child;
        }
    }
    static class IntMaxConstraint implements HConstraint9813<Integer> {
        @Override
        public boolean isConstraintValid(Integer parent, Integer child) {
            return parent >= child;
        }
    }
}