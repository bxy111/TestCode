package practice2;

public class Test {
    public static void main(String[] args) {
        TestWin w1 = new TestWin();
        TestWin w2 = new TestWin();

        w1.openWin();
        w2.openWin();

        ButtonListener buttonListener = new ButtonListener(w1.getField(), w2.getField());
        w1.getBut().addActionListener(buttonListener);
        ButtonListener buttonListener1 = new ButtonListener(w2.getField(), w1.getField());
        w2.getBut().addActionListener(buttonListener1);
    }
}
