package xyl.cct.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import xyl.cct.pojo.Ly;
import xyl.cct.pojo.Xy;
import java.util.List;

@Repository("xyDao")
public class XyDao {
    /*
    查询所有校友信息
     */
    public static List<Xy> queryAll(){
        //负责被持久化对象的CRUD操作
        Session session=HibernateUtils.openSession();
        List<Xy> list= null;
        Transaction transaction=null;
        try{
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
    未入班校友
     */
    public static List<Xy> queryAll0(){
        //负责被持久化对象的CRUD操作
        Session session=HibernateUtils.openSession();
        List<Xy> list= null;
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();

            //查询所有记录
            String sql="from Xy as xy where xy.state=0 order by xid asc";
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
    有班校友
     */
    public static List<Xy> queryAll1(){
        //负责被持久化对象的CRUD操作
        Session session=HibernateUtils.openSession();
        List<Xy> list= null;
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();

            //查询所有记录
            String sql="from Xy as xy where xy.state=1 order by xid asc";
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
    申请状态校友
     */
    public static List<Xy> queryAll2(){
        //负责被持久化对象的CRUD操作
        Session session=HibernateUtils.openSession();
        List<Xy> list= null;
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();

            //查询所有记录
            String sql="from Xy as xy where xy.state=2 order by xid asc";
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
    查找相同班级的校友
     */
    public static List<Xy> queryByClassId(int id){
        //负责被持久化对象的CRUD操作
        Session session=HibernateUtils.openSession();
        List<Xy> list= null;
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();

            //查询所有记录
            String sql="from Xy as xy where xy.clazzByClassid.cid=:cid";
            Query query=session.createQuery(sql);
            query.setParameter("cid",id);
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
        Session session=HibernateUtils.openSession();
        boolean ok=true;
        Transaction transaction=null;
        try{
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
        Session session=HibernateUtils.openSession();
        Xy xy=new Xy();
        Transaction transaction=null;
        try{
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
        Session session=HibernateUtils.openSession();
        Transaction transaction=null;
        try{
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

    /*
    根据校友name来找校友信息
     */
    public static Xy getXybyName(String name){
        Xy xy=new Xy();
        Session session=HibernateUtils.openSession();
        Transaction transaction=null;
        try {
            //负责事务相关的操作
            transaction = session.beginTransaction();

            String hql="from Xy as xy where xy.name =:name";
            Query hqlquery=session.createQuery(hql);
            hqlquery.setParameter("name",name);
            List<Xy> list=hqlquery.list();

            //判断数组list为空方法！！！
            if (list.isEmpty()||list.size()==0) { //校友账号不存在

                System.out.println("不存在"+name+"校友");
            } else {
                xy=list.get(0);
            }
            transaction.commit();
        }
        catch (HibernateException ex){
            System.out.println("服务器故障");
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
     * 判断校友是否存在
     */
    public static int ifExist(Xy xy) {
        int ok=-1;

        Session session=HibernateUtils.openSession();
        Transaction transaction=null;
        try {
            //负责事务相关的操作
            transaction = session.beginTransaction();

            // 从数据库中获取相同用户名的
            String name=xy.getName();
            String hql="from Xy as xy where xy.name =:name";
            Query hqlquery=session.createQuery(hql);
            hqlquery.setParameter("name",name);
            List<Xy> list=hqlquery.list();

            //判断数组list为空方法！！！
            if (list.isEmpty()||list.size()==0) { //校友账号不存在

                System.out.println("id not exists");
                ok=-1;
            } else {    //校友账号存在，进一步判断密码是否正确

                if (list.get(0).getPw().equals(xy.getPw())){
                    // 密码正确
                    ok = list.get(0).getXid();
                } else {
                    System.out.println(list.get(0).getPw()+xy.getPw());
                    System.out.println("password incorrect");
                    ok = 0;
                }
            }
            transaction.commit();
        }
        catch (HibernateException ex){
            ok=-2;
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

    // 删除校友班级信息
    public boolean XyOutCla(Xy xy) {
        boolean ok=true;
        //负责被持久化对象的CRUD操作
        Session session=HibernateUtils.openSession();
        Transaction transaction=null;
        try{
            //负责事务相关的操作
            transaction=session.beginTransaction();

            //更新
            String hql = "update Xy xy set xy.classid=null where xy.xid="+xy.getXid();
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
