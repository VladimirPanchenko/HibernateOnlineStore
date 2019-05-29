package ru.itprogram.repository;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itprogram.entity.dao.Order;
import ru.itprogram.utils.generater.ArrayListGenerate;
import ru.itprogram.utils.generater.dao.OrderGenerate;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class OrderRepository implements Repository<Order> {
    @Autowired
    private ArrayListGenerate arrayListGenerate;
    @Autowired
    private OrderGenerate orderGenerate;
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Order> getAllEntity() {
        CriteriaQuery<Order> query = entityManager.getCriteriaBuilder().createQuery(Order.class);
        query.from(Order.class);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void saveEntity(Order order) {
        entityManager.getTransaction().begin();
        entityManager.merge(order);
        entityManager.getTransaction().commit();
    }
}
