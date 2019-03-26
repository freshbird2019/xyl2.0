package xyl.cct.service;

import xyl.cct.dao.LyEntityDao;
import xyl.cct.pojo.LyEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("lyEntityService")
public class LyEntityService {
    @Resource(name = "lyEntityDao")
    LyEntityDao dao;
    public List<LyEntity> getAllLyEntity(){
        return dao.queryAll();
    }

    public boolean addLyEntity(LyEntity lyEntity){
        return dao.add(lyEntity);
    }

    public boolean deleteLyEntity(int id){
        return dao.delete(id);
    }

    public int getMaxId(){
        return dao.getLyNum();
    }
}
