package dao;

import dao.intefaces.SubjectDAO;
import model.Group;
import model.Subject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class SubjectDAOImpl implements SubjectDAO {

//    private static final Logger LOGGER = Logger.getLogger(SubjectDAOImpl.class);

    @PersistenceContext
    private EntityManager manager;

    public EntityManager getManager() {
        return manager;
    }

    public void setManager(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public List<Subject> getAll() {
        TypedQuery<Subject> namedQuery = manager.createNamedQuery("Subject.getAll", Subject.class);
        return namedQuery.getResultList();
    }

    @Override
    public Subject getEntityById(Integer id) {
        return manager.find(Subject.class, id);
    }

    @Override
    public boolean update(Subject entity) {
//        LOGGER.info("subject group");
        if (getEntityById(entity.getId()) != null) {
            manager.merge(entity);
        }

        return true;
    }

    public void deleteAllGroupsFromSubjects() {

        for (Subject subject: getAll()){
            subject.setGroupList(null);
            update(subject);
        }
    }

    @Override
    public Subject create(Subject entity) {

//        LOGGER.info("create new subject");
        manager.persist(entity);

        return entity;
    }

    @Override
    public boolean delete(Subject entity) {
//        LOGGER.info("delete subject");
        manager.remove(manager.contains(entity) ? entity : manager.merge(entity));
        return true;
    }

    public void deleteAll() {
        manager.createQuery("DELETE FROM Subject s").executeUpdate();
    }

}
