package model.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.datasource.H2JPAConnection;
import model.entity.FlashcardSet;

import java.util.List;

public class FlashcardSetDao {

    public void persist(FlashcardSet flashcardSet) {
        try (EntityManager em = H2JPAConnection.createEntityManager()) {
            em.getTransaction().begin();
            try {
                em.persist(flashcardSet);
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
                throw e;
            }
        }
    }

    public FlashcardSet find(int flashcardSetId) {
        try (EntityManager em = H2JPAConnection.createEntityManager()) {
            return em.find(FlashcardSet.class, Integer.valueOf(flashcardSetId));
        }
    }

    public List<FlashcardSet> findAll() {
        try (EntityManager em = H2JPAConnection.createEntityManager()) {
            TypedQuery<FlashcardSet> query = em.createQuery(
                    "SELECT fs FROM FlashcardSet fs", FlashcardSet.class
            );
            return query.getResultList();
        }
    }

    public void update(FlashcardSet flashcardSet) {
        try (EntityManager em = H2JPAConnection.createEntityManager()) {
            em.getTransaction().begin();
            try {
                em.merge(flashcardSet);
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
                throw e;
            }
        }
    }

    public void delete(FlashcardSet flashcardSet) {
        try (EntityManager em = H2JPAConnection.createEntityManager()) {
            em.getTransaction().begin();
            try {
                if (!em.contains(flashcardSet)) {
                    flashcardSet = em.merge(flashcardSet);
                }
                em.remove(flashcardSet);
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
                throw e;
            }
        }
    }

    public List<FlashcardSet> findByClassId(int classId) {
        try (EntityManager em = H2JPAConnection.createEntityManager()) {
            TypedQuery<FlashcardSet> query = em.createQuery(
                    "SELECT fs FROM FlashcardSet fs WHERE fs.classModel.classId = :cid",
                    FlashcardSet.class
            );
            query.setParameter("cid", classId);
            return query.getResultList();
        }
    }

    public boolean existsBySubjectInClass(String subject, int classId) {
        try (EntityManager em = H2JPAConnection.createEntityManager()) {
            TypedQuery<Long> query = em.createQuery(
                    "SELECT COUNT(fs) FROM FlashcardSet fs " +
                            "WHERE fs.subject = :subject AND fs.classModel.classId = :cid",
                    Long.class
            );
            query.setParameter("subject", subject);
            query.setParameter("cid", classId);

            return query.getSingleResult() > 0;
        }
    }

public FlashcardSet findWithCards(int id) {
    try (EntityManager em = H2JPAConnection.createEntityManager()) {
        return em.createQuery(
                "SELECT s FROM FlashcardSet s LEFT JOIN FETCH s.cards WHERE s.flashcardSetId = :id",
                FlashcardSet.class
        ).setParameter("id", id).getSingleResult();
    }
}
}