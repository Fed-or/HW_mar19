package com.fedor.homeworks.hw10.robot;


public class Main {

    public static void main(String[] args) {
        Robot robot = new Robot(0, 0, Direction.UP);
        System.out.println(robot.getX());
        System.out.println(robot.getY());
        System.out.println(robot.getDirection());
        System.out.println();


        robot.stepForward();
        System.out.println(robot.getX());
        System.out.println(robot.getY());
        System.out.println(robot.getDirection());
        System.out.println();

        robot.stepForward();
        robot.turnLeft();
        System.out.println(robot.getDirection());
        System.out.println(robot.getX());
        System.out.println(robot.getY());

        RobotConnectionManager robotConnectManager = new RobotConnectManager();
        robot.moveRobot(robotConnectManager, 3, 4);
        }
}