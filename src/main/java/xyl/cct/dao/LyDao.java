package xyl.cct.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import xyl.cct.pojo.Ly;
import java.util.List;

@Repository("lyDao")
public class LyDao {
    /*
    查找所有留言
     */
    public static List<Ly> queryAll(){
        //负责被持久化对象的CRUD操作
        Session session=null;
        List<Ly> list= null;
        Transaction transaction=null;
        try{
            //负责配置并启动hibernate，创建SessionFactor，加载hibernate.cfg.xml
            Configuration configuration=new Configuration().configure();
            //SessionFactor负责初始化hibernate，创建session对象
            SessionFactory sf=configuration.buildSessionFactory();
            session = sf.openSession();
            //负责事务相关的操作
            transaction=session.beginTransaction();

            //查询所有记录
            String sql="from Ly order by lid asc";
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
    校友添加留言
     */
    public static boolean add(Ly ly) {
        SessionFactory sf;
        Session session = null;
        Transaction transaction = null;

        boolean ok = true;
        try {
            Configuration configuration = new Configuration().configure();
            sf = configuration.buildSessionFactory();
            session = sf.openSession();
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
        SessionFactory sf;
        Session session = null;
        Transaction transaction = null;

        boolean ok = true;
        try {
            Configuration configuration = new Configuration().configure();
            sf = configuration.buildSessionFactory();
            session = sf.openSession();
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
}
