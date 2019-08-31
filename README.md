Annexure A:  
CODING ROUND  
 
Instructions:  
●
●
●
●
●
●
You will have to code the below problem using the Java language only, however you  
are free to use any open source Java library/framework.  
We would evaluate your code using both automation and manual processes. So  
please give it your best shot - use your best design, your best coding practices, et al.  
You will have to complete this coding assignment within 48 hours of receiving this, if  
you would need more time, please contact your consultant explaining the reason.  
We have tried to define the problem as clearly as possible, however if you have any  
questions you can contact us.  
After you are done, you will need to push the code to your private github repository.  
You will then need to invite github user coding-interview as a collaborator to view  
your code.  
https://help.github.com/en/articles/inviting-collaborators-to-a-personal-repository  
●
●
After all the above is done, please email back along with your github userid.  
We may fork your code to evaluate it and for future references. We shall however  
not use it in any of our code or products without your consent.  
 
 
 6  
 
The Problem:  
Let’s say we have this ecommerce website called AmazinKart. AmazinKart gets its product  
details from a third party json API which contains the product prices and other details. You  
as a developer of AmazinKart needs to create a module which will :  
1. Retrieve the product details by calling the third party json API  
url: https://api.jsonbin.io/b/5d31a1c4536bb970455172ca/latest   
2. Convert the prices to INR if the price is not in INR using exchangeratesapi.io  
url: https://api.exchangeratesapi.io/latest  
3. Save the json file (named output.json) into target folder.  
But what’s the point of having an ecommerce site without any discounts right?! So  
let's add some promotions.  
Unsurprisingly, running promotion is a complex game and our geeky product  
managers wants multiple sets of them to be deployed simultaneously in production but will  
run only one of them at a time.  
Promotion Set A:  
1. There will be a 7% discount on the price if the origin of the products is Africa  
2. There will be a discount of 4% if the product rating is equal to 2 and 8 % if the  
product rating is below 2.  
3. There will be a flat discount of Rs 100 on the products in these categories:  
“electronics”,”furnishing” for items costing Rs 500 and above.  
Promotion Set B:  
1. There will be a 12% discount on the prices if the inventory is more than 20.  
2. There will be a discount of 7% if the product arrival status is new.  
Common Rules:  
1. There can only be one discount applied at a time for each Promotion Set.  
2. You have to apply the discount which provides the highest discount to the customer  
3. There will be a default discount of 2% if the price of the item exceeds Rs 1000 and  
no other discount was applied.  
 
 
 7  
 
Running the program:  
To run Promotion Set A:  
java target/amazinkart-1.0.0.jar promotionSetA  
To run Promotion Set B:  
java target/amazinkart-1.0.0.jar promotionSetB  
Running the above program should retrieve the product details from the API, convert the  
prices to INR if required, run the discount rules and then create a json file with a json node  
called discount like below. Please note that this is just an example - the below price and  
discount amount may not be correct.  
[  
{  
"category": "toys",  
"inventory": 10,  
"rating": 2.8,  
"currency": "INR",  
"price": 2000.50,  
"origin": "Asia",  
"product": "remote control car",  
"discount": {  
"amount": 300.5,  
"discountTag": "get 5% off"  
}  
},  
{  
"category": "electronics",  
"inventory": 10,  
"rating": 2.8,  
"currency": "INR",  
"price": 4500,  
"origin": "Asia",  
"product": "mobile",  
"discount": {  
"amount": 100.5,  
"discountTag": "get Rs 100 off"  
}  
}  
.....  
..........]  8  
 
FAQs:  
●
Do I need to convert the prices to INR?  
All price should be in INR.  
●
What format is the price and discount attribute?  
All price related attributes should be in double.  
●
Do I need to add a discount node to the output if no discounts were  
applicable?  
No. It is not required to add a discount node if no discounts were applicable  
●
I am not able to access the API urls, now what?  
If you are not able to access the urls via code, please double check in the  
browser first. If it is not working in the browser, please contact us.  
