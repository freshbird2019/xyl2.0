package xyl.dyx.service;

import org.springframework.stereotype.Service;
import xyl.dyx.POJO.ManagerEntity;
import xyl.dyx.dao.glyEntityDao;

import javax.annotation.Resource;
import java.util.List;

@Service("glyEntityService")
public class glyEntityService {

    @Resource(name = "glyEntityDao")
    glyEntityDao dao = new glyEntityDao();

    // 查找管理员账号密码是否正确
    public boolean ifCorrect(ManagerEntity gly) {

            return dao.ifExist(gly);
    }

    public List<ManagerEntity> getAllGly() {
        return dao.getAll();
    }

}
