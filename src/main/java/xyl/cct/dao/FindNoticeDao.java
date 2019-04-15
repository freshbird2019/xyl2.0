package xyl.cct.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import xyl.cct.pojo.FindNotice;

import java.util.List;

@Repository("findNoticeDao")
public class FindNoticeDao {
    /*
    查找所有寻人启事
     */
    public static List<FindNotice> query(int cid) {
        //负责被持久化对象的CRUD操作
        Session session = HibernateUtils.openSession();
        List<FindNotice> list = null;
        Transaction transaction = null;
        try {
            //负责事务相关的操作
            transaction = session.beginTransaction();

            //查询所有记录
            String sql = "from FindNotice as fn where fn.showstate = :id or fn.showstate=0 order by ftime";
            Query query = session.createQuery(sql);
            query.setParameter("id",cid);
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

    /*
    添加一则寻人启事
     */
    public static boolean add(FindNotice findNotice) {
        Session session = HibernateUtils.openSession();
        Transaction transaction = null;

        boolean ok = true;
        try {
            transaction = session.beginTransaction();
            //保存记录
            session.save(findNotice);
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
    删除一则寻人启事
     */
    public static boolean delete(int id){
        Session session = HibernateUtils.openSession();
        Transaction transaction = null;

        boolean ok = true;
        try {
            transaction = session.beginTransaction();
            //根据id找到记录
            Object ly=session.get(FindNotice.class,id);
            //删除
            session.delete(ly);
            //提交事务
            transaction.commit();
        } catch (Exception e) {
            ok = false;
            e.printStackTrace();
            //回滚事务
            if (transaction != null) {//事务不为空，说明事务提交不成功
                transaction.rollback();
                ;
            }
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return ok;
    }

}