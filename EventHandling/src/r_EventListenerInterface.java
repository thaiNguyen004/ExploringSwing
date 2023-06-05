/*
* Dưới đây là danh sách 13 giao diện nghe sự kiện trong gói `java.awt.event`:

1. ActionListener: Được sử dụng để lắng nghe sự kiện từ các thành phần như nút hoặc mục menu khi người dùng
* thực hiện một hành động.

2. ItemListener: Được sử dụng để lắng nghe sự kiện từ các thành phần như checkbox hoặc danh sách chọn khi người dùng
* thay đổi trạng thái của chúng.

3. MouseListener: Được sử dụng để lắng nghe các sự kiện chuột như nhấn chuột, thả chuột, và nhấn kép chuột.

4. MouseMotionListener: Được sử dụng để lắng nghe các sự kiện chuột liên quan đến chuyển động chuột, như di
* chuyển chuột và kéo thả chuột.

5. MouseWheelListener: Được sử dụng để lắng nghe sự kiện cuộn chuột.

6. KeyListener: Được sử dụng để lắng nghe các sự kiện từ bàn phím, chẳng hạn như nhấn phím và thả phím.

7. FocusListener: Được sử dụng để lắng nghe sự kiện liên quan đến việc nhận hoặc mất trạng thái tiêu điểm (focus)
* của một thành phần.

8. WindowListener: Được sử dụng để lắng nghe các sự kiện liên quan đến cửa sổ, như mở cửa sổ, đóng cửa sổ và thay đổi
* kích thước cửa sổ.

9. ComponentListener: Được sử dụng để lắng nghe các sự kiện liên quan đến thành phần, chẳng hạn như thay đổi kích thước
* và vị trí của một thành phần.

10. ContainerListener: Được sử dụng để lắng nghe các sự kiện liên quan đến các thay đổi trong các thành phần chứa,
* như thêm hoặc xóa thành phần con.

11. AdjustmentListener: Được sử dụng để lắng nghe các sự kiện liên quan đến thanh cuộn, như khi giá trị thanh cuộn thay đổi.

12. TextListener: Được sử dụng để lắng nghe sự kiện từ các thành phần văn bản, như khi nội dung của một ô nhập văn bản
* thay đổi.

13. WindowFocusListener: Được sử dụng để lắng nghe sự kiện liên quan đến việc nhận hoặc mất trạng thái tiêu điểm của cửa sổ.
*
*
* Giao diện ActionListener
Giao diện này định nghĩa phương thức actionPerformed() được gọi khi một sự kiện hành động xảy ra.
* Dạng chung của phương thức này được hiển thị như sau:
void actionPerformed(ActionEvent ae)
*
*
* Giao diện AdjustmentListener
Giao diện này định nghĩa phương thức adjustmentValueChanged() được gọi khi một sự kiện điều chỉnh xảy ra.
* Dạng chung của phương thức này được hiển thị như sau:
*void adjustmentValueChanged(AdjustmentEvent ae)
*
*
* Giao diện ComponentListener
Giao diện này định nghĩa bốn phương thức được gọi khi một thành phần được thay đổi kích thước, di chuyển, hiển thị hoặc ẩn đi. Dạng chung của các phương thức này được hiển thị như sau:
void componentResized(ComponentEvent ce)
void componentMoved(ComponentEvent ce)
void componentShown(ComponentEvent ce)
void componentHidden(ComponentEvent ce)
*
*
* Giao diện ContainerListener
Giao diện này chứa hai phương thức. Khi một thành phần được thêm vào một container, phương thức componentAdded() được gọi. Khi một thành phần bị xóa khỏi một container, phương thức componentRemoved() được gọi. Dạng chung của các phương thức này được hiển thị như sau:
void componentAdded(ContainerEvent ce)
void componentRemoved(ContainerEvent ce)
*
*
* Giao diện FocusListener
Giao diện này định nghĩa hai phương thức. Khi một thành phần nhận được sự tập trung từ bàn phím, phương thức focusGained() được gọi. Khi một thành phần mất sự tập trung từ bàn phím, phương thức focusLost() được gọi. Dạng chung của các phương thức này được hiển thị như sau:
void focusGained(FocusEvent fe)
void focusLost(FocusEvent fe)
*
*
* Giao diện ItemListener
Giao diện này định nghĩa phương thức itemStateChanged() được gọi khi trạng thái của một mục thay đổi. Dạng chung của phương thức này được hiển thị như sau:
void itemStateChanged(ItemEvent ie)
*
*
Giao diện KeyListener
Giao diện này định nghĩa ba phương thức. Phương thức keyPressed() và keyReleased() được gọi khi một phím được nhấn và nhả ra, tương ứng. Phương thức keyTyped() được gọi khi một ký tự đã được nhập vào.
Ví dụ, nếu người dùng nhấn và nhả phím A, ba sự kiện được tạo ra theo thứ tự: phím đã nhấn, đã gõ, và đã nhả phím. Nếu người dùng nhấn và nhả phím HOME, hai sự kiện phím được tạo ra theo thứ tự: phím đã nhấn và đã nhả phím.
Dạng chung của các phương thức này được hiển thị như sau:
void keyPressed(KeyEvent ke)
void keyReleased(KeyEvent ke)
void keyTyped(KeyEvent ke)
*
*
* Giao diện MouseListener
Giao diện này định nghĩa năm phương thức. Nếu chuột được nhấn và nhả tại cùng một điểm, phương thức mouseClicked() được gọi. Khi chuột nhập vào một thành phần, phương thức mouseEntered() được gọi. Khi chuột rời đi, phương thức mouseExited() được gọi. Phương thức mousePressed() và mouseReleased() được gọi khi chuột được nhấn và nhả, tương ứng.
Dạng chung của các phương thức này được hiển thị như sau:
void mouseClicked(MouseEvent me)
void mouseEntered(MouseEvent me)
void mouseExited(MouseEvent me)
void mousePressed(MouseEvent me)
void mouseReleased(MouseEvent me)
*
*
* Giao diện MouseMotionListener
Giao diện này định nghĩa hai phương thức. Phương thức mouseDragged() được gọi nhiều lần khi chuột được kéo. Phương thức mouseMoved() được gọi nhiều lần khi chuột được di chuyển.
Dạng chung của các phương thức này được hiển thị như sau:
void mouseDragged(MouseEvent me)
void mouseMoved(MouseEvent me)
*
*
* Giao diện MouseWheelListener
Giao diện này định nghĩa phương thức mouseWheelMoved() được gọi khi bánh xe chuột được di chuyển. Dạng chung của phương thức này được hiển thị như sau:
void mouseWheelMoved(MouseWheelEvent mwe)

Giao diện TextListener
Giao diện này định nghĩa phương thức textValueChanged() được gọi khi có sự thay đổi xảy ra trong một khu vực văn bản hoặc trường văn bản. Dạng chung của phương thức này được hiển thị như sau:
void textValueChanged(TextEvent te)

Giao diện WindowFocusListener
Giao diện này định nghĩa hai phương thức: windowGainedFocus() và windowLostFocus(). Chúng được gọi khi một cửa sổ nhận hoặc mất trạng thái tập trung đầu vào. Dạng chung của các phương thức này được hiển thị như sau:
void windowGainedFocus(WindowEvent we)
void windowLostFocus(WindowEvent we)
*
*
* Giao diện WindowListener
Giao diện này định nghĩa bảy phương thức. Phương thức windowActivated() và windowDeactivated() được gọi khi một cửa sổ được kích hoạt hoặc vô hiệu hóa, tương ứng. Nếu một cửa sổ được thu nhỏ, phương thức windowIconified() được gọi. Khi một cửa sổ được mở lại, phương thức windowDeiconified() được gọi. Khi một cửa sổ được mở hoặc đóng, phương thức windowOpened() hoặc windowClosed() được gọi, tương ứng. Phương thức windowClosing() được gọi khi một cửa sổ đang được đóng. Dạng chung của các phương thức này là:
void windowActivated(WindowEvent we)
void windowClosed(WindowEvent we)
void windowClosing(WindowEvent we)
void windowDeactivated(WindowEvent we)
void windowDeiconified(WindowEvent we)
void windowIconified(WindowEvent we)
void windowOpened(WindowEvent we)*/
public class r_EventListenerInterface {
}
