function dateObject() {

	//TODO
}

function dateManipulation() {

	let first = new Date('January 1, 2019 04:30:00');
	let second = new Date('2019-01-01T04:30:00');
	console.log(first); 	// Tue Jan 01 2019 04:30:00 GMT-0600
	console.log(first.getTime() == second.getTime());	// true
	console.log(second.getHours());					// 4
	console.log(first.setMinutes(45));				// 1546339500000
	console.log(first.getMinutes());					// 45

}

function numberObject() {

	const str = "23";
	const num = Number(str);
	console.log(typeof str); //string
	console.log(typeof num); // number
	console.log(Number(340900000000000000).toExponential()); // 3.409e+17
}

function testRandom() {
	const lmin = 5;
	const lmax = 10;

	//to finish from screenshot
}

function randomWholeNumber(min, max) {
	return Math.floor(Math.random() * (max - min + 1) + min);
}
//console.log(randomWholeNumber(5, 10)); 	// numbers from 5 to 10
//console.log(randomWholeNumber(7, 42)); 	// numbers from 7 to 42	
//console.log(randomWholeNumber(1, 100)); 	// numbers from 1 to 100	
//console.log(randomWholeNumber(-10, 10)); 	// numbers from -10 to 10	
//console.log(randomWholeNumber(-4, 20)); 	// numbers from -4 to 20

function multiDimArrayObject() {
	const multiArray = [
		[{ key1: "value1", key2: "value2" }, //array index 0 element index 0
		{ key1: "value3", key2: "value4" }],//array index 0 element index 1

		[{ key1: "value5", key2: "value6" }, //array index 1 element index 0
		{ key1: "value7", key2: "value8" }] //array index 1 element index 1
	];
	// ArrayName[array_index][internal_array_index][object_key]	
	console.log(multiArray[1][0]["key2"]);	// value6

}


function arraysPush() {


	//using push
	const a = [];			// an empty array
	a.push(3);				// a = [3]
	console.log(a);

	a.push(4, 5, 6);		// a = [3, 4, 5, 6]

	console.log(a);
}

function arraysPopAndShift() {

	const a = [4, 5, 6];		// a = [4, 5, 6]
	const b = a.pop();  		// a = [4, 5]; b = 6 //pop example getting rid of 6 
	console.log(a);
	console.log(b);
	// now a = [4, 5]	
	const c = a.shift();		// a = [5]; c = 4  // shift example
	console.log(a);
	console.log(c);
}

function arraysJoin() {

	const a = [1, 2, 3];		// a new array with three elements
	console.log("a array" + a);

	const x = a.join();		// “1,2,3”
	console.log("x array" + x);

	const y = a.join(" ");		// “1 2 3”
	console.log("y array" + y);

	const z = a.join("");		// “123”
	console.log("z array" + z);

	const b = new Array(10);	// a new array with ten empty elements
	console.log("b array" + b);

	const k = b.join("-");		// “---------” (a string with nine hyphens)
	console.log("k array" + k);


	const c = x.split(",");		// [‘1’, ‘2’, ‘3’]
	console.log("c array" + c);
}

function arraysReverse() {
	const a = [1, 2, 3];			// a new array with three elements
	let b = a.reverse().join();	// b = “3,2,1”
	console.log("a array" + a);				// [3, 2, 1]
	console.log("b array" + b);				// 3,2,1



}

function arraysSort() {
	let a = ["banana", "cherry", "apple"];
	a.sort();
	console.log("sorted a array " + a);

	const s = a.join(" is good, ");
	console.log(s);		// apple is good, banana is good, cherry


	let fruits = ["banana", "orange", "apple", "mango"];
	fruits.sort();
	console.log(fruits);	// [“Apple”, “Banana”, “Mango”, “Orange”]

}

function arraysSlice() {

	const a = [1, 2, 3, 4, 5];
	console.log("a array" + a);

	const w = a.slice(0, 3);	// w = [1, 2, 3]
	console.log("w array" + w);

	const x = a.slice(3);		// x = [4, 5]
	console.log("x array" + x);

	const y = a.slice(1, -1);	// y = [2, 3, 4]
	console.log("y array" + y);

	const z = a.slice(-3, -2);	// z = [3]
	console.log("z array" + z);

	console.log(a);			// [1, 2, 3, 4, 5]

	const languages = ["JavaScript", "Python", "C", "C++", "Java"];
	// slicing the array from start to second-to-last element

	let new_arr = languages.slice(0, -1);
	console.log(new_arr); // ['JavaScript', 'Python', 'C', 'C++']

	// slicing the array from third-to-last to last element
	let new_arr1 = languages.slice(-3);
	console.log(new_arr1); // ['C', 'C++', 'Java']

}

function arraysSplice() {
	let fruits = ["banana", "orange", "apple", "mango"];
	fruits.splice(2, 2, "lemon", "kiwi");	// removes 2 elements
	console.log(fruits);				// [“banana”, “orange”, “lemon”, “kiwi”]
	const a = [1, 2, 3, 4, 5, 6, 7, 8];
	const x = a.splice(4);				// x = [5, 6, 7, 8]; a = [1, 2, 3, 4]
	const y = a.splice(1, 2);			// y = [2, 3]; a = [1, 4]
	const z = a.splice(1, 1);			// z = [4]; a = [1]
	const b = [1, 2, 3, 4, 5];
	const m = b.splice(2, 0, "a", "b");	// m = []; b = [1, 2, “a”, “b”, 3, 4, 5]
	const n = b.splice(2, 2, [1, 2], 3);	// n = [“a”, “b”]; 
	// b = [1, 2, [1, 2], 3, 3, 4, 5]

}

function arraysIterating() {
	let a = [23, 32, 45, 67, 77, 67, 98, 12];
	for (let i = 0; i < a.length; i++) {
		console.log(a[i]);	// will output each element of the array
	}

	function arraysForInLoop() {
		//not good practice so just use a for loop not a for...in

		let a = [23, 32, 45, 67, 77, 67, 98, 12];
		for (const index in a) {
			console.log(a[index]);	// will output each element of the array
		}

	}
}



class Person {
	
	static species = "Human";
	constructor(firstName, lastName, age, eyeColor) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.years = age;
		this.eyeColor = eyeColor;
	}
	static greet() {
		// Math.random() is also a static method!
		if (Math.random() <= 0.5)
			console.log("Hello!");
		else
			console.log("Hi!");
	}
};
const myFather = new Person("John", "Doe", 50, "blue");
console.log(myFather.species);	// undefined
console.log(Person.species);	// Human
Person.greet();   // Will print either “Hello!” or “Hi!”
