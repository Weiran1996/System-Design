package MinHeap;

//Java implementation of Min Heap 
public class MinHeap {
	private int[] Heap;
	// 当前heap中有多少个元素
	private int size;
	private int maxsize;

	private static final int FRONT= 1;

	public MinHeap(int maxsize) {
		this.maxsize= maxsize;
		this.size= 0;
		Heap= new int[this.maxsize + 1];
		// heap array中的第一个位置不存东西
		Heap[0]= Integer.MIN_VALUE;
	}

	// 给了当前node在array中的position 找到parent的position
	private int parent(int pos) {
		return pos / 2;
	}

	// 给了当前node在array中的position 找到left child的index
	private int leftChild(int pos) {
		return (2 * pos);
	}

	// 给了当前node在array中的position 找到right child的index
	private int rightChild(int pos) {
		return (2 * pos) + 1;
	}

	// 来看看一个位置的node是不是leaf
	private boolean isLeaf(int pos) {
		if (pos >= (size / 2) && pos <= size) { return true; }
		return false;
	}

	// Function to swap two nodes of the heap
	private void swap(int fpos, int spos) {
		int tmp;
		tmp= Heap[fpos];
		Heap[fpos]= Heap[spos];
		Heap[spos]= tmp;
	}

	// 刚放进去一个新的数字 其实也就是一个index 要heapify移动到正确的位置
	private void minHeapify(int pos) {

		// 如果当前不是在leaf 还比自己左child 或者又child大
		if (!isLeaf(pos)) {
			if (Heap[pos] > Heap[leftChild(pos)] || Heap[pos] > Heap[rightChild(pos)]) {
				// 永远把左右两个child最符合要求的那一个往上走
				// left和right比较 哪个更小就和谁swap
				if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
					swap(pos, leftChild(pos));
					minHeapify(leftChild(pos));
				}

				// Swap with the right child and heapify
				// the right child
				else {
					swap(pos, rightChild(pos));
					minHeapify(rightChild(pos));
				}
			}
		}
	}

	// Function to insert a node into the heap
	public void insert(int element) {
		// 超出最大范围就增加不了了
		if (size >= maxsize) { return; }
		// 把新增的元素先放到最后边
		Heap[ ++size]= element;
		int current= size;

		// 当新增的元素 就是比parent小的时候 就一直swap
		while (Heap[current] < Heap[parent(current)]) {
			swap(current, parent(current));
			current= parent(current);
		}
	}

	// Function to print the contents of the heap
	public void print() {
		for (int i= 1; i <= size / 2; i++ ) {
			System.out
				.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2 * i] + " RIGHT CHILD :" + Heap[2 * i + 1]);
			System.out.println();
		}
	}

	// Function to build the min heap using
	// the minHeapify
	public void minHeap() {
		// 把前边那些大的 都给heapify了
		for (int pos= (size / 2); pos >= 1; pos-- ) {
			minHeapify(pos);
		}
	}

	// Function to remove and return the minimum
	// element from the heap
	public int remove() {
		// 先保存最上边的元素 等heapify结束后再return
		int popped= Heap[FRONT];
		// 最后一个上位 然后heapify最上边的元素
		Heap[FRONT]= Heap[size-- ];
		minHeapify(FRONT);
		return popped;
	}

	// Driver code
	public static void main(String[] arg) {
		System.out.println("The Min Heap is ");
		MinHeap minHeap= new MinHeap(15);
		minHeap.insert(5);
		minHeap.insert(3);
		minHeap.insert(17);
		minHeap.insert(10);
		minHeap.insert(84);
		minHeap.insert(19);
		minHeap.insert(6);
		minHeap.insert(22);
		minHeap.insert(9);
		minHeap.minHeap();

		minHeap.print();
		System.out.println("The Min val is " + minHeap.remove());
	}
}
