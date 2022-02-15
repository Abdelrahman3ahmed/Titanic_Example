package commonscsv;

public class Person {
    private  String name;
    private  String email;
    private  String country;
    private  double salary;
    private  int experience;

    public Person(String name, String email, String country, int experience, double salary) {
        this.name = name;
        this.email = email;
        this.country = country;
        this.experience = experience;
        this.salary = salary;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", salary=" + salary +
                ", experience=" + experience +
                '}';
    }
}
