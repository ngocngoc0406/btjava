package ky2lab5;
public class Employee2 {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String role;

    public Employee2(int id, String name, int age, String gender, String role) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.role = role;
    }

    // các getter và setter

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee2 [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", role=" + role + "]";
    }

}
