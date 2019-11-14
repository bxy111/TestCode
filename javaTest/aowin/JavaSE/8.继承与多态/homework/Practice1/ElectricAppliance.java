package Practice1;

public class ElectricAppliance {
    public void useElectric() {
        System.out.println("ElectricAppliance use electricity");
    }
}

class Television extends ElectricAppliance {
    public void playMovie() {
        System.out.println("Television playMovie");
    }
}

class Cellphone extends ElectricAppliance {
    public void callUp() {
        System.out.println("Cellphone callUp");
    }
}
