var submit_btn = document.getElementById("submit-btn");
console.log(submit_btn);


var taskData = {
    name: "Pierwsze zadanie",
    text: "pierwsze zadanko do zrobienia cyk"
    };

    function sendObject() {
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/api/v1/task",
            data: JSON.stringify(taskData),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function(data) {
                console.log("succes_zaj");
                alert(data);
            },
            failure: function(errMsg) {
                console.log("failaaa_zaj");
                alert(errMsg);
            }
        });
    }

    submit_btn.addEventListener("click", sendObject);