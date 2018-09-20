package nl.han.oose;

public class App {

    public static void main(String[] args) {

        FizzBuzz fizzBuzz = new FizzBuzz(new NameGeneratorAdapter());

        fizzBuzz.addPlayer("Peter");
        fizzBuzz.addRandomPlayer();
        fizzBuzz.addRandomPlayer();
        fizzBuzz.addRandomPlayer();

        try {
            fizzBuzz.play(100);
        } catch (FizzBuzzException e) {
            System.out.println(e.getMessage());
        }

    }

}
