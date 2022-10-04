package org.example.service.impl;

import org.example.service.TaskService;

import java.util.*;

public class TaskTwoServiceImpl implements TaskService {
    private final int MIN_STRING_SIZE=3;
    private final int MAX_STRING_SIZE=30;
    private final int MIN_LOWERCASE_CHAR_VALUE='a';
    private final int MAX_LOWERCASE_CHAR_VALUE='z';
    private final int MIN_UPPERCASE_CHAR_VALUE='A';
    private final int MAX_UPPERCASE_CHAR_VALUE='Z';
    private final int STRINGS_QUANTITY=10;
    @Override
    public void runTask() {
        Map<String, String> map = createMap();
        printMap(map);
        System.out.printf("The first longest key is %s, the first shortest value is %s",
                findLongestString(map.keySet()), findShortestString(map.values()));
    }

    public String createString(){
        Random random = new Random();
        StringBuilder str= new StringBuilder();
        int stringSize = random.nextInt(MAX_STRING_SIZE-MIN_STRING_SIZE)+MIN_STRING_SIZE;
        for(int i=0; i<stringSize; i++){
            if(random.nextBoolean()){
                str.append((char) (random.nextInt(MAX_LOWERCASE_CHAR_VALUE - MIN_LOWERCASE_CHAR_VALUE) + MIN_LOWERCASE_CHAR_VALUE));
            } else{
                str.append((char) (random.nextInt(MAX_UPPERCASE_CHAR_VALUE - MIN_UPPERCASE_CHAR_VALUE) + MIN_UPPERCASE_CHAR_VALUE));
            }
        }
        return str.toString();
    }

    public String findShortestString(Collection<String> strings){
        int minLength=strings.toString().length();
        String stringValue="";
        for(String currentString : strings){
            if(currentString.length()<minLength){
                minLength=currentString.length();
                stringValue=currentString;
            }
        }
        return stringValue;
    }

    public String findLongestString(Collection<String> strings){
        int maxLength=0;
        String stringValue="";
        for(String currentString : strings){
            if(currentString.length()>maxLength){
                maxLength=currentString.length();
                stringValue=currentString;
            }
        }
        return stringValue;
    }

    public Map<String, String> createMap(){
        Map<String, String> map=new HashMap<>();
        for(int i=0; i<STRINGS_QUANTITY; i++){
            String key = createString();
            String value = createString();
            map.put(key, value);
        }
        return map;
    }

    public void printMap(Map<String, String> map){
        for(Map.Entry<String, String> item : map.entrySet()){
            System.out.println("Key '"+item.getKey()+"' has '"+item.getValue()+"' value.");
        }
    }
}
