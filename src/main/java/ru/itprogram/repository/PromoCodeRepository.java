package ru.itprogram.repository;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itprogram.entity.dao.PromoCode;
import ru.itprogram.utils.generater.ArrayListGenerate;
import ru.itprogram.utils.generater.dao.PromoCodeGenerate;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class PromoCodeRepository implements Repository<PromoCode> {
    @Autowired
    private ArrayListGenerate arrayListGenerate;
    @Autowired
    private PromoCodeGenerate promoCodeGenerate;
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<PromoCode> getAllEntity() {
        CriteriaQuery<PromoCode> query = entityManager.getCriteriaBuilder().createQuery(PromoCode.class);
        query.from(PromoCode.class);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void saveEntity(PromoCode promoCode) {
        entityManager.getTransaction().begin();
        entityManager.merge(promoCode);
        entityManager.getTransaction().commit();
    }
}
