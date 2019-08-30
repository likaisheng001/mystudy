package designmodel.iterator;

/**
 * Created by Administrator on 2019/8/30.
 */
public interface Iterator<E> {
    boolean hasNext();
    E next();
    void remove();
}
