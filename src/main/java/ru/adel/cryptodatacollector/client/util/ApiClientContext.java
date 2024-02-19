package ru.adel.cryptodatacollector.client.util;

import org.springframework.stereotype.Component;
import ru.adel.cryptodatacollector.client.action.ApiClientAction;

@Component
public class ApiClientContext {
    private String url;
    private ApiClientAction action;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ApiClientAction getAction() {
        return action;
    }

    public void setAction(ApiClientAction action) {
        this.action = action;
    }
}