package ru.itprogram.repository;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itprogram.entity.dao.Brand;
import ru.itprogram.utils.generater.ArrayListGenerate;
import ru.itprogram.utils.generater.dao.BrandGenerate;

import javax.persistence.EntityManager;
import java.util.List;

public class BrandRepository implements Repository<Brand> {
    @Autowired
    private ArrayListGenerate arrayListGenerate;
    @Autowired
    private BrandGenerate brandGenerate;
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Brand> getAllEntity() {
        return entityManager.createQuery("SELECT brand FROM Brand brand", Brand.class).getResultList();
    }

    @Override
    public void saveEntity(Brand brand) {
        entityManager.getTransaction().begin();
        entityManager.merge(brand);
        entityManager.getTransaction().commit();
    }
}
