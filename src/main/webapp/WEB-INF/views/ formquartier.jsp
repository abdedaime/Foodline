





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
                             <strong>le quartier a été bien ajouté</strong> 
                          </div>
                     </c:if>


				<div class="modal fade in " id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel1" style="display: none;">
              				<div class="modal-dialog" role="document">
               					<div class="modal-content">
               					<div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                    <h4 class="modal-title" id="exampleModalLabel1">Ajouter une  quartier</h4>
                  </div>
                  <div class="modal-body">
                    	<form:form action="addQuartier" method="post" modelAttribute="quartier"
								accept-charset="utf-8" class="form-material form-horizontal">
								<div class="form-group">
									<label class="col-md-12"> quartier <span class="help">
									</span></label>
									<div class="col-md-12">
										<form:input path="name" class="form-control form-control-line"  />
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-12"> villes <span class="help">
									</span></label>
									<div class="col-md-12">
										<form:select path="ville.id"  class="form-control form-control-line" >
											<option selected disabled><spring:message code="snack.label.select.ville" /></option>
											<form:options items="${villes}"  itemLabel="ville" itemValue="id" ></form:options>
										</form:select>
									</div>
								</div>
								<div class="form-group">
								   <input type="submit" value="save" class="btn  btn-info pull-right" />
								</div>
					</form:form>
                  </div>
       
                </div>
              </div>
            </div>

							<br>
   <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">add Quartier</button>
					<table class="table table-striped">
								
                           <tr>
		                      <th>id</th>
			                  <th>ville ,quartier</th>
			                    <th>action</th>
		                    </tr>
						<c:forEach items="${quartiers}" var="quartier">
                               	<tr>
									<td>${quartier.id}</td>
									<td>${quartier.ville.ville} ${quartier.name}</td>
									<td><a href='delete-quartier/${quartier.id}' class="btn btn-danger">supprimer</a> </td>
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