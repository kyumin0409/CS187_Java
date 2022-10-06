package sets;

import java.util.Iterator;

public class LinkedSet<E> implements Set<E> {
  private LinkedNode<E> head = null;

  // Constructors
  public LinkedSet() {
  }

  public LinkedSet(E e) {
    this.head = new LinkedNode<E>(e, null);
  }

  private LinkedSet(LinkedNode<E> head) {
    this.head = head;
  }

  @Override
  public int size() {
    // TODO (1)
	  Iterator<E> iter = iterator();
	  int count=0;
	  while(iter.hasNext()){
		  count++;
		  iter.next();
	  }
    return count;
  }

  @Override
  public boolean isEmpty() {
    // TODO (2)
	  if (head == null){
		  return true;
	  }
	  return false;
  }

  @Override
  public Iterator<E> iterator() {
    return new LinkedNodeIterator<E>(this.head);
  }

  @Override
  public boolean contains(Object o) {
    // TODO (3)
	  Iterator<E> iter = iterator();

	  while(iter.hasNext()){
		  E e = iter.next();	
		  if(e.equals(o)){
			  return true;
		  }
	  }
    return false;
  }

  @Override
  public boolean isSubset(Set<E> that) {
    // TODO (4)
	  Iterator<E> iter1 = iterator();
	  boolean exists = false;
	  while(iter1.hasNext()){
		  E a = iter1.next();
		  Iterator<E> iter2 = that.iterator();
		  while(iter2.hasNext()){
			  E b = iter2.next();
			  if(a.equals(b)){
				  exists = true;
				  break;
			  }
		  }
		  if(exists == false){
			  return false;
		  }
		  exists = false;
	  }
    return true;
  }

  @Override
  public boolean isSuperset(Set<E> that) {
    // TODO (5)
	  Iterator<E> iter1 = that.iterator();
	  boolean exists = false;
	  while(iter1.hasNext()){
		  E a = iter1.next();
		  Iterator<E> iter2 = this.iterator();
		  while(iter2.hasNext()){
			  E b = iter2.next();
			  if(a.equals(b)){
				  exists = true;
				  break;
			  }
		  }
		  if(exists == false){
			  return false;
		  }
		  exists = false;
	  }
    return true;
  }

  @Override
  public Set<E> adjoin(E e) {
    // TODO (6)
	  LinkedSet<E> set = new LinkedSet<E>(new LinkedNode<E>(e, head));
	  if(this.contains(e)){
		  return this;
	  }
	  return set;
	  
	 
  }

  @Override
  public Set<E> union(Set<E> that) {
    // TODO (7)
	  Set<E> set = new LinkedSet<E>();
	  for(E e : this){
		  set = set.adjoin(e);
	  }
	  for(E e : that){
		  set = set.adjoin(e);
	  }
	  return set;
  }

  @Override
  public Set<E> intersect(Set<E> that) {
    // TODO (8)
	  int count = 0;
	  LinkedNode<E> h = new LinkedNode<E>(null, null);
	  boolean exists = false;
	  Iterator<E> iter1 = this.iterator();
	  while(iter1.hasNext()){
		  E a = iter1.next();
		  Iterator<E> iter2 = that.iterator();
		  while(iter2.hasNext()){
			  E b = iter2.next();
			  if(a.equals(b)){
				  exists = true;
				  break;
			  }
		  }
		  if(exists == true){
			  if(count ==0){
				  h = new LinkedNode<E>(a, null);
				  count++;
			  }
			  LinkedNode<E> temp = new LinkedNode<E>(a, h);
			  h = temp;
		  }
		  exists = false;
	  }
	  Set<E> set = new LinkedSet<E>(h);
	  return set;
	 
  }

  @Override
  public Set<E> subtract(Set<E> that) {
    // TODO (9)
	  Set<E> set;
	  int count = 0;
	  LinkedNode<E> h1 = new LinkedNode<E>(null, null);
	  
	  Iterator<E> iter = this.iterator();
	  while(iter.hasNext()){
		  E b = iter.next();
		  if(that.contains(b)){
			  continue;
		  }
		  else{
			  if(count==0){
				  h1 = new LinkedNode<E>(b, null);
				  count++;
			  }
			  else{
				  LinkedNode<E> temp = new LinkedNode<E>(b, h1);
				  h1 = temp;
			  }
		  }
	  }
	  if(h1.getData()==(null)){
		  set = new LinkedSet<E>();
	  }
	  else{
		  set = new LinkedSet<E>(h1);
	  }
	  return set;
  }

  @Override
  public Set<E> remove(E e) {
    // TODO (10)
	  Set<E> set = new LinkedSet<E>();
	  for(E a : this){
		  if(!(a.equals(e))){
			  set = set.adjoin(a);
		  }
	  }
	  return set;
  }

  @Override
  @SuppressWarnings("unchecked")
  public boolean equals(Object o) {
    if (! (o instanceof Set)) {
      return false;
    }
    Set<E> that = (Set<E>)o;
    return this.isSubset(that) && that.isSubset(this);
  }

  @Override
    public int hashCode() {
    int result = 0;
    for (E e : this) {
      result += e.hashCode();
    }
    return result;
  }
  

}
