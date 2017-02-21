

				<div class="row">
							<div class="col-sm-12">
								<div class="white-box">
									<div class="table-responsive">
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#snackform" data-whatever="@mdo">Ajouter Snack</button>
										<table id="myTable" class="table table-striped">
											<tr>
												<th><spring:message code='snack.label.id' />  </th>
												<th> <spring:message code='snack.label.name' /></th>
												<th><spring:message code='snack.label.mail' /></th>
												<th><spring:message code='snack.label.quartier' /></th>
												<th><spring:message code='snack.label.phone' /></th>
												<th><spring:message code='snack.label.action' /></th>
											</tr>
											<c:forEach items="${snacks}" var="snac">

												<tr>
													<td>${snac.id}</td>
													<td><img width="50px" height="50px"
														src="${pageContext.request.contextPath}/images/logo/${snac.id}.png" />&nbsp; ${snac.name} </td>
				                                    <td>${snac.login}</td>
													<td>${snac.quartier.ville.ville} , ${snac.quartier.name}</td>
													<td>${snac.phone}</td>
													<td id="editSnack" class="text-nowrap"><a href="#" data-id="${snac.id}" data-toggle="tooltip" data-original-title="<spring:message code="snack.label.edit" />"> <i class="fa fa-pencil text-inverse m-r-10"></i> </a> <a href="delete-snack/${snac.id}" data-toggle="tooltip" data-original-title='<spring:message code="snack.label.delete" />'> <i class="fa fa-close text-danger"></i> </a> </td>
												</tr>


											</c:forEach>





										</table>
										
										</div>
          </div>
        </div>

									</div>

