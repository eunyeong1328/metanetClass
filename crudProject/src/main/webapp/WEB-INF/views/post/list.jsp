<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Tables</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				Board List Page
				<button id='regBtn' type="button" class="btn btn-xs pull-right">Register
					New Board</button>
			</div>

			<!-- /.panel-heading -->
			<div class="panel-body">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>공고번호</th>
							<th>공고제목</th>
							<th>직종</th>
							<th>경력구분</th>
							<th>고용형태</th>
							<th>근무지</th>
						</tr>
					</thead>

					<c:forEach items="${list}" var="post">
						<tr>
							<td><c:out value="${post.post_seq}" /></td>

							<td>
								<a class='move' href='<c:out value="${post.post_title}"/>'>
										<c:out value="${post.post_title}" />
								</a>
							</td>
							<td><c:out value="${post.post_job}" /></td>
							<td><c:out value="${post.post_career}" /></td>
							<td><c:out value="${post.post_emptype}" /></td>
							<td><c:out value="${post.post_add}" /></td>
						</tr>
					</c:forEach>
				</table>


			</div>


		</div>
		<!--  end panel-body -->
	</div>
	<!-- end panel -->
</div>
</div>
<!-- /.row -->






<script type="text/javascript">
	$(document)
			.ready(
					function() {

						var result = '<c:out value="${result}"/>';

						checkModal(result);

						history.replaceState({}, null, null);//history안을 초기화시킴

						function checkModal(result) {

							if (result === '' || history.state) {
								return;
							}

							if (parseInt(result) > 0) {
								$(".modal-body").html(
										"게시글 " + parseInt(result)
												+ " 번이 등록되었습니다.");
							}

							$("#myModal").modal("show");
						}

						$("#regBtn").on("click", function() {

							self.location = "/post/register";

						});

						var actionForm = $("#actionForm");

						$(".paginate_button a").on(
								"click",
								function(e) {

									e.preventDefault(); //기본 이벤트 취소

									console.log('click');

									actionForm.find("input[name='pageNum']")
											.val($(this).attr("href")); //this는 클릭한 a이다.
									actionForm.submit();
								});

$(".move").on("click",function(e) {
		e.preventDefault();
		actionForm.append("<input type='hidden' name='bno' value='"+ $(this).attr("href") + "'>");
		actionForm.attr("action","/board/get");
		actionForm.submit();
});

	v
</script>




