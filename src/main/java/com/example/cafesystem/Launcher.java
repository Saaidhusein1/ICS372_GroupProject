package com.example.cafesystem;

import javafx.application.Application;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Launcher {
    public static void main(String[] args) {
        Application.launch(CafeApplication.class, args);
    }
}
