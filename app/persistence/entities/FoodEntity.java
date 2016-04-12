package persistence.entities;

import javax.persistence.*;

@Table(name = "foods")
@Entity
public class FoodEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "food_group", nullable = false)
    private String foodGroup;

    @Column(name = "severity", nullable = false)
    private String severity;

    @Column(name = "information", nullable = false)
    private String information;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getGroup() {
        return foodGroup;
    }

    public void setGroup(String group) {
        this.foodGroup = group;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

}
