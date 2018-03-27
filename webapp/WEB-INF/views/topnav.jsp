<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<div>
	<nav class="navbar navbar-default navbar-cls-top " role="navigation"
		style="margin-bottom: 0">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".sidebar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand">Certainty HR</a>
		</div>
		<c:choose>
			<c:when test="${pageContext.request.userPrincipal.name != null}">
					<div
						style="color: white; padding: 15px 50px 5px 50px; float: right; font-size: 16px;">
						 &nbsp; <a
							href="logout" class="btn btn-danger square-btn-adjust">Logout</a>
					</div>
			</c:when>
			<c:otherwise>
					<div
						style="color: white; padding: 15px 50px 5px 50px; float: right; font-size: 16px;">
					<a href="login" class="btn btn-danger square-btn-adjust">Login</a>
					</div>
			</c:otherwise>
		</c:choose>
	</nav>
</div>

