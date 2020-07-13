// var request = new XMLHttpRequest();
// request.open('GET', 'localhost:8080/api/v1/task');
// request.onload = function() {
//     console.log(request.responseText);
// };
// request.send();

// DO GET
$( document ).ready(function() {
  
    function ajaxGet() {
        $.ajax({
        type : "GET",
        url : window.location + "api/v1/task",
        success: function(result){
            if(result.status == "Done"){
            $('#getResultDiv ul').empty();
            var custList = "";
            $.each(result.data, function(i, task) {
                var task = "- Customer with Id = " + i + ", firstname = " + task.name + ", lastName = " + task.text + "<br>";
                $('#getResultDiv .list-group').append(task)
                console.log(i);
                });
            console.log("Success: ", result);
            }else{
            $("#getResultDiv").html("<strong>Error</strong>");
            console.log("Fail: ", result);
            }
        },
        error : function(e) {
            $("#getResultDiv").html("<strong>Error</strong>");
            console.log("ERROR: ", e);
        }
        });  
    }
    console.log("odpalam metode: ")
    ajaxGet();

});
console.log("odpalam metode: V2")