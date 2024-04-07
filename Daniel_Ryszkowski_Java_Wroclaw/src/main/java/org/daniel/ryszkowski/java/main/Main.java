package org.daniel.ryszkowski.java.main;

import org.daniel.ryszkowski.java.ocadoApi.BasketSplitter;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        BasketSplitter basketSplitter = new BasketSplitter("config-test-1.json");
        Map<String, List<String>> test = basketSplitter.split(basketSplitter.getJsonInPutter().readJsonBasketFile("test-b-1.json"));
        System.out.println("----------------------------------------------------");
        test.forEach((k, v) -> System.out.println(k + " : " + v + "\n"));
    }
}
