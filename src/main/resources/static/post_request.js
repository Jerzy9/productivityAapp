var submit_btn = document.getElementById("submit-btn");

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

    submit_btn.addEventListener("click", function() {
        // Prevent the form from submitting via the browser.
        event.preventDefault();

        //     name: $("#name-input").val(),
        //     text: $("#text-area").val()
        var taskData = {
            name: document.getElementById("name-input").val,
            // text: document.getElementById("text-area")
            };
        
        console.log(name);
        // console.log(text);
        
        sendObject();

          
        
       
    });