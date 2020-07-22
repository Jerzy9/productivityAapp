var submit_btn = document.getElementById("submit-btn");

    function sendObject() {

         const taskData = {
            name: $("#name-input").val(),
            text: $("#text-area").val()
        };

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/api/v1/task",
            data: JSON.stringify(taskData),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function(data) {
                alert(data);
            },
            failure: function(errMsg) {
                alert(errMsg);
            }
        });
    }

    submit_btn.addEventListener("click", function() {
        // Prevent the form from submitting via the browser.
        event.preventDefault();


//        console.log(taskData.name);
//        console.log(text);
        
        sendObject();

          
        
       
    });