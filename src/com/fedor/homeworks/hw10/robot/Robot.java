package com.fedor.homeworks.hw10.robot;

public class Robot {
    private int x;
    private int y;
    private Direction direction;

    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void turnLeft() {

        switch (getDirection()) {
            case UP:
                direction = Direction.LEFT;
                break;
            case DOWN:
                direction = Direction.RIGHT;
                break;
            case LEFT:
                direction = Direction.DOWN;
                break;
            case RIGHT:
                direction = Direction.UP;
                break;
        }

    }

    public void turnRight() {

        switch (getDirection()) {
            case UP:
                direction = Direction.RIGHT;
                break;
            case DOWN:
                direction = Direction.LEFT;
                break;
            case LEFT:
                direction = Direction.UP;
                break;
            case RIGHT:
                direction = Direction.DOWN;
                break;
        }
    }

    public void stepForward() {

        switch (getDirection()) {
            case UP:
                this.y = y+1;
                break;
            case DOWN:
                this.y = y-1;
                break;
            case LEFT:
                this.x = x-1;
                break;
            case RIGHT:
                this.x = x+1;
                break;
        }
    }
    public static void moveRobotTo(RobotConnectionManager robotConnectionManager, int toX, int toY) {

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

    @Override
    public String toString() {
        return "Robot{" +
                "x=" + x +
                ", y=" + y +
                ", direction=" + direction +
                '}';
    }
}