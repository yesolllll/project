<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, height=device-height, initial-scale=1.0, user-scalable=yes">
<meta name="format-detection"
	content="telephone=no, address=no, email=no">
<meta name="keywords" content="">
<meta name="description" content="">
<title>게시판목록</title>
<%@ include file="/WEB-INF/view/include/head.jsp"%>
<script >
</script>
</head>
<body>
	<div class="wrap">
		<%@ include file="/WEB-INF/view/include/top.jsp"%>
		<div class="sub">
			<div class="size">
				<h3 class="sub_title">내가 쓴 글</h3>

				<div class="bbs">
					<table class="list">
						<!-- boardVO는 VO에서 getter에서 get을뺀값을 쓰는것이기 때문에 소문자로 작성 -->
						<p>
							<span><strong>총 ${boardVO.totCount}개</strong> |
								${boardVO.reqPage}/${boardVO.totPage }페이지</span>
						</p>
						<caption>게시판 목록</caption>
						<colgroup>
							<col width="80px" />
							<col width="*" />
							<col width="100px" />
							<col width="100px" />
							<col width="80px" />
						</colgroup>
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일</th>
								<th>조회수</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${empty list}">
								<tr>
									<td class="first" colspan="5">등록된 글이 없습니다.</td>
								</tr>
							</c:if>

							<c:forEach var="vo" items="${list}">
								<tr>
									<td>${vo.no }</td>
									<td class="txt_l"><a href="/project/board/detail.do?no=${vo.no}&reqPage=${boardVO.reqPage }&stype=${boardVO.stype}&sval=${boardVO.sval}&orderby=${boardVO.orderby}&direct=${boardVO.direct}">
											${vo.title}</a></td>
									<td class="writer">${vo.name}</td>
									<td class="date">${vo.regdate}</td>
									<td>${vo.readcount}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="btnSet" style="text-align: right;">
						<a class="btn" a href="javascript:move();">글작성 </a>
					</div>
					<!-- 페이징처리 -->
					<div class="pagenate clear">
						<ul class='paging'>
							<c:if test="${boardVO.startPage > boardVO.pageRange}">
								<li><a
									href="mypage.do?reqPage=${boardVO.startPage-1}&stype=${param.stype}&sval=${param.sval}"><</a>
								</li>
							</c:if>
									<!-- 동작하던 전 페이지로 가려면 파라미터를 물고 다녀야함 예를들어 상세 페이지에서 목록으로 갔을경우 보던페이지 출력시>  -->
									<!-- 즉 1보다 작으면 안되고, 이전을 누르면 시작페이지에서 1뺀 곧으로 이동 /for문안에 있으면 x -->

							<c:forEach var="rp" begin="${boardVO.startPage}"
								end="${boardVO.endPage}">
								<li><a
									href='mypage.do?reqPage=${rp}&stype=${param.stype}&sval=${param.sval}&orderby=${param.orderby}&direct=${param.direct}'
									<c:if test="${rp==boardVO.reqPage }">class='current'</c:if>>${rp}</a></li>
							</c:forEach>

							<c:if test="${boardVO.totPage > boardVO.endPage}">
								<li><a
									href="mypage.do?reqPage=${boardVO.endPage+1}&stype=${param.stype}&sval=${param.sval}&orderby=${param.orderby}&direct=${param.direct}">></a>
								</li>
								<!-- for문안에 있으면 x -->
							</c:if>
						</ul>
					</div>

					<!-- 검색 -->
					<div class="bbsSearch">
						<form method="get" name="searchForm" id="searchForm" action="">
							<span class="srchSelect">
							 <select id="orderby" name="orderby"     
								class="dSelect" title="검색분류 선택" onchange="$('#searchForm').submit();"> 			<!-- name과 vo변수명이 같아야함! -->
									<option value="regdate"
										<c:if test="${param.stype =='regdate' }">selected</c:if>>작성일</option>
									<option value="readcount"
										<c:if test="${param.stype =='readcount' }">selected</c:if>>내용</option>
							</select>
							 <select id="direct" name="direct"
								class="dSelect" title="검색분류 선택" onchange="$('#searchForm').submit();">
									<option value="DESC"
										<c:if test="${param.stype =='DESC' }">selected</c:if>>오름차순</option>
									<option value="ASC"
										<c:if test="${param.stype =='ASC' }">selected</c:if>>내림차순</option>
							</select>
							 <select id="stype" name="stype"
								class="dSelect" title="검색분류 선택" onchange="$('#searchForm').submit();">
									<option value="all">전체</option>
									<option value="title"
										<c:if test="${param.stype =='title' }">selected</c:if>>제목</option>
									<option value="content"
										<c:if test="${param.stype =='content' }">selected</c:if>>내용</option>
							</select>
							
							</span> <span class="searchWord"> <input type="text" id="sval"
								name="sval" value="${boardVO.sval}" title="검색어 입력"> <input
								type="button" id="" value="검색" title="검색"
								onclick="$('#searchForm').submit();"> 
										<!-- ↑ 버튼누르면 이동, type submit변경 css풀림 -->

							</span>
						</form>

					</div>
				</div>
			</div>
		</div>
		<%@ include file="/WEB-INF/view/include/bottom.jsp"%>
	</div>
</body>
</html>