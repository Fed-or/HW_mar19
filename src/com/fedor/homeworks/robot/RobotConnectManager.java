package com.fedor.homeworks.robot;

import java.util.Random;

public class RobotConnectManager implements RobotConnectionManager {

    Random random = new Random();

    @Override
    public RobotConnection getConnection() {
        RobotConnection rc = null;
        boolean isConect = random.nextBoolean();
        if (!isConect) {
           throw new RobotConnectionException("Not Connect");
        } else{
            System.out.println("There is connection");
        rc = new RobotConnect();
    }
        return rc;
    }
}
