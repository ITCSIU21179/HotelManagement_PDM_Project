package ControlManager;

public class HotelManagementSystem{
    private static HotelManagementSystem hotelManagementSystem;


    public HotelManagementSystem(String type){
        if(type.equals("Guest"))
             new GuestDashboard();
        else new AdminDashboard();

    }
    public static void executeHotel(String type){
        if(hotelManagementSystem == null && type .equals("Guest"))
            hotelManagementSystem = new HotelManagementSystem("Guest");
        else hotelManagementSystem = new HotelManagementSystem("Admin");
    }


}
