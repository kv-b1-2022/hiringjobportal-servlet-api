user = JSON.parse(localStorage.getItem("loggedIn"));
const url = "http://localhost:8080/app/UserProfile?mailId="+user.email+"&password="+user.pass;
// const url = "http://localhost:8080/app/UserProfile?mailId="+email+"&password="+pass;
fetch(url).then(res => res.json()).then(res => {
    let result = res;
    console.log(typeof (result));
    console.log("guhbjgvhgvvhg");
    console.log(result, result.length);
    
    for (let value of result) {
        var nameCondent = `<h2>${value.userName}</h2>`;
        var dob =`<h2>${value.userMailId}</h2>`;
        var collegeName = `<h2>${value.userName}</h2>`;
        var branch = `<h2>${value.userName}</h2>`;
        var course = `<h2>${value.cource}</h2>`;
        var phoneNumber = `<h2>${value.phoneNumber}</h2>`;
    }
    document.getElementById("name").innerHTML = condent;
    document.getElementById("dOB").innerHTML = condent;
    document.getElementById("collegeName").innerHTML = condent;
    document.getElementById("cource").innerHTML = condent;
    document.getElementById("branch").innerHTML = condent;
    document.getElementById("phoneNumber").innerHTML = condent;
    console.log(condent);
});
