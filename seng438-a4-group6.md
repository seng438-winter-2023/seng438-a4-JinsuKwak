**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#4 – Mutation Testing and Web app testing**

| Group \#:      |  6   |
| -------------- | --- |
| Student Names: |  Maarya Ahmed   |
|                |  Jinsu Kwak   |
|                |  Hannah Son  |
|                |  Jack Li  |

# Introduction

In this assignment, students were required to learn two important aspects of testing: Mutation testing ang GUI testing on a chosen website. In the mutation testing part of the assignment, it was espected from students to learn how to inject mutation faults in a Java code-base using a mutation testing tool called PIT Mutations. We had to interpret the reported mutation scores and the mutants that were killed and that survived to design new test cases to improve the overall quality of the test suite. In the second part of the assignment, we tested a chosen website using a common way of GUI test automation, record and replay. We learned how to use a very well-known tool for web interface testing (Selenium) and compared it with another alternative.

# Analysis of 10 Mutants of the Range class 

<img width="500" alt="Screen Shot 2023-03-17 at 8 26 33 AM" src="https://user-images.githubusercontent.com/56771715/225933222-13ba4168-3aab-4af2-8fb1-cfbafb466619.png">


# Report all the statistics and the mutation score for each test class

    Range Class:

      Before:
      
<img width="500" alt="Screen Shot 2023-03-17 at 10 53 36 AM" src="https://user-images.githubusercontent.com/56771715/225969332-6b179bf1-f52b-4bd3-ac84-f5f6b2c752c1.png">
       
      After:

<img width="500" alt="Screen Shot 2023-03-17 at 11 24 49 AM" src="https://user-images.githubusercontent.com/56771715/225976617-14195581-a243-4517-85dc-6033f7e0e157.png">

    DataUtilities Class:
 
        Before:
<img width="500" alt="Screen Shot 2023-03-17 at 10 53 36 AM" src="https://user-images.githubusercontent.com/81532489/226078541-a6adf925-206c-40fe-8f3b-85e0c71745a8.png">


        After:
<img width="500" alt="Screen Shot 2023-03-17 at 10 53 36 AM" src="https://user-images.githubusercontent.com/81532489/226083187-12e279a2-d985-4da2-8389-e0ed664be49a.png">


# Analysis drawn on the effectiveness of each of the test classes
For the Range class, our test suites were somewhat effective, we started out with 87% line coverage as well as 66% mutation coverage . This means that there were tests for the majority of the code in the methods. Carrying out mutation testing allow us to create tests that we did not come up with initially, strengthening the effectiveness of our test suite. 

As for the DataUtilities class, we Started off with 99% line coverage and 89% mutation coverage, concluding that our test suite for DataUtilities was highly effective. Increasing the mutation coverage above 90% would be very difficult in this case, as many of the mutants created may not be applicable or are equivalent mutants.
# A discussion on the effect of equivalent mutants on mutation score accuracy

Equivalent mutants distort the accuracy of mutation scores. The presence of equivalent mutants makes the test suite's quality look lower than it actually is, when in fact it doesn't since no tests can actually detect them.


# A discussion of what could have been done to improve the mutation score of the test suites
Since the mutation coverage was determined off the tests we created in labs 2 and 3, we were able to have generally effective test suites for both of the classes Range and DataUtilities. DataUtilities had a close to 100% mutation coverage, which meant that it would be near impossible to increase the coverage by a large amount due to non-applicable mutants or equivalent mutants. Nevertheless, we looked at the mutation summaries for the statements and worked backwards to attempt to increase the coverage for DataUtilities. For Range, the same method was employed to eliminate some surviving mutants. In the future, the same process can likely be applied to eliminate more mutants to increases the mutation score.
# Why do we need mutation testing? Advantages and disadvantages of mutation testing

Mutatation testing is needed because it tells us the quality of our test suite and how good it is at catching bugs.

Advantages of Mutation Testing

     -Mutation Testing is automated 
     
     -Mutation Testing gives us the mutation score, which tells us when to stop testing and which test suite's quality is better

Disadvantages of Mutation Testing

     -Mutation Testing is time consuming
     
     -The presence of equivalent mutants (there tends to be a lot of equivalent mutants in SUTs, and as we know, equivalent mutants cannot be killed)



# Explain your SELENUIM test case design process

| Functionality | Sequence of Events |
| --------------|--------------------|
| Search for a product | Click on search bar, type "Tent", click on search button, click on product |
| Search for a warehouse | Click on locations link, type "Calgary", click on find button, click on a warehouse | 
| Change Delivery Location | Click on Delivery Location, type "PostalCode", click Change Delivery Location button, where PostalCode is 6 digit letter with [A1A 1A1] format|
| Change Region | Click current region (top right conner CA in most cases) Click desired region to change |
| Add Item to Cart | |
| Sign Up | |
| Register | |
| Compare Product | |
 

# Explain the use of assertions and checkpoints

In Selenium, the assertions are checkpoints that are used to make sure that the SUT is working as intended. For example, you can assert whether the web page displaying correct links or not or checking the presence or absence of an element, and ensuring that a specific element is visible or clickable. If an assertion fails, the test will stop executing and report an error message.

Checkpoints, on the other hand, are used to verify that a specific value or state is achieved during the test. Checkpoints are typically implemented using the "verify" command. This command checks a specific property or attribute of an element and compares it to an expected value. If the actual value matches the expected value, the test continues. If not, the test stops executing and reports an error message.


# How did you test each functionaity with different test data

| Functionality | Input Sequence | Expected Ouput | Assertions |
| --------------|----------------|----------------|------------|
| Search for a product | Click on search bar, type "Tent", click on search button, click on product | Shows product title and image | Assert that product title and image are there|
| Search for a product | Click on search button (no keyword in search bar) | Nothing happens | Assert that page is the same |
| Search for a warehouse | Click on locations link, type "Calgary", click on find button, click on a warehouse | Shows warehouse title, description, and map | Assert that warehouse title and map image are there |
| Search for a warehouse | Click on locations link, click on find button (no keyword in search bar) | Error Message Appears | Assert that error message appears |
| Change Delivery Location | intput PostalCode = T2N 1N4, valid format [A1A 1A1] and exist postal code in Canada | Delivery location changes and display changed delivery location | assert text "A2S 2G1" which is new delivery location |
| Change Delivery Location | intput PostalCode = A2S 2G1, valid format [A1A 1A1] but not exist postal code in Canada, it is unable to test non valid format because GUI blocks if format does not meet | Display warning "Please enter a valid Postal code." | assert text "Please enter a valid Postal code." is appeared on screen |
| Change Region | previous region selected: Canada, desired region to change: Canada | reload the page with desired region "CA" and corresponding language settings | assert text "CA" is appeared on screen |
| Change Region | previous region selected: Canada, desired region to change: United States | reload the page with desired region "US" and corresponding language settings | assert text "US" is appeared on screen |
| Change Region | previous region selected: United States, desired region to change: Canada | reload the page with desired region "CA" and corresponding language settings | assert text "CA" is appeared on screen |
| Change Region | previous region selected: Canada, desired region to change: France | reload the page with desired region "France" and corresponding language settings | assert text "France" is appeared on screen |
| Add Item to Cart | | | |
| Add Item to Cart | | | |
| Sign Up | | | | 
| Sign Up | | | | 
| Register | | | |
| Register | | | |
| Register | | | |
| Register | | | |
| Register | | | |
| Compare Product | | | |
| Compare Product | | | |
| Compare Product | | | |
| Compare Product | | | |

# Discuss advantages and disadvantages of Selenium vs. Sikulix

Advantages of Selenium:

    -It is supported across multiple operating systems and browsers


Disadvantages of Selenium:

    -Can only test web applications


Advantages of Sikulix:

    -Can automate Flash objects
    
    -Can automate desktop applications

Disadvantages of Sikulix:

    -It has issues with cross-browser testing


# How the team work/effort was divided and managed

For the GUI Testing, we made a list of possible functionalities that our chosen website would have and put our names beside the functionalities and got that done

# Difficulties encountered, challenges overcome, and lessons learned

Some difficulties encountered in this assignment is firstly, running the PIT mutations on our computers. It took very long to execute the mutation tests and we did not know what the printed code on the console meant. But after some asking around and help with the TA's, we were able to run the PIT mutations on our laptops and were able to generate the reports of the killed and survived mutants are well as the mutation coverage percentage for each class. Another difficulty we faced was during the GUI testing. Just trying to set up the Selenium IDE took some time since we were not familiar with it. But we also had some difficulty understanding how to do the verification points on the Selenium IDE for our tests but we researched and asked with our peers and were able to solve our issues. 

# Comments/feedback on the lab itself

This assignment took a long time for us to understand what exactly needs to be done. It was also hard because the PIT Mutations took a very long time to execute and compile. Overall, the assignment was effective in creating tasks that demonstrated Mutation and GUI testing.
