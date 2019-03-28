package xyl.cct.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static SessionFactory sessionFactory;

    static {
        //负责配置并启动hibernate，创建SessionFactor，加载hibernate.cfg.xml
        Configuration configuration=new Configuration().configure();
        //SessionFactor负责初始化hibernate，创建session对象
        sessionFactory=configuration.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static Session openSession(){
        return sessionFactory.openSession();
    }
}
