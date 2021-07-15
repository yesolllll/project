<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, user-scalable=yes">
    <meta name="format-detection" content="telephone=no, address=no, email=no">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <title>게시판 상세</title>
	<%@ include file="/WEB-INF/view/include/head.jsp" %>
</head>
<body>
    <div class="wrap">
       <%@ include file="/WEB-INF/view/include/top.jsp" %>
        <div class="sub">
            <div class="size">
                <h3 class="sub_title">게시판</h3>
                <div class="bbs">
                    <div class="view">
                        <div class="title">
                            <dl>
                                <dt>${vo.title } </dt>
                                <dd class="date">작성일 :${vo.regdate } </dd>
                            </dl>
                        </div>
                        <div class="cont"><p>${vo.content }</p> </div>
                        
                        <c:if test="${!empty vo.filename_org}">  <!-- ←파일이 저장된 경우에만 첨부파일 있다고 출력 -->
                        	<dl class="file">
                            	<dt>첨부파일 </dt>
                            	<dd>
                            	<a href="/project/common/download.jsp?path=/upload/&org=${vo.filename_org }&real=${vo.filename_real}"  
                            	target="_blank">첨부파일.pptx [38.07KB] </a>
                            	</dd>
                        	</dl>
                         </c:if>         
                        
                        <div class="btnSet clear">
                            <div class="fl_l"><a href="index.do?reqPage=${param.reqPage}&stype=${param.stype}&sval=${param.sval}&orderby=${param.orderby}&direct=${param.direct}" class="btn">목록으로</a></div>
                            <c:if test="${userInfo.no == vo.user_no}">
                            	<div class="fl_l"><a href="edit.do?no=${vo.no}" class="btn">수정</a></div>
                            	<div class="fl_l"><a href="javascript:isDel();" class="btn">삭제</a></div>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
      <%@ include file="/WEB-INF/view/include/bottom.jsp" %>
    </div>
    <script >
    	function isDel() {
			if(confirm("삭제하시겠습니까?")){			/* ← 확인 "true" 취소 "false" */
			 //삭제처리
				$.ajax({
					url:'delete.do',
					data:{
						'no':${vo.no}
					},
					method: 'post',
					success:function(res){
						console.log(res);
						if(res.trim() == 'true'){
							alert('정상적으로 삭제되었습니다.');
							location.href ='index.do';
						}else{
							alert('삭제 실패');
						}
					}
				}); 
			}
		}
    </script>
</body>
</html>