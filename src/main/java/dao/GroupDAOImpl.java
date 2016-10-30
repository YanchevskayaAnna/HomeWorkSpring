package dao;

import dao.intefaces.GroupDAO;
import model.Group;
import model.Student;
import model.Subject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class GroupDAOImpl implements GroupDAO {

//    private static final Logger LOGGER = Logger.getLogger(GroupDAOImpl.class);

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Group> getAll() {
        TypedQuery<Group> namedQuery = manager.createNamedQuery("Group.getAll", Group.class);
        return namedQuery.getResultList();
    }

    @Override
    public Group getEntityById(Integer id) {
        return manager.find(Group.class, id);
    }

    @Override
    public boolean update(Group entity) {

//        LOGGER.info("update group");

        if (getEntityById(entity.getId()) != null) {
            manager.merge(entity);
        }

        return true;
    }

    @Override
    public Group create(Group entity) {

//        LOGGER.info("create new group");
        manager.persist(entity);
        return entity;
    }

    @Override
    public boolean delete(Group entity) {

        Group found = manager.find(Group.class, entity.getId());
//        LOGGER.info("delete group");
        manager.remove(found);
        return true;
    }

    public void deleteAll() {
         manager.createQuery("DELETE FROM Group g").executeUpdate();
    }

    public void deleteAllSubjectsFromGroups() {

        for (Group group: getAll()){
            group.setSubjectList(null);
            update(group);
        }
    }


    public List<Group> getAllGroupsWithSubject(Subject subject, int start, int end) {

        TypedQuery<Group> query = manager.createQuery("SELECT n FROM Group n join n.subjectList s WHERE s.name = :subjectName", Group.class);
        query.setParameter("subjectName", subject.getName());

        return query.getResultList();

    }

    @Override
    public int getAverageRatingGroup(Group group) {

        TypedQuery<Double> query = manager.createQuery("SELECT AVG(m.value) FROM Student n join n.markList m join n.group s WHERE s.name = :groupName", Double.class);
        query.setParameter("groupName", group.getName());

        return query.getSingleResult().intValue();
    }

    @Override
    public int getAverageRating(Subject subject) {

        TypedQuery<Double> query = manager.createQuery("SELECT AVG(s.value) FROM Subject n join n.markList s WHERE n.name = :subjectName", Double.class);
        query.setParameter("subjectName", subject.getName());
        return query.getSingleResult().intValue();

    }

    public Map<Student, Integer> getAverageRating() {

        String queryString = "SELECT m.student,  AVG(m.value) FROM Mark m join m.subject s join m.student st join st.group g GROUP BY m.student";
        TypedQuery<Object[]> query = manager.createQuery(queryString, Object[].class);
        List<Object[]> resultList = query.getResultList();

        HashMap<Student, Integer> map = new HashMap<Student, Integer>();

        for (int i = 0; i < resultList.size(); i++) {
            map.put((Student) resultList.get(i)[0], ((Double) resultList.get(i)[1]).intValue());
        }

        return map;

    }

    public int getAverageRating(Subject subject, Group group) {

        TypedQuery<Double> query = manager.createQuery("SELECT AVG(m.value) FROM Mark m join m.subject s join m.student st join st.group g WHERE s.name = :subjectName and g.name = :groupName", Double.class);
        query.setParameter("groupName", group.getName());
        query.setParameter("subjectName", subject.getName());

        return query.getSingleResult().intValue();

    }
}
