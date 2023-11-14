
function personObject() {

	const person = {
		firstName: "Jane",
		lastName: "Doe",
		age: 35,
		eyeColor: "grayish-blue",
		fullName: function() {
			return this.firstName + " " + this.lastName; //notice you can have a function as a key:value pair
		}
	}; //notice semicolon. It's needed because you've assigned multiple values to obj. person

	person.address = "123 Hope Avenue"; //adding new property to object person
	person.title = "Java Developer"; //adding new property to object person

	document.write(person.address, " | ", person.title, " | ", person.firstName);



	//document.write(document.getElementById("demo0").innerHTML = person.fullName());






	//document.write(person.firstName + " " + person.lastName + " " + person.age + " " + person.eyeColor + "<br>");


	//const myArray = Object.values(person); //converting info into an array
	//document.write(myArray);

	//delete person.age;
	//document.write(person.firstName + " " + person.lastName + " " + person.age + " " + person.eyeColor + "<br>");




	//let x =  person.eyeColor; //objectName.propertyName
	//document.write(x, "<br>");

	//let y = person["lastName"] //objectName[propertyName]

	//document.write(y, "<br>");

	//let z = "age"				//objectName[Expression]
	//document.write(person[z]);
	//return person;
}

function literalObject() {
	const empty = {} // An object with no properties.
	const point = { x: 10, y: 7 }; // An object with two properties.
	document.write(point.x, point.y, "<br>");


	const point2 = { x: point.x, y: point.y + 1 }; // More complex values.
	document.write(point2.x, " | ", point2.y, "<br>");

	const book = {
		"main title": "JavaScript", // Property names can include spaces,
		"sub-title": "The Definitive Guide", // and hyphens; use string literals.
		"for": "all audiences", // for is a reserved word; quote it to use.
		author: { // The value of this property is itself an object.
			firstname: "David", // Note that these single-word
			surname: "Flanagan" // property names are unquoted.
		}
	};
	document.write(book["main title"], "<br>", book["sub-title"], "<br>", book.for, "<br>", book.author.firstname, "<br>", book.author.surname);

}

function person() {
	const person = new Object();
	person.firstName = "John";
	person.lastName = "Doe";
	person.age = 50;
	person.eyeColor = "blue";

	document.write(person.firstName, " ", person.lastName, " ", person.age, " ", person.eyeColor);
}

function Person(first, last, age, eye) {
	this.firstName = first;
	this.lastName = last;
	this.age = age;
	this.eyeColor = eye;
	this.introduce = function() {
		document.write(this.firstName + " " + this.lastName +
			" is " + this.age + " years old with " + this.eyeColor + " eyes.");
	};
}

//Person.prototype.species = "Human";

//const myFather = new Person("John", "Doe", 50, "blue");
//const myMother = new Person("Sally", "Rally", 48, "green");

//myFather.birthday = "June 15th"; // Adding a property to an Object.
//document.write(myFather.birthday); 
//document.write(myMother.species);

//myFather.introduce(); // Calling an Object method.

const myFather = new Person("John", "Doe", 50, "blue");
const myMother = new Person("Sally", "Rally", 48, "green");
const myBrother = new Person("Jane", "Doe", 22, "blue");

myBrother.species = "Goblin";

Person.prototype.species = "Human";
console.log(myFather.species); // Human
console.log(myBrother.species); // Goblin
console.log(Object.getPrototypeOf(myBrother).species); // Human



