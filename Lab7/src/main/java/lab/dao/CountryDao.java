package lab.dao;

import java.util.List;

import lab.model.Country;
import org.springframework.transaction.annotation.Transactional;

public interface CountryDao {

	void save(Country country);

	List<Country> getAllCountries();

	Country getCountryByName(String name);

}