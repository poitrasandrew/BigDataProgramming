# ICP-1
ICP-1

#### Complete the following:

#### Name: Andrew
#### Email: Poitras

<br/>
 
Write brief explanation here:
First I used hdfs dfs -put to put both files into the hadoop folder.

Then I used hdfs dfs -appendToFile with both files to append each of them to an empty file.

I checked HUE to ensure that the files appended succesfully.

Then I used hdfs dfs -cat with head -5 to view the first five line of the new file and used -appendToFile to append it to the end.

Then I used hdfs dfs -cat with tail -5 and -appendToFile to append the last five lines of the word_list.txt file to the new file

Last, I used HUE to look through the new file to check that all of the correct words were appended to the file.