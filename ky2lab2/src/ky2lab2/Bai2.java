package ky2lab2;

public class Bai2 {
    public static void main(String[] args) throws InterruptedException {
    	 Thread t1 = new Thread(new Runnable() {
             public void run() {
                 for (int i = 1; i <= 16; i++) {
                     for (int j = 1; j <= i; j++) {
                         System.out.print("Multiple program   ".charAt(j-1));
                     }
                     System.out.println();
                 }
             }
         });
       ;
       Thread t2 = new Thread(new Runnable() {
           public void run() {
        	   try {
                   t1.join(); // chờ tuyến 1 hoàn thành trước khi thực hiện tác vụ
                   for (int i = 16; i >= 1; i--) {
                       for (int j = 1; j <= i; j++) {
                           System.out.print("Multiple program ".charAt(j-1));
                       }
                       System.out.println();
                   }
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
              
           }
       });
       t1.start();
       t1.setPriority(1);
       t2.start();
       t2.setPriority(2);
     }
}

