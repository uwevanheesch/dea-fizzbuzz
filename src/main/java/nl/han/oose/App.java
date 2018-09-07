package nl.han.oose;

public class App {

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();

        // Adding no players to cause exception; Uncomment block to get a working app
//        fizzBuzz.addPlayer("Peter");
//        fizzBuzz.addRandomPlayer();
//        fizzBuzz.addRandomPlayer();
//        fizzBuzz.addRandomPlayer();

        try {
            fizzBuzz.play(100);
        } catch (FizzBuzzException e) {
            System.out.println(e.getMessage());
        }

    }

}
