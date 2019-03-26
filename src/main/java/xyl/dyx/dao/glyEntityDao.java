package xyl.dyx.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import xyl.dyx.POJO.ManagerEntity;
import xyl.dyx.controller.hibernateUtil;

import java.util.List;

/*
 * 管理员账号由校方提供
 */
@Repository("glyEntityDao")
public class glyEntityDao implements dao{

    public boolean add(Object object) {
        /*
        * 暂不提供管理员注册功能
         */
        return false;
    }

    public boolean delete(Object id) {
        /*
        * 管理员账号无删除操作
         */
        return false;
    }

    /*
    * 管理员信息无需编辑
     */
    public boolean edit(Object id) {
        return false;
    }


    public Object search(Object id) {

        //System.out.println(id);

        // 开启数据库操作
        Session session = hibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // 查找对应id的活动
        ManagerEntity gly = session.get(ManagerEntity.class, (String)id);

        session.close();

        return gly;

    }

    /*
     * 返回所有管理员信息
     */
    public List<ManagerEntity> getAll() {

        // 开启数据库操作session
        Session session = hibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // 获取所有管理员数据
        Query query =session.createQuery("from ManagerEntity ");
        List<ManagerEntity> glyList = query.list();

        // 关闭数据库操作
        session.close();

        System.out.println(glyList.size());

        return glyList;
    }

    /*
    * 判断管理员是否存在
     */
    public static boolean ifExist(ManagerEntity gly) {

        // 开启数据库操作session
        Session session = hibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // 判断
        if(session.get(ManagerEntity.class,gly.getId()) == null ) { //管理员账号不存在

            System.out.println("id not exists");
            session.close();
            return false;
        } else {    //管理员账号存在，进一步判断密码是否正确

            if(gly.getPassword().equals(session.get(ManagerEntity.class,gly.getId()).getPassword())) {
                // 密码正确
                session.close();

                return true;
            } else {

                System.out.println("password incorrect");
                session.close();
                return false;
            }


        }

    }

    /*
    public static void main(String[] args) {
        ManagerEntity gly = new ManagerEntity();

        gly.setId("gly01");
        gly.setName("laomei");
        gly.setPassword("1");

        System.out.println(ifExist(gly));

    }
    */

}
