# Assignment-1-CS102

This text file is designed for instructing users on how to use the provided program

Author: Jeff Ceja
Date: May 5th 2018
This program was made and tested using the IDE IntelliJ

To operate this program 3 things must be done:
    1. An IDE such as IntelliJ, JGrasp, Eclipse or many others alike must have all of the files in the same folder
    2. The Command line argument must have the correct file location of the expected file to read from
    3. A simple understanding of how to run a program

    Information from the document will be stored accordingly and 6 options will be available

    1 -- Print all tennis players.             (players will be sorted by id)
    2 -- Print all tennis matches of a player. (tennis matches will be sorted by date)
    3 -- Print all tennis matches.             (tennis matches will be sorted by date)
    4 -- Insert a new player.                  (player format to input will be shown when selected)
    5 -- Insert a new match.                   (match format to input will be shown when selected)
    8 -- Exit.

    For Example:
            This program was ran using IntelliJ and the example data file with information bellow was used

            PLAYER/DJO87/NOVAK/DJOKOVIC/1987/SERBIA
            MATCH/FED81/DJO87/20150223/DUBAI/6-3,7-5
            MATCH/NAD86/DJO87/20151005/CHINA OPEN/2-6,2-6
            PLAYER/NAD86/RAFAEL/NADAL/1986/SPAIN
            MATCH/DJO87/FED81/20150316/INDIAN WELLS/6-3,6-7,6-2
            MATCH/FED81/NAD86/20151026/BASEL/6-3,5-7,6-3
            MATCH/FED81/DJO87/20150511/ROME/4-6,3-6
            MATCH/FED81/DJO87/20150712/WIMBLEDON/6-7,7-6,4-6,3-6
            MATCH/FED81/DJO87/20150817/CINCINNATI/7-6,6-3
            MATCH/DJO87/FED81/20150913/US OPEN/6-4,5-7,6-4,6-4
            MATCH/DJO87/FED81/20151116/ATP WORLD TOUR FINALS/6-3,6-4
            PLAYER/FED81/ROGER/FEDERER/1981/SWITZERLAND
            PLAYER/DJA80/Chris/Paul/1987/Ireland
            PLAYER/DJA81/Chris/Pratt/1980/SERBIA
            PLAYER/DJA82/Alex/Michael/1987/SERBIA
            MATCH/DJO87/FED81/20160316/CountryA/6-3,6-7,6-2
            MATCH/FED81/NAD86/20161026/CountryB/6-3,5-7,6-3
            MATCH/FED81/DJO87/20160511/CountryC/4-6,3-6
            MATCH/FED81/DJO87/20160712/CountryD/6-7,7-6,4-6,3-6
            MATCH/FED81/DJO87/20160817/CountryE/7-6,6-3
            MATCH/DJO87/FED81/20160913/CountryF/6-4,5-7,6-4,6-4
            MATCH/DJO87/FED81/20161116/CountryG/6-3,6-4

            This information provided accurate implementation and expected output of code.
            Inserted information can either be a player or match and must be formatted as such:

            Player
                PLAYER/PlayerId/FirstName/LastName/BirthYear/BirthCountry
                The first word player will notify the program what to expect the remaining information to be
                the second word will be a 5 letter id number
                first and last name are self explanatory along with birth year and birth country
            Match
                MATCH/firstPlayerId/secondPlayerId/date of match/location of match/scores
                The first word match will notify the program what to expect the remaining information to be
                the second and third words will be the id's of the players within the match
                date and location are self explanatory
                scores will be a comma separated list of scores in 1-0 order

        Incomplete or false information will be handled and the program will end in critical situations
        deemed appropriate

Thank you for your time and I hope this program has exceeded expectations or at least the readme.txt has.
