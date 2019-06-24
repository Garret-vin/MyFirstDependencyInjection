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
            if (field.getDeclaredAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                String fieldName = field.getName();
                switch (fieldName) {
                    case "betDao":
                        if (betDaoClass.getDeclaredAnnotation(Dao.class) != null) {
                            field.set(null, BetDaoFactory.getInstance());
                        }
                        break;
                    case "cityDao":
                        if (cityDaoClass.getDeclaredAnnotation(Dao.class) != null) {
                            field.set(null, CityDaoFactory.getInstance());
                        }
                        break;
                }
            }
        }
    }
}
