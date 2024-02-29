package com.example.firstWebApp.entities;

// كائن الطلب
public class AIRequest {
    private String inputText;

    public AIRequest(String inputText) {
        this.inputText = inputText;
    }

    public String getInputText() {
        return inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }

}
