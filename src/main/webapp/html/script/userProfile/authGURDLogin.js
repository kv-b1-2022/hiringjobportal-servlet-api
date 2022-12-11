
user = JSON.parse(localStorage.getItem("loggedIn"));
if (user == null) {
    alert("please login first");
    location.replace("login.html");

}
