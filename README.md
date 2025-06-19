# Practicum-Exam-IMAD5112-ST10479817-

## The Project Overview
This app will store your aongs allowing you to add details like artist Name, comment and alowing you to rate it out of five. The first screen alows for user to enter all the information needed and stops the user at four songs.

## The Repository Link
https://github.com/ST10479817/Practicum-Exam-IMAD5112-ST10479817-.git

## The Report

### Q.1.2 The Main Screen
![image](https://github.com/user-attachments/assets/81de46cd-0a47-452e-bdc5-8f0d4a4e6090)

Above you see the user will be asked to enter the following details. The song name, artist's name, the rating out of 5 and add a comment. 

![image](https://github.com/user-attachments/assets/53554291-aed3-48f8-bb6c-df8301489682)

There are 3 buttuns: The Add to Playlist Button, The Exit Button and The Detailed Infomation Button. Each one has a purpose. As you can see on the last adding it will be showing you how many songs is currently add.

![image](https://github.com/user-attachments/assets/662bed52-3681-4f09-97af-325bd42fc69f)

When all FOUR songs has beed added the text will tell and the add to playlist button will disappear.
To go to the next screen you press the Detailed Information button and it will take you there.


### Q.1.3 Detailed View Screen

![image](https://github.com/user-attachments/assets/ce83b617-27d6-4776-bea1-09669c31c738)

This is the last screen.
![image](https://github.com/user-attachments/assets/02695629-0cb0-439c-ac9c-167c9314d3df)

once you pressshow playlist it show all the songs you added.

![image](https://github.com/user-attachments/assets/17acbf32-dd24-4d3b-82b1-09e9574e1ddf)

When you press Average Rating Button
and last button is just the return to main screen.

#### SCREENSHOTS OF CODE


![image](https://github.com/user-attachments/assets/51347218-6f67-4ce3-b8a8-bafd307f954b)
![image](https://github.com/user-attachments/assets/dc8a6cce-6bb4-4341-a719-67a4fc3b7662)




 

#### GitHub Version Control 
I consistency committed my progress to GitHub, I have been following good practices and documenting any changes with meaningful commit messages.

#### GitHub Version Control
I managed to get the Action test to work. 
name: Kotlin Build

on:
  push:
    branches: [main]

jobs:
  build:
    runs-on: ubuntu-latest

    steps:
      - uses: actions/checkout@v3

      - name: Set up JDK 17
        uses: actions/setup-java@v3
        with:
          java-version: '17'
          distribution: 'temurin'

      - name: Make Gradle wrapper executable
        run: chmod +x ./gradlew
        working-directory: PracticumExamIMAD5112ST10479817

      - name: Build the project
        run: ./gradlew build
        working-directory: PracticumExamIMAD5112ST10479817
