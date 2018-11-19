package com.xbb.ssm.controller;

import com.xbb.ssm.service.EmpService;
import com.xbb.ssm.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * className:EmpController
 * discriptoin:
 * author:邢博
 * createTime:2018-11-07 15:51
 */
@Controller
@RequestMapping("/emp")
public class EmpController {

    //依赖注入
    @Autowired
    private EmpService empService;

    @RequestMapping("/list")
    public String list(@RequestParam Map map, Model model, HttpServletRequest request){
        map.put("pageSize",5);
        int pageNo = map.get("pageNo")==null?1:Integer.valueOf(map.get("pageNo")+"");
        String stringPage = new PageUtil(pageNo, 5, empService.getPageCount(map),request).getStringPage();
        model.addAttribute("stringPage",stringPage);
        model.addAttribute("pageNo",pageNo);
        model.addAttribute("sel",map.get("sel"));
        model.addAttribute("empList",empService.getPage(map));
        return "emp/list";
    }

    /**
     * 新增的toString方法
     * @return
     */
    @RequestMapping("/toAdd")

    public String toAdd(){
       /* List<Map> deptNoList = empService.getDeptNoList();
        System.out.println(deptNoList);*/
        return "emp/add";
    }

    /**
     * 新增
     */
    @RequestMapping("addEmp")
    public String addEmp(@RequestParam  Map map,Model model){
        if(map!=null){
            int result = empService.addEmp(map);
            if(result>0){
                return "redirect:list.do";
            }else{
                model.addAttribute("info","添加失败");
                return "redirect:toAdd.do";
            }
        }
        return null;
    }


    /**
     * 删除
     */
    @RequestMapping("/deleteEmp")
    public String deleteEmp(@RequestParam Integer empNo,@RequestParam Integer pageNo){
        if(empNo!=null){
            int result = empService.deleteEmp(empNo);
            if(result>0){
                return "redirect:list.do?pageNo="+pageNo;
            }
        }
        return null;
    }

    /**
     * 通过ID查询
     */
    @RequestMapping("/getById")
    public String getEmpList(@RequestParam Integer empNo,Model model,@RequestParam Integer pageNo) {
        if (empNo != null) {
            List<Map> empList = empService.getEmpList(empNo);
            if (empList!=null&&empList.size()>0) {
                model.addAttribute("empInfo",empList.get(0));
                model.addAttribute("pageNo",pageNo);
                return "emp/update";
            }
        }
        return null;
    }

    /**
     * 修改
     */
    @RequestMapping("/updateEmp")
    public String updateEmp(@RequestParam Map map){
        int result = empService.updateEmp(map);
        if(result>0){
            return "redirect:list.do?pageNo="+map.get("pageNo");
        }
        return null;
    }
}
