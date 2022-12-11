/**
 * 
 */
 function apply(id){
	console.log(id);
	let list = JSON.parse(localStorage.getItem("loggedIn"));
	let email = list.emaill;
	url = "http://localhost:8080/app/api/applyJobs?mail="+email+"&id="+id;
	fetch().then(res=>res.text()).then(res=>{
		let result = res.trim();
		console.log(result,type(result));
	});
	}

