import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;


public class MainProgram {
    public static Scanner scanner = new Scanner(System.in);
    public static List<University> universities = new ArrayList<>();
    public static List<Faculty> faculties = new ArrayList<>();
    public static List<Group> groups = new ArrayList<>();
    public static List<Student> students = new ArrayList<>();

    public static University getUniversity(String name){
        for(int index=0;index<universities.size();index++){
            if(universities.get(index).getName().equals(name)){
                return universities.get(index);
            }
        }
        return null;
    }

    public static void addUniversity(University university) {
        if (university != null) {
            if (!universities.contains(university)) {
                universities.add(university);
            }
        }
    }

    public static void displayUniversities() {
        if (universities.size() > 0) {
            for (University u : universities) {
                System.out.println(u);
            }
        } else {
            System.out.println("Universities not found!");
        }
    }

    public static void displayAllInfo() {
        System.out.println("Universities:\n");
        if (universities.size() > 0) {
            for (University u : universities) {
                System.out.println(u);
            }
        }
        System.out.println("Faculties:\n");
        if (faculties.size() > 0) {
            for (Faculty u : faculties) {
                System.out.println(u);
            }
        }

        System.out.println("Groups:\n");
        if (groups.size() > 0) {
            for (Group u : groups) {
                System.out.println(u);
            }
        }

    }

    public static void addFaculty(Faculty faculty) {
        if (faculty != null) {
            if (!faculties.contains(faculty)) {
                faculties.add(faculty);
            }
        }
    }

    public static void removeFaculty(String name) {
        if (name.length() > 0) {
            Faculty f = faculties.stream().filter(x -> x.getName().equals(name)).findAny().orElse(null);
            if (f != null) {
                faculties.remove(f);
                System.out.println(name + " was removed!");
            } else {
                System.out.println(name + " doesn t exist!");
            }
        }
    }

    public static String displayUniversitiesNames() {
        String names = "";
        for (University u : universities) {
            names += u.getName() + ",";
        }
        return names;
    }

    public static String displayFacultyNames() {
        String names = "";
        for (Faculty f : faculties) {
            names += f.getName() + ",";
        }
        return names;
    }

    public static String displaySpecialityNames(String facultyName) {
        String specialities = "";
        for (Faculty fac : faculties) {
            if (fac.getName().equals(facultyName)) {
                specialities = fac.getSpecialties().toString();
            }

        }
        return specialities;
    }

    public static void addFacultyCase() {
        System.out.println("Please choose the name of the university:(from this list: "+ displayUniversitiesNames() + ")");
        String univ = scanner.next();

        System.out.println("Please insert the name of the faculty:"); //Faculty of Cybernetics, Statistics and Economic Informatics
        String name = scanner.next();
        Faculty f = new Faculty(name);

        getUniversity(univ).addFaculty(name);

        System.out.println("Do you want to add a speciality?(YES/NO)");
        String answerInside2 = scanner.next().toUpperCase();

        while (answerInside2.equals("YES")) {
            System.out.print("Please insert the name of the specifity:"); //JAVA,OOP
            String specialty = scanner.next();
            f.addSpecialities(specialty);

            System.out.println("Do you want to add a speciality?(YES/NO)");
            answerInside2 = scanner.next().toUpperCase();
        }
        addFaculty(f);
    }

    public static void addGroup(Group group) {
        if (group != null) {
            if (!groups.contains(group)) {
                groups.add(group);
                System.out.println("The \'" + group.getName() + "\' group was inserted");
            } else {
                System.out.println("The \'" + group.getName() + "\' group already exist");
            }
        }
    }

    public static void removeGroup(String name) {
//        if (name.length() > 0) {
//            Faculty f = faculties.stream().filter(x -> x.getName().equals(name)).findAny().orElse(null);
//            if (f != null) {
//                faculties.remove(f);
//                System.out.println(name + " was removed!");
//            } else {
//                System.out.println(name + " doesn t exist!");
//            }
//        }
    }

    public static void saveInFile() throws FileNotFoundException {
        try (PrintWriter file = new PrintWriter("file1.txt")) {
            for (var x : universities) {
                file.printf("%s,%s,%s%n", x.getName(), x.getAddress(), x.getFaculties());
            }
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Welcome to the console application for registering university students!");
        System.out.println("Do you want to make any changes?(YES/NO)");
        String answer = scanner.nextLine().toUpperCase();

        while (answer.equals("YES")) {
            System.out.println("What do you want to do? (Choose a functionality by inserting its code.)");
            System.out.println("1-Creation of the university");
            System.out.println("2-Adding and removing faculties");
            System.out.println("3-Adding and removing groups");
            System.out.println("4-report display info about universities");
            System.out.println("5-report display info about universities,faculties,groups");
            System.out.println("6-Save information about all universities in a text file");

            int code = scanner.nextInt();
            switch (code) {
                case 1 -> {
                    System.out.println("Please insert the name of the university:"); //ASE
                    String name = scanner.next();
                    System.out.println("Please insert the address of the university:");//Bucharest
                    String address = scanner.next();
                    addUniversity(new University(name, address));
                    break;
                }
                case 2 -> {
                    System.out.println("What do you want to do? (Choose a functionality by inserting its code.)");
                    System.out.println("1-Add a faculty");
                    System.out.println("2-Remove a faculty");
                    int answerInside = scanner.nextInt();
                    switch (answerInside) {
                        case 1 -> {
                            addFacultyCase();
                            break;
                        }
                        case 2 -> {
                            System.out.println("Please choose the name of the faculty:(from this list:" + displayFacultyNames() + ")");
                            String name = scanner.next();
                            removeFaculty(name);
                            break;
                        }
                    }
                }
                case 3 -> {
                    System.out.println("What do you want to do? (Choose a functionality by inserting its code.)");
                    System.out.println("1-Add a group");
                    System.out.println("2-Remove a group");
                    int answerInside = scanner.nextInt();
                    switch (answerInside) {
                        case 1 -> {
                            System.out.print("Please insert the name of the group:"); //Java exam
                            String name = scanner.next();
                            System.out.print("Please choose the faculty name of the group:(from this list:" + displayFacultyNames() + ")"); //Faculty of Cybernetics, Statistics and Economic Informatics
                            String faculty = scanner.next();
                            System.out.print("Please choose the specialty of the group:(from this list: " + displaySpecialityNames(faculty) + ")"); //Java
                            String specialty = scanner.next();
                            addGroup(new Group(name, specialty, faculty));
                            break;
                        }
                        case 2 -> {
                            System.out.print("Please insert the name of the group:"); //Faculty of Cybernetics, Statistics and Economic Informatics
                            String name = scanner.next();
                            removeFaculty(name);
                            break;
                        }
                    }
                }
                case 4 -> displayUniversities();
                case 5 -> displayAllInfo();
                case 6-> saveInFile();
            }

            System.out.println("Do you want to make any changes?(YES/NO)");
            answer = scanner.next().toUpperCase();
        }
        
    }
}
