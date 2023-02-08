public class Bat extends Mammal {
    public Bat(){
        this.changeEnergy(200);
    }

    public void fly(){
        System.out.println("Flying");
        this.changeEnergy(-50);
    }
    public void eatHumans(){
        System.out.println("Feasting on humans");
        this.changeEnergy(25); 
    }
    public void destroyTowns(){
        System.out.println("Destroying towns");
        this.changeEnergy(-100);
    }
}
