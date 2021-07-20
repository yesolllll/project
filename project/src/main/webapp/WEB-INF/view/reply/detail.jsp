<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, user-scalable=yes">
    <meta name="format-detection" content="telephone=no, address=no, email=no">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <title>답변 게시판 상세</title>
    <%@ include file="/WEB-INF/view/include/head.jsp" %>
    <script>
	function reply() {
		<c:if test="${!empty userInfo}">
			location.href='reply.do?no=${vo.no}&gno=${vo.gno}&ono=${vo.ono}&nested=${vo.nested}';
		</c:if>
		<c:if test="${empty userInfo}">
			alert('로그인 후 사용가능합니다.')
		</c:if>
	}
	
    </script>
</head>
<body>
    <div class="wrap">
        <%@ include file="/WEB-INF/view/include/top.jsp" %>
        <div class="sub">
            <div class="size">
                <h3 class="sub_title">답변 게시판</h3>
                <div class="bbs">
                    <div class="view">
                        <div class="title">
                            <dl>
                                <dt>${vo.title }</dt>
                                <dd class="date">작성일 : ${vo.regdate } </dd>
                            </dl>
                        </div>
                        <div class="cont">${vo.content } </div>
                        <dl class="file">
                            <dt>첨부파일 </dt>
                            <dd>
                            <a href="/project/common/download.jsp?path=/upload/&org=${vo.filename_org}&real=${vo.filename_real}" 
                            target="_blank">${vo.filename_org }</a></dd>
                        </dl>
                                    
                        <div class="btnSet clear">
                            <div class="fl_l"><a href="index.do?reqPage=${param.reqPage}&stype=${param.stype}&sval=${param.sval}&orderby=${param.orderby}&direct=${param.direct}" class="btn">목록으로</a></div>
                             <div class="fl_l"><a href="javascript:reply();"  class="btn">답변</a></div>
                            <c:if test="${userInfo.no == vo.user_no}">
                            <div class="fl_l"><a href="edit.do?no=${vo.no}" class="btn">수정</a></div>
                            <div class="fl_l"><a href="javascript:isDel();" class="btn">삭제</a></div>
                            </c:if>
                        </div>
                    </div>
                    <!-- 댓글영역 form태그 필요없음. ajax로 처리. -->
                    <table class="board_write">
                        <colgroup>
                            <col width="*" />
                            <col width="80px" />
                        </colgroup>
                        <tbody>
                        <tr>
                            <td>
                                <textarea name="content" id="content" style="width:100%; height:50px"></textarea>
                            </td>
	                        <td>    
		                        <div class="btnSet"  style="text-align:right;">
		                       		<a class="btn" href="javascript:goSave();">저장 </a>
		                    	</div>
	                    	</td>
                        </tr>
                        </tbody>
                    </table>

                    <script>
                    	function goSave(){
                    		<c:if test="${!empty userInfo}">  
	                    		if($("#content").val().trim()==''){ //스페이스바 방지 
	                    			alert('내용을 입력해 주세요.');
	                    		}else{
	                    			if(confirm('댓글을 등록하시겠습니까?')){
			                    		$.ajax({
			                    			url : '/project/reply/comment/insert.do',
			                    			data : {
			                    				content:$("#content").val(),
			                    				board_no:${vo.no},
			                    				user_no:${userInfo.no}
			                    			},
			                    			success:function(res){
			                    				if(res.trim()=='true'){
			                    					alert('댓글이 등록되었습니다.');
			                    					$("#content").val("");  /* 작성부분의 값을 "" 으로 변경 */
			                    					getComment(1);
			                    				}else{
			                    					alert('댓글 등록 실패');
			                    				}
			                    			}
			                    		});
	                    			}
	                    		}
                    		</c:if>  
                    		<c:if test="${empty userInfo}">
                    			alert('댓글은 로그인 후 사용가능합니다.');
                    		</c:if>
                    	}         
                   	 $(function () {
                 		/* 
                 		여러곳에서 재사용하기 위해 함수사용
                 		또, 예를 들어 상품 상세 페이지에 달린 댓글 페이징 처리를 할 경우 
                 		상세페이지는 이동 안하고 댓글 페이지만 이동 할때 ajax 호출하여 사용하는 경우 많음 
                 		*/
                 		 getComment(1)  /*새로 로드될때 1페이지 고정 */
                 		});
                   	 function getComment(reqPage) {    
						$.ajax({
							url: '/project/reply/comment/list.do',
							data: {board_no: ${vo.no},
								   reqPage: reqPage
							},
							success:function(res){
								$("#commentArea").html(res);
							}
						});
					}
                    </script> 
                          
           				<!-- 댓글 있던 자리 -->
           				
                    <div id="commentArea"></div>
                </div>
            </div>
        </div>
        <%@ include file="/WEB-INF/view/include/bottom.jsp" %>
    </div>
    <script>
  
    	function isDel() {
    		if (confirm('삭제하시겠습니까?')) {
    			// 삭제처리
    			$.ajax({
    				url:'delete.do',
    				data:{
    					'no':${vo.no}
    				},
    				method:'post',
    				success:function(res) {
    					console.log(res);
    					if (res.trim() == 'true') {
    						alert('정상적으로 삭제되었습니다.');
    						location.href='index.do';
    					} else {
    						alert('삭제 실패');
    					}
    				},
    				error : function(res) {
    					console.log(res);
    				}
    			});
    		}
    	}
    </script>
</body>
</html>