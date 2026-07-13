package FactoryMethodPatternExample.src;

public class ExcelDocument implements Document {
    @Override
    public void render() {
        System.out.println("Rendering Excel document...");
    }
}

