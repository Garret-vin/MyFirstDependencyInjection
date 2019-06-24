package factory;

import dao.CityDaoImpl;
import dao.DaoInterface;

public class CityDaoFactory {

    private static DaoInterface instance;

    public static DaoInterface getInstance() {
        if (instance == null) {
            instance = new CityDaoImpl();
        }
        return instance;
    }
}
