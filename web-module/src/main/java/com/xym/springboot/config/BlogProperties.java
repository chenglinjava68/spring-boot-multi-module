package com.xym.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/*通过@Value自定发现配置值*/
@Component
public class BlogProperties {

    @Value("${com.xym.blog.name}")
    private String name;
    @Value("${com.xym.blog.title}")
    private String title;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
