
public class Dog {
	
  private String name;
  private double weight;
   
  public Dog (String name, double weight) {
    this.name = name; 
    this.weight = weight;
  }
   
  public String getName() {
    return this.name;
  }
  
  public double getWeight() {
    return this.weight;
  }
  
  public void setName (String name) {
    this.name = name;
  }
  
  public void setWeight (double weight) {
    this.weight = weight;
  }
}