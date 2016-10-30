package dao;

import dao.intefaces.MarkDAO;
import model.Group;
import model.Mark;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class MarkDAOImpl implements MarkDAO {

//    private static final Logger LOGGER = Logger.getLogger(MarkDAOImpl.class);

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Mark> getAll() {
        TypedQuery<Mark> namedQuery = manager.createNamedQuery("Mark.getAll", Mark.class);
        return namedQuery.getResultList();
    }

    @Override
    public Mark getEntityById(Integer id) {
        return manager.find(Mark.class, id);
    }

    @Override
    public boolean update(Mark entity) {

//        LOGGER.info("update mark");
        if(getEntityById(entity.getId()) != null) {
            manager.merge(entity);
        }

        return true;
    }

    @Override
    public Mark create(Mark entity) {

//        LOGGER.info("create mark");
        manager.persist(entity);

        return entity;
    }

    @Override
    public boolean delete(Mark entity) {

//        LOGGER.info("delete mark");
        manager.remove(manager.contains(entity) ? entity : manager.merge(entity));
        return true;
    }

    public void deleteAll(){
        manager.createQuery("DELETE FROM Mark m").executeUpdate();
    }
}
