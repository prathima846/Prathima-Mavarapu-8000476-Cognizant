package BuilderPatternExample.src;

public class BuilderTest {
    public static void main(String[] args) {
        Computer gamingPc = new Computer.Builder()
                .cpu("Intel i7")
                .ram(16)
                .storage(512)
                .wifi(true)
                .build();

        Computer basicPc = new Computer.Builder()
                .cpu("Intel i3")
                .ram(8)
                .storage(256)
                .wifi(false)
                .build();

        gamingPc.showSpec();
        System.out.println();
        basicPc.showSpec();
    }
}

