package ru.job4j.polymorphism;

public interface Transport {

    void ride();

    void passengers(int quantity);

    float refill(float fuelAmount);
}
