package ru.itprogram.repository;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itprogram.entity.dao.User;
import ru.itprogram.utils.*;
import ru.itprogram.utils.generater.ArrayListGenerate;
import ru.itprogram.utils.generater.dao.UserGenerate;

import javax.persistence.EntityManager;
import java.util.List;

public class UserRepository implements Repository<User> {
    @Autowired
    private ArrayListGenerate arrayListGenerate;
    @Autowired
    private UserGenerate userGenerate;
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> getAllEntity() {
        return entityManager.createQuery("SELECT user FROM User user", User.class).getResultList();
    }

    @Override
    public void saveEntity(User user) {
        entityManager.getTransaction().begin();
        entityManager
                .createNativeQuery(InsertSql.INSERT_USER)
                .setParameter(1, user.isAdministrator())
                .setParameter(2, user.getName())
                .setParameter(3, user.getEmail())
                .setParameter(4, user.getPhone())
                .setParameter(5, user.getPassword())
                .executeUpdate();
        entityManager.getTransaction().commit();
    }
}
