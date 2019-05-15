public class Student {

    private final String name;
    private final double age;
    private final int mark;

    public Student(String name, double age, int mark) {
        this.name = name;
        this.age = age;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public double getAge() {
        return age;
    }

    public int getMark() {
        return mark;
    }

    @Override
    public String toString() {
        return "\nName: " + getName() + "\nAge: " + getAge() + "\nMark: " + getMark();
    }
}
