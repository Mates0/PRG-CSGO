package com.company;

public class Weapon {
    private String name;
    private String team;
    private int cost;
    private int rof;
    private int damage;

    public Weapon(String name, String team, int cost, int rof, int damage) {
        this.name = name;
        this.team = team;
        this.cost = cost;
        this.rof = rof;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public int getCost() {
        return cost;
    }

    public int getRof() {
        return rof;
    }

    public int getDamage() {
        return damage;
    }

}
