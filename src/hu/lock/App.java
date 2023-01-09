package hu.lock;

import hu.lock.controller.KeyService;
import hu.lock.model.service.Console;
import hu.lock.model.service.DataApi;
import hu.lock.model.service.DataParser;
import hu.lock.model.service.FileReader;

import java.util.Scanner;

public class App {

    private final KeyService service;
    private final Console console;

    private App() {
        DataApi dataApi = new DataApi(new FileReader(), new DataParser());
        service = new KeyService(dataApi.getData("ajto.txt"));
        console = new Console(new Scanner(System.in));
    }

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        System.out.println("2. feladat");
    }
}
