$('#errDiv').hide();

$('#frmAddContact').on('submit', function(){
	$('#errDiv').hide();
	var name, email, phone;
	
	name = $('#name').val();
	email = $('#email').val();
	phone = $('#phone').val();
	
	var errors = [];
	if(!name || name.length<3) {
		errors.push('Name is required and must have at least 3 letters');
	}
	if(!email) {
		errors.push('Email is required');
	}
	var re = /^\d{10}$/
	if(!re.test(phone)) {
		errors.push('A valid 10 digity phone is required')
	}
	
	if(errors.length) {
		var errList = $('<ul>');
		for(var i=0; i<errors.length; i++){
			$('<li>').html(errors[i]).appendTo(errList);
		}
		
		$('#errDiv').html(errList).fadeIn(1000);
		setTimeout(function(){
			$('#errDiv').fadeOut(1000);
		}, 5000);
		return false;
	}
	
	return true;
});