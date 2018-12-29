package com.bceden.pattern.Builder.service;

import com.bceden.pattern.Builder.model.BritishStyleHouse;
import com.bceden.pattern.Builder.model.House;

public class BritishStyleHouseBuilderImpl implements IHouseBuilder {

    public House house = new BritishStyleHouse(); 
    
    @Override
    public void buildDoor() {
        house.setDoor("Ӣʽ�����");
    }

    @Override
    public void buildFloor() {
        house.setFloor("Ӣʽ���ذ�");
    }

    @Override
    public void buildWall() {
        house.setWall("Ӣʽ���ذ�");
    }

    @Override
    public void buildWindows() {
        house.setWindows("Ӣʽ��񴰻�");
    }

    @Override
    public House getHouse() {
        return house;
    }

}