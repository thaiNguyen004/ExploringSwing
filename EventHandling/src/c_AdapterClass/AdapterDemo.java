package c_AdapterClass;

import java.awt.*;
import java.awt.event.*;

/*
* Lớp Adapter
* Java cung cấp một tính năng đặc biệt, được gọi là lớp adapter, có thể đơn giản hóa việc tạo ra các trình xử lý
* sự kiện trong một số tình huống cụ thể. Một lớp adapter cung cấp một phiên bản trống của tất cả các phương thức
* trong giao diện lắng nghe sự kiện. Lớp adapter rất hữu ích khi bạn chỉ muốn nhận và xử lý một số sự kiện mà được
* xử lý bởi một giao diện lắng nghe sự kiện cụ thể. Bạn có thể định nghĩa một lớp mới để hoạt động như một lắng nghe
* sự kiện bằng cách mở rộng một trong các lớp adapter và chỉ triển khai các sự kiện mà bạn quan tâm.
*
* Ví dụ, lớp MouseMotionAdapter có hai phương thức là mouseDragged() và mouseMoved(), đó là các phương thức được
* định nghĩa trong giao diện MouseMotionListener. Nếu bạn chỉ quan tâm đến sự kiện kéo chuột, bạn có thể mở rộng lớp
* MouseMotionAdapter và ghi đè phương thức mouseDragged(). Việc triển khai trống rỗng của phương thức mouseMoved()
* sẽ xử lý các sự kiện di chuyển chuột cho bạn.
* Bảng 24-4 liệt kê một số lớp adapter thông dụng trong java.awt.event và ghi chú về giao diện mà mỗi lớp triển khai.
*
* Dưới đây là danh sách 7 lớp adapter thông dụng trong gói java.awt.event và ghi chú về giao diện mà mỗi lớp triển khai:
* 1. WindowAdapter: Triển khai WindowListener.
* 2. KeyAdapter: Triển khai KeyListener.
* 3. MouseAdapter: Triển khai MouseListener.
* 4. MouseMotionAdapter: Triển khai MouseMotionListener.
* 5. FocusAdapter: Triển khai FocusListener.
* 6. ComponentAdapter: Triển khai ComponentListener.
* 7. ContainerAdapter: Triển khai ContainerListener.
*
* Các lớp adapter này cung cấp các phương thức rỗng cho tất cả các phương thức trong giao diện tương ứng,
* giúp bạn chỉ triển khai những sự kiện mà bạn quan tâm mà không cần triển khai tất cả các phương thức.
*
* Bạn đã thấy một lớp adapter trong các ví dụ trước đó: WindowAdapter. Hãy nhớ rằng giao diện WindowListener
* định nghĩa bảy phương thức, nhưng chỉ cần một phương thức windowClosing() được sử dụng trong các chương trình.
* Việc sử dụng adapter đã ngăn việc cung cấp triển khai rỗng của các phương thức không sử dụng khác, từ đó tránh
* việc làm rối mắt trong các ví dụ. Như bạn đã mong đợi, các lớp adapter khác có thể được sử dụng theo cách tương tự.
*
* Chương trình dưới đây cung cấp một ví dụ khác về việc sử dụng adapter. Nó sử dụng MouseAdapter để phản ứng với
* sự kiện nhấp chuột và kéo chuột. Như được hiển thị trong Bảng 24-4, MouseAdapter triển khai tất cả các giao diện
* lắng nghe chuột. Do đó, bạn có thể sử dụng nó để xử lý tất cả các loại sự kiện chuột. Tất nhiên, bạn chỉ cần ghi đè
* các phương thức được sử dụng bởi chương trình của bạn. Trong ví dụ dưới đây, MyMouseAdapter mở rộng MouseAdapter và
* ghi đè các phương thức mouseClicked() và mouseDragged(). Tất cả các sự kiện chuột khác sẽ được bỏ qua một cách im lặng.
* Lưu ý rằng MyMouseAdapter constructor được truyền một tham chiếu đến đối tượng AdapterDemo. Tham chiếu này được lưu trữ
* và sau đó được sử dụng để gán một chuỗi cho msg và gọi repaint() trên đối tượng nhận thông báo sự kiện.
* Giống như trước đây, một WindowAdapter được sử dụng để xử lý sự kiện đóng cửa sổ.
* */
public class AdapterDemo extends Frame {
    String msg = "";

    public AdapterDemo () {
        //Vì MouseAdapter bao gồm cả các phương thức của MouseListener và MouseMotionListener nên
        //phải triển khai cả 2 phương thức addMouseListener và addMouseMotionListener
        addMouseListener(new MyMouseAdapter(this));
        addMouseMotionListener(new MyMouseAdapter(this));
        addWindowListener(new MyWindowAdapter());
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg, 20, 80);
    }

    public static void main(String[] args) {
        AdapterDemo appwin = new AdapterDemo();

        appwin.setSize(new Dimension(300, 300));
        appwin.setTitle("Adapter Demo");
        appwin.setVisible(true);
    }
}

class MyMouseAdapter extends MouseAdapter {
    AdapterDemo listener;
    public MyMouseAdapter(AdapterDemo o) {
        listener = o;
    }

    //MouseClicked là phương thức có ở Interface MouseListener
    @Override
    public void mouseClicked(MouseEvent e) {
        listener.msg = "Mouse Click!!!";
        listener.repaint();
    }

    //MouseDragged là phương thức có ở Interface MouseMotionListener
    @Override
    public void mouseDragged(MouseEvent e) {
        listener.msg = "Mouse Dragged";
        listener.repaint();
    }
}

/*
* Như bạn có thể thấy khi xem chương trình, không cần triển khai tất cả các phương thức được định nghĩa trong
* các giao diện MouseMotionListener, MouseListener và MouseWheelListener sẽ giúp tiết kiệm rất nhiều công sức
* và ngăn mã của bạn trở nên rối rắm với các phương thức rỗng. Là một bài tập, bạn có thể thử viết lại một trong
* các ví dụ về đầu vào từ bàn phím được hiển thị trước đó để sử dụng KeyAdapter.
*/

class MyWindowAdapter extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}

