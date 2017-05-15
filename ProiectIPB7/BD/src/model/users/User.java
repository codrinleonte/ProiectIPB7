package model.users;

public abstract class User {

    protected int id;
    protected int idCont;
    protected String username;
	protected String firstName;
    protected String lastName;
    protected String email;
    protected String tip;
    
    public User() {}
    
    
    public void setIdCont( int id){
    	this.idCont=id;
    }
    
    public int getIdCont(){
    	return idCont;
    }
    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return firstName + " " + lastName;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setId( int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	public String getTip(){
		return tip;
	}


	@Override
	public String toString() {
		return "User [id="+id+", username=" + username + ", name=" + getName() + ", email=" + email+", tip="+tip+"]";
	}

}