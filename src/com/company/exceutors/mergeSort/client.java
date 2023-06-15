package com.company.exceutors.mergeSort;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class client {

    public static void main(String[] args) throws Exception {
        List<Integer> list = List.of(7,3,4,1,9,8,2,6);

        ExecutorService executorService = Executors.newCachedThreadPool();

        mergeSort mergeSorter = new mergeSort(list,executorService);
        Future<List<Integer>> sortedListFuture = executorService.submit(mergeSorter);
        List<Integer> sortedList = sortedListFuture.get();
        System.out.println(sortedList);

        executorService.shutdown();
    }
}
