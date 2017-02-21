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

						<c:if test="${param.success  eq 1}">
                          <div  class="alert alert-success form-group alert-dismissable">
                           <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                            <strong>le snack a été bien ajouté</strong> 
                        </div>
                       </c:if>
                       <c:if test="${param.success  eq 0}">
                          <div  class="alert alert-success form-group alert-dismissable">
                           <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                            <strong>le snack a été bien modifié</strong> 
                        </div>
                       </c:if>
                        
                        	<c:if test="${param.successdelete  eq 1}">
                               <div  class="alert alert-success form-group alert-dismissable">
                           <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                            <strong>la suppression du snack a été bien effectuée</strong> 
                        </div>
                             </c:if>
                             <!-- start form -->
 <div class="modal fade in " id="snackform" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel1" style="display: none;">
              				<div class="modal-dialog" role="document">
               					<div class="modal-content">
               					<div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                    <h4 class="modal-title" id="exampleModalLabel1">Ajouter un Snack</h4>
                  </div>
                  <div class="modal-body">
                    			<form:form method="post" action="add-snack"
								modelAttribute="snack" enctype="multipart/form-data"
								accept-charset="utf-8" class="form-material form-horizontal">
                        <div class="row">
									<div class="col-md-12">
										

										<form:input id="idsnack" path="id" type="text"
											class="form-control form-control-line hide " />

										
										
										<div class="row">
											<div class="col-md-12">
												<div class="form-group">
													<label class="control-label"><spring:message  code='snack.label.name' /> <span class="help"> </span></label>
													<form:input id="name" path="name" type="text" class="form-control form-control-line" />
												</div>
											</div>
							                  <div class="col-md-6">
							                    <div class="form-group">
							                      <label class="control-label"><spring:message code='snack.label.mail' /></label>
							                      <form:input id="login" path="login" type="email" class="form-control form-control-line" />
							                  	</div>
							                  </div>
							                  <!--/span-->
							                  <div class="col-md-6">
							                    <label class="control-label"><spring:message code='snack.label.phone' /></label>
												<form:input id="phone" path="phone" type="text" class="form-control form-control-line" />
							                  <!--/span-->
							                </div>
							                
						                </div>
						                
						                <div class="row">
						                	<div class="col-md-6">
							                    <label class="control-label"><spring:message code='snack.label.villes' /></label>
												<select id="ville" class="form-control">
													<option selected disabled><spring:message code="snack.label.select.ville" /></option>
													<c:forEach items="${villes}" var="ville">
														<option value="${ville.id}">${ville.ville}</option>
													</c:forEach>
												</select>
							                  <!--/span-->
							                </div>
							                <div class="col-md-6">
							                    <label class="control-label"><spring:message code='snack.label.quartiers' /></label>
												<form:select id="quartier" path="quartier.id"
													class="form-control">
													<option selected disabled><spring:message
															code="snack.label.select.ville" /></option>
												</form:select>
							                  <!--/span-->
							                </div>
						               </div>
						               
						               
						               <div class="row">
						                	<div class="col-md-6">
							                    <label class="control-label"><spring:message code='snack.label.lat' /></label>
												<form:input id="lat" path="lat" class="form-control form-control-line" />
							                  <!--/span-->
							                </div>
							                <div class="col-md-6">
							                    <label class="control-label"><spring:message
													code='snack.label.long' /></label>
												<form:input id="lng" path="lng"
													class="form-control form-control-line" />
							                  <!--/span-->
							                </div>
						               </div>
						                
						               
										<div class="form-group">
											<label class="col-sm-12"><spring:message
													code='snack.label.logo' /></label>
											<div class="col-sm-12">
												<div class="fileinput fileinput-new input-group"
													data-provides="fileinput">
													<div class="form-control" data-trigger="fileinput">
														<i class="glyphicon glyphicon-file fileinput-exists"></i>
														<span class="fileinput-filename"></span>
													</div>
													<span class="input-group-addon btn btn-default btn-file">
														<span class="fileinput-new">Select file</span> <span
														class="fileinput-exists">Change</span> <input type="file"
														name="file">
													</span> <a href="#"
														class="input-group-addon btn btn-default fileinput-exists"
														data-dismiss="fileinput">Remove</a>
												</div>
											</div>
										</div>
										<input type="submit" value="save"
											class="btn btn-block btn-info">
									</div>
								</div>
						</div>

						</form:form>
							
                  </div>
       
                </div>
              </div>
            </div>

	                       <!-- end form  -->
	                     <%@ include file="modal-update-snack.jsp"%>
                        <%@ include file="tables/table-snack.jsp"%>

						<!--row -->
						<!-- .right-sidebar -->
						<%@ include file="elements/right_sidebar.jsp"%>
						<!-- /.right-sidebar -->
					</div>
					<!-- /.container-fluid -->
					<%@ include file="elements/footer.jsp"%>
				</div>
				<!-- /#page-wrapper -->
			</div>
			<!-- /#wrapper -->

			<%@ include file="elements/foot.jsp"%>


			<script type="text/javascript">
				$(document).ready(function() {

					ChangeVille();
					$("#editSnack a").click(function() {
						$.ajax({
							type : "POST",
							contentType : "application/json",
							url : "editSnack/" + $(this).data('id'),
							dataType : 'json',
							success : function(data) {
								console.log("SUCCESS: ", data);
								displyaData(data);

							},
							error : function(e) {
								console.log("ERROR: ", e);

							}

						});
					});
				});

				function ChangeVille() {

					$("form").find("#ville")
							.change(
									function() {
										
										$("form").find('#quartier')
												.find('option')
												.remove()
												.end()
												.append(
														'<option selected disabled><spring:message
															code="snack.label.select.quartier" /></option>');

										$.getJSON('quartierByVille/'
												+ $(this).val(), {}, function(
												json, textStatus) {
											console.log("Success", json);
											createOption(json,"form #quartier");
										});

									});

				}

				function createOption(data,id) {

					jQuery
							.each(
									data,
									function(index, value) {
										var option = "<option  id='quart' ";
                                        option+=" value="+value.id+">";
										option += value.name;
										option += "</option>";
										console.log("Option", option);
										$(id).append(option);

									});

				}

				function displyaData(data) {
					$('#updateSnack #idsnack').val(data.id);
					$('#updateSnack #name').val(data.name);
					$('#updateSnack #lat').val(data.lat);
					$('#updateSnack #lng').val(data.lng);
					$('#updateSnack #login').val(data.login);
					$('#updateSnack #phone').val(data.phone);
					$("#updateSnack #ville").val(data.quartier.ville.id);
					editQuartier(data,data.quartier.ville.id);
					$('#snackUpdateform').modal('show');
				}
				
				
				function editQuartier(data,idVille){
					$('#updateSnack #quartier')
					.find('option')
					.remove()
					.end()
					.append('<option selected disabled><spring:message code="snack.label.select.quartier" /></option>');

			$.getJSON('quartierByVille/'+ idVille, {}, function(json, textStatus) {
				console.log("Success", json);
				createOption(json,"#updateSnack #quartier");
				$("#updateSnack #quartier").val(data.quartier.id);
			});
				}
			</script>