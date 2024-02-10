# L3 design pattern report

- **Firstname**: Grégoire
- **Lastname**: Wartner

> Add your thoughts on every TP bellow, everything is interresting but no need to right a book.
>
> Keep it short simple and efficient:
>
> - What you did and why
> - What helped you and why
> - What did you find difficult
> - What did not help you
> - What did you need to change
> - Anything relevant
>
> Add a link to schemas describing your architecture (UML or not but add a legend)
>
> Remember: it is ok to make mistakes, you will have time to spot them later.
>
> Fill free to contact me if needed.

---

## TP1

### What I did and why

I implemented classes and interfaces to represent the different components of the ToDo app.
The goal was to lighten the App class which was doing too much and used a lot of malpractice code techniques.
I divided the app into three main components : ToDo, DataStorage and CommandParser.

### What helped me and why

Making an UML diagram of the app helped me to understand the different components and their interactions.
I also used ChatGPT to understand ways of implementing different methods and classes of the app.

### What I found difficult

I found it difficult to understand the different ways of implementing the app. I had to try different ways of doing it before finding the one that suited me the most.

### What did not help me

The java documentation was not very clear and I had to look for other resources to understand how to implement the app.

### What did I need to change

I had to chage the structure of the `App.java` class because it was doing too much and was not respecting the SOLID Principles.
I also had to change the way I was implementing the app because I was doing it the wrong way.

---

## TP2

### What I did and why

I added the option for a new flag in the CLI to manage done tasks.
If used with the `list` command, it will display the tasks that are done.
If used with the `add` command, it will add a task as done.

### What helped me and why

I took example from the `list` command to implement the `done` command.
It allowed for smoother integration with the existing code.

### What I found difficult

Nothing was particularly difficult in this TP.

### What did not help me

The java documentation was not very clear and I had to look for other resources to understand how to implement the option.

### What did I need to change

I had to make modifications to the `TodoController` and `TodoItem` classes to add the new option.
