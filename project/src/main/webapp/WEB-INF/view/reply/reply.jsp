<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, user-scalable=yes">
    <meta name="format-detection" content="telephone=no, address=no, email=no">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <title>답변 게시판 등록</title>
    <%@ include file="/WEB-INF/view/include/head.jsp" %>
      <script>
		function goSave() {
    		oEditors.getById['content'].exec("UPDATE_CONTENTS_FIELD",[]);
    		$("#frm").submit();
    	}
    	var oEditors;
    	$(function(){
    		oEditors = setEditor("content"); // id
    	});
 		/* var id ='{$userInfo.id}';
    	//로그인 할때만 글작성 가능
    	<c:if test="${empty userInfo}">
    	alert('로그인 후 사용가능합니다');
    	location.href='index.do'
    	</c:if> */
    </script>
</head>
<body>
    <div class="wrap">
       <%@ include file="/WEB-INF/view/include/top.jsp" %>
        <div class="sub">
            <div class="size">
                <h3 class="sub_title">답변 게시판</h3>
    
                <div class="bbs">
                <form method="post" name="frm" id="frm" action="insertReply.do" enctype="multipart/form-data" >
                 <input type="hidden"  name="user_no" value="${userInfo.no}">  <!-- usercontroller에서 login처리중 session에 login한 회원의 정보를 userInfo라는 이름으로 저장 -->
                 <input type="hidden"  name="gno" value="${gno }">   <!-- param 또는 replyVO 둘다 가능함 -->
                 <input type="hidden"  name="ono" value="${param.ono }">
                 <input type="hidden"  name="nested" value="${replyVO.nested }">
                    <table class="board_write">
                        <tbody>
                        <tr>
                            <th>제목</th>
                            <td>
                                <input type="text" name="title" id="title" class="wid100" value=""/>
                            </td>
                        </tr>
                        <tr>
                            <th>내용</th>
                            <td>
                                <textarea name="content" id="content" style="width: 900px"></textarea>
                            </td>
                        </tr>
                        <tr>
                        	<th>파일 첨부</th>
                        	<td>
                        	<input type="file" name="file"> <!-- ← 확인 -->
                        	</td>
                        </tr>
                        </tbody>
                    </table>
                    <div class="btnSet"  style="text-align:right;">
                        <a class="btn" href="javascript:goSave();">저장 </a>
                    </div>
                    </form>
                </div>
            </div>
        </div>
        <%@ include file="/WEB-INF/view/include/bottom.jsp" %>
    </div>
</body>
</html>