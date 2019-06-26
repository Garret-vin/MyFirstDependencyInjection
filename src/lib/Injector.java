package lib;

import controller.BetConsoleHandler;
import controller.CityConsoleHandler;
import dao.BetDaoImpl;
import dao.CityDaoImpl;
import dao.DaoInterface;
import factory.BetDaoFactory;
import factory.CityDaoFactory;

import java.lang.reflect.Field;

public class Injector {

    public static void injectDependency() throws IllegalAccessException {
        Class<BetConsoleHandler> betConsoleHandlerClass = BetConsoleHandler.class;
        Class<CityConsoleHandler> cityConsoleHandlerClass = CityConsoleHandler.class;
        Class<BetDaoImpl> betDaoClass = BetDaoImpl.class;
        Class<CityDaoImpl> cityDaoClass = CityDaoImpl.class;
        Class<DaoInterface> daoInterface = DaoInterface.class;

        Field[] betConsoleHandlerFields = betConsoleHandlerClass.getDeclaredFields();
        for (Field field : betConsoleHandlerFields) {
            if (field.isAnnotationPresent(Inject.class)) {
                if (field.getType().equals(daoInterface)
                        && betDaoClass.isAnnotationPresent(Dao.class)) {
                    field.setAccessible(true);
                    field.set(null, BetDaoFactory.getInstance());
                }
            }
        }

        Field[] cityConsoleHandlerFields = cityConsoleHandlerClass.getDeclaredFields();
        for (Field field : cityConsoleHandlerFields) {
            if (field.isAnnotationPresent(Inject.class)) {
                if (field.getType().equals(daoInterface)
                        && cityDaoClass.isAnnotationPresent(Dao.class)) {
                    field.setAccessible(true);
                    field.set(null, CityDaoFactory.getInstance());
                }
            }
        }
    }
}
