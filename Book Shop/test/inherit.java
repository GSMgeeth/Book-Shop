


class vehicle{

	private String name;
	private int wheel;

	public vehicle(String pname, int pwheel){
		name = pname;
		wheel = pwheel;
	}
	void display(){
		System.out.println("Vehicle name:" + name);
		System.out.println("Vehicle number of wheel:" + wheel);
	}

}

class car extends vehicle{

	private String model;
	private int speed;

    public car() {
        super(null, 0);
    }

    public car(String model, int speed, String pname, int pwheel) {
        super(pname, pwheel);
        this.model = model;
        this.speed = speed;
    }
    
   
	
    
    
	void displayCar(){

		super.display();
		System.out.println("Car model:" + model);
		System.out.println("Top speed:" + speed);

	}
}



