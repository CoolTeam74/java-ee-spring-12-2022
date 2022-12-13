package org.example;

@Html
public class HtmlStringProvider implements StringProvider{
    @Override
    public String load() {
        return "Load from HTML";
    }
}
