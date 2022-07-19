public class Group {
    private String name;
    private String speciality;
    private String faculty;

    public Group(String name, String speciality, String faculty) {
        this.name = name;
        this.speciality = speciality;
        this.faculty = faculty;
    }

    public String getName() {
        return name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public String getFaculty() {
        return faculty;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Group name:");
        sb.append("\'").append(name).append('\'');
        sb.append(", speciality='").append(speciality).append('\'');
        sb.append(", faculty='").append(faculty).append('\'');
        return sb.toString();
    }
}
