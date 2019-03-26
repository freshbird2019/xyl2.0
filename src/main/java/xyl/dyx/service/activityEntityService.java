package xyl.dyx.service;

import org.springframework.stereotype.Service;
import xyl.dyx.POJO.ActivityEntity;
import xyl.dyx.dao.activityEntityDao;

import javax.annotation.Resource;
import java.util.List;

@Service("activityEntityService")
public class activityEntityService {

    @Resource(name = "activityEntityDao")
    activityEntityDao dao;

    // 获取所有活动
    public List<ActivityEntity> getAllActivities() {
        return dao.getAll();
    }

    // 添加活动
    public boolean addActivityEntity(ActivityEntity ac) {
        return dao.add(ac);
    }

    // 删除活动
    public boolean deleteActivityEntity(int id) {
        return dao.delete(id);
    }

    //暂时没有删除活动的功能，要是写错了，直接删除吧
    public boolean editAcEntity(int id) {
        return dao.edit(id);
    }


}
