package lib;

import controller.ConsoleHandler;
import dao.BetDaoImpl;
import dao.CityDaoImpl;
import factory.BetDaoFactory;
import factory.CityDaoFactory;

import java.lang.reflect.Field;

public class Injector {

    public static void injectDependency() throws IllegalAccessException {
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Class<BetDaoImpl> betDaoClass = BetDaoImpl.class;
        Class<CityDaoImpl> cityDaoClass = CityDaoImpl.class;

        Field[] consoleHandlerFields = consoleHandlerClass.getDeclaredFields();
        for (Field field : consoleHandlerFields) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                String fieldName = field.getName();
                switch (fieldName) {
                    case "betDao":
                        if (betDaoClass.isAnnotationPresent(Dao.class)) {
                            field.set(null, BetDaoFactory.getInstance());
                        }
                        break;
                    case "cityDao":
                        if (cityDaoClass.isAnnotationPresent(Dao.class)) {
                            field.set(null, CityDaoFactory.getInstance());
                        }
                        break;
                }
            }
        }
    }
}
