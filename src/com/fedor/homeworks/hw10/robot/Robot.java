package com.fedor.homeworks.hw10.robot;

public class Robot {
    int x = 0;
    int y = 0;
    Direction direction = Direction.UP;

    public Direction getDirection() {
        // текущее направление взгляда
        return Direction.UP;
    }

    public int getX() {
        // текущая координата X
        return x;
    }

    public int getY() {
        // текущая координата Y
        return y;
    }

    public void turnLeft() {
        // повернуться на 90 градусов против часовой стрелки
    }

    public void turnRight() {
        // повернуться на 90 градусов по часовой стрелке
    }

    public void stepForward() {
    }


    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {

        int count = 1;
        boolean connect = false;
        while (!connect && count < 3) {
            try (RobotConnection robot = robotConnectionManager.getConnection()) {
                robot.moveRobotTo(toX, toY);
                connect = true;

            } catch (RobotConnectionException e) {
                count++;
            }
        }
        if (!connect) {
            throw new RobotConnectionException("attemt was failed");
        }
    }
}