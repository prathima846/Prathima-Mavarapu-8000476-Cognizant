package CommandPatternExample.src;

public class CommandTest {
    public static void main(String[] args) {
        Light light = new Light();

        RemoteControl onRemote = new RemoteControl(new LightOnCommand(light));
        RemoteControl offRemote = new RemoteControl(new LightOffCommand(light));

        onRemote.pressButton();
        offRemote.pressButton();
    }
}

