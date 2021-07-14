package lab05.ex1;

public interface Vehicle {
    public int getMaxVolume();

    public int getMaxPassangers();
}

class Scooter implements Vehicle {

    private int passangers;

    protected Scooter(int passangers) { 
        this.passangers = passangers;
    }

    @Override
    public int getMaxVolume() {
        // max Volume
        return 0;
    }

    @Override
    public int getMaxPassangers() {
        // max passangers
        return 1;
    }

    @Override
    public String toString() {
        return "Vehicle for " + passangers + " passenger: Use a Scooter";
    }

}

class Micro implements Vehicle {

    private int passangers;
    private int[] luggage;

    protected Micro(int passangers, int[] luggage) {
        this.passangers = passangers;
        this.luggage = luggage;
    }

    @Override
    public int getMaxVolume() {
        // max Volume
        return 250;
    }

    @Override
    public int getMaxPassangers() {
        // max passangers
        return 1;
    }

    @Override
    public String toString() {
        return "Vehicle for 1 passenger with " + this.luggage.length + " items of luggage: Use a Micro car";
    }

}

class City implements Vehicle {

    private int passangers;
    private int[] luggage;
    private int flag;        

    protected City(int passangers, int[] luggage) {
        flag = 0;
        this.passangers = passangers;
        this.luggage = luggage;
    }

    protected City(int passangers) {
        flag = 1;
        this.passangers = passangers;
    }

    @Override
    public int getMaxVolume() {
        // max Volume
        return 250;
    }

    @Override
    public int getMaxPassangers() {
        // max passangers
        return 3;
    }

    @Override
    public String toString() {
        if(flag == 0){
            return "Vehicle for " + this.passangers + " passenger with " + this.luggage.length + " items of luggage: Use a City car";
        }
        else{
            return "Vehicle for " + this.passangers + " passenger: Use a City car";
        }
    }
}

class Family implements Vehicle {

    private int passangers;
    private int[] luggage;
    private int flag;

    protected Family(int passangers, int[] luggage) {
        flag = 0;
        this.passangers = passangers;
        this.luggage = luggage;
    }

    protected Family(int passangers){
        flag = 1;
        this.passangers = passangers;
    }

    @Override
    public int getMaxVolume() {
        // max Volume
        return 600;
    }

    @Override
    public int getMaxPassangers() {
        // max passangers
        return 4;
    }

    @Override
    public String toString() {
        if(flag == 0){
            return "Vehicle for " + this.passangers + " passengers with " + this.luggage.length + " items of luggage: Use a Family car";
        }
        else{
            return "Vehicle for " + this.passangers + " passengers: Use a Family car";
        }
    }
}

class Van implements Vehicle {

    private int passangers;
    private int[] luggage;
    private boolean wheelie;

    private int flag;

    protected Van(int passangers, int[] luggage) {
        flag = 0;
        this.passangers = passangers;
        this.luggage = luggage;
    }

    protected Van(int passangers, int[] luggage, boolean wheelie) {
        flag = 1;
        this.passangers = passangers;
        this.luggage = luggage;
        this.wheelie = wheelie;
    }

    protected Van(int passangers, boolean wheelie) {
        flag = 2;
        this.passangers = passangers;
        this.wheelie = wheelie;
    }

    @Override
    public int getMaxVolume() {
        // max Volume
        return 1000;
    }

    @Override
    public int getMaxPassangers() {
        // max passangers
        return 4;
    }

    @Override
    public String toString() {
        // primeiro construtor
        if (flag == 0) {
            return "Vehicle for " + this.passangers + " passengers with " + this.luggage.length + " items of luggage: Use a Van";
        }
        // segundo construtor
        else if(flag == 1){
            return "Vehicle for " + this.passangers + " passengers with " + this.luggage.length + " items of luggage and wheelchair: Use a Van";
        }
        // terceiro construtor
        else{
            return "Vehicle for " + this.passangers + " passangers and wheelchair: Use a Van";
        }

        
    }

}

class VehicleFactory {
    public static Vehicle getVehicle(int passengers) {
        if(passengers == 1){
            return new Scooter(passengers);
        }
        else if(passengers <= 3){
            return new City(passengers);
        }
        else if(passengers == 4){
            return new Family(passengers);
        }
        else{
            throw new IllegalArgumentException("Número de passageiros inválido");
        }
        
    }

    public static Vehicle getVehicle(int passengers, int[] luggage) {

        int volumeTotal = 0;
        for (int i = 0; i < luggage.length; i++) {
            volumeTotal += luggage[i];
        }

        if (passengers == 1 && volumeTotal <= 250) {
            return new Micro(passengers , luggage);
        }
        if (passengers <= 3 && volumeTotal <= 250) {
            return new City(passengers , luggage);
        }
        if (passengers <= 4 && volumeTotal <= 600) {
            return new Family(passengers , luggage);
        }
        if (passengers <= 4 && volumeTotal <= 1000) {
            return new Van(passengers , luggage);
        } else {
            if (passengers <= 0) {
                throw new IllegalArgumentException("Numero de passageiros invalido!");
            }
            throw new IllegalArgumentException("Volume total de carga inválido");
        }
    }

    public static Vehicle getVehicle(int passengers, int[] luggage, boolean wheelie) {
        int volumeTotal = 0;
        for (int i = 0; i < luggage.length; i++) {
            volumeTotal += luggage[i];
        }

        if (passengers <= 4 && volumeTotal <= 1000)
            return new Van(passengers, luggage , wheelie);
        else
            throw new IllegalArgumentException("Numero de passageiros invalido, ou volume total de carga inválido");
    }

    public static Vehicle getVehicle(int passengers, boolean wheelie) {
        if (passengers <= 4)
            return new Van(passengers , wheelie);
        else
            throw new IllegalArgumentException("Numero de passageiros invalido!");

    }
}