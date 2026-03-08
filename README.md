# Online Flashcard System for Study- install(.exe)

## Overview

This project aims to create a simple and user-friendly flashcard platform that helps students study more effectively by organizing flashcard sets, supporting study/review sessions, and tracking learning progress. At the same time, it allows teachers to create classrooms, assign flashcards, and follow students’ performance, making learning more structured, engaging, and easier to manage.

## Features

- User authentication: Registration, Login
- Flashcard management: Create, Edit, Delete
- Classroom management: Create, Edit
- Flashcard Sets management: Upload, Assign to Classroom
- Different mode for student
  - Study
  - Quiz
- Track learning progress
- View statistics

## database: H2

## Cau lenh de tao file .exe(cai phan mem "wit tool set 3.11.2")
jpackage `                                                                                                       
>>   --type exe `                                                                                                                                                
>>   --name Fliply `                                                                                                                                             
>>   --input target `                                                                                                                                            
>>   --main-jar fliply-1.0-SNAPSHOT.jar `                                                                                                                        
>>   --main-class Main `                                                                                                                                         
>>   --icon src/main/resources/images/icon.ico `                                                                                                                 
>>   --dest installer `                                                                                                                                          
>>   --app-version 1.0 `                                                                                                                                         
>>   --win-menu `                                                                                                                                                
>>   --win-shortcut `                                                                                                                                            
>>   --win-dir-chooser `                                                                                                                                         
>>   --resource-dir installer-resources
          
## Trello Board
[https://trello.com/w/sep1_group3/home](https://trello.com/w/sep1_group3/home)

## Figma Design
[Fliply Prototype](https://www.figma.com/proto/vr1e9M1MRVlRu9v6x4GVHH/Untitled?node-id=1-2&p=f&t=KOn9wktxFwEu72ek-0&scaling=min-zoom&content-scaling=fixed&page-id=0%3A1&starting-point-node-id=1%3A2&show-proto-sidebar=1)
