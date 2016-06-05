package service;

public class Queue {

	public int max = 10, rear = 0, front = 0, size = 0;
	Object[] q;
	public Object o;

	public Queue(int s) {
		q = new Object[s];
	}

	public void Enqueue(Object r) {
		if (rear == max) {
			System.out.println("Sorry Tikets are over");
		} else {
			q[rear++] = (Reservation) r;
			size++;
		}
	}

	public Object Dequeue() {

		if (rear == -1) {
			System.out.println("W/L is Empty");
			return 0;
		} else {
			o = q[front];
			front++;
			size--;
		}
		return o;
	}

	public boolean check() {
		if (q[0] == null) {
			return true;
		} else {
			return false;
		}

	}

}
