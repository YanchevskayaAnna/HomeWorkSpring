package dto;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "student")
public class StudentDTO {

    private int id;
    private String name;

    public StudentDTO() {
    }

    public StudentDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @XmlAttribute(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
