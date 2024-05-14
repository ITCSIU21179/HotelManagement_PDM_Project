package ControlManager;

public class HotelManagementSystem{
    private static HotelManagementSystem hotelManagementSystem;
    private AdminDashboard adminDashboard;


    public HotelManagementSystem(){
        this.adminDashboard = new AdminDashboard();

    }
    public static void executeHotel(){
        if(hotelManagementSystem == null)
            hotelManagementSystem = new HotelManagementSystem();
    }


}
