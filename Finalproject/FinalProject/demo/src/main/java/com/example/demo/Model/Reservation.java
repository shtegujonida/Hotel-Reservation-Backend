package com.example.demo.Model;


public class Reservation {
	private int id;
	private int roomNumber;
	private int price;
	private int persons;
	private int numOfBeds;
	private Boolean jaccuzi;
	private Boolean free;
	private String arrivalDate;
	private String until;
	private Boolean roomService;
	private String image;
 
    // reservation super and fields constructors

	public Reservation(int id, int roomNumber, int price, int persons, int numOfBeds, Boolean jaccuzi, Boolean free, String arrivalDate, String until, Boolean roomService, String image) {
		this.id = id;
		this.roomNumber = roomNumber;
		this.price = price;
		this.persons = persons;
		this.numOfBeds = numOfBeds;
		this.jaccuzi = jaccuzi;
		this.free = free;
		this.arrivalDate = arrivalDate;
		this.until = until; 
		this.roomService = roomService;
		this.image = image;
	}
	
	// reservation getters and setters fields
	
	public Reservation() {
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}


	public int getPersons() {
		return persons;
	}

	public void setPersons(int persons) {
		this.persons = persons;
	}

	public int getNumOfBeds() {
		return numOfBeds;
	}

	public void setNumOfBeds(int numOfBeds) {
		this.numOfBeds = numOfBeds;
	}

	public Boolean getJaccuzi() {
		return jaccuzi;
	}

	public void setJaccuzi(Boolean jaccuzi) {
		this.jaccuzi = jaccuzi;
	}

	public Boolean getFree(){
		return free;
	}

	public void setFree(Boolean free){
		this.free = free;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getUntil() {
		return until;
	}

	public void setUntil(String until) {
		this.until = until;
	}

	public Boolean getRoomService() {
		return roomService;
	}

	public void setRoomService(Boolean roomService) {
		this.roomService = roomService;
	}

	public String getImage(){
		return image;
	}

	public void setPhoto(String image){
		this.image = image;
	}
}

