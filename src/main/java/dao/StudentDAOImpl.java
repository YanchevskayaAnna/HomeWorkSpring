package dao;

import dao.intefaces.StudentDAO;
import model.Mark;
import model.Student;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

//    private static final Logger LOGGER = Logger.getLogger(StudentDAOImpl.class);

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Student> getAll() {

        TypedQuery<Student> namedQuery = manager.createNamedQuery("Student.getAll", Student.class);
        return namedQuery.getResultList();
    }

    @Override
    public Student getEntityById(Integer id) {
        return manager.find(Student.class, id);
    }

    @Override
    public boolean update(Student entity) {
//        LOGGER.info("update student");
        if(getEntityById(entity.getId()) != null) {
            manager.merge(entity);
        }
        return true;
    }

    @Override
    public Student create(Student entity) {
//        LOGGER.info("create new student");
        manager.persist(entity);
        return entity;
    }

    @Override
    public boolean delete(Student entity) {
//        LOGGER.info("delete student");
        manager.remove(manager.contains(entity) ? entity : manager.merge(entity));
        return true;
    }

    public void deleteAll() {
        manager.createQuery("DELETE FROM Student s").executeUpdate();
    }

}
