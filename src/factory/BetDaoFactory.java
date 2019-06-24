package factory;

import dao.BetDaoImpl;
import dao.DaoInterface;

public class BetDaoFactory {

    private static DaoInterface instance;

    public static DaoInterface getInstance() {
        if (instance == null) {
            instance = new BetDaoImpl();
        }
        return instance;
    }
}
