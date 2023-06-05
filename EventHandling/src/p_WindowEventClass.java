/*
* Có mười loại sự kiện cửa sổ. Lớp WindowEvent định nghĩa các hằng số nguyên để xác định chúng.
* Các hằng số và ý nghĩa của chúng được hiển thị dưới đây:
*
* WINDOW_OPENED: Được kích hoạt khi cửa sổ được mở.
* WINDOW_CLOSING: Được kích hoạt khi người dùng cố gắng đóng cửa sổ.
* WINDOW_CLOSED: Được kích hoạt khi cửa sổ đã được đóng hoàn toàn.
* WINDOW_ICONIFIED: Được kích hoạt khi cửa sổ được thu nhỏ (minimize).
* WINDOW_DEICONIFIED: Được kích hoạt khi cửa sổ được phục hồi từ trạng thái thu nhỏ (restore).
* WINDOW_ACTIVATED: Được kích hoạt khi cửa sổ được kích hoạt (focus).
* WINDOW_DEACTIVATED: Được kích hoạt khi cửa sổ mất kích hoạt (mất focus).
* WINDOW_GAINED_FOCUS: Được kích hoạt khi cửa sổ nhận được sự tập trung (focus).
* WINDOW_LOST_FOCUS: Được kích hoạt khi cửa sổ mất sự tập trung (mất focus).
* WINDOW_STATE_CHANGED: Được kích hoạt khi trạng thái của cửa sổ thay đổi, ví dụ như thu nhỏ, mở rộng, thu gọn.
*
* Lớp WindowEvent là một lớp con của ComponentEvent. Nó xác định một số hàm tạo (constructor).
* Hàm tạo đầu tiên là:
*       WindowEvent(Window src, int type)
*
* Ở đây, src là tham chiếu đến đối tượng tạo ra sự kiện này. Kiểu sự kiện được xác định bởi type.
*
* Ba hàm tạo tiếp theo cung cấp kiểm soát chi tiết hơn:
*       WindowEvent(Window src, int type, Window other)
*       WindowEvent(Window src, int type, int fromState, int toState)
*       WindowEvent(Window src, int type, Window other, int fromState, int toState)
*
* Ở đây, other xác định cửa sổ đối diện khi một sự kiện tập trung hoặc kích hoạt xảy ra.
* fromState xác định trạng thái trước của cửa sổ, và toState xác định trạng thái mới của cửa sổ khi một sự
* thay đổi trạng thái cửa sổ xảy ra.
*
* Một phương thức thường được sử dụng trong lớp này là getWindow(). Nó trả về đối tượng Window đã tạo ra sự kiện.
* Dạng tổng quát của phương thức này được hiển thị dưới đây:
*       Window getWindow()
*
* WindowEvent cũng xác định các phương thức trả về cửa sổ đối diện (khi một sự kiện tập trung hoặc kích hoạt đã xảy ra),
* trạng thái trước đó của cửa sổ và trạng thái hiện tại của cửa sổ. Các phương thức này được hiển thị dưới đây:
*       Window getOppositeWindow()
*       int getOldState()
*       int getNewState()
* */
public class p_WindowEventClass {
}
