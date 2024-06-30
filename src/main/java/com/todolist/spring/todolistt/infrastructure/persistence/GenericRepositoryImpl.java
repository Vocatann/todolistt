package com.todolist.spring.todolistt.infrastructure.persistence;
import com.todolist.spring.todolistt.core.domain.repository.GenericRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public class GenericRepositoryImpl<T> implements GenericRepository<T, Long> {

    @PersistenceContext
    EntityManager em;

    Class<T> entityType;

    public GenericRepositoryImpl(Class<T> entityType) {
        this.entityType = entityType;
    }

    @Override
    public void save(T entity) {
        if (em.contains(entity)) {
            em.merge(entity);
        } else {
            em.persist(entity);
        }
    }

    @Override
    public Optional<T> findById(Long id) {
        return Optional.ofNullable(em.find(entityType, id));
    }

    @Override
    public List<T> findAll() {
        TypedQuery<T> query = em.createQuery("SELECT e FROM " + entityType.getSimpleName() + " e", entityType);
        return query.getResultList();
    }

    @Override
    public void deleteById(Long aLong) {

    }
}
