package xyl.cct.dao;

import xyl.cct.pojo.LyEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("lyEntityDao")
public class LyEntityDao {
    /*@Resource
    private SessionFactory sessionFactory;

    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }*/
    /*
    *查询ly表中所有数据
    * @return
     */

    public static List<LyEntity> queryAll(){
        //负责被持久化对象的CRUD操作
       Session session=null;
        List<LyEntity> list= null;
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
           String sql="from LyEntity order by id asc";
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

    public static int getLyNum(){
        List<LyEntity> list= null;
        try{
            list=queryAll();
        }
        catch (Exception e){
            System.out.println("查询留言数量出错!");
            return -1;
        }
        int index=list.size();

        int re=list.get(index-1).getLyId();
        System.out.println(re);
        return re;
    }


    public static boolean add(LyEntity lyEntity) {
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
            session.save(lyEntity);
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
            Object ly=session.get(LyEntity.class,id);
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
