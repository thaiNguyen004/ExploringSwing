/*
* Lớp KeyEvent
* Một KeyEvent được tạo ra khi có sự kiện nhập từ bàn phím xảy ra. Có ba loại sự kiện phím, được xác định
* bằng các hằng số số nguyên sau: KEY_PRESSED (Phím đã nhấn), KEY_RELEASED (Phím đã thả) và KEY_TYPED (Phím đã gõ).
*
* Hai sự kiện đầu tiên được tạo ra khi bất kỳ phím nào được nhấn hoặc thả. Sự kiện cuối cùng chỉ xảy ra khi
* một ký tự được tạo ra. Hãy nhớ rằng, không phải tất cả các lần nhấn phím đều tạo ra ký tự.
* Ví dụ, việc nhấn SHIFT không tạo ra một ký tự.
*
* Có nhiều hằng số số nguyên khác được định nghĩa bởi KeyEvent.
* Ví dụ, VK_0 đến VK_9 và VK_A đến VK_Z xác định các tương đương ASCII của các số và chữ cái.
* Dưới đây là một số hằng số khác:
*
* VK_0 đến VK_9: Các phím số từ 0 đến 9.
* VK_A đến VK_Z: Các chữ cái từ A đến Z.
* VK_ENTER: Phím Enter.
* VK_BACK_SPACE: Phím Backspace.
* VK_TAB: Phím Tab.
* VK_SPACE: Phím Space.
* VK_SHIFT: Phím Shift.
* VK_CONTROL: Phím Control.
* VK_ALT: Phím Alt.
* VK_CAPS_LOCK: Phím Caps Lock.
* VK_ESCAPE: Phím Escape.
* VK_PAGE_UP: Phím Page Up.
* VK_PAGE_DOWN: Phím Page Down.
* VK_END: Phím End.
* VK_HOME: Phím Home.
* VK_INSERT: Phím Insert.
* VK_DELETE: Phím Delete.
* VK_LEFT: Phím mũi tên trái.
* VK_RIGHT: Phím mũi tên phải.
* VK_UP: Phím mũi tên lên.
* VK_DOWN: Phím mũi tên xuống
*
* Lớp KeyEvent định nghĩa nhiều phương thức, nhưng có lẽ hai phương thức phổ biến nhất là getKeyChar() và getKeyCode().
* Dưới đây là mô tả của chúng:
*
* - Phương thức getKeyChar(): Trả về ký tự được nhập vào. Hình thức tổng quát của phương thức này là:
*       char getKeyChar()

* - Phương thức getKeyCode(): Trả về mã phím tương ứng với sự kiện KeyEvent. Hình thức tổng quát của phương thức này là:
*       int getKeyCode()
*
* Ví dụ, khi người dùng nhấn một phím, phương thức getKeyChar() sẽ trả về ký tự tương ứng nếu có,
* còn getKeyCode() sẽ trả về mã phím tương ứng với phím đó.
* Lưu ý rằng nếu không có ký tự tương ứng, getKeyChar() có thể trả về giá trị CHAR_UNDEFINED và getKeyCode()
* có thể trả về giá trị VK_UNDEFINED trong trường hợp của sự kiện KEY_TYPED.*/
public class l_KeyEventClass {
}
