package com.fedor.homeworks.robot;


public class Main {

    public static void main(String[] args) {
        Robot robot = new Robot(0, 0, Direction.UP);
        System.out.println(robot);
        System.out.println();

        robot.stepForward();
        System.out.println(robot);
        System.out.println();

        robot.stepForward();
        robot.turnLeft();
        System.out.println(robot);

        RobotConnectManager robotConnectManager = new RobotConnectManager();
        Robot.moveRobotTo(robotConnectManager, 3, 4);
        System.out.println(robot);
        }
}