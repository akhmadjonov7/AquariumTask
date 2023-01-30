package org.example;

import java.util.LinkedList;
import java.util.Random;

public class Main {
    static LinkedList<Fish> allFishes = new LinkedList<>();
    static Random random = new Random();
    static int male = 0;
    static int female = 0;

    public static void main(String[] args) throws InterruptedException {

        int allFishCount = random.nextInt(30 - 10 + 1) + 10;
        System.out.println(allFishCount);
        for (int i = 0; i < allFishCount; i++) {
            allFishes.add(new Fish(random.nextBoolean(), random.nextInt(100) + 1, random.nextInt(1000) + 1));
        }
        fishCount();
        while (allFishes.size() != 0) {
            for (int i = 0; i < allFishes.size(); i++) {
                FishLife fishLife = new FishLife(allFishes.get(i));
                fishLife.start();
                Thread.sleep(1000);
            }
        }
        System.out.println("Baliq qolmadi");
    }

    public static void fishCount() {
        male = 0;
        female = 0;
        for (Fish fish : allFishes) {
            if (fish.isMale()) male++;
            else female++;
        }
        System.out.printf("Akvariumda %s erkak va %s urg'ochi baliq bor\n", male, female);
    }
}