public class RunPingPong implements Runnable{

    private String word;
    private int delay;

    public RunPingPong(String wordToUse, int delay){
        this.word = wordToUse;
        this.delay = delay;
    }

    public void run(){
        if(Thread.currentThread().getName().equals("pingThread") || Thread.currentThread().getName().equals("pongThread")) {
            try {
                while (true) {
                    System.out.print(word + " ");
                    Thread.sleep(delay);
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }else{
            System.out.println("Not allowed execution!!");
        }
    }

    public static void main(String args[]){
        RunPingPong ping = new RunPingPong("ping",330);
        RunPingPong pong = new RunPingPong("PONG", 1000);

        Thread pingThread = new Thread(ping,"pingThread");
        Thread pongThread = new Thread(pong, "pongThread");
        pingThread.start();
        pongThread.start();

        // restricted the work of run method by adding a check on thread name
        Thread anonymousThread = new Thread(ping);
        anonymousThread.start();
    }

}



