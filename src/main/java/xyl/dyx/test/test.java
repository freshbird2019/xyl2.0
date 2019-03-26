package xyl.dyx.test;

import xyl.dyx.POJO.ManagerEntity;
import xyl.dyx.service.glyEntityService;

public class test {

    public static void main(String[] args) {

        /*
        Session session = hibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        ActivityEntity ac = new ActivityEntity();

        ac.setNum(5);
        ac.setTime("550");
        ac.setName("he");
        ac.setLocation("a");
        ac.setDescription("dd");

        System.out.println(ac.getAid());

        int id = (Integer) session.save(ac);

        System.out.println(id);

        tx.commit();
        session.close();
        */


        /*
        Object obj = new Object();
        Integer shuzi = new Integer(5);
        String zimu = new String("gly");
        obj = shuzi;

        System.out.println(obj);

        obj = zimu;

        System.out.println(obj);

        */

        /*
        * 测试这个查找功能
        *         Session session = hibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Test4Entity ts ;

        ts = session.get(Test4Entity.class,9);

        if(ts == null) {
            System.out.println("nope");
        } else {
            System.out.println("yes");
        }
        tx.commit();
        session.close();
         */


        ManagerEntity gly = new ManagerEntity();

        gly.setId("gly01");
        gly.setName("laomei");
        gly.setPassword("1");



        glyEntityService glyser = new glyEntityService();

        System.out.println(glyser.ifCorrect(gly));







    }
}

