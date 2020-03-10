package com.panda.study.designmodel_gp.decorator.goodhomework01;/**
 * Created by My on 2020-03-07.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:24:59 2020-03-07
 * @Modified By:
 */
public class Test {
    private static void getNavs(User user){
        INav nav = new BaseNav();

        nav = new QANavWrapper(nav);
        nav = new ArticleNavWrapper(nav);

        if (user != null && LoginManager.isLogin(user)){
            nav = new HomeworkNavWrapper(nav);
            nav = new QuestionsNavWrapper(nav);
            nav = new GrowupWallNavWrapper(nav);
            nav = new BrilliantNavWrapper(nav);
        }

        nav = new BubbleUpNavWrapper(nav);
        nav = new MallNavWrapper(nav);

        System.out.println(nav.getNavs());
    }

    public static void main(String[] args) {
        System.out.println("未登录");
        getNavs(null);
        System.out.println("-------------------");

        User user = new User().setUserName("huiyuan");
        LoginManager.login(user);
        System.out.println("已登录");
        getNavs(user);
    }
}
