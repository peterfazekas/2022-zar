package hu.lock;

import hu.lock.controller.KeyService;
import hu.lock.model.service.Console;
import hu.lock.model.service.DataApi;
import hu.lock.model.service.DataParser;
import hu.lock.model.service.FileReader;
import hu.lock.model.service.FileWriter;

import java.util.Scanner;

public class App {

    private final KeyService service;
    private final Console console;
    private final FileWriter writer;

    private App() {
        DataApi dataApi = new DataApi(new FileReader(), new DataParser());
        service = new KeyService(dataApi.getData("ajto.txt"));
        console = new Console(new Scanner(System.in));
        writer = new FileWriter("siker.txt");
    }

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        System.out.println("2. feladat");
        System.out.print("Adja meg, mi nyitja a zárat! ");
        String actualKey = console.read();
        System.out.println("3. feladat");
        System.out.println("A nyitó kódszámok sorai: " +
                service.getEqualKeyIds(actualKey));
        System.out.println("4. feladat");
        System.out.println("Az első ismétlődést tartalmazó próbálkozás sorszáma: " +
                service.getSameDigitKeyId());
        System.out.println("5. feladat");
        System.out.println(service.getGeneratedKey(actualKey));
        writer.writeAll(service.getOpenResults(actualKey));
    }
}
