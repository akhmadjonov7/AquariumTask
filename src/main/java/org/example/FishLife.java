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
            ArrayList<Fish> list =  allFishes;
            list.remove(fish);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getLocation()==fish.getLocation() && list.get(i).isMale()!= fish.isMale() ){
                    Fish fish1 = new Fish(random.nextBoolean(), random.nextInt(100) + 1, random.nextInt(500) + 1);
                    allFishes.add(fish1);
                    fishCount();
                }
            }
            fish.setLocation(random.nextInt(500) +1);
            fish.setLife(fish.getLife()-1);

        }
        allFishes.remove(fish);
        fishCount();
    }
}
