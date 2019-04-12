package xyl.dyx.service;

import org.springframework.stereotype.Service;
import xyl.cct.pojo.Xy;
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

    // 编辑活动信息
    public boolean editAcEntity(ActivityEntity ac) {
        return dao.edit(ac);
    }

    // 参加活动
    public boolean joinAc(int aid, int xid) {
        return dao.joinAc(aid, xid);
    }

    // 获取活动人员
    public List<Xy> getAcXy(int aid) {
        return dao.getAcXy(aid);
    }

    // 获取参加的活动
    public List<ActivityEntity> getXyAcSer(int xid) {
        return dao.getXyAc(xid);
    }

    // 退出活动
    public boolean exitAc(int aid, int xid) {
        return dao.exitAc(aid, xid);
    }
}
