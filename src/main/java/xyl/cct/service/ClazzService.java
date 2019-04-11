package xyl.cct.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import xyl.cct.dao.ClazzDao;
import xyl.cct.pojo.Clazz;
import xyl.cct.pojo.Xy;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("ClazzService")
public class ClazzService {

    @Resource(name = "clazzDao")
    ClazzDao dao;

    // 获取班级所有成员
    public List<Xy> getAllXy(int id) {
        return dao.getAllmember(id);
    }


    // 新建班级
    public boolean addCla(Clazz cla) {
        return dao.add(cla);
    }

    // 获取所有班级
    public List<Clazz> getAllCla() {
        return dao.getAll();
    }

    // 获取每个班申请校友人数
    public Map<Integer,List<Xy>> getApplyNum() {

        List<Clazz> claList = dao.getAll();
        Map<Integer,List<Xy>> map = new HashMap<Integer, List<Xy>>();

        for (Clazz cla : claList) {

            // 获取所有成员
            List<Xy> xyList = dao.getAllmember(cla.getCid());

            // 查找所有未审核校友
            for(Xy xy : xyList) {

                //直接删除所有通过审核的成员
                if(xy.getState() == 1) {
                    xyList.remove(xy);
                }

            }
            //将班级id和对应的成员存入map中
            map.put(cla.getCid(),xyList);

        }
        return map;
    }

    // 更新班级
    public boolean update(Clazz cla) {
        return dao.edit(cla);
    }

    // 删除班级
    public  boolean deleteCla(int id) {
        return dao.delete(id);
    }

    //根据id获取班级
    public Clazz getClassById(int id){return dao.getClassById(id);}
}
