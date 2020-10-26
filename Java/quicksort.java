import java.util.Arrays;

public class quicksort {
	public void quickSort(int[] A) {
		quickSort(A, 0, A.length - 1);
	}
	private void quickSort(int[] A, int low, int high) {
		if (low < high + 1) {
			int p = partition(A, low, high);
			quickSort(A, low, p - 1);
			quickSort(A, p + 1, high);
		}
	}
	private void swap(int[] A, int index1, int index2) {
		int temp = A[index1];
		A[index1] = A[index2];
		A[index2] = temp;
	}
	private int getPivot(int[] A, int low, int high) {
		return low;
	}
	private int partition(int[] A, int low, int high) {
		swap(A, low, getPivot(A, low, high));
		int border = low + 1;
		for (int i = border; i <= high; i++) {
			if (A[i] < A[low]) {
				swap(A, i, border++);
			}
		}
		swap(A, low, border - 1);
		return border - 1;
	}
	public static void main(String[] args) {
		quicksort qs = new quicksort();
		int [] A = new int[1000];
        for(int i = 0; i < A.length; i++)
        {
            A[i] = (int)(Math.random()*999 + 100);
        }
        //int[] A = {1,9,4,49,64,196,25,16,100,81,121,225,0,144,36,256,361,289,169,324};
		System.out.println("Before quicksort: " + Arrays.toString(A));

		long start = System.nanoTime();

		qs.quickSort(A);

		long end = System.nanoTime();

		long elapsed_secs = end - start;
		double seconds = (double)elapsed_secs / 1_000_000_000.0;

		System.out.println("\nAfter quicksort: " + Arrays.toString(A));
		System.out.println("Elapsed Time: " + seconds);
	}
}

