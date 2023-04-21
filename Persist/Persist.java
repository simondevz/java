class Persist {
    public static void main(String[] args) {
        System.out.printf("Persistence - %d\n", persistence(Long.parseLong(args[0])));
    }
    
	public static int persistence(long n) {
		int persistenceNumber = 0;
		String string = Long.toString(n);
		int len = string.length();
		
		while (len > 1) {
    		persistenceNumber++;
    		int[] arr = new int[len];
    		System.out.println(""+persistenceNumber);
    		
    		for (int i = 0; i < len; i++) {
    		    arr[i] = Integer.parseInt(String.valueOf(string.charAt(i)));
    		    System.out.println("arr - "+arr[i]);
    		} 
    		
    		long product = 1;
    		for (int j = 0; j < arr.length; j++) {
    		    product *= arr[j];
    		} 
    		
    		string = Long.toString(product);
		    len = string.length();
		}
		
	    return persistenceNumber;
	}
}