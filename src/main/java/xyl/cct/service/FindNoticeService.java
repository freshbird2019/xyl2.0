package xyl.cct.service;

import org.springframework.stereotype.Service;
import xyl.cct.dao.FindNoticeDao;
import xyl.cct.pojo.FindNotice;

import javax.annotation.Resource;
import java.util.List;

@Service("findService")
public class FindNoticeService {
    @Resource(name = "findNoticeDao")
    FindNoticeDao dao;
    public List<FindNotice> getAll(int cid){return dao.query(cid);}
    public boolean saveOneFind(FindNotice findNotice){
        return dao.add(findNotice);
    }
    public boolean deleteOneFind(int id){
        return dao.delete(id);
    }
}
