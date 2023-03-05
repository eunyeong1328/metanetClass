<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">공고수정</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">

      <div class="panel-heading">공고수정</div>
      <!-- /.panel-heading -->
      <div class="panel-body">

      <form role="form" action="/post/modify" method="post">
      
 
<div class="form-group">
  <label>공고번호</label> 
  <input class="form-control" name='post_seq' 
     value='<c:out value="${post.post_seq }"/>' readonly="readonly">
</div>

<div class="form-group">
  <label>공고제목</label> 
  <input class="form-control" name='post_title' 
    value='<c:out value="${post.post_title }"/>' >
</div>

<div class="form-group">
  <label>직종</label>
  <textarea class="form-control" rows="3" name='post_job' >
  <c:out value="${board.post_job}"/></textarea>
</div>

<div class="form-group">
  <label>경력구분</label> 
  <input class="form-control" name='post_career'
    value='<c:out value="${post.post_career}"/>' readonly="readonly">            
</div>

<div class="form-group">
  <label>고용형태</label> 
  <input class="form-control" name='post_emptype'
    value='<c:out value="${post.post_emptype}"/>' readonly="readonly">            
</div>

<div class="form-group">
  <label>근무지</label> 
  <input class="form-control" name='post_add'
    value='<c:out value="${post.post_add}"/>' readonly="readonly">            
</div>


          

  <button type="submit" data-oper='modify' class="btn btn-default">Modify</button>
  <button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>
  <button type="submit" data-oper='list' class="btn btn-info">List</button>
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


	  var formObj = $("form");

	  $('button').on("click", function(e){
	    
	    e.preventDefault(); 

	    var operation = $(this).data("oper");
	    
	    console.log(operation);
	    
	    if(operation === 'remove'){
	      formObj.attr("action", "/post/remove");
	      
	    }else if(operation === 'list'){
	      //move to list
	      formObj.attr("action", "/post/list").attr("method","get");  
	      
	      formObj.empty();
	             
	    }
	    
	    formObj.submit();
	  });

});
</script>
  




