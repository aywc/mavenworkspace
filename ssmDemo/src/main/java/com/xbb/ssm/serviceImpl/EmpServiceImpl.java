package com.xbb.ssm.serviceImpl;

import com.xbb.ssm.dao.EmpDao;
import com.xbb.ssm.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * className:EmpServiceImpl
 * discriptoin:
 * author:邢博
 * createTime:2018-11-07 15:16
 */
@Service//交给spring管理
@Transactional//加上事务后，如果有异常，整个事务都会回滚  可以在类头上加后者加在方法的头上
public class EmpServiceImpl implements EmpService {

    @Autowired//依赖注入
    private EmpDao empDao;

    //@Transactional(propagation = Propagation.NOT_SUPPORTED)//如果该方法不需要事务加上这行代码就不添加事务

    @Override
    public List<Map> getPage(Map map) {
       int pageNo = map.get("pageNo")==null?1:Integer.valueOf(map.get("pageNo")+"");
       int pageSize = map.get("pageSize")==null?10:Integer.valueOf(map.get("pageSize")+"");
       //分页的开始值和结束值
       map.put("start",(pageNo-1)*pageSize);
       map.put("end",pageNo*pageSize+1);
        return empDao.getPage(map);
    }

    @Override
    public int getPageCount(Map map) {
        return empDao.getPageCount(map);
    }

    /**
     * 新增
     * @param map
     * @return
     */
    @Override
    public int addEmp(Map map) {
        int add = empDao.addEmp(map);
        System.out.println(1/0);
        System.out.println("返回的主键"+map.get("empNo"));
        return add;
    }

    /**
     * 修改
     * @param map
     * @return
     */
    @Override
    public int updateEmp(Map map) {
        return empDao.updateEmp(map);
    }

    /**
     * 通过ID查询
     * @param empNo
     * @return
     */
    @Override
    public List<Map> getEmpList(Integer empNo) {
        return empDao.getEmpList(empNo);
    }


    /**
     * 删除
     * @param empNo
     * @return
     */
    @Override
    public int deleteEmp(Integer empNo) {
        return empDao.deleteEmp(empNo);
    }

    /**
     * 查询单位编号
     */
    @Override
    public List<Map> getDeptNoList() {
        return empDao.getDeptNoList();
    }
}
