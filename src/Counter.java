/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rnavarro
 */
public class Counter {
    
     protected long count = 0;
     
     public Counter() {
         this.count = 0;
     }
     
     public Counter(long n) {
         this.count = n;
         
     }

     public void add(long value){
         this.count = this.count + value;
     }
     
     public long get() {
         return this.count;
     }
    
}
