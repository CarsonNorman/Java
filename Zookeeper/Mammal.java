public class Mammal{
    private int energy  = 100;

    public int displayEnergy(){
        System.out.println(this.energy);
        return this.energy;
    }
    public int changeEnergy(int change){
        this.energy += change;
        return this.energy;
    }
}