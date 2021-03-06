<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
 <div class="navbar-default sidebar" role="navigation">
    <div class="sidebar-nav navbar-collapse slimscrollsidebar">
      <div class="user-profile">
        <div class="dropdown user-pro-body">
          <div><img src="${pageContext.request.contextPath}/images/logo/${currentUser.id}.png"  alt="user-img" class="img-circle" ></div>
          <a href="#" class="dropdown-toggle u-dropdown" role="button" aria-haspopup="true" aria-expanded="false">${currentUser.firstName} ${currentUser.lastName} </a>
    
        </div>
      </div>
      <ul class="nav" id="side-menu">
        <li class="sidebar-search hidden-sm hidden-md hidden-lg">
          <!-- input-group -->
          <div class="input-group custom-search-form">
            <input type="text" class="form-control" placeholder="Search...">
            <span class="input-group-btn">
            <button class="btn btn-default" type="button"> <i class="fa fa-search"></i> </button>
            </span> </div>
          <!-- /input-group -->
        </li>
        
        <li class="nav-small-cap m-t-10">Menu</li>
             <security:authorize access="hasAuthority('Role_admin')">   
               <li><a href="villes" class="waves-effect"><i class="icon-globe  fa-fw"></i> <span class="hide-menu">Gestions des Villes</span></a></li>
               <li><a href="quartiers" class="waves-effect"><i class=" icon-location-pin  fa-fw"></i> <span class="hide-menu">Gestions des Quarties</span></a></li>
               <li><a href=snacks class="waves-effect"><i class="icon-cup fa-fw"></i> <span class="hide-menu">Gestions des Snacks</span></a></li>
               <li><a href="clients" class="waves-effect"><i class="icon-user fa-fw"></i> <span class="hide-menu">Gestions des Clients</span></a></li>
        
        </security:authorize>
        
         <li><a href="../logout" class="waves-effect"><i class="icon-logout fa-fw"></i> <span class="hide-menu">Log out</span></a></li>
        
      </ul>
    </div>
  </div>