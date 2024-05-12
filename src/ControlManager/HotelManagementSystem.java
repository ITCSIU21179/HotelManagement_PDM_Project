package ControlManager;

public class HotelManagementSystem implements Runnable{
    private static HotelManagementSystem hotelManagementSystem;
    private Panel panel;
    private Frame frame;
    private Thread thread;
    private int fps = 120;
    private int ups = 120;
    public HotelManagementSystem(){
        this.panel = new Panel();
        this.frame = new Frame(panel);
        panel.requestFocus();
        startLoop();
    }
    public static void executeHotel(){
        if(hotelManagementSystem == null)
            hotelManagementSystem = new HotelManagementSystem();
    }
    private void startLoop(){
        thread = new Thread(this);
        thread.start();
    }


    @Override
    public void run() {
        double timePerFrame = 1000000000.0/fps;
        double timePerUpdate = 1000000000.0/ups;
        double pre_time = System.nanoTime();
        double pre_time2 = System.nanoTime();

        int frame = 0;
        int update = 0;
        double deltaF = 0;
        double deltaU = 0;

        while(true){
            long  current_time = System.nanoTime();
            long  current_time2 = System.nanoTime();
            deltaU += (current_time - pre_time)/timePerUpdate;
            deltaF += (current_time - pre_time)/timePerFrame;

            pre_time = current_time;

            if(deltaU >=1){
//                update();
                update++;
                deltaU--;
            }

            if(deltaF >=1) {
                panel.repaint();
                frame++;
                deltaF--;
            }
//            if((current_time2 - pre_time2) >=1000000000) {
//                System.out.println("FPS= " + frame + " ,UPS= " + update);
//                pre_time2=current_time2;
//                frame =0;
//                update =0;
//            }
        }
    }
}
