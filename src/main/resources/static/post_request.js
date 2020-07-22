// POST Task
function sendTaskToRestApi() {

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
    
    sendTaskToRestApi();

});

//GET All Tasks
function getDateFromRestApi() {


$.ajax({
    type: "GET",
    url: "http://localhost:8080/api/v1/task",
    contentType: "application/json; charset=utf-8",
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

getDateFromRestApi()

});