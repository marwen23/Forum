var c1 = document.getElementById("c1");
var parent = document.getElementById("p1");
c1.width = parent.offsetWidth - 40;
c1.height = parent.offsetHeight - 40;

var data1 = {
	labels: ["Jan", "Feb", "March", "April", "May", "June", "July","Aug", "Sept", "Oct", "Nov", "Dec"],
	datasets: [
		{
			fillColor: "#EEE",
			strokeColor: "#58ca42",
			pointColor: "#58ca42",
			pointStrokeColor: "#428bca",
			data: [1, 1.5, 1, 1.5, 1, 1.5, 2.5, 2, 1.5, 2, 1.5, 2]
    }
  ]
}

var options1 = {
	scaleFontColor: "#111",
	scaleLineColor: "#428bca",
	scaleGridLineColor: "transparent",
	bezierCurve: false,
	scaleOverride: true,
	scaleSteps: 7,
	scaleStepWidth: 0.5,scaleStartValue: 0,
}

new Chart(c1.getContext("2d")).Line(data1, options1)




var c2 = document.getElementById("c2");
var parent = document.getElementById("p2");
c2.width = parent.offsetWidth - 40;
c2.height = parent.offsetHeight - 40;

var data2 = {
	labels: ["Jan", "Feb", "March", "April", "May", "June", "July","Aug", "Sept", "Oct", "Nov", "Dec"],
	datasets: [
		{
			fillColor: "#EEE",
			strokeColor: "#58ca42",
			pointColor: "#58ca42",
			pointStrokeColor: "#428bca",
			data: [0.5, 1, 0.5, 1.5, 1, 0.5, 1.5, 1, 1.5, 1, 1.5, 1]
    }
  ]
}

var options2 = {
	scaleFontColor: "#111",
	scaleLineColor: "#428bca",
	scaleGridLineColor: "transparent",
	bezierCurve: false,
	scaleOverride: true,
	scaleSteps: 7,
	scaleStepWidth: 0.5,scaleStartValue: 0,
}

new Chart(c2.getContext("2d")).Line(data2, options2)





var c3 = document.getElementById("c3");
var parent = document.getElementById("p3");
c3.width = parent.offsetWidth - 40;
c3.height = parent.offsetHeight - 40;

var data3 = {
	labels: ["Jan", "Feb", "March", "April", "May", "June", "July","Aug", "Sept", "Oct", "Nov", "Dec"],
	datasets: [
		{
			fillColor: "#EEE",
			strokeColor: "#58ca42",
			pointColor: "#58ca42",
			pointStrokeColor: "#428bca",
			data: [0.25, 0.5, 0.25, 1, 0.5, 0.25, 1, 0.5, 0.75, 0.5, 0.75, 0.5]
    }
  ]
}

var options3 = {
	scaleFontColor: "#111",
	scaleLineColor: "#428bca",
	scaleGridLineColor: "transparent",
	bezierCurve: false,
	scaleOverride: true,
	scaleSteps: 7,
	scaleStepWidth: 0.5,scaleStartValue: 0,
}

new Chart(c3.getContext("2d")).Line(data3, options3)
