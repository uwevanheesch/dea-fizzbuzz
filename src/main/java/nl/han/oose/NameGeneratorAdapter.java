package nl.han.oose;

import org.ajbrown.namemachine.NameGenerator;

public class NameGeneratorAdapter implements PlayerGenerator {

    @Override
    public String generateRandomName() {
        return new NameGenerator().generateName().getFirstName();
    }
}
