package xyl.cct.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import xyl.cct.dao.TimelineDao;
import xyl.cct.pojo.Timeline;

@Service("timeService")
public class TimelineService {
    @Resource(name = "timeLineDao")
    TimelineDao dao;
    public List<Timeline> getAll(int id){return dao.query(id);}
    public boolean saveOneFind(Timeline t){
        return dao.add(t);
    }
}
