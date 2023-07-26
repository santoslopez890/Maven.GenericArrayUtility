package com.zipcodewilmington.arrayutility;


import java.lang.reflect.Array;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility <T>{

    private T[] inputArray;



    public ArrayUtility(T[] inputArray) {
        this.inputArray=inputArray;
    }

    public Integer countDuplicatesInMerge(T [] arrayToMerge, T valueToEvaluate) {
        T[] newArr= (T[]) Array.newInstance(valueToEvaluate.getClass(), inputArray.length+arrayToMerge.length);
        Integer lengthOfBaseArr=0;
        Integer count;
        for (int i = 0; i < inputArray.length; i++) {
            newArr[i]=inputArray[i];
            lengthOfBaseArr++;
        }
        for (T t : arrayToMerge) {
            newArr[lengthOfBaseArr] = t;
            lengthOfBaseArr++;
        }
        inputArray=newArr;
        count=getNumberOfOccurrences(valueToEvaluate);
        return count;
    }


    public T getMostCommonFromMerge(T[] arrayToMerge) {
        T mostCommon=null;
        Integer count=0;
        Integer tempcount;
        for (T type:inputArray) {
            tempcount=countDuplicatesInMerge(arrayToMerge,type);
            if(tempcount>count){
                count=tempcount;
                mostCommon=type;
            }
        }
        return mostCommon;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        Integer count =0;
        for (T t : inputArray) {
            if (t == valueToEvaluate) {
                count++;
            }
        }
        return count;
    }

    public T[] removeValue(T valueToRemove) {
        int sizeMod=getNumberOfOccurrences(valueToRemove);
        T[] newArr= (T[]) Array.newInstance(valueToRemove.getClass(), inputArray.length-sizeMod);
        int newArrayIndex=0;

        for (int i = 0; i < inputArray.length; i++) {
            if(!(inputArray[i]==valueToRemove)){
                newArr[newArrayIndex]=inputArray[i];
                newArrayIndex++;
            }

        }
    return newArr;
        }

    }


