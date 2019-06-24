package dao;

import db.Storage;
import lib.Dao;
import model.City;

import java.util.List;

@Dao
public class CityDaoImpl implements DaoInterface<City> {

    @Override
    public void add(City city) {
        Storage.cities.add(city);
    }

    @Override
    public List<City> getAll() {
        return Storage.cities;
    }
}
