package main.java.database.dao;

import main.java.database.model.ResultPoint;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ResultPointDAO {

    private EntityManager entityManager;

    public ResultPointDAO(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-persistence");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public ResultPoint insertPoint(ResultPoint point) {
        EntityTransaction tran = entityManager.getTransaction();
        try{
            tran.begin();
            entityManager.persist(point);
            tran.commit();
        } catch (Exception e) {
            tran.rollback();
        }
        return point;
    }

    public ResultPoint findResultPoint(String id) {
        return entityManager.find(ResultPoint.class, id);
    }

    public List<ResultPoint> findAllPoints() {
        TypedQuery<ResultPoint> query = entityManager.createQuery("Select e from ResultPoint e", ResultPoint.class);
        return query.getResultList();
    }
}
