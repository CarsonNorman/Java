public class testAnimal {
    public static void main(String[] args) {
        Gorilla g = new Gorilla();
        g.throwSomething();
        g.throwSomething();
        g.throwSomething();

        g.eatBananas();
        g.eatBananas();

        g.climb();

        g.displayEnergy();

        Bat b = new Bat();
        b.displayEnergy();
        b.destroyTowns();
        b.destroyTowns();
        b.destroyTowns();
        b.eatHumans();
        b.eatHumans();
        b.fly();
        b.fly();
        b.displayEnergy();
    }
}
