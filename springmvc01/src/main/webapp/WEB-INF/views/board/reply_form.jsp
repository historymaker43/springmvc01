<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="/WEB-INF/views/include/header.jsp"%>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>답글 쓰기</h2>
				<p>
					<a class="btn btn-primary btn-large" href="/board/list">목록</a>
				</p>
			</div>
			<div class="row">
				<div class="col-md-12">
					<form role="form" action="/board/replyRun" method="post">
					<input type="hidden" name="re_group" value="${boardVo.re_group}">
					<input type="hidden" name="re_level" value="${boardVo.re_level}">
					<input type="hidden" name="re_seq" value="${boardVo.re_seq}">
						<div class="form-group">
							<label for="title">제목</label> 
							<input type="text" class="form-control" id="title" name="title" value="re : ${boardVo.title}" />
						</div>
						<div class="form-group">
							<label for="content">내용</label>
							<textarea class="form-control" id="content" name="content">

---------------------------------------
${boardVo.content}</textarea>
						</div>
						<div class="form-group">
							<label for="writer">작성자</label> 
							<input type="text" class="form-control" id="writer" name="writer" />
						</div>
						<button type="submit" class="btn btn-primary">작성완료</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/views/include/footer.jsp"%>