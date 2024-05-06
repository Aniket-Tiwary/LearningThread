public class PingPong extends Thread{
    private String word; // choose the word to print
    private int delay;  // how much delay between printing the words

    public PingPong(String whatToSay, int delay){
        this.word = whatToSay;
        this.delay = delay;
    }

    public void run(){
        try {
            while (true) {
                System.out.print(word + " ");
                Thread.sleep(delay); // wait until next time
            }

        } catch (InterruptedException ex){
            return;
        }
    }


    // Two threads are running and each is printed after certain interruptions
    public static void main(String args[]){
        PingPong ping = new PingPong("ping",330); // 1/3 of a second
        PingPong pong = new PingPong("PONG", 1000); //  per second
        ping.start();
        pong.start();

        // Output should be like
        // ping PONG ping ping PONG ping ping ping PONG ping ping ping PONG ping ping ping PONG ping ping ping PONG ping ping ping PONG ......


        // Class.currentThread() is used to print the name of the current thread, so the below print statement prints the name of current thread
        System.out.println(PingPong.currentThread());
    }
}