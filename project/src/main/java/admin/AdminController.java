package admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController{

@RequestMapping("/admin")
public String login(){
return "admin/index";
 }

@RequestMapping("/admin/board/index.do")
public String index(){
return "admin/board/index";
 }

@RequestMapping("/admin/board/view.do")
public String view(){
return "admin/board/view";
 }

@RequestMapping("/admin/board/write.do")
public String write(){
return "admin/board/write";
 }
}