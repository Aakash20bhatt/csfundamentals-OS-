package com.company.exceutors.mergeSort;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class mergeSort implements Callable<List<Integer>>{

    private List<Integer> arrayToSort;
    private ExecutorService executorService;

    mergeSort(List<Integer> arrayToSort, ExecutorService executorService){
        this.arrayToSort = arrayToSort;
        this.executorService = executorService;
    }

    @Override
    public List<Integer> call() throws Exception{

        if(arrayToSort.size()<=1){
            return arrayToSort;
        }

        int mid = arrayToSort.size()/2;

        List<Integer> leftArray = new ArrayList<>();

        for(int i=0; i<mid; i++){
            leftArray.add(arrayToSort.get(i));
        }

        List<Integer> rightArray = new ArrayList<>();

        for(int i=mid; i<arrayToSort.size(); i++){
            rightArray.add(arrayToSort.get(i));
        }

        mergeSort leftMergeSort = new mergeSort(leftArray,executorService);
        mergeSort rightMergeSort = new mergeSort(rightArray, executorService);

//        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<List<Integer>> leftSortedArrayFuture = executorService.submit(leftMergeSort);
        Future<List<Integer>> rightSortedArrayFuture = executorService.submit(rightMergeSort);

        // code
        List<Integer> leftSortedArray = leftSortedArrayFuture.get();
        List<Integer> rightSortedArray = rightSortedArrayFuture.get();

        // Merge Two Sorted Arrays

        List<Integer> sortedArray = new ArrayList<>();

        int i=0;
        int j=0;

        while(i<leftSortedArray.size() && j<rightSortedArray.size()){
            if(leftSortedArray.get(i)<rightSortedArray.get(j)){
                sortedArray.add(leftSortedArray.get(i));
                i++;
            }else{
                sortedArray.add(rightSortedArray.get(j));
                j++;
            }
        }

        while(i<leftSortedArray.size()){
            sortedArray.add(leftSortedArray.get(i));
            i++;
        }

        while(j<rightSortedArray.size()){
            sortedArray.add(rightSortedArray.get(j));
            j++;
        }


        return sortedArray;
    }

}
