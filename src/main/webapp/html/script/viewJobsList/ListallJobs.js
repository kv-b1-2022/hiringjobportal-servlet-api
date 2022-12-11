function getAllList(){
const findUrl = "http://localhost:8080/app/DisplayJobsBySalaryServlet";
let jobList ;
    fetch(findUrl).then(res=>res.json()).then(res=>{
        jobList = res;
        localStorage.setItem("jobList",JSON.stringify(jobList));
        console.log(jobList);
    });
}