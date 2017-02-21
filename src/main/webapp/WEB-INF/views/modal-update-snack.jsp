<div class="modal fade in " id="snackUpdateform" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel1" style="display: none;">
              				<div class="modal-dialog" role="document">
               					<div class="modal-content">
               					<div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                    <h4 class="modal-title" id="exampleModalLabel1">Modifier un Snack</h4>
                  </div>
                  <div class="modal-body">
                    			<form:form id="updateSnack" method="post" action="add-snack"
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