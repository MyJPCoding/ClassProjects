class Human{
    private int strength = 3;
    private int stealth = 3;
    private int intelligence = 3;
    private int health = 100;

    int attack(Class human){
        health -= strength;
    }
}