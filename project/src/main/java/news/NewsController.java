package news;



import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class NewsController {
	
	@Autowired
	NewsService service;
	
	@RequestMapping("/news/index.do")
	public String index(Model model, NewsVO vo) {
	model.addAttribute("list", service.selectAll(vo));
	
	return "news/index";
	}
	
	@RequestMapping("/news/detail.do")
	public String detail(Model model, NewsVO vo) {
		model.addAttribute("vo",service.detail(vo));
	
	return "news/detail";
	}
	
	@RequestMapping("/news/write.do")
	public String write(Model model, NewsVO vo) {
		return "news/write";
	}

	@RequestMapping("/news/insert.do")            						/*↓ 파일첨부를 위한 변수*/
	public String insert(Model model, NewsVO vo, @RequestParam("file")  MultipartFile file, HttpServletRequest req) {
		if( !file.isEmpty()) { 	//첨부파일이 있으면 
			try {
			String org = file.getOriginalFilename();	// 원본파일명
			String ext =""; //확장자
			ext = org.substring(org.lastIndexOf("."));
			String real= new Date().getTime()+ext;		//서버에 저장할 파일
				//파일 저장
			String path = req.getRealPath("/upload/");  //경로
			file.transferTo(new File(path+real)); 		//경로+파일명
				//vo에 set
				vo.setFilename_org(org);
				vo.setFilename_real(real);
			} catch (Exception e) {
			} 
		}
		int r = service.insert(vo);
		//r > 0 :정상 → alert → 목록으로 이동
		//r ==0:비정상 → alert → 이전페이지로 이동
		if(r>0) {
			model.addAttribute("msg","정상적으로 등록되었습니다.");
			model.addAttribute("url","index.do");
		}else {
			model.addAttribute("msg","등록실패.");
			model.addAttribute("url","write.do");
		}
		return "include/alert";
	}
	
	@RequestMapping("/news/edit.do")
	public String edit(Model model, NewsVO vo) {
		model.addAttribute("vo",service.edit(vo));
		return "news/edit";
	}
	
	@RequestMapping("/news/update.do")            						/*↓ 파일첨부를 위한 변수*/
	public String update(Model model, NewsVO vo, @RequestParam("file")  MultipartFile file, HttpServletRequest req) {
		if( !file.isEmpty()) { 	//첨부파일이 있으면 
			try {
			String org = file.getOriginalFilename();	// 원본파일명
			String ext =""; //확장자
			ext = org.substring(org.lastIndexOf("."));
			String real= new Date().getTime()+ext;		//서버에 저장할 파일
				//파일 저장
			String path = req.getRealPath("/upload/");  //경로
			file.transferTo(new File(path+real)); 		//경로+파일명
				//vo에 set
				vo.setFilename_org(org);
				vo.setFilename_real(real);
			} catch (Exception e) {
			} 
		}
		int r = service.update(vo);
		//r > 0 :정상 → alert → 목록으로 이동
		//r ==0:비정상 → alert → 이전페이지로 이동
		if(r>0) {
			model.addAttribute("msg","정상적으로 수정되었습니다.");
			model.addAttribute("url","index.do");
		}else {
			model.addAttribute("msg","수정실패.");
			model.addAttribute("url","edit.do no="+vo.getNo());
		}
		return "include/alert";
	}
	
	@RequestMapping("/news/delete.do")
	public String delete(Model model, NewsVO vo) {
	
	int r= service.delete(vo);
	if(r>0) {
		model.addAttribute("result","true");
	}else {
		model.addAttribute("result","false");
	}
	
	return "include/result";
	}
	
}
