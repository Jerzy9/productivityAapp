
function time() {

    var hours_div = document.getElementById('hours');
    var minutes_div = document.getElementById('minutes');
    var seconds_div = document.getElementById('seconds');

    var dayOfTheWeek_div = document.getElementById('day-of-the-week');

    var day_div = document.getElementById('day');
    var month_div = document.getElementById('month');
    var year_div = document.getElementById('year');

    var hours = new Date().getHours();
    var minutes = new Date().getMinutes();
    var seconds = new Date().getSeconds();

    var dayOfTheWeek = new Date().getDay();
    var dayOfTheWeekString;

    var day = new Date().getDate();
    var month = new Date().getMonth();
    var year = new Date().getFullYear();

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

