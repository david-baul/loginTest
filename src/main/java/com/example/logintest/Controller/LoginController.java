package com.example.logintest.Controller;

import com.example.logintest.domain.User;
import com.example.logintest.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    @GetMapping("/boards/index.do")
    public String index(Model model, HttpServletRequest request, HttpServletResponse response) {

        String getSession = (String) request.getSession().getAttribute("id");
        if (getSession == null) {
            return "boards/index";
        } else {
            return "redirect:" + "main.do";
        }
    }

    @PostMapping("/boards/login.do")
    public String login(ModelAndView modelAndView, Model model, HttpServletRequest request, HttpServletResponse response) {

        String id = request.getParameter("id");
        String password = request.getParameter("password");
        Map<String, Object> paramMap = new HashMap<String, Object>();

        paramMap.put("id", id);
        paramMap.put("password", password);
        Map<String, Object> resultMap = userService.getId(paramMap);


        if (resultMap == null) {
            //로그인실패
            //model.addAttribute("message", "입력하신 정보를 다시 확인해주세요.");
            //return "/boards/index";
            return null;

        } else {
            //로그인성공
            userService.insertLoginTime(paramMap);
            request.getSession().setAttribute("id", resultMap.get("id").toString());

            return  "redirect:" + "/boards/main.do";
        }

    }

    @PostMapping("/boards/logout.do")
    public String logout(Model model, HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("id");
        return null;
    }

    @GetMapping("/boards/membership.do")
    public String membership(Model model, HttpServletRequest request, HttpServletResponse response) {

        String getSession = (String) request.getSession().getAttribute("id");
        if (getSession == null) {
            return  "/boards/membership";
        } else {
            return "redirect:" + "main.do";
        }
    }

    @PostMapping("/boards/signup.do")
    public Object signup(ModelAndView modelAndView, Model model, HttpServletRequest request, HttpServletResponse response) {

        String id = request.getParameter("id");

        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", id);
        Map<String, Object> resultIdMap = userService.getDupId(paramMap);

        if(resultIdMap != null){
            //model.addAttribute("message", "ID가 존재합니다 다른 ID로 가입해주세요");
            return null;
        } else{
            String password = request.getParameter("password");
            paramMap.put("password", password);
            userService.insertUser(paramMap);
            return "/boards/index";
        }
    }

    @RequestMapping("/boards/main.do")
    public String main(Model model, HttpServletRequest request, HttpServletResponse response) {

        String id = (String) request.getSession().getAttribute("id");
        if(id != null){
            Map<String, Object> loginTime = userService.getLoginTime(id);
            Map<String, Object> loginCnt = userService.getLoginCnt(id);

            model.addAttribute("id", id);
            model.addAttribute("loginTime", loginTime.get("loginTime"));
            model.addAttribute("cnt", loginCnt.get("cnt"));

        }

        return "boards/main";
    }

}
