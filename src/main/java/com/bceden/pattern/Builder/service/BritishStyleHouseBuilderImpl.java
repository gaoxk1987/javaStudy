package com.bceden.pattern.Builder.service;

import com.bceden.pattern.Builder.model.BritishStyleHouse;
import com.bceden.pattern.Builder.model.House;

public class BritishStyleHouseBuilderImpl implements IHouseBuilder {

    public House house = new BritishStyleHouse();

    @Override
    public void buildDoor() {
        house.setDoor("荎宒瑞跡藷");
    }

    @Override
    public void buildFloor() {
        house.setFloor("荎宒瑞跡華啣");
    }

    @Override
    public void buildWall() {
        house.setWall("荎宒瑞跡華啣");
    }

    @Override
    public void buildWindows() {
        house.setWindows("荎宒瑞跡敦誧");
    }

    @Override
    public House getHouse() {
        return house;
    }

}