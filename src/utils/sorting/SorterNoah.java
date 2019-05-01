/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.sorting;

/**
 *
 * @author noah
 */
public class SorterNoah {
    long[] heaptime = new long[2];
    
    public SorterNoah(){
        //be zen
    }
    
    /**
     * Heap sort implementation
     * @param origin unsorted primitives
     * @return 
     */
    public int[] heapSort(int[] origin){
        // get timestamp and store it;
        this.heaptime[0] = java.time.Instant.now().toEpochMilli();
        
        int[] heap = new int[origin.length];
        int node = 0;
        int tail = (origin.length-1);
        final int HEAD = 0;
        int parent = 0;
        
        //build binary tree (max heap)
        for(int i=0; i<origin.length; i++){
            node = i;
            heap[node] = origin[i];
            while(node>0){
                parent = (node-1)/2;
                if(heap[node] > heap[parent]){
                    //swap
                    int tmp = heap[parent];
                    heap[parent] = heap[node];
                    heap[node] = tmp;
                } else break; //heapified
                node = parent;
            }
        }
        
        /* print unsorted max heap
        
        for(int i : heap){
            System.out.print(i+ ", ");
        }
        System.out.println();
        */
        
        //sort heap
        for(int i=0; i<origin.length; i++){
            node = 0;
            //swap head and tail and decrement tail by 1
            int tmp = heap[tail];
            heap[tail] = heap[HEAD];
            heap[HEAD] = tmp;
            tail--;
            
            //heapify
            while(true){
                int left = (2*node)+1;
                int right = (2*node)+2;
                
                //tree is a heap
                if(left >= tail) break;
                
                //find max child
                int max;
                if(heap[right] > heap[left]) max = right;
                else max = left;
                
                
                //child swap
                if(heap[max] > heap[node]){
                    tmp = heap[node];
                    heap[node] = heap[max];
                    heap[max] = tmp;
                    node = max;
                } else break;
            }
        }
        
        //final swap
        int tmp = heap[0];
        heap[0] = heap[1];
        heap[1] = tmp;
        
        // clock heap end time
        this.heaptime[1] = java.time.Instant.now().toEpochMilli();
        
        return heap;
    }
    
    public long[] getHeaptime(){
        return this.heaptime;
    }
    
}
