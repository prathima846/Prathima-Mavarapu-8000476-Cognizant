package ProxyPatternExample.src;

public class RealImage implements Image {
    private final String url;

    public RealImage(String url) {
        this.url = url;
        loadFromRemote();
    }

    private void loadFromRemote() {
        System.out.println("Loading image from remote: " + url);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + url);
    }
}

