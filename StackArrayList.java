import java.util.*;

/**
 * <code>StackInsertException</code> Class
 * <p>
 * A subclass of the <code>IllegalArgumentException</code> class. An exception for creating a
 * <code>StackArrayList</code> with an illegal size declaration. 
 */
class StackIllegalSizeDeclartion extends IllegalArgumentException {
  public StackIllegalSizeDeclartion(int maxSize) {
    super("Can't declare stack size of " + maxSize);
  }
}

/**
 * <code>StackInsertException</code> Class
 * <p>
 * A subclass of the <code>RuntimeException</code> class. An exception for inserting an item into a
 * full stack.
 */
class StackInsertException extends RuntimeException {
  public StackInsertException() {
    super("Can't insert an item into a full stack");
  }
}

/**
 * <code>StackDeleteException</code> Class
 * <p>
 * A subclass of the <code>RuntimeException</code> class. An exception for deleting an item from an
 * empty stack.
 */
class StackDeleteException extends RuntimeException {
  public StackDeleteException() {
    super("Can't delete the last item from an empty stack");
  }
}

/**
 * <code>StackReadException</code> Class
 * <p>
 * A subclass of the <code>RuntimeException</code> class. An exception for reading an item from an
 * empty stack.
 */
class StackReadException extends RuntimeException {
  public StackReadException() {
    super("Can't read the last item from an empty stack");
  }
}

/**
 * <code>StackArrayList</code> Class
 * <p>
 * A generic stack implementation.
 */
class StackArrayList<T> {
  private int top;           // The pointer to the top of the stack.
  private int maxSize;       // The maximum number of items in the stack.
  private List<T> container; // The List implentation of the stack.

	/**
	 * No-argument constructor. 
	 * <p>
	 * Creates a <code>StackArrayList</code> object that doesn't become full and initializes the following fields:
	 * <ul>
	 * <li><code>top</code>       - The <code>int</code> value <code>-1</code>.
	 * <li><code>container</code> - A <code>List</code> object implemented by the <code>ArrayList</code> class.
	 * </ul>
	 */
  StackArrayList() {
    top = -1;
    container = new ArrayList<>();
  }

  /**
   * Parameterized constructor with one parameter.
   * <p>
   * Creates a <code>StackArrayList</code> object that can become full and initializes the following
   * fields:
   * <li><code>top</code>       - The <code>int</code> value <code>-1</code>.
   * <li><code>maxSize</code>   - The value of the <code>int</code> parameter <code>maxSize</code>.
   * <li><code>container</code> - A <code>List</code> object implemented by the <code>ArrayList</code> class with an initial capacity of <code>maxSize</code>.
   * @param maxSize the maximum size of the stack.
   * @throws StackIllegalSizeDeclartion if the the value of the <code>int</code> parameter
   * <code>maxSize</code> if less than or equal to <code>0</code>.
   */
  StackArrayList(int maxSize) throws StackIllegalSizeDeclartion {
    if (maxSize <= 0) {
      throw new StackIllegalSizeDeclartion(maxSize);
    }
  
    top = -1;
    this.maxSize = maxSize;
    container = new ArrayList<>(maxSize);
  }

  /**
   * The <code>toString()</code> method.
   * <p>
   * @return the <code>StackArrayList</code> object as a <code>String</code> object.
   */
  public String toString() {
    // Handle empty stack case.
    if (container.isEmpty()) {
      return "[]";
    }

    StringBuilder output = new StringBuilder("[\n");

    // Iterate through the stack, except the first item
    for (int i = container.size() - 1; i > 0; i--) {
      output.append(" ");
      output.append(container.get(i));
      output.append(",\n");
    }
  
    // Bottom of the stack, the first item.
    output.append(" ");
    output.append(container.get(0));
    output.append("\n]");
    
    return output.toString();
  }
  
  /**
   * If the stack is not full, first increment the <code>top</code> field then insert an item on the
   * top of the stack.
   * @param item the item to be inserted on the top of the stack.
   * @throws StackInsertException if the stack is full.
   */
   public void push(T item) throws StackInsertException {
    if (container.size() == maxSize && maxSize > 0) {
      throw new StackInsertException();
    }
    
    container.add(++top, item);
  }

  /**
   * If the stack is not empty, then delete the item on the top of the stack and decrement the
   * <code>top</code> field. 
   * @return the item on the top of the stack. 
   * @throws StackDeleteException if the stack is empty.
   */
  public T pop() throws StackDeleteException {
    if (container.isEmpty()) {
      throw new StackDeleteException();
    }

    return container.remove(top--);
  }

  /**
   * If the stack is not empty, then return the item on the top of the stack. 
   * @return the item on the top of the stack. 
   * @throws StackReadException if the stack is empty.
   */
  public T peek() throws StackReadException {
    if (container.isEmpty()) {
      throw new StackReadException();
    }

    return container.get(top);
  }

  /**
   * Returns the number of items in the stack.
   * @return an <code>int</code> referencing the number of items in the stack.
   */
  public int size() {
    return container.size();
  }

  /**
   * Returns a <code>boolean</code> if the stack is empty or not empty.
   * @return <code>true</code> if the stack is empty. Otherwise <code>false</code>.
   */
  public boolean isEmpty() {
    return container.isEmpty(); // top == -1
  }
}
