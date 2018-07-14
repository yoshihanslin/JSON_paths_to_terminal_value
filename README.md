# JSON_paths_to_terminal_value

A program that takes a JSON object as input and outputs the path to every terminal value in the JSON structure.
The program uses the json parser jar file from either:

https://mvnrepository.com/artifact/org.json/json/20140107

https://github.com/stleary/JSON-java

Input is a string structured as a JSON object. 
If using the Linux console:
- compile the java file:
    javac JSON.java
- execute the java file, with first argument as input file path: 
    java JSON <your input file path>
    
If you've executed the java file, and the input file is not found, then the console will ask for input JSON string:
Press "enter" twice for the program to read the input successfully.

Input:

```json
{
    "a": 1,
    "b": true,
    "c": {
        "d": 3
    }
}
```
In this example the path to the terminal value 1 is "a" and the path to the terminal value 3 is "c.d".

The output for the above object would be:

```json
{
    "a": 1,
    "b": true,
    "c.d": 3
}
```


#Assumptions

The input received will be a JSON object as a string.
All key names in the original JSON object will be simple strings without ‘.’ characters.
The input JSON will not contain arrays.
