package com.xbb.ssm.service;

import java.util.List;
import java.util.Map;

/**
 * className:EmpService
 * discriptoin:员工服务接口
 * author:zz
 * createTime:2018-11-07 15:10
 */
public interface EmpService {

    /**
     * 员工分页数据
     * @param map
     * @return
     */
    List<Map> getPage(Map map);

    /**
     * 分页总数量
     * @param map
     * @return
     */
    int getPageCount(Map map);

    /**
     * 添加员工
     */
    int addEmp(Map map);

    /**
     * 通过ID查询员工信息
     */
    List<Map> getEmpList(Integer empNo);

    /**
     * 修改
     */
    int updateEmp(Map map);

    /**
     * 删除员工
     */
    int deleteEmp(Integer empNo);

    /**
     * 查询单位编号
     */
    List<Map> getDeptNoList();
}
