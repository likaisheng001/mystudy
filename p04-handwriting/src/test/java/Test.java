/**
 * Created by My on 2020-01-04.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 15:26:53 2020-01-04
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(test());

    }
    private static int test() {
        int temp = 1;
        try {
            System.out.println(temp);
            return ++temp;
        } catch (Exception e) {
            System.out.println(temp);
            return ++temp;
        } finally {
            ++temp;
            System.out.println(temp);
        }
    }
}
