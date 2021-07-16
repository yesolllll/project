<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<meta charset="EUC-KR">
		<!-- ��� ��� -->
         <table class="list">
                    <p><span><strong>�� ${commentVO.totCount }��</strong>  |  ${commentVO.reqPage}/${commentVO.totPage }������</span></p>
                        <caption>��� ���</caption>
                        <colgroup>
                            <col width="*" />
                            <col width="100px" />
                            <col width="100px" />
                        </colgroup>
                        <tbody>
						<c:if test="${empty list }">
                            <tr>
                                <td class="first" colspan="5">��ϵ� ����� �����ϴ�.</td>
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
                    <!-- ����¡ ó�� -->
                    <div class="pagenate clear">
						<ul class='paging'>
							<c:if test="${commentVO.startPage > commentVO.pageRange}">
								<li><a
									href="javascript:getComment(${commentVO.startPage-1})"><</a>
								</li>
							</c:if>
									<!-- �����ϴ� �� �������� ������ �Ķ���͸� ���� �ٳ���� ������� �� ���������� ������� ������� ���������� ��½�>  -->
									<!-- �� 1���� ������ �ȵǰ�, ������ ������ �������������� 1�� ������ �̵� /for���ȿ� ������ x -->

							<c:forEach var="rp" begin="${commentVO.startPage}" end="${commentVO.endPage}">
								<li><a
									href='javascript:getComment(${rp})'
									<c:if test="${rp==commentVO.reqPage }">class='current'</c:if>>${rp}</a></li>
							</c:forEach>

							<c:if test="${commentVO.totPage > commentVO.endPage}">
								<li><a href="javascript:getComment(${commentVO.endPage+1})">></a></li>
								<!-- for���ȿ� ������ x -->
							</c:if>
						</ul>
					</div>