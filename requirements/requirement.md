# Assignment requirements, Java advanced.


## Customer's follow up:

Previously you made a console application for a photocopy store called PhotoShop.
Their employees have been using it for a couple of weeks, but are reporting issues controlling the application and adding new items to the store. 🤔

The owner has asked you to create some buttons and UI to make the application easier to use. She also heard about data being stored efficiently in a database and would like to use this feature because she expects a lot of customers in the coming years.

## Before you start coding:

Every time you start coding you need to have a general idea of what to develop.

☝️ Try to think about how to make the program before programming. Either write this out or make a UML (flow chart). Also, remember to create a database diagram. You must also provide a GUI design so the owner can rate your progress.

Something else that might help is making a distribution between your BOL, DAL, and GUI layers before you start the actual coding.

If you are not sure about your UML and class diagram you can always use the teams chat to ask a fellow trainee or trainer. Starting with a bad design ends up in a bad program. 😉


## The requirements for the next stage of developing Photoshop's application are:

* The user needs to input customer data. Name, Address, Postal code, City, Phone number, E-Mail
* The user needs to input employee data. Name, Employee number
* Whenever the user forgets to input a value or fills in a wrong type of value, the program needs to give a proper notification.
* The user wants to see the opening hours of the store.
* The user wants to select multiple products from a drop-down menu and choose how many of a particular item needs to be added to the order.
* The user wants to have an oversight of all selected products and have the ability to edit the amounts or remove the products altogether.
* The user wants to see when the order can be completed.
* An extra challenge is to make sure that two different orders can’t be carried out at the same time.
* The orders need to be saved to a database.
* The products and opening hours need to be added to the database. You will use the same data files as in the previous assignment.
* The user needs to be able to create an invoice as a .pdf file type.
* The application needs to be web-based. (This means that you have to use the knowledge gained from the Udemy course, there is no need to put it online 😁)


## Recap assignment requirements, Java basics.

For a photocopy store called PhotoShop, you have to make a good working application that can select different items from the store catalogue and add this to a shopping cart. After the user has selected all the different items an invoice has to be created.

## Requirements

* Show your progress in each Java meetup.
* The user needs to input either the id or name of the item to put it in the order.
* The user needs to be able to modify or add multiple items to the order.
* The user needs to be able to modify or add customer information for the order.
* The user needs to be able to create an invoice.
* On the invoice, the entire order's total cost must be shown.
* On the invoice, the completion time needs to be shown.
* The pickup date and time need to be within the store's opening hours.
* Keep in mind that PhotoShop only has one printer, so orders should stack accordingly. 
* The shopping cart needs to be saved to and retrieved from either XML or Json. So that old orders can be reviewed.
* Use the CSV files for the opening hours and the price list.
* The program needs to be made completely in the command log.


## Considerations  

Make sure you put sufficient comments in your code. 

Apply inheritance, for example, the order can inherit from a photo. 

Use the naming conventions correctly and consistently. 

Make sure your code is efficient, readable, extendable and maintainable. 
Your grandma should be able to use your application, so make sure is clear and easy to use