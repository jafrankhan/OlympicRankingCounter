
# Olympic Ranking Counter

Jafaran Khan

CSIT121 - Object Oriented Programming - Year 1 Semester 3

In the class Olympic, you have an important instance variable which is the
name of the country. Each country receives an array of scores (the size is
NO, a constant, as specified in the class; the scores given by the judges) and
also a final ranking which will be updated later in the design.

When constructing an object of class Olympic, you only need pass in the
country name. The processScores method is to generate some scores (upon
100) for each judge.

The class OlympicFrame designs your GUI. You construct a list of Olympic
objects and determine the ranking.
A few important methods in the class OlympicFrame:
- The getFinalRanking constructs and returns a string that you can display this string in the panel.
- The getCountry method returns the country name that has rank n.
- The getScores method returns the total scores of a country.

