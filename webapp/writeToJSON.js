let Food = {
    firstMeal: "",
    secondMeal: "",
    thirdMeal: "",
    fourthMeal: "",
    weight: 0
}
function getData(){
    Food.firstMeal = document.getElementById("firstMeal").value;
    Food.secondMeal = document.getElementById("secondMeal").value;
    Food.thirdMeal = document.getElementById("thirdMeal").value;
    Food.fourthMeal = document.getElementById("fourthMeal").value;
    Food.weight = document.getElementById("weight").value;
    let seriesJson = JSON.stringify(Food);
    let xhr = new XMLHttpRequest();
    xhr.open("POST", "write", true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(seriesJson);
}