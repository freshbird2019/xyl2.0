package xyl.dyx.dao;

public interface dao {

    // 添加数据
    public boolean add(Object object);

    // 删除数据
    public boolean delete(Object id);

    // 编辑数据
    public boolean edit(Object id);

    // 查询,参数是id
    public Object search(Object id);

}
