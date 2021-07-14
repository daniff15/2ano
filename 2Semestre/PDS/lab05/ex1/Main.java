package lab05.ex1;

public class Main {
    public static void main(String[] args) {
        int[] luggage;
        Vehicle v;

        // Get vehicle for 1 passenger without luggage
        v = VehicleFactory.getVehicle(1);
        System.out.println(v);

        // Get vehicle for 1 passenger with 2 luggage
        luggage = new int[]{100,140}; //two bags with a total of 240 volume
        v = VehicleFactory.getVehicle(1, luggage);
        System.out.println(v);

        // Get vehicle for 3 passenger with 3 luggage
        luggage = new int[]{50,200,240};//three bags with a total of 490 volume
        v = VehicleFactory.getVehicle(3, luggage);
        System.out.println(v);

        // Get vehicle for 1 passenger and wheelchair
        v = VehicleFactory.getVehicle(2, true);
        System.out.println(v);

        // Get vehicle for 2 passenger without luggage
        v = VehicleFactory.getVehicle(2);
        System.out.println(v);

        // Get vehicle for 4 passenger without luggage
        v = VehicleFactory.getVehicle(4);
        System.out.println(v);

        // Get vehicle for 3 passenger with 3 luggage
        luggage = new int[]{10,100,24};//three bags with a total of 134 volume
        v = VehicleFactory.getVehicle(3, luggage);
        System.out.println(v);

        // Get vehicle for 3 passenger with 3 luggage
        luggage = new int[]{50,200,240};//three bags with a total of 490 volume
        v = VehicleFactory.getVehicle(3, luggage);
        System.out.println(v);

        // Get vehicle for 3 passenger with 3 luggage
        luggage = new int[]{500,200,100};//three bags with a total of 800 volume
        v = VehicleFactory.getVehicle(3, luggage);
        System.out.println(v);

        // Get vehicle for 3 passenger with 3 luggage and wheelchair
        luggage = new int[]{500,200,100};//three bags with a total of 800 volume
        v = VehicleFactory.getVehicle(2,luggage, true);
        System.out.println(v);

    }
}
