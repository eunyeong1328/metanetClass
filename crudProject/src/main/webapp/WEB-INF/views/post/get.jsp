<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">공고별 상세 페이지</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">

      <div class="panel-heading">공고별 상세 페이지</div>
      <!-- /.panel-heading -->
      <div class="panel-body">

          <div class="form-group">
          <label>공고번호</label> <input class="form-control" name='post_seq'
            value='<c:out value="${post.post_seq }"/>' readonly="readonly">
        </div>

        <div class="form-group">
          <label>공고제목</label> <input class="form-control" name='post_title'
            value='<c:out value="${post.post_title }"/>' readonly="readonly">
        </div>

        <div class="form-group">
          <label>직종</label>
          <textarea class="form-control" rows="3" name='post_job'
            readonly="readonly"><c:out value="${post.post_job}" /></textarea>
        </div>

        <div class="form-group">
          <label>경력구분</label> <input class="form-control" name='post_career'
            value='<c:out value="${post.post_career }"/>' readonly="readonly">
        </div>
        
        <div class="form-group">
          <label>고용형태</label> <input class="form-control" name='post_emptype'
            value='<c:out value="${post.post_emptype }"/>' readonly="readonly">
        </div>
        
        <div class="form-group">
          <label>근무지</label> <input class="form-control" name='post_add'
            value='<c:out value="${post.post_add }"/>' readonly="readonly">
        </div>

<%-- 		<button data-oper='modify' class="btn btn-default">
        <a href="/board/modify?bno=<c:out value="${board.bno}"/>">Modify</a></button>
        <button data-oper='list' class="btn btn-info">
        <a href="/board/list">List</a></button> --%>


<button data-oper='modify' class="btn btn-default">수정</button>
<button data-oper='list' class="btn btn-info">목록보기</button>


<form id='operForm' action="/boad/modify" method="get">
  <input type='hidden' id='post_seq' name='post_seq' value='<c:out value="${post.post_seq}"/>'>

</form>



      </div>
      <!--  end panel-body -->

    </div>
    <!--  end panel-body -->
  </div>
  <!-- end panel -->
</div>
<!-- /.row -->

<script type="text/javascript">
$(document).ready(function() {
  
  var operForm = $("#operForm"); 
  
  $("button[data-oper='modify']").on("click", function(e){
    
    operForm.attr("action","/post/modify").submit();
    
  });
  
    
  $("button[data-oper='list']").on("click", function(e){
    
    operForm.find("#post_seq").remove();
    operForm.attr("action","/post/list")
    operForm.submit();
    
  });  
});
</script>
