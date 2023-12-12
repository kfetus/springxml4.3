<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>REST 테스트</title>

	<script src="<c:url value="/js/comm/jquery-3.7.1.min.js" />"></script>
	<link rel="stylesheet" href="<c:url value="/css/base/base.css" />" />
	 
	<script>
	
		function fn_selectList(url){
			console.log('ddd');
						
			$.ajax({
				type : 'post',
				url : url,
				async : true,
				dataType : 'text',
 				headers : {"Content-Type" : "application/json"},
				data : JSON.stringify( {'type1':'name', 'type2':'identity'}),    
				success : function(result) {
					console.log(result);
				},
				error : function(request, status, error) { // 결과 에러 콜백함수        
					console.log(error);
				}
			});

		}
	
		function fn_scriptTest() {
			const initialState = [{count: 0},'dddd'];
			const [a,b] = initialState;
			console.log(a);
			console.log(a.count);
			console.log(b);
		}
	
	</script>
</head>

<body>

	<div>

		<header>
			<div>
				<button type="button" title="이전">뒤로</button>
			</div>
			<div>
				<h1>타이틀</h1>
			</div>
			<div>
				<button type="button" title="메뉴" ><span class="hidden">메뉴</span></button>
			</div>
		</header>

		<main>
		<div>
			본문
			<button type="button" id="s1" onclick="javascript:fn_selectList('/sampleRest.do');"><span><strong>샘플</strong></span></button>
			<button type="button" id="s2" onclick="javascript:fn_selectList('/restBaseModel.do');">기본</button>
			<button type="button" id="s2" onclick="javascript:fn_scriptTest();">스크립트테스트</button>
		</div>
		<div>
			<p>box 1</p>
		</div>
		<div>
			<p>box 2</p>
		</div>
		<div>
			<p>box 3</p>
		</div>
		</main>

		<footer>
			바닥
		</footer>
	</div>
</body>
</html>