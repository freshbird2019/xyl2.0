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
}
