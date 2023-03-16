package QueueViaArray;

public class MyQueue {
    private int capacity;
    private int queueArr[];
    private int head = 0;
    private int tail = -1;
    private int currentSize = 0;

    //Constructor triển khai mảng dữ liệu
    public MyQueue(int queueSize) {
        this.capacity = queueSize;
        queueArr = new int[this.capacity];
    }

    //Phương thức kiểm tra trạng thái full dữ liệu trong mảng khi so sánh với kích thước mảng thực
    public boolean isQueueFull() {
        boolean status = false;
        if (currentSize == capacity) {
            status = true;
        }
        return status;
    }

    //Phương thức kiểm tra trạng thái trống dữ liệu trong mảng khi so sánh với kích thước mảng thực
    public boolean isQueueEmpty() {
        boolean status = false;
        if (currentSize == 0) {
            status = true;
        }
        return status;
    }

    //Phương thức thêm phần tử vào cuối của queue (hàng đợi)
    //Kiểm tra trạng thái đầy tải của mảng => đưa ra thông báo đầy hoặc thực thi
    //Nếu thoả mãn, phần tử được đẩy vào cuối mảng, và cập nhật kích thước thực
    public void enqueue(int item) {
        if (isQueueFull()) {
            System.out.println("Overflow ! Unable to add element: " + item);
        } else {
            tail++;
            if (tail == capacity - 1) {
                tail = 0;
            }
            queueArr[tail] = item;
            currentSize++;
            System.out.println("Element " + item + " is pushed to Queue !");
        }
    }

    //Phương thức xoá phần tử khỏi vị trí của queue (hàng đợi)
    //Kiểm tra trạng thái trống của mảng => đưa ra thông báo không có dữ liệu hoặc thực thi
    //Nếu thoả mãn, phần tử được xoá ra khỏi cuối mảng, và cập nhật kích thước thực
    public void dequeue() {
        if (isQueueEmpty()) {
            System.out.println("Underflow ! Unable to remove element from Queue");
        } else {
            head++;
            if (head == capacity - 1) {
                System.out.println("Pop operation done ! removed: " + queueArr[head - 1]);
                head = 0;
            } else {
                System.out.println("Pop operation done ! removed: " + queueArr[head - 1]);
            }
            currentSize--;
        }
    }
}
