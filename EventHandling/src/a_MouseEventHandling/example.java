package a_MouseEventHandling;
/*
* Để xử lý các sự kiện chuột, bạn phải triển khai các giao diện MouseListener và MouseMotionListener.
* (Bạn cũng có thể muốn triển khai MouseWheelListener, nhưng chúng ta không sẽ làm như vậy ở đây.)
* Chương trình sau đây minh họa quá trình đó. Nó hiển thị tọa độ hiện tại của con trỏ chuột trong cửa sổ chương trình.
* Mỗi lần một nút chuột được nhấn, cụm từ "Button Down" được hiển thị tại vị trí của con trỏ chuột.
* Mỗi khi nút chuột được thả ra, cụm từ "Button Released" được hiển thị. Nếu một nút chuột được nhấp,
* một thông báo xác nhận điều này được hiển thị tại vị trí chuột hiện tại.
* Khi chuột đi vào hoặc rời khỏi cửa sổ, một thông báo được hiển thị cho biết điều gì đã xảy ra.
* Khi kéo chuột, một dấu * được hiển thị, di chuyển theo con trỏ chuột khi nó được kéo.
*
* Lưu ý rằng hai biến mouseX và mouseY lưu trữ vị trí của con trỏ chuột khi một sự kiện chuột được nhấn,
* thả hoặc kéo xảy ra. Các tọa độ này sau đó được sử dụng bởi phương thức paint() để hiển thị đầu ra tại
* điểm xuất hiện này.*/

import java.awt.*;
import java.awt.event.*;

public class example extends Frame implements MouseListener, MouseMotionListener{

    String msg = "";
    int mouseX = 0, mouseY = 0; //Tọa độ của con chuột

    public example () {
        addMouseListener(this);
        addMouseMotionListener(this);
        addWindowListener(new MyWindowAdapter());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        msg = msg + "Đã nhận click";
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //Lưu lại tọa độ
        mouseX = e.getX();
        mouseY = e.getY();
        msg = "Button down";
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //Lưu lại tọa độ
        mouseX = e.getY();
        mouseY = e.getY();
        msg = "Button Released";
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        mouseX = 100;
        mouseY = 100;
        msg = "Mouse Entered";
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        mouseX = 100;
        mouseY = 100;
        msg = "Mouse Exited";
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        msg = "*" + "mouse at " + mouseX + ", " + mouseY;
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        msg  = "Di chuyển chuột tại vị trí :  " + e.getX() +", " +e.getY();
        repaint();
    }

    public static void main(String[] args) {
        example appwin = new example();
        appwin.setSize(300, 300);
        appwin.setTitle("Mouse Event Demo");
        appwin.setVisible(true);
    }
    @Override
    public void paint(Graphics g) {
        g.drawString(msg, mouseX, mouseX);
    }
}

class MyWindowAdapter extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

}
/*
* Hãy xem kỹ ví dụ này. Đầu tiên, lưu ý rằng example mở rộng từ lớp Frame. Do đó, nó tạo ra cửa sổ cấp cao nhất
* cho ứng dụng. Tiếp theo, lưu ý rằng nó triển khai cả hai giao diện MouseListener và MouseMotionListener.
* Hai giao diện này chứa các phương thức để nhận và xử lý các loại sự kiện chuột khác nhau. Lưu ý rằng
* example vừa là nguồn tạo ra sự kiện vừa là người lắng nghe cho các sự kiện này. Điều này hoạt động vì
* Frame cung cấp các phương thức addMouseListener() và addMouseMotionListener().
* Việc vừa là nguồn tạo ra sự kiện vừa là người lắng nghe cho các sự kiện không phải là điều hiếm gặp đối
* với các chương trình GUI đơn giản.
*
* Trong hàm khởi tạo của example, chương trình đăng ký chính nó làm người lắng nghe cho sự kiện chuột.
* Điều này được thực hiện bằng cách gọi addMouseListener() và addMouseMotionListener().
* Cú pháp của hai phương thức này như sau:
*
*       void addMouseListener(MouseListener ml)
*       void addMouseMotionListener(MouseMotionListener mml)
*
* Ở đây, ml là một tham chiếu đến đối tượng nhận sự kiện chuột, và mml là một tham chiếu đến đối tượng nhận
* sự kiện di chuyển chuột. Trong chương trình này, cùng một đối tượng được sử dụng cho cả hai.
* Sau đó, example triển khai tất cả các phương thức được định nghĩa bởi giao diện MouseListener và MouseMotionListener.
* Đây là các trình xử lý sự kiện cho các sự kiện chuột khác nhau. Mỗi phương thức xử lý sự kiện của mình và
* sau đó trả về.
*
* Lưu ý rằng trong hàm khởi tạo của MouseEventsDemo cũng có thêm một WindowListener. Điều này cần thiết để cho
* phép chương trình phản ứng với sự kiện đóng cửa sổ khi người dùng nhấp vào ô đóng. Lớp người nghe này sử dụng
* một lớp adapter để triển khai giao diện WindowListener. Lớp adapter cung cấp các triển khai trống rỗng của một
* giao diện người nghe, cho phép bạn ghi đè chỉ các phương thức mà bạn quan tâm. Chúng được mô tả chi tiết trong
* phần tiếp theo của chương này, nhưng ở đây được sử dụng để đơn giản hóa rất nhiều mã cần thiết để đóng chương trình.
* Trong trường hợp này, phương thức windowClosing() được ghi đè. Phương thức này được gọi bởi AWT khi cửa sổ được đóng.
* Ở đây, nó gọi System.exit() để kết thúc chương trình.
*
* Bây giờ hãy nhìn vào các bộ xử lý sự kiện chuột. Mỗi khi xảy ra một sự kiện chuột, biến msg được gán một
* chuỗi mô tả những gì đã xảy ra và sau đó gọi repaint(). Trong trường hợp này, repaint() cuối cùng khiến
* AWT gọi paint() để hiển thị đầu ra. (Quá trình này được xem xét kỹ hơn trong Chương 25.)
* Lưu ý rằng paint() có một tham số kiểu Graphics. Lớp này mô tả ngữ cảnh đồ họa của chương trình và là bắt
* buộc cho việc đầu ra. Chương trình sử dụng phương thức drawString() do Graphics cung cấp để thực sự hiển thị
* một chuỗi trong cửa sổ tại vị trí X, Y đã chỉ định. Mẫu được sử dụng trong chương trình được hiển thị ở đây:
*
*       void drawString(String message, int x, int y)
*
Ở đây, message là chuỗi cần hiển thị bắt đầu tại x, y. Trong một cửa sổ Java, góc trên bên trái là vị trí 0,0.
* Như đã đề cập, mouseX và mouseY giữ vị trí của chuột. Những giá trị này được chuyển đến drawString()
* là vị trí mà đầu ra được hiển thị.
*
* Cuối cùng, chương trình được khởi động bằng cách tạo một thể hiện MouseEventsDemo và sau đó đặt kích thước
* của cửa sổ, tiêu đề của nó và làm cho cửa sổ trở nên hiển thị. Những tính năng này được mô tả chi tiết hơn
* trong Chương 25.
* */

