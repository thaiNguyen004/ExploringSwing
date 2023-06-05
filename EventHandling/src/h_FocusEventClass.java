/*
* Lớp FocusEvent
* Một FocusEvent được tạo ra khi một thành phần đạt được hoặc mất đi sự tập trung đầu vào. Những sự kiện này
* được xác định bằng các hằng số số nguyên FOCUS_GAINED và FOCUS_LOST.
*
* FocusEvent là một lớp con của ComponentEvent và có các constructor như sau:
*
* FocusEvent(Component src, int type)
* FocusEvent(Component src, int type, boolean temporaryFlag)
* FocusEvent(Component src, int type, boolean temporaryFlag, Component other)
* FocusEvent(Component src, int type, boolean temporaryFlag, Component other, FocusEvent.Cause what)
*
* Ở đây, src là một tham chiếu tới thành phần đã tạo ra sự kiện này. Loại sự kiện được chỉ định bởi tham số type.
* Đối số temporaryFlag được đặt thành true nếu sự kiện tập trung là tạm thời.
* Ngược lại, nó được đặt thành false. (Một sự kiện tập trung tạm thời xảy ra như kết quả của một hoạt động giao diện
* người dùng khác. Ví dụ, giả sử rằng tập trung đang nằm trong một trường văn bản. Nếu người dùng di chuyển chuột
* để điều chỉnh thanh cuộn, tập trung sẽ bị mất tạm thời.)
*
* Thành phần khác tham gia vào thay đổi tập trung, được gọi là thành phần đối diện, được truyền vào đối số other.
* Do đó, nếu xảy ra một sự kiện FOCUS_GAINED, other sẽ đề cập đến thành phần đã mất tập trung.
* Ngược lại, nếu xảy ra một sự kiện FOCUS_LOST, other sẽ đề cập đến thành phần đã đạt được tập trung.
*
* Constructor thứ tư được thêm vào từ JDK 9. Tham số what của nó xác định lý do sự kiện được tạo ra.
* Nó được chỉ định dưới dạng một giá trị của định danh FocusEvent.Cause, xác định nguyên nhân của sự kiện tập trung.
* Định danh FocusEvent.Cause cũng được thêm vào từ JDK 9.
*
* Bạn có thể xác định thành phần đối diện bằng cách gọi phương thức getOppositeComponent(), được hiển thị ở đây:
*
*       Component getOppositeComponent()
*
* Thành phần đối diện sẽ được trả về.
*
* Phương thức isTemporary() chỉ ra xem sự thay đổi tập trung này có phải là tạm thời hay không. Đây là cấu trúc của nó:
*       boolean isTemporary()
* Phương thức trả về true nếu sự thay đổi là tạm thời. Ngược lại, nó trả về false.
*
* Bắt đầu từ JDK 9, bạn có thể lấy được nguyên nhân của sự kiện bằng cách gọi getCause(), được hiển thị ở đây:
*
*       final FocusEvent.Cause getCause()
*
* Nguyên nhân được trả về dưới dạng một giá trị định danh FocusEvent.Cause.
* */
public class h_FocusEventClass {
}
