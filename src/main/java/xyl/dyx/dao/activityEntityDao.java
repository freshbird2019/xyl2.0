package xyl.dyx.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import xyl.dyx.POJO.ActivityEntity;
import xyl.dyx.controller.hibernateUtil;

import java.util.List;

@Repository("activityEntityDao")
public class activityEntityDao implements dao{

    /*
    * add an activity
     */
    public boolean add(Object object) {

        // 不太知道能不能挪出去，不然代码挺冗余的
        boolean flag = true;
        Transaction trans = null;
        Session session = null;

        try {
            // 开启数据库操作session
            session = hibernateUtil.getSessionFactory().openSession();
            trans = session.beginTransaction();

            // 添加实体，id是自增的
            int id = (Integer)session.save(object);

            // 设置id
            ActivityEntity ac = (ActivityEntity)object;
            ac.setAid(id);

            System.out.println(ac.getAid());

            // commit
            trans.commit();


        }catch (Exception e) {
            flag = false;
            e.printStackTrace();

            // rollback
            if(trans != null) {
                trans.rollback();
            }
        }finally {
            session.close();
        }

        return flag;
    }

    /*
    * delete entity
     */
    public boolean delete(Object id) {

        boolean flag = true;
        Transaction trans = null;
        Session session = null;

        try {
            // 开启数据库操作session
            session = hibernateUtil.getSessionFactory().openSession();
            trans = session.beginTransaction();

            // 一般删除都是存在的实体，所以不必判断是否存在
            ActivityEntity ent = session.load(ActivityEntity.class,(Integer)id);
            System.out.println("delete "+ ent.getName());

            session.delete(ent);
            trans.commit();

        }catch (Exception e) {
            flag = false;
            e.printStackTrace();

            // rollback
            if(trans != null) {
                trans.rollback();
            }
        }finally {
            session.close();
        }

        return flag;

    }

    // 暂时没这功能
    public boolean edit(Object id) {
        return true;
    }

    /*
    * return all entities
     */

    public List<ActivityEntity> getAll() {

        // 开启数据库操作session
        Session session = hibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // 获取所有活动数据
        Query query =session.createQuery("from ActivityEntity ");
        List<ActivityEntity> activityList = query.list();

        // 关闭数据库操作
        session.close();

        return activityList;
    }

    /*
    * find the entity
     */
    public Object search(Object id) {

        // 开启数据库操作
        Session session = hibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // 查找对应id的活动
        ActivityEntity activity= session.get(ActivityEntity.class, (Integer)id);

        session.close();

        // 返回活动实体
        if(activity == null) {

            return null;

        } else {

            return activity;

        }


    }
}
