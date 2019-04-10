package xyl.cct.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import xyl.cct.pojo.Clazz;
import xyl.cct.pojo.Ly;
import xyl.cct.pojo.Xy;
import xyl.cct.service.ClazzService;
import xyl.dyx.controller.hibernateUtil;
import xyl.dyx.dao.dao;

import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;
import java.util.List;

@Repository("clazzDao")
public class ClazzDao implements dao {

    @Override
    public boolean add(Object object) {
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
            Clazz cla = (Clazz)object;
            cla.setCid(id);


            System.out.println("add new class " + cla.getCid());

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

    @Override
    public boolean delete(Object id) {
        Session session = hibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        boolean flag = true;

        try {


            Clazz cla = new Clazz();
            cla.setCid((Integer)id);

            session.delete(cla);

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

    @Override
    public boolean edit(Object obj) {
        /*
         * 传入参数应该是一个班级实体
         * 不是id啊，不然咋知道要修改什么地方
         */

        boolean flag = true;
        Transaction trans = null;
        Session session = null;

        try {
            // 开启数据库操作session
            session = hibernateUtil.getSessionFactory().openSession();
            trans = session.beginTransaction();


            // 更新数据
            session.update(obj);


            System.out.println("update new class " );

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


    @Override
    public Object search(Object id) {
        return null;
    }

    /*
    * 获取所有班级信息
     */
    public List<Clazz> getAll() {
        // 开启数据库操作session
        Session session = hibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();

        // 获取所有活动数据
        Query query =session.createQuery("from Clazz ");
        List<Clazz> claList = query.list();

        // 关闭数据库操作
        trans.commit();
        session.close();

        return claList;
    }

    /*
    * 获取某一班级所有班级成员
    * 参数是班级id
     */
    public List<Xy> getAllmember(int id) {

        boolean flag = true;
        Transaction trans = null;
        Session session = null;
        List<Xy> xyList = new ArrayList<>();

        try {
            // 开启数据库操作session
            session = hibernateUtil.getSessionFactory().openSession();
            trans = session.beginTransaction();

            Clazz cla = new Clazz();
            cla.setCid(id);
            // 获取所有活动数据
            String hql = "from Xy as xy where xy.clazzByClassid.xiesByCid="+id;

            Query query =session.createQuery(hql);
            xyList = query.list();

            //Hibernate.initialize(xyList);

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

        return xyList;

    }



}
