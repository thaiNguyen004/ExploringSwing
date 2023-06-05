/*
* Lớp MouseEvent định nghĩa tám loại sự kiện chuột. Lớp MouseEvent cũng định nghĩa các hằng số nguyên sau
* đây để xác định chúng:
*
- MouseEvent.MOUSE_CLICKED: Được tạo ra khi người dùng nhấp chuột lên và nhả chuột ra tại cùng một vị trí trên thành phần.
- MouseEvent.MOUSE_DRAGGED: Được tạo ra khi người dùng giữ chuột và di chuyển con trỏ chuột trên thành phần.
- MouseEvent.MOUSE_ENTERED: Được tạo ra khi con trỏ chuột nhập vào vùng của thành phần.
- MouseEvent.MOUSE_EXITED: Được tạo ra khi con trỏ chuột rời khỏi vùng của thành phần.
- MouseEvent.MOUSE_MOVED: Được tạo ra khi con trỏ chuột di chuyển trên thành phần mà không có nút nào được nhấn.
- MouseEvent.MOUSE_PRESSED: Được tạo ra khi người dùng nhấn một nút chuột trên thành phần.
- MouseEvent.MOUSE_RELEASED: Được tạo ra khi người dùng nhả một nút chuột ra sau khi đã nhấn trên thành phần.
- MouseEvent.MOUSE_WHEEL: Được tạo ra khi người dùng di chuyển bánh xe chuột (scroll wheel) trên thành phần.
*
* Lớp MouseEvent là một lớp con của lớp InputEvent. Dưới đây là một trong các hàm tạo của nó:
*
* MouseEvent(Component src, int type, long when, int modifiers, int x, int y, int clicks, boolean triggersPopup)
*
* Ở đây, src là tham chiếu đến thành phần tạo ra sự kiện. Loại sự kiện được chỉ định bởi type.
* Thời gian hệ thống khi sự kiện chuột xảy ra được truyền vào when. Đối số modifiers chỉ ra các phím tắt
* đã được nhấn khi sự kiện chuột xảy ra. Tọa độ của chuột được truyền vào qua x và y.
* Số lần nhấp chuột được truyền vào qua clicks.
* Cờ triggersPopup xác định xem sự kiện này có gây ra hiển thị menu bật lên trên nền tảng hiện tại hay không.
*
* Hai phương thức thường được sử dụng trong lớp này là getX() và getY().
* Chúng trả về tọa độ X và Y của chuột trong thành phần khi sự kiện xảy ra. Dưới đây là các dạng của chúng:
*
*       int getX()
*       int getY()
*
* Ngoài ra, bạn cũng có thể sử dụng phương thức getPoint() để lấy các tọa độ của chuột. Dưới đây là dạng của nó:
* Point getPoint()
* Nó trả về một đối tượng Point chứa các tọa độ X, Y trong các thành viên nguyên của nó: x và y.
*
* Phương thức translatePoint() thay đổi vị trí của sự kiện. Dưới đây là dạng của nó:
*
*       void translatePoint(int x, int y)
*
* Ở đây, các đối số x và y được cộng vào các tọa độ của sự kiện.
*
* Phương thức getClickCount() lấy số lần nhấp chuột cho sự kiện này. Dưới đây là dạng của nó:
*
*       int getClickCount()
*
* Phương thức isPopupTrigger() kiểm tra xem sự kiện này có gây ra hiển thị menu bật lên trên nền tảng này hay không.
* Dạng của nó được hiển thị như sau:
*
*       boolean isPopupTrigger()
*
* Cũng có sẵn phương thức getButton(), dưới đây là dạng của nó:
*
*       int getButton()
*
* Nó trả về một giá trị đại diện cho nút đã gây ra sự kiện. Đối với hầu hết các trường hợp, giá trị trả về
* sẽ là một trong những hằng số được định nghĩa bởi MouseEvent sau đây:
*
* 1. NOBUTTON; 2. BUTTON1; 3. BUTTON2; 4. BUTTON3
*
* Giá trị NOBUTTON chỉ ra rằng không có nút nào được nhấn hoặc nhả ra.
*
* Cũng có sẵn ba phương thức để lấy tọa độ của con trỏ chuột liên quan đến màn hình chứ không phải thành phần.
* Dưới đây là dạng của chúng:
*
* Point getLocationOnScreen()
* int getXOnScreen()
* int getYOnScreen()
*
* Phương thức getLocationOnScreen() trả về một đối tượng Point chứa cả tọa độ X và Y.
* Hai phương thức còn lại trả về tọa độ tương ứng.*/
public class m_MouseEventClass {
}
