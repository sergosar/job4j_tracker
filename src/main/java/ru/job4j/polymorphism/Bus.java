package ru.job4j.polymorphism;

public class Bus implements Transport {
    private float fuelCost = 1.0f;

    @Override
    public void ride() {
        System.out.println("Bus start ride..");
    }

    @Override
    public void passengers(int quantity) {
        System.out.println("there are " + quantity + " passenger(s) on the bus");
    }

    @Override
    public float refill(float fuelAmount) {
        return fuelAmount * fuelCost;
    }
}
