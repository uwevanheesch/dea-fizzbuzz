package nl.han.oose;

import org.ajbrown.namemachine.NameGenerator;

public class NameGeneratorAdapter implements PlayerGenerator {

    private NameGenerator nameGenerator = new NameGenerator();

    @Override
    public String generateRandomName() {
        return nameGenerator.generateName().getFirstName();
    }

    @Override
    public int getAvgerageScore() {
        return (int) Math.random();
    }
}
