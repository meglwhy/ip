# Koji Chatbot User Guide

![Koji Screenshot](https://meglwhy.github.io/ip/Ui.png)  
*Screenshot of Koji Chatbot in action.*

Koji Chatbot is your personal task manager and assistant that helps you keep track of your tasks, deadlines, events, and more. With an intuitive interface, you can easily add, update, edit, and find tasks using simple commands.

## Adding Deadlines

To add a deadline, use the `deadline` command followed by the task description and the deadline date/time. The date must be in the format `yyyy-MM-dd HHmm`.

**Example:**

deadline return book /by 2023-12-31 1800

**Expected output:**

Got it. I've added this task:
  [D][ ] return book (by: Dec 31 2023, 6:00 PM) 
Now you have X tasks in the list.

## Adding Todo

To add a todo, use the `todo` command followed by the task description.

**Example:**

todo read book

**Expected output:**

Got it. I've added this task:
  [T][ ] read book  
Now you have X tasks in the list.

## Adding Events

To add an event with a start and end time, use the `event` command:

**Example:**

event project meeting /from 2023-10-15 1400 /to 2023-10-15 1600

**Expected output:**

Got it. I've added this task: 
  [E][ ] project meeting (from: Oct 15 2023, 2:00 PM to: Oct 15 2023, 4:00 PM) 
Now you have X tasks in the list.

## Marking and Unmarking Tasks

To mark a task as done, type:

mark TASK_NUMBER

**Example:**

mark 2

**Expected output:**

Nice! I've marked this task as done: 
  [E][X] Study session (from: Feb 01 2019, 12:00 am to: Dec 12 2020, 6:00 pm) 
Now you have X tasks in the list.

To unmark a task, type:

unmark TASK_NUMBER

**Example:**

unmark 2

**Expected output:**

OK, I've marked this task as not done yet: 
  [E][] study sesh (from: Feb 01 2019, 12:00 am to: Dec 12 2020, 6:00 pm) 
Now you have X tasks in the list.


## Editing Tasks

To update a task's description without deleting it, use the `edit` command:

edit TASK_NUMBER NEW_DESCRIPTION

**Example:**

edit 3 Submit IP report

This command updates the description of the task at position 3.

## List Tasks

To list all tasks, use:

list

**Expected output:**

Here are the tasks in your list:

1. [T][ ] study lac4202
2. [D][X] return book (by: Dec 31 2023, 6:00 PM)

## Finding Tasks

To search for tasks containing a specific keyword, use:

find KEYWORD

**Example:**

find book 

**Expected output:**

Here are the matching tasks in your list:

1. [T][ ] study lac4202
2. [D][X] return book (by: Dec 31 2023, 6:00 PM)

## Deleting Tasks

To delete a task, use the `delete` command:

delete TASK_NUMBER

**Example:**

delete 2

**Expected output:**

Noted. I've removed this task: 
  [D][X] return book (by: Dec 31 2023, 6:00 PM) 
Now you have X tasks in the list.

## Exit Program

To exit the program, use the `bye` command.


---

This User Guide provides an overview of the key features of Koji Chatbot, including how to add deadlines, mark/unmark tasks, edit and find tasks, add events, and delete tasks. Follow the examples for proper command usage, and refer back to this guide whenever you need assistance interacting with Koji Chatbot.


