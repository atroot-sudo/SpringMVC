package com.theoldzheng.Controller;

import com.theoldzheng.bean.Employee;
import com.theoldzheng.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * Description: 处理员工的相关请求
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.4.8 12:01
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "/emps")
    public String getEmps(Model model) {
        Collection<Employee> all = employeeDao.getAll();
        model.addAllAttributes(all);
        return "list";
    }

}
