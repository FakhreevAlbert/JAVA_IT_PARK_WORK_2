class Program {
	public static void main(String[] args) {
		int a[] = {5, 2, 1, 5, 6, 7};
		int n = 6;

              for (int i = 0; i < (n/2); i++) {
			int temp = a[i];
			a[i] = a[n - 1 - i];
			a[n - 1 - i] = temp;
			
		}
                 
		
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
                        
			
		}
		
	}
}