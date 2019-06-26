package controller;

import dao.DaoInterface;
import lib.Inject;
import model.City;

public class CityConsoleHandler implements Handler {

    @Inject
    private static DaoInterface<City> cityDao;

    @Override
    public void handle() {
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
