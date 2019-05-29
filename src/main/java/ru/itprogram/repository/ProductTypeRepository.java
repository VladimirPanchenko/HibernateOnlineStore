package ru.itprogram.repository;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itprogram.entity.dao.ProductType;
import ru.itprogram.utils.generater.ArrayListGenerate;
import ru.itprogram.utils.generater.dao.ProductTypeGenerate;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class ProductTypeRepository implements Repository<ProductType> {
    @Autowired
    private ArrayListGenerate arrayListGenerate;
    @Autowired
    private ProductTypeGenerate productTypeGenerate;
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<ProductType> getAllEntity() {
        CriteriaQuery<ProductType> query = entityManager.getCriteriaBuilder().createQuery(ProductType.class);
        query.from(ProductType.class);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void saveEntity(ProductType productType) {
        entityManager.getTransaction().begin();
        entityManager.merge(productType);
        entityManager.getTransaction().commit();
    }
}
