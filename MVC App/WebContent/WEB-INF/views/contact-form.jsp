<%@ include file="header.jsp" %>

<div class="row">
	<div class="col-sm-3"></div>
	<div class="col-sm-6">
		<h3 class="well text-center">Add new contact</h3>
		
		<form id="frmAddContact" method="POST" class="form-horizontal">
		<input type="hidden" name="id" value="${contact.id}" >
			<div class="form-group">
				<label class="col-sm-4 control-label" for="name">Name</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" id="name" name="name" 
						placeholder="enter a name" value="${contact.name}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label" for="email">Email address</label>
				<div class="col-sm-8">
					<input class="form-control" type="email" id="email" name="email" 
						placeholder="enter an email address"
						value="${contact.email}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label" for="phone">Enter phone number</label>
				<div class="col-sm-8">
					<input class="form-control" type="tel" id="phone" name="phone" 
						placeholder="enter a phone number"
						value="${contact.phone}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label" for="city">City</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" id="city" name="city" 
						placeholder="enter a city"
						value="${contact.city}">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-8 col-sm-offset-4">
					<button class="btn btn-primary">Save details</button>
				</div>
			</div>
		</form>
		<div class="alert alert-warning" id="errDiv"></div>
		<c:if test="${requestScope.errMsg!=null}">
		<div class="alert alert-warning">
			${requestScope.errMsg}
		</div>
		</c:if>
	</div>
	<div class="col-sm-3"></div>
</div>


<%@ include file="footer.jsp" %>