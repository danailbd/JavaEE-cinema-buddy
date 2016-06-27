package dao.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Theater {

    @Id
    @GeneratedValue
    private int id;

    private int capacity;

    @Enumerated(EnumType.STRING)
    private Type type;

    public int getId() {
        return id;
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

    // We want to access all projections for theater
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Projection> projections = new ArrayList();

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
