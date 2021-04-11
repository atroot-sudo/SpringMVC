package com.theoldzheng.Controller;

import com.theoldzheng.bean.Department;
import com.theoldzheng.bean.Employee;
import com.theoldzheng.dao.DepartmentDao;
import com.theoldzheng.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
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

    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping(value = "/emps")
    public String getEmps(Model model) {
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps", all);
        return "list";
    }

    /**
     * 处理点击list.jsp页面的添加按钮执行操作
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/toAddPage")
    public String add(Model model) {
        //遍历部门，进而传递到request域中等待被获取
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("dept", departments);
        model.addAttribute("employee", new Employee());
        return "add";
    }

    /**
     * 处理保存按钮后的操作
     *
     * @param employee
     * @return
     */
    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public String addEmp(@Valid Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("信息校验失败！");
            return "add";
        }else {

            employeeDao.save(employee);
            System.out.println("save successfully!");
            //添加成功后进行重定向到显示所有employee
            return "redirect:/emps";
        }

    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    public String Edit(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        Collection<Department> departments = departmentDao.getDepartments();

        model.addAttribute("dept", departments);
        model.addAttribute("employee", employee);
        return "edit";

    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.PUT)
    public String update(Employee employee) {
        System.out.println("要修改的：" + employee);
        employeeDao.save(employee);
        System.out.println("update successfully!");
        //修改成功后进行重定向到显示所有employee
        return "redirect:/emps";
    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        System.out.println("delete successful!");
        return "redirect:/emps";
    }
}