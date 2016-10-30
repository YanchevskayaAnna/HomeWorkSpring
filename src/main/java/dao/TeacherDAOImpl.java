package dao;

import dao.intefaces.TeacherDAO;
import model.Teacher;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class TeacherDAOImpl implements TeacherDAO {

//    private static final Logger LOGGER = Logger.getLogger(TeacherDAOImpl.class);

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Teacher> getAll() {
        TypedQuery<Teacher> namedQuery = manager.createNamedQuery("Teacher.getAll", Teacher.class);
        return namedQuery.getResultList();
    }

    @Override
    public Teacher getEntityById(Integer id) {
        return manager.find(Teacher.class, id);
    }

    @Override
    public boolean update(Teacher entity) {
//        LOGGER.info("update group");
        if(getEntityById(entity.getId()) != null) {
            manager.merge(entity);
        }
        return true;
    }

    @Override
    public Teacher create(Teacher entity) {
//        LOGGER.info("create new teacher");
        manager.persist(entity);
        return entity;
    }

    @Override
    public boolean delete(Teacher entity) {
//        LOGGER.info("delete teacher");
        manager.remove(manager.contains(entity) ? entity : manager.merge(entity));
        return true;
    }

    public void deleteAll() {
        manager.createQuery("DELETE FROM Teacher t").executeUpdate();
    }
}
