public class Solution2_5 {
    // Method g() that throws FirstCustomException
    public void g() throws FirstCustomException {
        throw new FirstCustomException("Exception thrown in g()");
    }

    // Method f() that calls g(), catches FirstCustomException, and throws SecondCustomException
    public void f() throws SecondCustomException {
        try {
            g();
        } catch (FirstCustomException e) {
            throw new SecondCustomException("Exception thrown in f() after catching FirstCustomException");
        }
    }

    public static void main(String[] args) {
        Solution2_5 solution = new Solution2_5();
        try {
            solution.f();
        } catch (SecondCustomException e) {
            System.out.println("Caught SecondCustomException: " + e.getMessage());
        }
    }
}