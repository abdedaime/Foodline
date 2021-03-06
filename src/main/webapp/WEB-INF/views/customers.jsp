<%@ include file="elements/head.jsp"%>
<body>
	<!-- Preloader -->
	<div class="preloader">
		<div class="cssload-speeding-wheel"></div>
	</div>
	<div id="wrapper">
		<!-- Navigation -->
		<%@ include file="elements/navbar.jsp"%>
		<!-- Left navbar-header -->
		<%@ include file="elements/left_navbar_header.jsp"%>
		<!-- Left navbar-header end -->
		<!-- Page Content -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<%@ include file="elements/breadcrumb.jsp"%>
				<!-- /.row -->

				<div class="row">
					<div class="col-sm-12">
						<div class="white-box p-l-20 p-r-20">
						
						  	<table id="myTable" class="table table-striped">
											<tr>
												<th><spring:message code='client.label.id' />  </th>
												<th>Nom Complet</th>
												<th>Email</th>
												<th><spring:message code='client.label.phone' /></th>
												<th><spring:message code='client.label.action' /></th>
												
											</tr>
											<c:forEach items="${clients}" var="client">
                                                   <tr>
													<td>${client.id}</td>
											         <td><img width="80px" height="80px"
														src="${pageContext.request.contextPath}/images/avatar/${client.id}.png" /> ${client.firstName} ${client.lastName} </td>
													<td>${client.login}</td>
				                                    <td>${client.phone}</td>
													<td> 
													<c:if test="${client.enabled}">
														<input data-id="${client.id}"  type="checkbox" checked   class="js-switch" data-color="#6164c1"/> 
													</c:if>
													<c:if test="${!client.enabled}">
														<input data-id="${client.id}"  type="checkbox"     class="js-switch" data-color="#6164c1"/> 
													</c:if>
													</td>
												</tr>


											</c:forEach>
                                             </table>
						  
						
						
						</div>
					</div>


					<!--row -->
					<!-- .right-sidebar -->
					<%@ include file="elements/right_sidebar.jsp"%>
					<!-- /.right-sidebar -->
				</div>
				<!-- /.container-fluid -->
				<%@ include file="elements/footer.jsp"%>
			</div>
			</div>
			<!-- /#page-wrapper -->
		</div> 
		<!-- /#wrapper -->
				<%@ include file="elements/foot.jsp"%>
				
				
	<script type="text/javascript">
	


       $(function() {
           var elems = Array.prototype.slice.call(document.querySelectorAll('.js-switch'));
           $('.js-switch').each(function() {
            new Switchery($(this)[0], $(this).data());

           });
        });
       
          $('.js-switch').change(function () {
              var status=$(this).is(":checked");
              var id=$(this).data('id');
    	       alert(status);
    	       
    	       $.ajax({
					type : "POST",
					contentType : "application/json",
					url : "change-status/"+id+"/"+status,
					dataType : 'json',
					success : function(data) {
						console.log("SUCCESS: ", data);

					},
					error : function(e) {
						console.log("ERROR: ", e);

					}

				});

    	 });
	
	</script>