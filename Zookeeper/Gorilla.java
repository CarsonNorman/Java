public class Gorilla extends Mammal {

    public void throwSomething(){
        System.out.println("Threw something");
        this.changeEnergy(-5);

    }
    public void eatBananas(){
        System.out.println("Eating Bananas");
        this.changeEnergy(10);

    }
    public void climb(){
        System.out.println("Monkeying around");
        this.changeEnergy(-10);
  
    }
}
