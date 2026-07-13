package CommandPatternExample.src;

public class RemoteControl {
    private final Command command;

    public RemoteControl(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

