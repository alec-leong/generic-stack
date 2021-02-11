class Main {
  public static void main(String[] args) {
    try {
      StackArrayList<Integer> primes = new StackArrayList<>();
      primes.push(2);
      primes.push(3);
      primes.push(5);
      primes.push(7);
      primes.push(11);

      System.out.println(primes.peek()); // 11
      System.out.println(primes.size()); // 5
      System.out.println(primes);
 
      int primeNum = primes.pop();

      System.out.println(primeNum);      // 11
      System.out.println(primes.size()); // 4
      System.out.println(primes);


    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

/* Output
11
5
[
 11,
 7,
 5,
 3,
 2
]
11
4
[
 7,
 5,
 3,
 2
]
*/
