package com.example.Logging;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.session.StandardSession;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

@RestController
@Slf4j
public class HomeResource {
    @RequestMapping("/{user}")
    public String home(HttpSession session, @PathVariable("user") String user) {
        MDC.put("username", user);
        session.setAttribute("username", user);
        log.trace("home method accessed");
        return "Hello from Spring Boot";
    }

    @RequestMapping("/new")
    public String newMd() {
        log.trace("new method accessed");
        return "Hello from Spring Boot @";
    }

    @RequestMapping("/favicon.ico")
    public void favicon() {

    }
}
