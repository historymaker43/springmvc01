<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="/WEB-INF/views/include/header.jsp"%>

<div class="row">
	<div class="col-md-12">
		<div class="tabbable" id="tabs-943751">
			<ul class="nav nav-tabs">
				<li class="nav-item">
					<a class="nav-link" href="/message/receive">받은 쪽지함</a>
				</li>
				<li class="nav-item">
					<a class="nav-link active" href="#">보낸 쪽지함</a>
				</li>
			</ul>
			
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>#</th>
					<th>내용</th>
					<th>받는사람</th>
					<th>날짜</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${messageList}" var="messageVo" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td>${messageVo.message}</td>
						<td>${messageVo.receiver}</td>
						<td>
						<c:choose>
							<c:when test="${empty messageVo.opendate}">
								읽지 않음
							</c:when>
							<c:otherwise>
								${messageVo.opendate}
							</c:otherwise>
						</c:choose>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<%@ include file="/WEB-INF/views/include/footer.jsp"%>