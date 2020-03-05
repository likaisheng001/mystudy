package designmodel.proxy.staticproxy;

/**
 * Created by Administrator on 2019/8/17.
 */
public class StaticProxyDemo {
    public static void main(String[] args) {
        ITeacherDao iTeacherDao = new TeacherDao();
        TeacherDaoProxy teacherDaoProxy = new TeacherDaoProxy(iTeacherDao);
        teacherDaoProxy.teach();

    }
}
interface ITeacherDao{
    void teach();
}
class TeacherDao implements ITeacherDao{

    @Override
    public void teach() {
        System.out.println("--------teaching-----------");
    }
}
class TeacherDaoProxy implements ITeacherDao{
    ITeacherDao iTeacherDao;

    public TeacherDaoProxy(ITeacherDao iTeacherDao) {
        this.iTeacherDao = iTeacherDao;
    }

    @Override
    public void teach() {
        System.out.println("-------代理开始--------");
        iTeacherDao.teach();
        System.out.println("----------代理结束-----------");
    }
}
