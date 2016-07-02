package dao.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Theater implements Serializable {

    @Id
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private int capacity;

    @Enumerated(EnumType.STRING)
    private Type type;

    public Theater() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    // We want
    @OneToMany(targetEntity=Projection.class, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "projection_id")
    private List<Projection> projections;

    public List<Projection> getProjections () {
        return projections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Theater theater = (Theater) o;

        if (getId() != theater.getId()) return false;
        if (getCapacity() != theater.getCapacity()) return false;
        return getType() == theater.getType();

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getCapacity();
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        return result;
    }
}
