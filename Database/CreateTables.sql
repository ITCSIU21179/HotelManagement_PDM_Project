CREATE TABLE Hotel (
    HotelID INT PRIMARY KEY,
    Name VARCHAR(255),
    Address VARCHAR(255),
    Phone VARCHAR(15),
    Email VARCHAR(255),
    Stars INT,
);
CREATE TABLE RoomType (
    Type_name VARCHAR(50) PRIMARY KEY,
    Description VARCHAR(255),
    PricePerNight DECIMAL(10, 2),
    Capacity INT
);
CREATE TABLE Room (
    RoomNumber INT PRIMARY KEY,
    Hotel_id INT,
    TypeID INT,
    Status VARCHAR(20),
    FOREIGN KEY (HotelID) REFERENCES Hotel(HotelID),
    FOREIGN KEY (Type_name) REFERENCES RoomType(Type_name)
);
CREATE TABLE Guest (
    GuestID INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    DateOfBirth DATE,
    Address VARCHAR(255),
    Phone VARCHAR(15),
    Email VARCHAR(255)
);
CREATE TABLE Booking (
    BookingID INT PRIMARY KEY,
    GuestID INT,
    RoomNumber INT,
    CheckinDate DATE,
    CheckoutDate DATE,
    TotalPrice DECIMAL(10, 2),
    FOREIGN KEY (GuestID) REFERENCES Guest(GuestID),
    FOREIGN KEY (RoomNumber) REFERENCES Room(RoomNumber)
);
CREATE TABLE Payment (
    PaymentID INT PRIMARY KEY,
    BookingID INT,
    Amount DECIMAL(10, 2),
    PaymentDate DATE,
    PaymentMethod VARCHAR(50),
    FOREIGN KEY (BookingID) REFERENCES Booking(BookingID)
);
