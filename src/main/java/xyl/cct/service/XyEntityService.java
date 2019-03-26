package xyl.cct.service;

import xyl.cct.dao.XyEntityDao;
import xyl.cct.pojo.XyEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("xyEntityService")
public class XyEntityService {
    @Resource(name = "xyEntityDao")
    public XyEntityDao dao;

    public List<XyEntity> getAllXyEntity(){
        return dao.queryAll();
    }

    public boolean addXyEntity(XyEntity xy){
        return dao.addXy(xy);
    }

    public boolean updateXyEntity(XyEntity xy){
        return dao.updateXy(xy);
    }

    public int getMaxId(){
        return dao.getXyNum();
    }

    public XyEntity getXyEntityById(int id){
        return dao.getXyEntityById(id);
    }
}
