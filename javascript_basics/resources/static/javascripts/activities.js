/**
 * 
 */

 function findEvenNumbers(){
	 for(let i = 0; i <= 100; i += 2){
		 document.write(i + "<br>");
	 }
 }
 
 function findOddNumbers(){
	 for(let i = 1; i <= 100; i += 2){
		 document.write(i + "<br>");
	 }
 }
 
 //needed to make a print status function below to get Yes or No to print
 function isPrimeNumber(n){
	 for (var i = 2; i < n; i++){
		 if(n % i === 0) return false;
	 }
	 return n > 1;
 }
 
 function printPrimeStatus(n){
	 if (isPrimeNumber(n)){
		 document.write("Yes");
		
	 }else{
		 document.write("No");
	 }
 }
 
 function isDivisibleBy4And6(){
	 for(let i = 10; i <= 1000; i++) {
		 if (i % 4 === 0 && i % 6 === 0){
			 document.write(i + "<br>");
		 }
	 }
	 
 }