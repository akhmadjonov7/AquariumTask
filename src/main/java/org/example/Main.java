package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    static ArrayList<Fish> allFishes = new ArrayList<>();
    static Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        int allFishCount = random.nextInt(30 - 10 + 1) + 10;
        for (int i = 0; i < allFishCount; i++) {
            allFishes.add(new Fish(random.nextBoolean(), random.nextInt(100) + 1, random.nextInt(500) + 1));
        }
        fishCount();
        while (allFishes.size() != 0) {
            for (int i = 0; i < allFishes.size(); i++) {
                FishLife fishLife = new FishLife(allFishes.get(i));
                fishLife.start();
                Thread.sleep(500);
            }
        }
        System.out.println("Baliq qolmadi");
    }

    public static void fishCount() {
        int male = 0;
        int female = 0;
        for (Fish fish : allFishes) {
            if (fish.isMale()) male++;
            else female++;
        }
        System.out.printf("Akvariumda %s erkak va %s urg'ochi baliq bor\r", male, female);

    }
}