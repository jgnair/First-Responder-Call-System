# First-Responder-Call-System
This project was designed in Java to aid in the sorting and submitting of calls through first-responder programs to more easily inform the required departments with what is needed, when, and how severe the situation is.

Project unfortunately never uploaded itself to github. I will slowly put in parts of the code and explain them in detail.  


Notification Class:
The notification class acts as a node class for the singly linked tree that I used later on. It contains the barebones for the entire project. Each notification contains it's own case number, time of arrival, required department, severity level, and distance.  While the distance is mainly for show, the other 4 parameters determine almost everything in the rest of the code.  


InputCalls Class:
The InputCalls class acts similarly to a meld between a tree, linked list, and priority queue. It's whole purpose is to act as the recipient of all information after the bubble sorter goes through all the different information that is input within the tester class.


Tester Class;
The tester contains all of the information for the project.  The sorter, scanner (for input information), and final results are all visible from here. The information gets pulled in from the user via the scanner and then gets thrown into an array to be bubble sorterd. Afterwards, that array gets put into the inputcalls 'tree' to be submitted to the various 'departments' that exist.  The idea is that depending on how many people are present at each department or how many more occupants/situations they can accept at the time, they can simply accept a call from the InputCalls class to add that situation to their roster.  
