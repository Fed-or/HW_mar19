package com.fedor.homeworks.hw7.handler;

import com.fedor.homeworks.hw7.dao.ClientDao;
import com.fedor.homeworks.hw7.dao.HumanDao;
import com.fedor.homeworks.hw7.di.InjectClient;
import com.fedor.homeworks.hw7.di.InjectHuman;
import com.fedor.homeworks.hw7.model.Client;
import com.fedor.homeworks.hw7.model.Human;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ConsoleHandler {

    @InjectClient
    private static ClientDao clientDao;

    @InjectHuman
    private static HumanDao humanDao;

    public void handle() throws IOException, ClassNotFoundException {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("If saving client - enter \"1\"; \n" +
                    "if getting client - enter \"2\"; \n if you saving human - enter \"3\"; \n" +
                    "if you getting human - enter \"4\"; \n if you want to exit - enter \"5\".\n");
            int consoleChoise = scanner.nextInt();
            switch (consoleChoise) {
                case 1:
                    addClientInfo(scanner);
                    break;
                case 2:
                    System.out.println("Enter name of client");
                    String name = scanner.next();
                    System.out.println(clientDao.get(name));
                    break;
                case 3:
                    addHumanInfo(scanner);
                    break;
                case 4:
                    System.out.println("Enter name of human");
                    String nameHuman = scanner.next();
                    System.out.println(humanDao.get(nameHuman));
                    break;
                case 5:
                    return;
            }
        }
    }

    private void addClientInfo(Scanner scanner) {
        System.out.printf("Info about client: \n");
        System.out.println("Enter clients name");
        String name = scanner.next();
        System.out.println("Enter clients phone number");
        String phone = scanner.next();
        Client client = new Client(name, phone);
        clientDao.save(client);
    }

    private void addHumanInfo(Scanner scanner) {
        System.out.printf("Info about human: \n");
        System.out.println("Enter humans name");
        String name = scanner.next();
        System.out.println("Enter humans address");
        String address = scanner.next();
        Human human = new Human(name, address);
        humanDao.save(human);
    }
}
