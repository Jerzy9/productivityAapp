
function time() {

    let hours_div = document.getElementById('hours');
    let minutes_div = document.getElementById('minutes');
    let seconds_div = document.getElementById('seconds');

    let dayOfTheWeek_div = document.getElementById('day-of-the-week');

    let day_div = document.getElementById('day');
    let month_div = document.getElementById('month');
    let year_div = document.getElementById('year');

    let hours = new Date().getHours();
    let minutes = new Date().getMinutes();
    let seconds = new Date().getSeconds();

    let dayOfTheWeek = new Date().getDay();
    let dayOfTheWeekString;

    let day = new Date().getDate();
    let month = new Date().getMonth();
    let year = new Date().getFullYear();

    if(dayOfTheWeek == 1) {
        dayOfTheWeekString = "Monday";
    } else if(dayOfTheWeek == 2) {
        dayOfTheWeekString = "Tuesday";
    } else if(dayOfTheWeek == 3) {
        dayOfTheWeekString = "Wednesday";
    } else if(dayOfTheWeek == 4) {
        dayOfTheWeekString = "Thursday";
    } else if(dayOfTheWeek == 5) {
        dayOfTheWeekString = "Friday";
    } else if(dayOfTheWeek == 6) {
        dayOfTheWeekString = "Saturday";
    } else if(dayOfTheWeek == 0) {
        dayOfTheWeekString = "Sunday";
    }

    if(month < 10) { 
        month = "0" + month;
    }
    if(minutes < 10) { 
        minutes = "0" + minutes;
    }
    if(seconds < 10) { 
        seconds = "0" + seconds;
    }

    hours_div.innerHTML = hours
    minutes_div.innerHTML = minutes;
    seconds_div.innerHTML = seconds;

    dayOfTheWeek_div.innerHTML = dayOfTheWeekString;

    day_div.innerHTML = day;
    month_div.innerHTML = month;
    year_div.innerHTML = year;

}
var interval = setInterval(time, 1000);

// function showAndHide() {
//     ducument.getElementById('add-button').style.display="inline";
// }

