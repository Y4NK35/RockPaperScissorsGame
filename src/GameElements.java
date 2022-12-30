import java.util.Random;
public enum GameElements {
    PAPER,SCISSORS,ROCK;
    private static Random rnd = new Random();

    public static GameElements randomGameElement(){
        GameElements[] elements = values();
        return elements[rnd.nextInt(elements.length)];
    }}
