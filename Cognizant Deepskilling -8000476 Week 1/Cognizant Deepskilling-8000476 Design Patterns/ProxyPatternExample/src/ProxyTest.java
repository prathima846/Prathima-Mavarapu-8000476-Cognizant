package ProxyPatternExample.src;

public class ProxyTest {
    public static void main(String[] args) {
        Image image = new ProxyImage("https://example.com/cat.jpg");

        image.display();
        System.out.println("--- second call ---");
        image.display();
    }
}

