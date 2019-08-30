package designmodel.iterator;

/**
 * Created by Administrator on 2019/8/30.
 */
public class Client {
    public static void main(String[] args) {
        OutputImpl university = new OutputImpl();
        InfoColleage infoColleage = new InfoColleage();
        ComputerCollege computerCollege = new ComputerCollege();
        Department department1 = new Department("java工程师");
        Department department2 = new Department("大数据工程师");
        Department department3 = new Department("前端工程师");
        Department department4 = new Department("网络信息安全");
        Department department5 = new Department("电子技术");
        infoColleage.addDepartment(department4);
        infoColleage.addDepartment(department5);
        computerCollege.addDepartment(department1);
        computerCollege.addDepartment(department2);
        computerCollege.addDepartment(department3);
        university.addCollege(computerCollege);
        university.addCollege(infoColleage);
        System.out.println("输出学校信息");
        university.show();
    }
}