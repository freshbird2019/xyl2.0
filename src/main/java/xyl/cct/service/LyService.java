package xyl.cct.service;

import xyl.cct.pojo.Ly;
import xyl.cct.dao.LyDao;
import xyl.cct.pojo.Xy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("lyService")
public class LyService {
    @Resource(name = "lyDao")
    LyDao dao;
    public List<Ly> getAllLy0(){
        return dao.query0();
    }

    public List<Ly> getAllLy(){
        return dao.query1();
    }

    public List<Ly> getSelfLy(Xy xy){
        return dao.querySelfLy(xy);
    }

    public boolean addLy(Ly ly){
        return dao.add(ly);
    }

    public boolean deleteLy(int id){
        return dao.delete(id);
    }

    public boolean updateState(int id) { return dao.updateLy(id); }

}
