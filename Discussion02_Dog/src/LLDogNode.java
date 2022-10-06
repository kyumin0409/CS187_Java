
public class LLDogNode {
	
  private Dog contents;
  private LLDogNode link;
   
  public LLDogNode (Dog dog, LLDogNode link) {
    this.contents = dog; 
    this.link = link;
  }
   
  public Dog getContents() {
    return contents;
  }
   
  public LLDogNode getLink() {
    return link;
  }
   
  public void setContents(Dog dog) {
    contents = dog;
  }
   
  public void setLink (LLDogNode link) {
    this.link = link;
  }
}