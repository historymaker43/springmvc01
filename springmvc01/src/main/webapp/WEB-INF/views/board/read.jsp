<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="/WEB-INF/views/include/header.jsp" %>

<script>
	$(function(){
		
		var frmPaging = $("#frmPaging");
		var update_result = "${update_result}";
		
		if (update_result == "true"){
			alert("수정되었습니다.");
		}
		
		// 수정 버튼
		$("#btnUpdate").click(function(){
			// readonly 해제
			$("*[readonly]").attr("readonly", false);
			$(this).fadeOut("fast");
			$("#btnUpdateRun").fadeIn("fast");
		});
		
		// 삭제버튼
		$("#btnDelete").click(function(e){
			e.preventDefault();
			var bno = $(this).attr("href");
			frmPaging.find("input[name=bno]").val(bno);
			frmPaging.attr("action", "/board/delete");
			frmPaging.attr("method", "get");
			frmPaging.submit();
		});
		
		$("#a_list").click(function(e){
			e.preventDefault();
			frmPaging.find("input[name=bno]").val("${boardVo.bno}");
			frmPaging.attr("action", "/board/list");
			frmPaging.submit();
		});
		
		$("#btnCommentInsert").click(function(){
			var content = $("#c_content").val();
			var userid = $("#c_userid").val();
			var bno = "${boardVo.bno}";
			var sData = {
					"content" : content,
					"userid" : userid,
					"bno" : bno
			};
			var url = "/comment/insertComment";
			$.post(url, sData, function(rData) {
				console.log(rData);
				if (rData == "true"){
					getCommentList();
				}
			});
		});
		
		function getCommentList(){
			var bno = "${boardVo.bno}";
			var url = "/comment/commentList/" + bno;
			$.get(url, function(rData){
				console.log("rData:", rData);
				$("#table_comment_list tr:gt(0)").remove();
				
				$.each(rData, function(){
					var tr = $("#table_clone tr").clone();
					var tds = tr.find("td");
					tds.eq(0).text(this.cno);
					tds.eq(1).text(this.content);
					tds.eq(2).text(this.userid);
					tds.eq(3).text(this.regdate);
					tds.find(".btnCommentDelete").attr("data-cno", this.cno);
					tds.find(".btnCommentModify").attr("data-cno", this.cno);
					$("#table_comment_list").append(tr);
				});
			});
		}
		
		getCommentList();
		

		// 댓글 삭제 버튼
		$("#table_comment_list").on("click", ".btnCommentDelete", function(){
			console.log("댓글 삭제 버튼");
			var cno = $(this).attr("data-cno");
			var url = "/comment/commentDelete/" + cno;
			$.get(url, function(rData){
				console.log(rData);
				if (rData == "true"){
					getCommentList();
				}
			});
			
		});
		
		// 댓글 수정 버튼
		$("#table_comment_list").on("click", ".btnCommentModify", function(){
			$("#modal-790385").trigger("click");
			var tr = $(this).parents("tr");
			var content = tr.find("td").eq(1).text();
			$("#modalContent").val(content);
			$("#btnModalSave").attr("data-cno", $(this).attr("data-cno"));
		});
		
		// 모달창 저장 버튼
		$("#btnModalSave").click(function(){
			var content = $("#modalContent").val();
			var cno = $(this).attr("data-cno");
			var sData = {
					"content" : content,
					"cno" : cno
			};
			var url = "/comment/updateComment";
			
			$.post(url, sData, function(rData){
				console.log(rData);
				if (rData == "true") {
					getCommentList();
					$("#btnModalClose").trigger("click");
				}
			});
		});
		
	});
</script>

<%@ include file="/WEB-INF/views/include/paging.jsp" %>

<div class="container-fluid">

	<!-- 모달 창 -->
	
	<div class="row">
		<div class="col-md-12">
			 <a id="modal-790385" href="#modal-container-790385" role="button" class="btn" data-toggle="modal" style="display: none;">Launch demo modal</a>
			
			<div class="modal fade" id="modal-container-790385" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="myModalLabel">댓글 수정</h5> 
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">×</span>
							</button>
						</div>
						<div class="modal-body">
							<input id="modalContent" type="text" class="form-control">
						</div>
						<div class="modal-footer">
							 
							<button type="button" class="btn btn-primary" id="btnModalSave">
								저장
							</button> 
							<button type="button" class="btn btn-secondary" data-dismiss="modal" id="btnModalClose">
								닫기
							</button>
						</div>
					</div>
					
				</div>
				
			</div>
			
		</div>
	</div>
	
	<!-- // 모달창 -->

	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>글 내용 보기</h2>
				<p>
					<a class="btn btn-primary btn-large" id="a_list" href="#">글 목록</a>
				</p>
			</div>
			<div class="row">
				<div class="col-md-12">
					<form class="rol-form" action="/board/updateRun" method="post">
						<input type="hidden" name="bno" value="${boardVo.bno}">
						<input type="hidden" name="page" value="${pagingDto.page}">
						<input type="hidden" name="perPage" value="${pagingDto.perPage}">
						<input type="hidden" name="keyword" value="${pagingDto.keyword}">
						<input type="hidden" name="searchType" value="${pagingDto.searchType}">
						
						<div class="form-group">
							<label for="title">제목</label>
							<input type="text" class="form-control" id="title" name="title" value="${boardVo.title}" readonly />
						</div>
						<div class="form-group">
							<label for="content">내용</label>
							<textarea class="form-control" id="content" name="content" readonly>${boardVo.content}</textarea>
						</div>
						<div class="form-group">
							<label for="writer">작성자</label> 
							<input type="text" class="form-control" id="writer" name="writer" value="${boardVo.writer}" readonly />
						</div>
						<button type="button" class="btn btn-primary" id="btnUpdate">수정</button>
						<button type="submit" class="btn btn-success" id="btnUpdateRun" style="display: none;">수정완료</button>
						<a class="btn btn-danger" href="${boardVo.bno}" id="btnDelete" >삭제</a>
						<a class="btn btn-warning" href="/board/replyForm?bno=${boardVo.bno}">답글</a>
					</form>
				</div>
			</div>
			<!-- 댓글(comment) -->
				
			<div class="row" style="margin-top: 30px; ">
					<div class="col-9">
						<input type="text" class="form-control" placeholder="댓글을 입력해주세요." id="c_content">
					</div>
					<div class="col-2">
						<input type="text" class="form-control" placeholder="아이디를 입력하세요." id="c_userid">
					</div>
					<div class="col-1">
						<button type="button" class="btn btn-sm btn-primary" id="btnCommentInsert">완료</button>
					</div>
			</div>
			
			<div class="row" style="margin-top: 30px;">
				<div class="col-md-12">
					<table style="display: none;" id="table_clone">
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>
								<button type="button" class="btn btn-sm btn-warning btnCommentModify">수정</button>
							</td>
							<td>
								<button type="button" class="btn btn-sm btn-danger btnCommentDelete">삭제</button>
							</td>
						</tr>
					</table>
					<table class="table" id="table_comment_list">
						<!-- 목록 나오는 곳 -->
						<tr>
							<td>#</td>
							<td>댓글 내용</td>
							<td>작성자</td>
							<td>날짜</td>
							<td>수정</td>
							<td>삭제</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/views/include/footer.jsp" %>