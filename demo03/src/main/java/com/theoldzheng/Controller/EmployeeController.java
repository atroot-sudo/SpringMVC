package com.theoldzheng.Controller;

import com.theoldzheng.bean.Department;
import com.theoldzheng.bean.Employee;
import com.theoldzheng.dao.DepartmentDao;
import com.theoldzheng.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

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
     * @param employee 员工对象
     * @return 错误则返回地址add，正确重定向到所有员工列表
     */
    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public String addEmp(@Valid Employee employee, BindingResult bindingResult, Model model) {
        HashMap<String, Object> errorsMap = new HashMap<>();
        //

        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError error : fieldErrors) {
                String field = error.getField();
                String defaultMessage = error.getDefaultMessage();
                errorsMap.put(field, defaultMessage);
            }
            model.addAttribute("errorInf", errorsMap);
            return "add";
        } else {

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

    @ModelAttribute
    public void myModelAttribute(@RequestParam(value = "id", required = false) Integer id,
                                 Model model) {
        if (id != null) {
            Employee employee = employeeDao.get(id);
            model.addAttribute("employee", employee);
        }
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("dept", departments);
    }

    @ResponseBody
    @RequestMapping(value = "/ajaxTest")
    public Collection<Employee> getAllEmployee() {
        Collection<Employee> all = employeeDao.getAll();
        return all;
    }

    @RequestMapping(value = "/getUrl")
    public String getUrl() {
        return "emps";
    }

    /**
     * //@RequestBody 可以获取 网页发过来的请求体里的信息 只有post方式有请求体
     * //@ResponseBody 可以把对象转换为json数据 返回给浏览器  将返回的内容放在响应体中
     *
     * @param message
     * @return
     */
    @RequestMapping(value = "/responseBody")
    public String responseBodyTest(@RequestBody String message) {
        System.out.println(message);
        return "success";
    }

    /**
     * HttpEntity 可以直接获取请求头里的所有信息
     *
     * @param str
     * @return
     */
    @RequestMapping(value = "/test01")
    public String test01(HttpEntity<String> str) {
        System.out.println(str);
        return "success";
    }

    /**
     *  实现文件下载
     * @param httpServletRequest
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/download")
    public ResponseEntity<byte[]> download(HttpServletRequest httpServletRequest) throws IOException {
        //将要下载的文件转换为字节流
        String contextPath = httpServletRequest.getServletContext().getRealPath("/QQ图片.jpg");
        FileInputStream fis = new FileInputStream(contextPath);

        byte[] buffer = new byte[fis.available()];

        HttpHeaders httpHeaders = new HttpHeaders();
        fis.read(buffer);
        httpHeaders.set("content-Disposition", "attachment;filename=" + "QQ图片下载版.jpg");
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(buffer, httpHeaders, HttpStatus.OK);

        return responseEntity;
    }

}