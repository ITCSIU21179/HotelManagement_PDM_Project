package ControlManager;

public class HotelManagementSystem {
    private static HotelManagementSystem hotelManagementSystem;
    private Panel panel;
    private Frame frame;
    public HotelManagementSystem(){
        this.panel = new Panel();
        this.frame = new Frame(panel);
        panel.requestFocus();
    }
    public static void executeHotel(){
        if(hotelManagementSystem == null)
            hotelManagementSystem = new HotelManagementSystem();
    }



}
