package xyl.cct.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import xyl.cct.pojo.Xy;
import java.util.List;

@Repository("xyDao")
public class XyDao {
    /*
    查询所有校友信息
     */
    public static List<Xy> queryAll(){
        //负责被持久化对象的CRUD操作
        Session session=null;
        List<Xy> list= null;
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
            String sql="from Xy order by xid asc";
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
    校友注册
    增加一条校友信息
     */
    public boolean addXy(Xy xy){
        Session session=null;
        boolean ok=true;
        Transaction transaction=null;
        try{
            //负责配置并启动hibernate，创建SessionFactor，加载hibernate.cfg.xml
            Configuration configuration=new Configuration().configure();
            //SessionFactor负责初始化hibernate，创建session对象
            SessionFactory sf=configuration.buildSessionFactory();
            session = sf.openSession();
            //负责事务相关的操作
            transaction=session.beginTransaction();

            //保存记录
            session.save(xy);
            //提交事务
            transaction.commit();
        }
        catch (HibernateException ex){
            ok=false;
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
        return ok;
    }

    /*
    查询校友数量
     */
    public static int getXyNum(){
        List<Xy> list= null;
        try{
            list=queryAll();
        }
        catch (Exception e){
            System.out.println("查询校友数量出错!");
            return -1;
        }
        int index=list.size();
        int re;
        if(index==0){
            re=0;
        }
        else re=list.get(index-1).getXid();
        System.out.println(re);
        return re;
    }

    /*
    根据校友xid来查询校友资料
     */
    public static Xy getXyById(int id){
        //负责被持久化对象的CRUD操作
        Session session=null;
        Xy xy=new Xy();
        Transaction transaction=null;
        try{
            //负责配置并启动hibernate，创建SessionFactor，加载hibernate.cfg.xml
            Configuration configuration=new Configuration().configure();
            //SessionFactor负责初始化hibernate，创建session对象
            SessionFactory sf=configuration.buildSessionFactory();
            session = sf.openSession();
            //负责事务相关的操作
            transaction=session.beginTransaction();

            //根据id查询校友资料
            xy=session.get(Xy.class,id);
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
        return xy;
    }

    /*
    校友修改自己的信息
    更新
     */
    public static boolean updateXy(Xy xy){
        boolean ok=true;
        //负责被持久化对象的CRUD操作
        Session session=null;
        Transaction transaction=null;
        try{
            //负责配置并启动hibernate，创建SessionFactor，加载hibernate.cfg.xml
            Configuration configuration=new Configuration().configure();
            //SessionFactor负责初始化hibernate，创建session对象
            SessionFactory sf=configuration.buildSessionFactory();
            session = sf.openSession();
            //负责事务相关的操作
            transaction=session.beginTransaction();

            //更新
            session.update(xy);
            transaction.commit();
        }
        catch (HibernateException ex){
            ok=false;
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
        return ok;
    }
}
