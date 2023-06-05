/*
* Lớp MouseWheelEvent đóng gói một sự kiện cuộn bánh xe chuột. Nó là một lớp con của MouseEvent.
* Không phải chuột nào cũng có bánh xe. Nếu một chuột có bánh xe, thì thông thường nó được đặt giữa các nút trái và phải.
* Bánh xe chuột được sử dụng để cuộn trang. MouseWheelEvent định nghĩa hai hằng số nguyên sau:
*
* Hai hằng số nguyên đó được định nghĩa trong lớp MouseWheelEvent là:
*
* 1. UNIT_SCROLL: Đại diện cho sự cuộn theo đơn vị. Sự kiện cuộn bánh xe chuột sử dụng chế độ cuộn theo đơn vị,
* trong đó giá trị cuộn thể hiện số lượng đơn vị cuộn.
*
* 2. BLOCK_SCROLL: Đại diện cho sự cuộn theo khối. Sự kiện cuộn bánh xe chuột sử dụng chế độ cuộn theo khối,
* trong đó giá trị cuộn thể hiện số lượng khối cuộn.
*
* Cả hai hằng số này cho phép xác định chế độ cuộn được sử dụng trong sự kiện cuộn bánh xe chuột
* và giá trị cuộn tương ứng.
*
* Dưới đây là một trong các constructor được định nghĩa trong lớp MouseWheelEvent:
*
* MouseWheelEvent(Component src, int type, long when, int modifiers,
* int x, int y, int clicks, boolean triggersPopup,
* int scrollHow, int amount, int count)
*
* Ở đây, src là một tham chiếu đến đối tượng đã tạo ra sự kiện. Loại của sự kiện được xác định bởi type.
* Thời gian hệ thống mà sự kiện chuột xảy ra được truyền vào trong tham số when. Đối số modifiers chỉ ra
* các phím tắt (modifiers) nào đã được nhấn khi sự kiện xảy ra. Tọa độ của con trỏ chuột được truyền vào
* trong x và y. Số lần nhấp chuột được truyền vào trong clicks. Cờ triggersPopup cho biết liệu sự kiện này
* gây ra hiện thị một menu pop-up trên nền tảng hiện tại hay không.
* Giá trị scrollHow phải là WHEEL_UNIT_SCROLL hoặc WHEEL_BLOCK_SCROLL. Số lượng đơn vị cuộn được truyền
* vào trong amount. Tham số count chỉ số lượng đơn vị quay của bánh xe.
*
* Lớp MouseWheelEvent định nghĩa các phương thức cho phép bạn truy cập vào sự kiện cuộn bánh xe.
*
* Để lấy số lượng đơn vị quay của bánh xe, gọi phương thức getWheelRotation(), được hiển thị dưới đây:
*       int getWheelRotation()
* Phương thức này trả về số lượng đơn vị quay. Nếu giá trị là dương, bánh xe đã quay theo chiều kim đồng hồ.
* Nếu giá trị là âm, bánh xe đã quay ngược chiều kim đồng hồ.
*
* Cũng có sẵn một phương thức gọi là getPreciseWheelRotation(), hỗ trợ bánh xe có độ phân giải cao.
* Nó hoạt động tương tự như getWheelRotation(), nhưng trả về một giá trị kiểu double.
*
* Để lấy loại cuộn, gọi phương thức getScrollType(), được hiển thị dưới đây:
*       int getScrollType()
* Phương thức này trả về WHEEL_UNIT_SCROLL hoặc WHEEL_BLOCK_SCROLL.
*
* Nếu loại cuộn là WHEEL_UNIT_SCROLL, bạn có thể lấy số lượng đơn vị để cuộn bằng cách gọi phương thức getScrollAmount().
* Đây là cách sử dụng của nó:
*       int getScrollAmount()
*
* */
public class n_MouseWheelEventClass {
}
