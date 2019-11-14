package Practice4;

public class Outter {
    private Inner in;

    public Outter() {
        in = new Inner();
    }

    private class Inner {
        private void test() {
            System.out.println("test Inner");
        }
    }

}
