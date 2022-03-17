package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("CSGO-Weapons-Data.csv"));
        ArrayList<String> arr = new ArrayList<>();
        ArrayList<Weapon> weaponList = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            arr.add(line);
        }
        for (int i = 1; i < arr.size(); i++) {
            String[] split = arr.get(i).replaceAll("\\$","").split(",");
            weaponList.add(new Weapon(split[0], split[1], Integer.parseInt(split[2]), Integer.parseInt(split[6]), Integer.parseInt(split[7])));
        }

        var averageCost = weaponList.stream()
                .mapToInt(i -> i.getCost())
                .average()
                .getAsDouble();
        var rof = weaponList.stream()
                .filter(i -> i.getTeam().equals("T"))
                .filter(i -> i.getRof() < 200)
                .map(i -> i.getName())
                .collect(Collectors.toList());
        var highestDamage = weaponList.stream()
                .sorted((o1, o2) -> o2.getDamage() - o1.getDamage())
                .limit(4)
                .map(i -> i.getName() + "(" + i.getDamage() + ")")
                .collect(Collectors.toList());
        System.out.println(averageCost);
        System.out.println(rof);
        System.out.println(highestDamage);
    }
}
