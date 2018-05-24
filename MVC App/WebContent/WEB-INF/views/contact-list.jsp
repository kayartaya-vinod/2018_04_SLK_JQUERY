<%@ include file="header.jsp" %>
		<h3>Contact list</h3>
		<table class="table table-striped table-bordered table-hover table-condensed table-responsive">
			<thead>
				<tr>
					<th>Sl no</th>
					<th>Name </th>
					<th>Email address</th>
					<th>Phone number</th>
					<th>City</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.contacts}" var="contact" varStatus="status">
				<tr>
					<td>${status.index+1}</td>
					<td>${contact.name}</td>
					<td>${contact.email}</td>
					<td>${contact.phone}</td>
					<td>${contact.city}</td>
					<td>
						<a href="edit-contact?id=${contact.id}">
							<span class="glyphicon glyphicon-pencil"></span>
						</a>
						<a href="delete-contact?id=${contact.id}">
							<span class="glyphicon glyphicon-trash"></span>
						</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
<%@ include file="footer.jsp" %>