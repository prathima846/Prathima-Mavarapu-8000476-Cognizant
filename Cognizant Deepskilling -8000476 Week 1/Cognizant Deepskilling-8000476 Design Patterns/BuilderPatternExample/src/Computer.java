package BuilderPatternExample.src;

public class Computer {
    private final String cpu;
    private final int ram;
    private final int storage;
    private final boolean wifi;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.wifi = builder.wifi;
    }

    public void showSpec() {
        System.out.println("Computer Specs:");
        System.out.println("CPU: " + cpu);
        System.out.println("RAM: " + ram + "GB");
        System.out.println("Storage: " + storage + "GB");
        System.out.println("WiFi: " + (wifi ? "Yes" : "No"));
    }

    public static class Builder {
        private String cpu;
        private int ram;
        private int storage;
        private boolean wifi;

        public Builder cpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder ram(int ram) {
            this.ram = ram;
            return this;
        }

        public Builder storage(int storage) {
            this.storage = storage;
            return this;
        }

        public Builder wifi(boolean wifi) {
            this.wifi = wifi;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}

