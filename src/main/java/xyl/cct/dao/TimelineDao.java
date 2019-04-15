package xyl.cct.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import xyl.cct.pojo.Timeline;

import java.util.List;

@Repository("timeLineDao")
public class TimelineDao {
    /*
   添加一条时间线
    */
    public static boolean add(Timeline timeline){
        Session session = HibernateUtils.openSession();
        Transaction transaction = null;

        boolean ok = true;
        try {
            transaction = session.beginTransaction();
            //保存记录
            session.save(timeline);
            //提交事务
            transaction.commit();
        } catch (Exception e) {
            ok = false;
            e.printStackTrace();
            //回滚事务
            if (transaction != null) {//事务不为空，说明事务提交不成功
                transaction.rollback();
            }
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return ok;
    }

    /*
    查找一个同学id的所有时间线
     */
    public static List<Timeline> query(int id) {
        //负责被持久化对象的CRUD操作
        Session session = HibernateUtils.openSession();
        List<Timeline> list = null;
        Transaction transaction = null;
        try {
            //负责事务相关的操作
            transaction = session.beginTransaction();
            System.out.println("alllaok");
            //查询所有记录
            String sql = "from Timeline as tl where tl.xyByTid.xid = :id order by ttime";
            Query query = session.createQuery(sql);
            query.setParameter("id",id);
            list = query.list();
            transaction.commit();

        } catch (HibernateException ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return list;
    }
}
