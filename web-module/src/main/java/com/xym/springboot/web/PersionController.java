package com.xym.springboot.web;

import comy.xym.springboot.domain.Persion;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("users")
public class PersionController {


    // 创建线程安全的Map
    static Map<Long, Persion> users = Collections.synchronizedMap(new HashMap<Long, Persion>());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Persion> getPersionList() {
        // 处理"/users/"的GET请求，用来获取用户列表
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
        List<Persion> r = new ArrayList<Persion>(users.values());
        return r;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postPersion(@ModelAttribute Persion user) {
        // 处理"/users/"的POST请求，用来创建Persion
        // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
        users.put(user.getId(), user);
        return "success";
    }

    //    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @GetMapping("/{id}")
    public Persion getPersion(@PathVariable Long id) {
        // 处理"/users/{id}"的GET请求，用来获取url中id值的Persion信息
        // url中的id可通过@PathVariable绑定到函数的参数中
        return users.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putPersion(@PathVariable Long id, @ModelAttribute Persion user) {
        // 处理"/users/{id}"的PUT请求，用来更新Persion信息
        Persion u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deletePersion(@PathVariable Long id) {
        // 处理"/users/{id}"的DELETE请求，用来删除Persion
        users.remove(id);
        return "success";
    }

}
