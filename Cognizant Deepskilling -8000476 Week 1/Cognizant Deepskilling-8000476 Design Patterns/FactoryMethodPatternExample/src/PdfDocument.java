package FactoryMethodPatternExample.src;

public class PdfDocument implements Document {
    @Override
    public void render() {
        System.out.println("Rendering PDF document...");
    }
}

