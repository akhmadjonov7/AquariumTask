package org.example;

import java.util.ArrayList;
import java.util.List;

import static org.example.Main.random;
import static org.example.Main.allFishes;
import static org.example.Main.fishCount;

public class FishLife extends Thread {
    private Fish fish;
    public  FishLife(Fish fish){
        this.fish = fish;
    }

    @Override
    public void run() {
        while(fish.getLife()>0){

            for (int i = 0; i < allFishes.size(); i++) {
                if (allFishes.get(i).getLocation()==fish.getLocation() && allFishes.get(i).isMale()!= fish.isMale() ){
                    Fish fish1 = new Fish(random.nextBoolean(), random.nextInt(100) + 1, random.nextInt(100) + 1);
                    allFishes.add(fish1);
                    fishCount();
                }
            }
            fish.setLocation(random.nextInt(1000) +1);
            fish.setLife(fish.getLife()-1);

        }
        allFishes.remove(fish);
        fishCount();
    }
}
