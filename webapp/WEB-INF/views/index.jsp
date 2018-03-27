<%@ include file="/WEB-INF/views/init.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- For providng view setting according to device coordinate -->
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Certainty HR - Home</title>
<%@ include file="/WEB-INF/views/header.jsp"%>
</head>

<!-- Body of code start-->

<body ng-app="hr" class="ng-cloak">
	<div id="wrapper" class="generic-container">
		<!-- NAV TOP  -->
		<%@ include file="/WEB-INF/views/topnav.jsp"%>
		<!-- NAV SIDE  -->
		<%@ include file="/WEB-INF/views/leftnav.jsp"%>

		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<div class="col-md-6">
							<h2>Home</h2>
						</div>
					</div>
				</div>
				<hr />
			</div>
		</div>
	</div>

	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>
