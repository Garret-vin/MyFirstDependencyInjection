package controller;

import dao.DaoInterface;
import lib.Inject;
import model.Bet;
import model.City;

import java.util.Scanner;

public class ConsoleHandler {

    private static Scanner scanner = new Scanner(System.in);

    @Inject
    private static DaoInterface<Bet> betDao;

    @Inject
    private static DaoInterface<City> cityDao;

    public static void handleBet() {
        try {
            while (scanner.hasNext()) {
                String command = scanner.nextLine();
                if (command.equals("0")) {
                    return;
                }
                String[] data = command.split(" ");
                int value = Integer.parseInt(data[0]);
                double risk = Double.parseDouble(data[1]);
                Bet bet = new Bet(value, risk);
                betDao.add(bet);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Данные введены некорректно");
        }
    }

    public static void handleCity() {
        try {
            while (scanner.hasNext()) {
                String command = scanner.nextLine();
                if (command.equals("0")) {
                    return;
                }
                String[] data = command.split(" ");
                int population = Integer.parseInt(data[1]);
                City city = new City(data[0], population);
                cityDao.add(city);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Данные введены некорректно");
        }
    }
}

