package service;

import dao.intefaces.*;
import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AdminController {

    @Autowired
    private GroupDAO groupDAO;

    @Autowired
    private SubjectDAO subjectDAO;

    @Autowired
    private TeacherDAO teacherDAO;

    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private MarkDAO markDAO;

    public AdminController() {
    }

    //MARKS
    public List<Mark> getAllMarks() {
        return markDAO.getAll();
    }

    public Mark getMarkById(Integer id) {
        return markDAO.getEntityById(id);
    }

    public boolean updateMark(Mark mark) {
        return markDAO.update(mark);
    }

    public Mark createMark(Mark mark) {
        return markDAO.create(mark);
    }

    public boolean deleteMark(String tableName, int id) {
//       return teacherDAO.delete(String tableName, int id);
        return false;
    }

    public void deleteAllMarks() {
        markDAO.deleteAll();
    }

    //TEACHERS
    public List<Teacher> getAllTeachers() {
        return teacherDAO.getAll();
    }

    public Teacher getTeacherById(Integer id) {
        return teacherDAO.getEntityById(id);
    }

    public boolean updateTeacher(Teacher teacher) {
        return teacherDAO.update(teacher);
    }

    public Teacher createTeacher(Teacher teacher) {
        return teacherDAO.create(teacher);
    }

    public boolean deleteTeacher(String tableName, int id) {
//       return teacherDAO.delete(String tableName, int id);
        return false;
    }

    //SUBJECTS
    public List<Subject> getAllSubjects() {
        return subjectDAO.getAll();
    }

    public Subject getSubjectById(Integer id) {
        return subjectDAO.getEntityById(id);
    }

    public boolean updateSubject(Subject subject) {
        return subjectDAO.update(subject);
    }

    public Subject createSubject(Subject subject) {
        return subjectDAO.create(subject);
    }

    public boolean deleteSubject(String tableName, int id) {
        return false;
    }

    public void deleteAllSubjects() {
        subjectDAO.deleteAll();
    }

    //STUDENTS
    public List<Student> getAllStudents() {
        return studentDAO.getAll();
    }

    public Student getStudentById(Integer id) {
        return studentDAO.getEntityById(id);
    }

    public boolean updateStudent(Student student) {
        return studentDAO.update(student);
    }

    public Student createStudent(Student student) {
        return studentDAO.create(student);
    }

    public boolean deleteStudent(String tableName, int id) {
        return false;
    }

    public List<Group> getAllGroupsWithSubject(Subject subject, int start, int end) {
        return groupDAO.getAllGroupsWithSubject(subject, start, end);
    }

    public void deleteAllStudents() {
        studentDAO.deleteAll();
    }


    //GROUP
    public List<Group> getAllGroups() {
        return groupDAO.getAll();
    }

    public Group getGroupById(Integer id) {
        return groupDAO.getEntityById(id);
    }

    public boolean updateGroup(Group group) {
        return groupDAO.update(group);
    }

    public Group createGroup(Group group) {
        return groupDAO.create(group);
    }

    public boolean deleteGroup(Group group) {
        return groupDAO.delete(group);
    }

    public void deleteAllGroups() {
        groupDAO.deleteAll();
    }

    //    -узнать средний бал студентов по физике (всех и определенной группы)
    public int getAverageRating(Subject subject) {

        return groupDAO.getAverageRating(subject);
    }

    public int getAverageRating(Subject subject, Group group) {
        return groupDAO.getAverageRating(subject, group);
    }

    public int getAverageRatingGroup(Group group) {
        return groupDAO.getAverageRatingGroup(group);
    }
//    -показать группу, в которой более 3-х студентов изучают философию (и выгнать с универа)

    public Map<Student, Integer> getAverageRating() {
        return groupDAO.getAverageRating();
    }

    public void deleteAllSubjectsFromGroups() {
        groupDAO.deleteAllSubjectsFromGroups();
    }

    public void deleteAllGroupsFromSubjects() {
        subjectDAO.deleteAllGroupsFromSubjects();
    }

    public GroupDAO getGroupDAO() {
        return groupDAO;
    }

    public void setGroupDAO(GroupDAO groupDAO) {
        this.groupDAO = groupDAO;
    }

    public SubjectDAO getSubjectDAO() {
        return subjectDAO;
    }

    public void setSubjectDAO(SubjectDAO subjectDAO) {
        this.subjectDAO = subjectDAO;
    }

    public TeacherDAO getTeacherDAO() {
        return teacherDAO;
    }

    public void setTeacherDAO(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    public StudentDAO getStudentDAO() {
        return studentDAO;
    }

    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }


}
