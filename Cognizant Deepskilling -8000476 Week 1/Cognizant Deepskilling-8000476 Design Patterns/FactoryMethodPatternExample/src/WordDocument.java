package FactoryMethodPatternExample.src;

public class WordDocument implements Document {
    @Override
    public void render() {
        System.out.println("Rendering Word document...");
    }
}

