var submit_btn = document.getElementById("submit-btn");
var tasksList = new Array();


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
function getDateFromRestApi() {

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/v1/task",
        contentType: "application/json; charset=utf-8",
        success: function(result) {

            for(let i = 0; i < result.length; i++) {
                 let obj = result[i];
                
                    createTaskDiv(obj.name, obj.text)
                    tasksList.push(obj);
                    console.log(tasksList.length);
             }
        },
        failure: function(errMsg) {
            alert(errMsg);
        }
    });
}
function getLatestTaskFromRestApi() {
    
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/v1/task/latest",
        contentType: "application/json; charset=utf-8",
        success: function(result) {
            tasksList.push(result);
            createTaskDiv(result.name, result.text)
        
        },
        failure: function(errMsg) {
            alert(errMsg);
        }
    });
}

//  Create task-div
function createTaskDiv(name, task) {
   
    //<div class="task">
    let taskDiv = document.createElement('div');
    taskDiv.setAttribute('class', 'task');

    // NAME
    //<div class="name-border">
    let nameBorderDiv = document.createElement('div');
    nameBorderDiv.setAttribute('class', 'name-border');
    
    //<div class="name">
    let nameDiv = document.createElement('div');
    nameDiv.setAttribute('class', 'name');

    //<div class="name-p">
    let namePDiv = document.createElement('div');
    namePDiv.setAttribute('class', 'name-p');

    //<p > Umyć naczynia </p>
    let pName = document.createElement('p');
    pName.textContent = name;

    //TEXT
    //<div class="text-border">
    let textBorderDiv = document.createElement('div');
    textBorderDiv.setAttribute('class', 'text-border');

    //<div class="text">
    let textDiv = document.createElement('div');
    textDiv.setAttribute('class', 'text');

    //<div class="name-p">
    let textPDiv = document.createElement('div');
    textPDiv.setAttribute('class', 'text-p');

    //<p > Umyć naczynia </p>
    let pText = document.createElement('p');
    pText.textContent = task;


    //name
    namePDiv.appendChild(pName);
    nameDiv.appendChild(namePDiv);
    nameBorderDiv.appendChild(nameDiv);
    taskDiv.appendChild(nameBorderDiv);
    //text
    textPDiv.appendChild(pText);
    textDiv.appendChild(textPDiv);
    textBorderDiv.appendChild(textDiv);
    taskDiv.appendChild(textBorderDiv);

    document.getElementById('all-tasks').appendChild(taskDiv);

}

function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}
function clearForm() {
    let form = document.getElementById('taskForm');
    form.reset();
}

async function submitForm() {
     // Prevent the form from submitting via the browser.
     sendTaskToRestApi();
     clearForm();
     // wait 0.4s, to avoid bugs with adding a wrong task, not the latest one
     // with sleep, everything works great
     await sleep(400);
     getLatestTaskFromRestApi();
}

//do on refresh
getDateFromRestApi();
//
