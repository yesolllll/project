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
    <title>게시판 등록</title>
    <script >
    function goSave() {
		$("#frm").submit();
	}
    </script>
<%@ include file="/WEB-INF/view/include/head.jsp" %>
</head>
<body>
    <div class="wrap">
       <%@ include file="/WEB-INF/view/include/top.jsp" %>
        <div class="sub">
            <div class="size">
                <h3 class="sub_title">게시판</h3>
    
                <div class="bbs">
                <form method="post" name="frm" id="frm" action="update.do" enctype="multipart/form-data" >
                    <table class="board_write">
                        <tbody>
                        <tr>
                            <th>제목</th>
                            <td>
                                <input type="text" name="title" id="title" class="wid100" value="${vo.title }"/>
                            </td>
                        </tr>
                        <tr>
                            <th>내용</th>
                            <td>
                                <textarea name="content" id="content">${vo.content }</textarea>
                            </td>
                        </tr>
                        <tr>
                        	<th>파일 첨부</th>
                        	<td>
                        	기존파일 : ${vo.filename_org }<br>
                        	<input type="checkbox" name="isDel" value="1">  <!-- 추가 -->
                        	<input type="file" name="file"> <!-- ← 확인 -->
                        	</td>
                        </tr>
                        </tbody>
                    </table>
                    <div class="btnSet"  style="text-align:right;">
                        <a class="btn" href="javascript:goSave();">저장 </a>
                    </div>
                    <input type="hidden" name="no" value="${vo.no}">
                    </form>
                </div>
            </div>
        </div>
        <%@ include file="/WEB-INF/view/include/bottom.jsp" %>
    </div>
</body>
</html>