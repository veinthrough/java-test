package com.veinthrough.test.goova;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.JdkFutureAdapters;
import com.google.common.util.concurrent.ListenableFuture;
import com.veinthrough.test.AbstractUnitTester;

public class ListenerableFutureDemo extends AbstractUnitTester {
    private static int counter= 10;
    private static int i,j;

    @Override
    public void test() {
        System.out.println("ASYNC TEST----------------------------------------------");
        i=0;conductTest( counter/2, false);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nSYNC TEST---------------------------------------------");
        i=0;conductTest( counter/2, true);
    }

    private void conductTest( int counter, boolean isSync) {
        ListenableFuture<Integer> future= isSync ? syncTask() : asyncTask();
        Futures.addCallback( future, new FutureCallback<Integer>() {
            @Override
            public void onFailure(Throwable arg0) {
                System.out.println("Failed with "+ j);
            }

            @Override
            public void onSuccess(Integer arg0) {
                System.out.println("Succeeded with "+ arg0);
            }
        });
        for( ; i<counter; i++){
            System.out.println("In main thread:"+ i);
            try {
                Thread.sleep( 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        future.cancel( true);
    }

    private static ListenableFuture<Integer> asyncTask() {
        FutureTask<Integer> task= new FutureTask<> ( new Callable<Integer>() {
            @Override
            public Integer call() {
                for( j=0; j<counter; j++) {
                    System.out.println("In asyncTask:"+ j);
                    try {
                        Thread.sleep( 1000);
                    } catch (InterruptedException e) {
                        return j;
                    }
                }
                return j;
            }
        });
        new Thread( task).start();
        return JdkFutureAdapters.listenInPoolThread( task);
    }

    private static ListenableFuture<Integer> syncTask() {
        for( j=0; j< counter; j++) {
            System.out.println("In syncTask, j:"+ j);
            try {
                Thread.sleep( 1000);
            } catch (InterruptedException e) {
                return Futures.immediateFuture( j);
            }
        }
        return Futures.immediateFuture( j);
    }

    public static void main(String[] args) {
        new ListenerableFutureDemo().test();
    }

}
