package com.example;

public class MyService {
    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }

    public String fetchDataWithArg(String key) {
        return externalApi.getDataFor(key);
    }

    public void processAction(String action) {
        externalApi.performAction(action);
    }

    public void processActionThatThrows(String action) {
        externalApi.performActionThatThrows(action);
    }
}
