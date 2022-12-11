Displaycontent("all");
function Displaycontent() {
	//preventDefault();
	var branch = document.querySelector("#branch").value;
	console.log(branch);
	var jobList = JSON.parse(localStorage.getItem("jobList"));
	console.log(jobList);
	document.getElementById("list").innerHTML = "";
	var contents;
	if (jobList == null) {
		getAllList();
		Displaycontent();
		
	} else {

		for (let details of jobList) {
			if ( branch == "null") {
				console.log(branch == "null");
				contents += `<div class="card">
            <h5 class="card-header">branch and roll :${details.branch}-${details.roll}</h5>
            <div class="card-body">
              <h5 class="card-title">company name :${details.companyName}</h5>
              <h5 class="card-title">Salary :${details.salary}</h5>
              <p class="card-text">skills required : ${details.skills} </p>
              <p class="card-text">place :${details.place_Details} </p>
              <a href="#" class="btn btn-primary" onclick="apply(${details.jobId})">apply</a>
            </div>
          </div><br>`;
          }
			else if (details.branch == branch) {
				contents += `<div class="card">
            <h5 class="card-header">branch and roll :${details.branch}-${details.roll}</h5>
            <div class="card-body">
              <h5 class="card-title">company name :${details.companyName}</h5>
              <h5 class="card-title">Salary :${details.salary}</h5>
              <p class="card-text">skills required : ${details.skills} </p>
              <p class="card-text">place :${details.place_Details} </p>
              <a href="#" class="btn btn-primary" onclick="apply(${details.jobId})">apply</a>
            </div>
          </div><br>`;
			}
			
		}
		document.getElementById("list").innerHTML = "";
			document.getElementById("list").innerHTML = contents;
		}

	}

	function getAllList() {
		const findUrl = "http://localhost:8080/app/DisplayJobsBySalaryServlet";
		let jobList;
		fetch(findUrl).then(res => res.json()).then(res=> {
			jobList = res;
			localStorage.setItem("jobList", JSON.stringify(jobList));
			console.log(jobList);
		});
	}