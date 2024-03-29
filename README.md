<h1> individual-project-liaoliao6</h1>

<ol>
<li><p>This Credit Card application employed several creational and behavioral patterns and allow users to identify the credit card type based on the files containing credit card records.<br></p></li>
<li><p>The design patterns included Strategy, Iterator and Factory Pattern.<br></p> </li>
<li><p>Factory pattern was used to describe the methodology identifying cardit card type and validating the card number. However, using Factory Pattern might voilate the open/closed principle of design pattern.The designer could easily make mistakes, include boolean methods in the factory and have the factory to determine the card type. The problem here is that, the responsiblity of identifing card type should not be the job of the factory but of the subclass. The primary problem this project was going to solve is the violation of open/closed principle. Therefore, in this project, static method and abstact factory were used to solve this problem, and the boolean method was moved to the concrete classes.<br></p></li>
<li><p>This project was extended to parse different input file formats (json, xml, csv). Stratege pattern was used to decide the input file format and therefore which method was going to be used to parse the file. However, since each file contains lines of credit card records,iterator pattern was incorporated with stratege pattern, so that each line of records was read and processed.<br></p></li>
<li><p>Different formats of input file brought the problem of a variaty of exceptions, which was the secondary problem this project was trying to solve.<br></p> </li>
</ol>

![Tux, the Linux mascot](/CreditCard/image/CreditCard.jpg)
