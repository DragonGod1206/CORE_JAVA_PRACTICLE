interface Game {
    int MAX_PLAYERS = 11;
}

class Cricket implements Game {
    void show() {
        System.out.println("Cricket - Max Players: " + MAX_PLAYERS);
    }
}

class Football implements Game {
    void show() {
        System.out.println("Football - Max Players: " + MAX_PLAYERS);
    }
}

public class Q18GameDemo {
    public static void main(String[] args) {
        new Cricket().show();
        new Football().show();
    }
}