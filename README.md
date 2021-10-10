# Habit tracker

## :blue_book: Glossary
- Goal - some aim that the user wants to achieve.
- Progress - visualizing steps performing.
- Reward - raiting which user can get for succsessful step on lose for failing the step.
- Steps - daily stage in a way to achieve the goal.
- User - someone who uses the app.

## :iphone: Description
This is an android mobile application which helps users to acquire new habits or quit old ones.
Scientists have proven that it takes 66 days for a person to acquire (or drop) a habit. 
The most difficult in this period of time are the first 21 days. Our application helps a person during this difficult period.

## :heavy_check_mark: App overview
User registers in the application. 

<img src="https://github.com/seytkalievm/HabitTracker/blob/main/screenshots/Screenshot_20211011-002146.png" width="200" height="400" />

After that he can log in.

<img src="https://github.com/seytkalievm/HabitTracker/blob/main/screenshots/Screenshot_20211011-002113.png" width="200" height="400" />


<img src="https://github.com/seytkalievm/HabitTracker/blob/main/screenshots/Screenshot_20211011-002405.png" width="200" height="400" />

After that he can create a goal: can be chosen one of the existing goals or created a new one from scratch.
The user will have ative goals:

<img src="https://github.com/seytkalievm/HabitTracker/blob/main/screenshots/Screenshot_20211011-000943.png" width="200" height="400" />

Completed coals:

<img src="https://github.com/seytkalievm/HabitTracker/blob/main/screenshots/Screenshot_20211011-000958.png" width="200" height="400" />

And failed once:

<img src="https://github.com/seytkalievm/HabitTracker/blob/main/screenshots/Screenshot_20211011-000952.png" width="200" height="400" />

After creating the goal, user will see a daily steps in the tab "To do". 
The app will send to the user notifications about daily steps everyday.
After completing the daily step the user should mark it as comlete id the tab "To do", or as incomplete overwise.

<img src="https://github.com/seytkalievm/HabitTracker/blob/main/screenshots/Screenshot_20211011-002550.png" width="200" height="400" />

## :bar_chart: Rationale

### Front-end
For the front-end development Kotlin was chosen. Let us compare it with one of the most known programming languages  for Android development - Java.

|Kotlin|Java|
|---|---|
|More concise, that increases readability and maintainability|Needs more lines of code to implement the same thing|
|New design patterns, cleaner syntax, ideas from functional programming|Lack of support for functional programming features|
|Scripting capabilities increase the portability (does not need to be compiled)|Needs to be compiled|
|Semicolons are optional, that makes code lighter|Semicolons are obligatory, more possibility for bugs occurrences|
|Null safety implemented|NullPointerException errors cause crashes|
|Has only primary and secondary constructors|Constructors can be used to take parameters, initialize attributes|
|No static members|Allows static members in classes|

All in all, Java and Kotlin have a lot in common, however Kotlin is a new programming language. It took the best from its predecessors, corrected mistakes, introduced new ideas. Thus, for Android development Kotlin is a better choice.
 
### Back-end
For the back-end Java in Spring Boot framework was chosen.  Firstly, let us discuss the language selection. One of the most famous languages for the back-end Android development is Python, so here is the comparison of Java and Python languages.
|Java|Python|
|---|---|
|The most supported language by Google|Android does not support native Python development, need to use converting tools|
|Complicated language for a beginner and SDK increases the complexity|More readable and easy syntax, more concise|
|Faster than Python|Slower than Java|
|Object-oriented|Cand mix object-oriented and imperative programming|
|Statically typed language|Dynamically typed language|
|Better characterized as low-level implementation language|Better as “glue” language|

We can see that each of these programming languages has pros and cons. While Java is faster, Python is much easier to learn, it is more concise. On the other side, Java fits Android development more.
Moreover, the complexity of the language can be reduced using frameworks. So, the second question is the Java framework. For this project the Spring Boot was chosen. Let us compare it with one of the most popular development frameworks of Java - Spring.
|Spring Boot|Spring|
|---|---|
|Developers need to write more code than in Spring Boot|Reduces boilerplate code|
|Internally takes care of downloading the dependencies|Developers manually define dependencies for the Spring project|
|Lack of control (creates dependencies itself)|Eliminates the need to independently create factory and singleton classes|

From this we see that Spring Boot reduces the complexity of Java more than Spring, however it is not suitable for big projects. Thus, as our project is not very large, the Spring Boot is a better choice.

### Database
For this project to work with data, data definition language of the database is needed. So, the most known and usable language - SQL was taken. And MySQL was chosen as a relational database management system. Here arises the question about the DBMS. Why exactly that choice was made. Let us provide a comparison of MySQL with PostreSQL - one of the most popular DBMS for SQL.

|MySQL|PostgreSQL|
|---|---|
|Simpler database that’s relatively easy to set up and manage, fast, reliable, and well-understood|Feature-rich database that can handle complex queries and massive databases|
|SQL-standard types|Support many advanced types such as array, hstore, and user-defined type|
|Each new connection is an OS thread|Each new connection is an OS process|
|Performs well in OLAP & OLTP systems|Performs well when executing complex queries|

From this comparison it is obvious that PosgreSQL is more suitable for complex databases with complex queries, it has more features. However, this project has a very simple database and simple queries, that is why MySQL is a better choice.

## :pencil2: Contacts
If you have questions or suggestions you can contact:

:point_right: [Dias Usenov](https://github.com/DiazzzU)

:point_right: [Makshe Seytkaliev](https://github.com/seytkalievm)

:point_right: [Kamila Khamidullina](https://github.com/Kamila-Khamidullina)

Documentation:

:link: [Software Design Documentation](https://github.com/seytkalievm/HabitTracker/blob/main/Software%20Design%20Documentation.pdf)

:link: [RUP Artifact](https://github.com/seytkalievm/HabitTracker/blob/main/RUP%20Artifact.pdf)

Front-end code is located in master-branch.

Back-end code is located in backend-branch.

References can be found in software design documentation.
