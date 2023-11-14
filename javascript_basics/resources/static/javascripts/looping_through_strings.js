/**
 * 
 */

function loopingThroughStrings() {
	
	let userInput = "";
         userInput = prompt("Enter an Arithmetic Expression");
         console.log(userInput);

	let operators = "";
	let numbers = "";
	const SEPARATOR = ", ";


	for (let i = 0; i < userInput.length; i++) {
		let c = userInput[i]; // the current character
		if (c >= '0' && c <= '9') {
			 while (i < userInput.length && c >= '0' && c <= '9') {
         c = userInput[i];
         numbers += c; 
         i++;
      } 

			numbers += c + SEPARATOR;
			i--;
		}else if(c == ' '){
			
		} else {
			operators += c + SEPARATOR;
		}
	}

	console.log("Numbers: ", numbers);
	console.log("Operators: ", operators);
}