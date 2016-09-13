package lab.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import lab.dao.CountryDao;
import lab.model.Country;

@Repository
public class CountryJpaDaoImpl extends AbstractJpaDao implements CountryDao {
    @Override
    public void save(Country country) {
        final EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(country);
        em.getTransaction().commit();

        em.close();
    }

    @Override
    public List<Country> getAllCountries() {
        final EntityManager em = emf.createEntityManager();

        final TypedQuery<Country> query = em.createQuery("from Country", Country.class);

        final List<Country> resultList = query.getResultList();
        em.close();
        return resultList;
    }

    @Override
    public Country getCountryByName(String name) {
        final EntityManager em = emf.createEntityManager();

        final TypedQuery<Country> query = em.createQuery("select c from Country c where c.name = :name", Country.class);
        query.setParameter("name", name);

        final Country singleResult = query.getSingleResult();
        em.close();
        return singleResult;
    }

}
