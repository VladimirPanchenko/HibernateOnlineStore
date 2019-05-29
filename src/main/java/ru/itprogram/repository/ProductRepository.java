package ru.itprogram.repository;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itprogram.entity.dao.Product;
import ru.itprogram.utils.*;
import ru.itprogram.utils.generater.ArrayListGenerate;
import ru.itprogram.utils.generater.dao.ProductGenerate;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class ProductRepository implements Repository<Product> {
    @Autowired
    private ArrayListGenerate arrayListGenerate;
    @Autowired
    private ProductGenerate productGenerate;
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Product> getAllEntity() {
        CriteriaQuery<Product> query = entityManager.getCriteriaBuilder().createQuery(Product.class);
        query.from(Product.class);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void saveEntity(Product product) {
        entityManager.getTransaction().begin();
        entityManager
                .createNativeQuery(InsertSql.INSERT_PRODUCT)
                .setParameter(1, product.getBrandId())
                .setParameter(2, product.getProductTypeId())
                .setParameter(3, product.getDescription())
                .setParameter(4, product.getQuantity())
                .setParameter(5, product.getWarranty())
                .setParameter(6, product.isAvailable())
                .setParameter(7, product.getPrice())
                .setParameter(8, product.getPromoCodId())
                .executeUpdate();
        entityManager.getTransaction().commit();
    }
}
