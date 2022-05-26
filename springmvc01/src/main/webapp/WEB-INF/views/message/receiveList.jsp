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
					<a class="nav-link active" href="#">받은 쪽지함</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/message/send">보낸 쪽지함</a>
				</li>
			</ul>
			
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>#</th>
					<th>내용</th>
					<th>보낸사람</th>
					<th>날짜</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${messageList}" var="messageVo" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td>${messageVo.message}</td>
						<td>${messageVo.sender}</td>
						<td>${messageVo.senddate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<%@ include file="/WEB-INF/views/include/footer.jsp"%>