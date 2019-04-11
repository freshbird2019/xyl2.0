package xyl.cct.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import xyl.cct.pojo.Ly;
import xyl.cct.pojo.Xy;
import java.util.List;

@Repository("lyDao")
public class LyDao {
    /*
    查找所有审核过的留言
     */
    public static List<Ly> query1(){
        //负责被持久化对象的CRUD操作
        Session session=HibernateUtils.openSession();
        List<Ly> list= null;
        Transaction transaction=null;
        try{
            //负责事务相关的操作
            transaction=session.beginTransaction();

            //查询所有记录
            String sql="from Ly as ly where ly.state=1";
            Query query=session.createQuery(sql);
            list=query.list();
            transaction.commit();
        }
        catch (HibernateException ex){
            ex.printStackTrace();
            if(transaction!=null){
                transaction.rollback();
            }
        }
        finally {
            if(session!=null&&session.isOpen()){
                session.close();
            }
        }
        return list;
    }
    /*
    查找状态为0的留言（未审核）
     */
    public static List<Ly> query0(){
        //负责被持久化对象的CRUD操作
        Session session=HibernateUtils.openSession();
        List<Ly> list= null;
        Transaction transaction=null;
        try{
            //负责事务相关的操作
            transaction=session.beginTransaction();

            //查询所有记录
            String sql="from Ly as ly where ly.state=0";
            Query query=session.createQuery(sql);
            list=query.list();
            transaction.commit();
        }
        catch (HibernateException ex){
            ex.printStackTrace();
            if(transaction!=null){
                transaction.rollback();
            }
        }
        finally {
            if(session!=null&&session.isOpen()){
                session.close();
            }
        }
        return list;
    }
    /*
    给定校友，查看他的所有留言
     */
    public static List<Ly> querySelfLy(Xy xy){
        //负责被持久化对象的CRUD操作
        Session session=HibernateUtils.openSession();
        List<Ly> list= null;
        Transaction transaction=null;
        try{
            //负责事务相关的操作
            transaction=session.beginTransaction();

            //查询所有记录
            int id=xy.getXid();
            String sql="from Ly as ly where ly.xyByLyxid.xid=:id";
            Query query=session.createQuery(sql);
            query.setParameter("id",id);
            list=query.list();
            transaction.commit();
        }
        catch (HibernateException ex){
            ex.printStackTrace();
            if(transaction!=null){
                transaction.rollback();
            }
        }
        finally {
            if(session!=null&&session.isOpen()){
                session.close();
            }
        }
        return list;
    }
    /*
    校友添加留言
     */
    public static boolean add(Ly ly) {
        Session session = HibernateUtils.openSession();
        Transaction transaction = null;

        boolean ok = true;
        try {
            transaction = session.beginTransaction();
            //保存记录
            session.save(ly);
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

    /*
    管理员删除留言
     */
    public static boolean delete(int id){
        Session session = HibernateUtils.openSession();
        Transaction transaction = null;

        boolean ok = true;
        try {
            transaction = session.beginTransaction();
            //根据id找到记录
            Object ly=session.get(Ly.class,id);
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

    /*
    * 通过留言审核
     */
    public static boolean updateLy(int id) {
        Session session = HibernateUtils.openSession();
        Transaction transaction = null;

        boolean ok = true;
        try {
            transaction = session.beginTransaction();

            //根据id找到记录
            Object ly=session.get(Ly.class,id);

            //更新
            ((Ly) ly).setState(1);

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

   /*
   * 留言加精选
    */
   public boolean asBest(Integer lid) {
       Session session = HibernateUtils.openSession();
       Transaction transaction = null;

       boolean ok = true;
       try {
           transaction = session.beginTransaction();

           //根据id找到记录
           Ly ly = session.get(Ly.class, lid);
           ly.setBest(1);
           session.save(ly);

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
