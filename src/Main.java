import controller.BetConsoleHandler;
import controller.CityConsoleHandler;
import controller.Handler;
import dao.BetDaoImpl;
import dao.CityDaoImpl;
import dao.DaoInterface;
import lib.Injector;

public class Main {

    static {
        try {
            Injector.injectDependency();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Если хотите сделать ставку, введите \n" +
                "сумму и риск через пробел (Для завершения работы введите 0):");
        Handler betConsoleHandler = new BetConsoleHandler();
        betConsoleHandler.handle();
        DaoInterface betDao = new BetDaoImpl();
        System.out.println(betDao.getAll() + "\n");

        System.out.println("Для внесения города в реестр, введите \n" +
                "Название и численность населения через пробел (Для завершения работы введите 0):");
        Handler cityConsoleHandler = new CityConsoleHandler();
        cityConsoleHandler.handle();
        DaoInterface cityDao = new CityDaoImpl();
        System.out.println(cityDao.getAll() + "\n");
    }
}
