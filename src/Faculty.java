import java.util.HashSet;
import java.util.Set;

public class Faculty {
    private String name;
    private Set<String> specialties;

    public Faculty(String name) {
        this.name = name;
        this.specialties = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public Set<String> getSpecialties() {
        return specialties;
    }

    public void addSpecialities(String nameOfSpeciality) {
        if (nameOfSpeciality.length() > 0) {
            this.specialties.add(nameOfSpeciality);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Faculty ");
        sb.append("\'").append(name).append('\'');
        sb.append(" with specialties ").append(specialties);
        return sb.toString();
    }
}
