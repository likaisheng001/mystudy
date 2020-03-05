package designmodel.iterator;

/**
 * Created by Administrator on 2019/8/30.
 */
public class Department {
    private String name;

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                '}';
    }

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
