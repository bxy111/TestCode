package practice5;

public class Num {
    private int src;
    private int guess;

    public int getSrc() {
        return src;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public int getGuess() {
        return guess;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }

    public int compare() {
        return guess - src;
    }
}
