function promptUser() {
	let message = prompt("Enter Custom Message");
	let iteration = prompt("Enter iteration value");

	//when you prompt user what they enter is considered a STRING so you need to parse it to a number

	iteration = parseInt(iteration);

	customMessage(message, iteration);


}

function customMessage(custom, iteration) {
	for (let i = 0; i <= iteration; i++) {
		document.write(i + "Custom Message -> " + custom + "<br>");
	}
}

function enterData() {

	let num1 = document.getElementById("num1").value;
	let num2 = document.getElementById("num2").value;

	num1 = parseInt(num1);
	num2 = parseInt(num2);

	//this is the line that calls the method to invoke the add method
	//and return value is assigned to result variable
	let result = add(num1, num2);

	document.write("Thanks for Loggin in <br>");
	document.write(num1 + " + " + num2 + " = " + result);
}


//just showing that you don't have to name them the same name
//as the enterData()
function add(xnum1, ynum2) {

	let result = xnum1 + ynum2;

	//this is where we get the added numbers and store the sum in the 
	//result variable. So the result is returned to the caller and 
	//assign to line 30 where they called for it.
	return result;


}

//custom error created by developer
//const err = new Error('Custom Error made by the developer.');
//console.log(err);


	const customerError = new Error('Custom Error made by the developer.');

	function someFunc(a) {
		if (a === 4) {
			throw customerError;
		}
	}

	try {
		someFunc(4);
	} catch (e) {
		console.log("Logging Customer Error:")
		console.log(e)
	}
	
	//using debugger to see if logic is correct....to see what is in result at that time
	function debugEnteredData(){
		let num1 = document.getElementById("num1").value;
		let num2 = document.getElementById("num2").value;
		
		num1 = parseInt(num1);
		num2 = parseInt(num2);
		
		let result = add(num1, num2);
		debugger;
		console.log(result);
		
	}

