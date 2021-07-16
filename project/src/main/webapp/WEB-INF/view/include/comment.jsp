<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<meta charset="EUC-KR">
		<!-- 댓글 목록 -->
         <table class="list">
                    <p><span><strong>총 ${commentVO.totCount }개</strong>  |  ${commentVO.reqPage}/${commentVO.totPage }페이지</span></p>
                        <caption>댓글 목록</caption>
                        <colgroup>
                            <col width="*" />
                            <col width="100px" />
                            <col width="100px" />
                        </colgroup>
                        <tbody>
						<c:if test="${empty list }">
                            <tr>
                                <td class="first" colspan="5">등록된 댓글이 없습니다.</td>
                            </tr>
                        </c:if>
                        <c:forEach var="vo" items="${list }">     
                            <tr>
                                <td class="txt_l">
                                    ${vo.content }
                                <td class="writer">
                                    ${vo.name}
                                </td>
                                <td class="date"><fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <!-- 페이징 처리 -->
                    <div class="pagenate clear">
						<ul class='paging'>
							<c:if test="${commentVO.startPage > commentVO.pageRange}">
								<li><a
									href="javascript:getComment(${commentVO.startPage-1})"><</a>
								</li>
							</c:if>
									<!-- 동작하던 전 페이지로 가려면 파라미터를 물고 다녀야함 예를들어 상세 페이지에서 목록으로 갔을경우 보던페이지 출력시>  -->
									<!-- 즉 1보다 작으면 안되고, 이전을 누르면 시작페이지에서 1뺀 곧으로 이동 /for문안에 있으면 x -->

							<c:forEach var="rp" begin="${commentVO.startPage}" end="${commentVO.endPage}">
								<li><a
									href='javascript:getComment(${rp})'
									<c:if test="${rp==commentVO.reqPage }">class='current'</c:if>>${rp}</a></li>
							</c:forEach>

							<c:if test="${commentVO.totPage > commentVO.endPage}">
								<li><a href="javascript:getComment(${commentVO.endPage+1})">></a></li>
								<!-- for문안에 있으면 x -->
							</c:if>
						</ul>
					</div>