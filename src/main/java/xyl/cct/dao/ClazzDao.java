package xyl.cct.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import xyl.cct.pojo.Clazz;
import xyl.cct.pojo.Xy;
import xyl.cct.service.ClazzService;
import xyl.dyx.controller.hibernateUtil;
import xyl.dyx.dao.dao;

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
        // 存在问题暂不实现
        // 不知道应不应该删除所有班级成员
        return false;
    }

    @Override
    public boolean edit(Object obj) {
        /*
        * 传入参数应该是一个班级实体
        * 不是id啊，不然咋知道要修改什么地方
         */
        return false;
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
        session.beginTransaction();

        // 获取所有活动数据
        Query query =session.createQuery("from Clazz ");
        List<Clazz> claList = query.list();

        // 关闭数据库操作
        session.close();

        return claList;
    }

    /*
    * 获取某一班级所有班级成员
    * 参数是班级id
     */
    public static List<Xy> getAllmember(int id) {

        // 开启数据库操作session
        Session session = hibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();



        Clazz cla = new Clazz();
        cla.setCid(id);
        // 获取所有活动数据
        String hql = "from Xy as xy where xy.clazzByClassid="+id;
        Query query =session.createQuery(hql);
        List<Xy> xyList = query.list();

        // 关闭数据库操作
        session.close();

        return xyList;
    }


    /*
    //测试
    public static void main(String[] args) {
        List<Xy> list = getAllmember(1);

        for(Xy item : list) {
            System.out.println(item.getName());
        }
    }
    */
}
