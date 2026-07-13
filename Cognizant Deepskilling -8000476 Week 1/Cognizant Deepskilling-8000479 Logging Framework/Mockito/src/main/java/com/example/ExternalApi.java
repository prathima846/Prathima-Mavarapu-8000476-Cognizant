package com.example;

public interface ExternalApi {
    String getData();
    String getDataFor(String input);
    void performAction(String action);
    void performActionThatThrows(String action);
}
