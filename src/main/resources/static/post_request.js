var submit_btn = document.getElementById("submit-btn");
var tasksList = new Array();


// POST Task
async function sendTaskToRestApi() {

    const taskData = {
        name: $("#name-input").val(),
        text: $("#text-area").val()
    };

    if(taskData.name.length > 0) {
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
        //get only when it has been sent
        getLastAndWait()
    } 

}
function getDateFromRestApi() {

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/v1/task",
        contentType: "application/json; charset=utf-8",
        success: function(result) {

            for(let i = 0; i < result.length; i++) {
                 let obj = result[i];
                
                    createTaskDivWithText(obj.name, obj.text)
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
            if(result != null) {
                tasksList.push(result);
                if(result.text.length > 0) {
                    createTaskDiv_WithText(result.name, result.text);
                    console.log("null");
                } else {
                    createTaskDiv(result.name);
                    console.log(result.text.length);
                }
            }
        },
        failure: function(errMsg) {
            alert(errMsg);
        }
    });
}

//  Create task-div
function createTaskDiv_WithText(name, task) {
   
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

    //<div class="remove-task-border">
    let removeTaskBorderDiv = document.createElement('div');
    removeTaskBorderDiv.setAttribute('class', 'remove-task-border');

    //<div class="remove-task">
    let removeTaskDiv = document.createElement('div');
    removeTaskDiv.setAttribute('class', 'remove-task');

    //<img src="/images/bin.png">
    let binImg = document.createElement('img');
    binImg.setAttribute('src', '/images/bin.png');
    binImg.setAttribute('class', 'bin')

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

    //<div class="text-p">
    let textPDiv = document.createElement('div');
    textPDiv.setAttribute('class', 'text-p');

    //<p > Umyć naczynia </p>
    let pText = document.createElement('p');
    pText.textContent = task;


    //name
    namePDiv.appendChild(pName);
    nameDiv.appendChild(namePDiv);
   
    //removeTaskDiv.appendChild(binImg);
    removeTaskBorderDiv.appendChild(removeTaskDiv);
    nameDiv.appendChild(removeTaskBorderDiv);

    nameBorderDiv.appendChild(nameDiv);
    taskDiv.appendChild(nameBorderDiv);
    //text
    textPDiv.appendChild(pText);
    textDiv.appendChild(textPDiv);
    textBorderDiv.appendChild(textDiv);
    taskDiv.appendChild(textBorderDiv);

    document.getElementById('all-tasks').prepend(taskDiv);

}

function createTaskDiv(name) {
    //<div class="task">
    let taskDiv = document.createElement('div');
    taskDiv.setAttribute('class', 'task');

    // NAME
    //<div class="name-border">
    let nameBorderDiv = document.createElement('div');
    nameBorderDiv.setAttribute('class', 'name-border-noText');

    //<div class="name">
    let nameDiv = document.createElement('div');
    nameDiv.setAttribute('class', 'name');

    //<div class="remove-task-border">
    let removeTaskBorderDiv = document.createElement('div');
    removeTaskBorderDiv.setAttribute('class', 'remove-task-border');

    //<div class="remove-task">
    let removeTaskDiv = document.createElement('div');
    removeTaskDiv.setAttribute('class', 'remove-task');

    //<img src="/images/bin.png">
    let binImg = document.createElement('img');
    binImg.setAttribute('src', '/images/bin.png');
    binImg.setAttribute('class', 'bin')

    //<div class="name-p">
    let namePDiv = document.createElement('div');
    namePDiv.setAttribute('class', 'name-p');

    //<p > Umyć naczynia </p>
    let pName = document.createElement('p');
    pName.textContent = name;


    //name
    namePDiv.appendChild(pName);
    nameDiv.appendChild(namePDiv);

    //removeTaskDiv.appendChild(binImg);
    removeTaskBorderDiv.appendChild(removeTaskDiv);
    nameDiv.appendChild(removeTaskBorderDiv);

    nameBorderDiv.appendChild(nameDiv);
    taskDiv.appendChild(nameBorderDiv);

    document.getElementById('all-tasks').prepend(taskDiv);

}

function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}
function clearForm() {
    let form = document.getElementById('taskForm');
    form.reset();
}
async function getLastAndWait() {
    // wait 0.4s, to avoid bugs with adding a wrong task, not the latest one
    // with sleep, everything works great
    await sleep(400);
    getLatestTaskFromRestApi();
}

async function submitForm() {
     // Prevent the form from submitting via the browser.
     sendTaskToRestApi();
     clearForm();  
}

/***** DOES EVERY REFRESH *****/
getDateFromRestApi();