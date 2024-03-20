<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp" %>
	<meta name="robots" content="index, follow, max-image-preview:large, max-snippet:-1, max-video-preview:-1">
	<link rel="stylesheet" href="/resources/include/assets2/css/main.css">
	<link rel="stylesheet" href="/resources/include/css/application/applicationView.css">
	
	<script src="/resources/include/js/application/applicationView.js"></script>
</head>
<body class="subpage">

<%@ include file="/WEB-INF/views/project/generic.jspf" %>   

	<!-- One -->
	<section id="One" class="wrapper style3">
		<div class="inner">
			<header class="align-center">
				<p>Save The Animal</p>
				<h2>페이지 이름</h2>
			</header>
		</div>
	</section>

	<!-- Two -->
	<section id="two" class="wrapper style2">
		<%-- post방식으로 전송 시 반드시 form 태그 추가해주어야 합니다. --%>
		<form name="f_data" id="f_data" method="post">
			<input type="hidden" name="applicationId" id="applicationId" >
		</form>
		<div class="inner">
			<div class="box">
				<div class="content">
					<c:if test="${empty userLogin}">
					  	<h4>로그인이 필요합니다</h4>
					  	<a href="/user/login" class="button">로그인 바로가기</a>
					</c:if>
					<c:if test="${not empty userLogin}">
					<div class="grid">
						<div class="image fit">
							<div class="my-3 p-4 bg-body rounded shadow-sm">
							    <h4 class="border-bottom pb-2 mb-0"><strong>My Activities</strong></h4>	
							    <br/>
							    <h5><strong>봉사활동 신청내역</strong></h5>
							    	<div id="appView">
							    		<table id="appliTable">
							    			<thead>
							    				<tr class="text-center">
							    					<th class="col-md-1">공고 번호</th>
							    					<th class="col-md-6">공고 제목</th>
							    					<th class="col-md-4">봉사 날짜</th>
							    					<th class="col-md-2">취소</th>
						    					</tr>
					    					</thead>
					    					<tbody>
					    						<c:choose>
					    							<c:when test="${ not empty view }">
					    								<c:forEach items="${ view }" var="list">
					    									<tr class="text-center" data-id="${ list.applicationId }">
					    										<td>${ list.volunteer.volunteerId }</td>
					    										<td>${ list.volunteer.volunteerTitle }</td>
					    										<td>${ list.volunteer.volunteerTime }</td>
					    										<td><button type="button" class="cancelBtn">취소</button></td>
				    										</tr>
			    										</c:forEach>
		    										</c:when>
		    										<c:otherwise>
		    											<tr>
		    												<td colspan="4" class="text-center">신청한 봉사가 없습니다.</td>
	    												</tr>
	  													</c:otherwise>
												</c:choose>
					    					</tbody>
							    		</table>
								    </div>
							    <small class="d-block text-end mt-3">
							      <a href="#"></a>
							    </small>
							  </div>					
						</div>
					</div>
					</c:if>
				</div>
			</div>
		</div>
	</section>
	
	
	
	
	
	
	<!-- Footer -->
	<footer id="footer">
		<div class="container">
			<ul class="icons">
				<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
				<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
				<li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
				<li><a href="#" class="icon fa-envelope-o"><span class="label">Email</span></a></li>
			</ul>
		</div>
	</footer>
	<div class="copyright">
		Made with <a href="https://templated.co/">Templated</a>.
	</div>

	<!-- Scripts -->
	<script src="/resources/include/assets2/js/jquery.min.js"></script>
	<script src="/resources/include/assets2/js/jquery.scrollex.min.js"></script>
	<script src="/resources/include/assets2/js/skel.min.js"></script>
	<script src="/resources/include/assets2/js/util.js"></script>
	<script src="/resources/include/assets2/js/main.js"></script>
</body>

</html> 
