package Practice1;

public interface ComputeTotalSales {
    public double totalSalesByYear();
}

class Television implements ComputeTotalSales {

    @Override
    public double totalSalesByYear() {
        return 1000000;
    }
}

class Computer implements ComputeTotalSales{
    @Override
    public double totalSalesByYear() {
        return 4000000;
    }
}

class Mobile implements ComputeTotalSales{
    @Override
    public double totalSalesByYear() {
        return 2000000;
    }
}