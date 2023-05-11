package com.abdulaziz.trivia.usecase

import com.abdulaziz.trivia.data.Question
import com.abdulaziz.trivia.repository.LocalRepository

class LocalUseCase() {
    private var questionList = arrayListOf<Question>()
    private fun insertTrivia(question: String, correctAnswer: String, incorrectAnswers: ArrayList<String>) {
        questionList.add(Question(question, correctAnswer, incorrectAnswers))
    }


    fun getAllTrivia(category:String):List<Question>{
        questionList.clear()
        when(category){
            "History" -> insertHistoryTrivia()
            "Geography" -> insertGeoTrivia()
            "Entertainment" -> insertMovieAndTVTrivia()
            "General Knowledge" -> insertGKTrivia()
        }
        return questionList
    }

    private fun insertHistoryTrivia(){
        insertTrivia("Which document declared the 13 American colonies independent from Great Britain?", "Declaration of Independence", arrayListOf("Constitution", "Bill of Rights", "Emancipation Proclamation"))
        insertTrivia("In which year did the French Revolution begin?", "1789", arrayListOf("1769", "1799", "1812"))
        insertTrivia("Who was the first emperor of the Roman Empire?", "Augustus", arrayListOf("Julius Caesar", "Nero", "Constantine"))
        insertTrivia("In which year did the Civil War in the United States begin?", "1861", arrayListOf("1850", "1870", "1880"))
        insertTrivia("Who led the Bolsheviks in the Russian Revolution of 1917?", "Vladimir Lenin", arrayListOf("Joseph Stalin", "Leon Trotsky", "Mikhail Gorbachev"))
        insertTrivia("Which famous speech begins with the words 'Four score and seven years ago'?", "Gettysburg Address", arrayListOf("I Have a Dream", "Tear Down This Wall", "Ich bin ein Berliner"))
        insertTrivia("In which year did World War I begin?", "1914", arrayListOf("1904", "1924", "1934"))
        insertTrivia("Who was the first female prime minister of the United Kingdom?", "Margaret Thatcher", arrayListOf("Angela Merkel", "Hillary Clinton", "Indira Gandhi"))
        insertTrivia("What was the name of the ship on which Charles Darwin sailed during his voyage of discovery?", "HMS Beagle", arrayListOf("HMS Victory", "USS Constitution", "Mayflower"))
        insertTrivia("Which American president famously said 'I cannot tell a lie' when asked if he chopped down a cherry tree?", "George Washington", arrayListOf("Thomas Jefferson", "Abraham Lincoln", "John F. Kennedy"))
    }

    private fun insertGeoTrivia(){
        insertTrivia("Which ocean is the largest in the world?", "Pacific Ocean", arrayListOf("Atlantic Ocean", "Indian Ocean", "Arctic Ocean"))
        insertTrivia("What is the capital of Australia?", "Canberra", arrayListOf("Sydney", "Melbourne", "Brisbane"))
        insertTrivia("Which mountain range runs through the western United States?", "Rocky Mountains", arrayListOf("Andes Mountains", "Himalayas", "Alps"))
        insertTrivia("What is the largest country in South America?", "Brazil", arrayListOf("Argentina", "Peru", "Chile"))
        insertTrivia("What is the highest mountain in Africa?", "Mount Kilimanjaro", arrayListOf("Mount Everest", "Mount McKinley", "Mount Aconcagua"))
        insertTrivia("What is the largest island in the Mediterranean Sea?", "Sicily", arrayListOf("Corsica", "Crete", "Sardinia"))
        insertTrivia("Which river forms the border between the United States and Mexico?", "Rio Grande", arrayListOf("Mississippi River", "Amazon River", "Nile River"))
        insertTrivia("What is the largest country in the world by land area?", "Russia", arrayListOf("Canada", "China", "United States"))
        insertTrivia("What is the smallest country in the world by land area?", "Vatican City", arrayListOf("Monaco", "Nauru", "San Marino"))
        insertTrivia("What is the largest desert in the world?", "Sahara Desert", arrayListOf("Arabian Desert", "Gobi Desert", "Kalahari Desert"))
    }

    private fun insertMovieAndTVTrivia(){
        insertTrivia("Who directed the 1994 film 'Pulp Fiction'?", "Quentin Tarantino", arrayListOf("Martin Scorsese", "Steven Spielberg", "Spike Lee"))
        insertTrivia("What is the name of the character played by Hugh Laurie in the TV series 'House'?", "Dr. Gregory House", arrayListOf("Dr. James Wilson", "Dr. Eric Foreman", "Dr. Lisa Cuddy"))
        insertTrivia("Which actor played the character of Gollum in 'The Lord of the Rings' film trilogy?", "Andy Serkis", arrayListOf("Ian McKellen", "Viggo Mortensen", "Sean Bean"))
        insertTrivia("What is the name of the fictional country where 'Black Panther' takes place?", "Wakanda", arrayListOf("Genosha", "Latveria", "Symkaria"))
        insertTrivia("Who played the title character in the 1999 film 'American Beauty'?", "Kevin Spacey", arrayListOf("Tom Hanks", "Brad Pitt", "Johnny Depp"))
        insertTrivia("What is the name of the character played by Bryan Cranston in the TV series 'Breaking Bad'?", "Walter White", arrayListOf("Jesse Pinkman", "Hank Schrader", "Saul Goodman"))
        insertTrivia("Which film won the Academy Award for Best Picture in 2010?", "The King's Speech", arrayListOf("Inception", "Toy Story 3", "The Social Network"))
        insertTrivia("Who directed the 1999 film 'The Sixth Sense'?", "M. Night Shyamalan", arrayListOf("Christopher Nolan", "David Fincher", "Steven Soderbergh"))
        insertTrivia("What is the name of the character played by Johnny Depp in the 'Pirates of the Caribbean' film series?", "Captain Jack Sparrow", arrayListOf("Barbossa", "Davy Jones", "Blackbeard"))
        insertTrivia("Which TV series features the character of Claire Underwood, played by Robin Wright?", "House of Cards", arrayListOf("The West Wing", "The Crown", "Mad Men"))
    }

    private fun insertGKTrivia(){
        insertTrivia("What is the smallest planet in our solar system?", "Mercury", arrayListOf("Venus", "Mars", "Jupiter"))
        insertTrivia("What is the name of the largest desert in the world?", "Sahara", arrayListOf("Gobi", "Mojave", "Atacama"))
        insertTrivia("What is the capital of France?", "Paris", arrayListOf("London", "Madrid", "Rome"))
        insertTrivia("What is the tallest mammal?", "Giraffe", arrayListOf("Elephant", "Rhino", "Hippopotamus"))
        insertTrivia("What is the chemical symbol for gold?", "Au", arrayListOf("Ag", "Cu", "Fe"))
        insertTrivia("What is the highest mountain in North America?", "Denali (Mount McKinley)", arrayListOf("Mount Everest", "Mount Kilimanjaro", "Mount Aconcagua"))
        insertTrivia("What is the capital of South Korea?", "Seoul", arrayListOf("Tokyo", "Beijing", "Taipei"))
        insertTrivia("What is the name of the largest ocean on Earth?", "Pacific Ocean", arrayListOf("Atlantic Ocean", "Indian Ocean", "Arctic Ocean"))
        insertTrivia("Which planet is known as the 'Red Planet'?", "Mars", arrayListOf("Venus", "Jupiter", "Saturn"))
        insertTrivia("What is the largest organ in the human body?", "Skin", arrayListOf("Liver", "Heart", "Lung"))
    }

}