import java.util.HashSet;
import java.util.Set;

public class University {
    private String name;
    private String address;
    private Set<String> faculties;//set store unique data about name of faculties

    public University(String name, String address) {
        this.name = name;
        this.address = address;
        this.faculties = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Set<String> getFaculties() {
        return faculties;
    }

    public void addFaculty(String nameOfFaculty) {
        if (nameOfFaculty.length() > 0) {
            this.faculties.add(nameOfFaculty);
        }
    }
    public void removeFaculty(String nameOfFaculty) {
        if (nameOfFaculty.length() > 0) {
            if(this.faculties.contains(nameOfFaculty))
            this.faculties.remove(nameOfFaculty);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("University \'");
        sb.append(name).append('\'');
        sb.append(", with the address \'").append(address).append('\'');
        if(faculties.size()>0){
            sb.append(",and with faculties ").append(faculties);
        }
        return sb.toString();
    }
}
