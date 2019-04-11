package xyl.cct.service;

import xyl.cct.dao.XyDao;
import xyl.cct.pojo.Xy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("xyService")
public class XyService {
    @Resource(name = "xyDao")
    public XyDao dao;

    public List<Xy> getAllXy(){
        return dao.queryAll();
    }

    public List<Xy> getAllXy0(){
        return dao.queryAll0();
    }

    public List<Xy> getAllXy1(){
        return dao.queryAll1();
    }

    public List<Xy> getAllXy2(){
        return dao.queryAll2();
    }

    public List<Xy> getXyByClassId(int id){
        return dao.queryByClassId(id);
    }

    public boolean addXy(Xy xy){
        return dao.addXy(xy);
    }

    public boolean updateXyEntity(Xy xy){
        return dao.updateXy(xy);
    }

    public int getMaxId(){
        return dao.getXyNum();
    }

    public Xy getXyById(int id){
        return dao.getXyById(id);
    }

    // 查找校友账号密码是否正确
    public int ifCorrect(Xy xy) {

        return dao.ifExist(xy);
    }

    // 删除校友班级信息
    public boolean xyOutCla(Xy xy) {
        return dao.XyOutCla(xy);
    }

    //根据name查找校友
    public Xy getXyByName(String name){return dao.getXybyName(name);}
}
