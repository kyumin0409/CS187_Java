
public class DogTeam {

  private LLDogNode head;

  public DogTeam(Dog dog) {
    head = new LLDogNode(dog, null);
  }

  public void printTeam() {
    LLDogNode cur = head;
    int dogNumber = 1;
    
    System.out.println("----------------");
    while (cur != null) {
      System.out.println(dogNumber + ". " + cur.getContents().getName() +
                         ", " + cur.getContents().getWeight());
      cur = cur.getLink();
      dogNumber += 1;
    }
  }


  public static void main(String[] args) {		
    
    DogTeam team = new DogTeam(new Dog("dog1", 60));		
    team.printTeam();
   System.out.println("weightDiff: " + team.weightDiff());
    
   team.insertTail(new Dog("dog0",  5));
   team.insertHead(new Dog("dog2",  90));
    team.printTeam();
   System.out.println("weightDiff: " + team.weightDiff());
    
   team.insertHead(new Dog("dog3",  7));
   team.insertTail(new Dog("dog4",  100));
   team.insertTail(new Dog("dog10", 205));		
   team.printTeam();
   System.out.println("weightDiff: " + team.weightDiff());
    
  }

  public void insertHead(Dog dog) {
    // TODO(0)
    // puts new node containing dog at the head of the list

	LLDogNode n1 = new LLDogNode(dog, head);
	head = n1;



  }

  public void insertTail(Dog dog) {
    // TODO(1)
    // puts new node containing dog at the tail of the list

	LLDogNode n1 = new LLDogNode(dog, null);
	
	LLDogNode pointer = head;
	while(pointer.getLink() != null){
		pointer = pointer.getLink();
	}
	pointer.setLink(n1);


  }

  public double weightDiff() {
    // TODO(2)
    // returns difference between max and min weights of dogs in list
    // pre: this list contains at least one node
	  
	double max = 0;
	double min = Double.MAX_VALUE;
	
	LLDogNode pointer = head;
	
	while(pointer != null){
		double weight = pointer.getContents().getWeight();
		if(weight>=max){
			max = weight;
		}
		if(weight<=min){
			min = weight;
		}
		pointer = pointer.getLink();
	}
    return max - min;


















  }
}