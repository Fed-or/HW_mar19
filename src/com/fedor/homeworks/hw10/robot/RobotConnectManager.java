package com.fedor.homeworks.hw10.robot;

import java.util.Random;

public class RobotConnectManager implements RobotConnectionManager {

    Random random = new Random();

    @Override
    public RobotConnection getConnection() {
        RobotConnection rc = null;
        boolean isConect = random.nextBoolean();
        if (!isConect) {
            System.out.println("No connection!");
        } else{
            System.out.println("There is conection");
        rc = new RobotConnect();
    }
        return rc;
    }
}
