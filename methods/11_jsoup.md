# JSoup Lesson

## Group 1
Brian M., Michele P, Peter T, Stephannia K, Chris O

## Instructions for setup
* Create a file named `Wikipedia.java`
  * Copy/paste the code from [here](https://github.com/jhy/jsoup/blob/master/src/main/java/org/jsoup/examples/Wikipedia.java)
  * Comment out the first line
  * Change all instances of `log` to `System.out.printf`
* Download jsoup and put it in the same directory as your `Wikipedia.java` file.
  * https://jsoup.org/
* To compile and run, use the following commands:
`javac -cp "jsoup-1.14.1.jar:." Wikipedia.java`
`java -cp "jsoup-1.14.1.jar:." Wikipedia.java`

## Starter exercise
* Use JSoup [documentation](https://jsoup.org/cookbook/) to practice navigating/extracting the HTML
  * [Use DOM methods to navigate a document](https://jsoup.org/cookbook/extracting-data/dom-navigation)
  * [Use selector-syntax to find elements](https://jsoup.org/cookbook/extracting-data/selector-syntax)
  * [Extract attributes, text, and HTML from elements](https://jsoup.org/cookbook/extracting-data/attributes-text-html)
* Let students choose website (X) and what information (Y) we want to extracting.
* Live code example where we scrape website X and extract information Y.

## Categories
* Sports: stats/schedule (user-specified team, sport, athlete, etc.)
  * Example: https://www.nhl.com/schedule
  * Write a program that allows the user to search by team, i.e. Pittsburgh
  * Program scrapes HTML to find all the dates that the team is playing
  * Program returns all dates
* Music: tour dates (user-specified band, venue, genre, etc)
  * Example:  https://www.ticketmaster.com/discover/concerts
* Food: recipes (user-specified ingredients, dietary restrictions, etc)

## Scaffolds
* Example of a working program: Medal count for olympics
* Starter code for each category?
* Youtube tutorials https://www.youtube.com/results?search_query=jsoup+tutorial+java

## Groupings
* Within each category, poll students to determine desired functionality. Group accordingly.
  * Ex: (music) group of students who want to search by band
  * Ex: (music) group of students who want to search by genre
  * Ex: (music) group of students who want to search by venue

## Deliverables
* calendar
  * when artists/teams are playing, when shows are at a venue
* table
  * recipes organized by type of cuisine
