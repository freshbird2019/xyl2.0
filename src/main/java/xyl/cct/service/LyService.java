package xyl.cct.service;

import xyl.cct.pojo.Ly;
import xyl.cct.dao.LyDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("lyService")
public class LyService {
    @Resource(name = "lyDao")
    LyDao dao;
    public List<Ly> getAllLy(){
        return dao.queryAll();
    }

    public boolean addLy(Ly ly){
        return dao.add(ly);
    }

    public boolean deleteLy(int id){
        return dao.delete(id);
    }

    public boolean updateState(int id) { return dao.updateLy(id); }

}
