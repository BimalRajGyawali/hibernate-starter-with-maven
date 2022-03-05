package me.personal.repo;

import me.personal.config.HibernateConfig;
import me.personal.entity.Customer;
import org.hibernate.SessionFactory;

import java.util.List;

public class CustomerRepoImpl implements CustomerRepo {
    private final SessionFactory sessionFactory;

    public CustomerRepoImpl() {
        this.sessionFactory = HibernateConfig.getSessionFactory();
    }

    @Override
    public Long save(Customer customer) {
        var session = sessionFactory.openSession();
        var transaction = session.beginTransaction();

        session.persist(customer);

        transaction.commit();
        session.close();

        return customer.id();

    }

    @Override
    public Customer findById(Long id) {
        var session = sessionFactory.openSession();

        var customer = session.find(Customer.class, id);

        session.close();

        return customer;
    }

    @Override
    public List<Customer> findByFullName(String fullName) {
        var session = sessionFactory.openSession();

        var query = session.createSQLQuery("select * from customer c where fullname=:fullName");

        query.setParameter("fullName", fullName);
        query.addEntity(Customer.class);

        return query.list();
    }

    @Override
    public List<Customer> findByAddress(String address) {
        var session = sessionFactory.openSession();

        var cb = session.getCriteriaBuilder();
        var cq = cb.createQuery(Customer.class);
        var root = cq.from(Customer.class);
        cq
                .select(root)
                .where(
                        cb.equal(root.get("address"), address)
                );

        var customers = session.createQuery(cq).getResultList();

        session.close();

        return customers;
    }
}
