/*
* Lớp trừu tượng InputEvent là một lớp con của ComponentEvent và là lớp cha cho các sự kiện đầu vào của thành phần.
* Các lớp con của nó là KeyEvent và MouseEvent.
*
* InputEvent xác định một số hằng số nguyên đại diện cho bất kỳ bộ chỉnh sửa nào, như phím điều khiển được nhấn,
* có thể được liên kết với sự kiện. Ban đầu, lớp InputEvent xác định tám giá trị sau để đại diện cho các bộ chỉnh sửa,
* và những bộ chỉnh sửa này có thể được tìm thấy trong mã nguồn kế thừa cũ hơn:
*
* Dưới đây là danh sách 8 giá trị hằng số ban đầu được xác định trong lớp InputEvent để đại diện
* cho các bộ chỉnh sửa (modifiers):
*
* 1. SHIFT_MASK: Đại diện cho phím Shift được nhấn.
* 2. CTRL_MASK: Đại diện cho phím Ctrl được nhấn.
* 3. META_MASK: Đại diện cho phím Meta (Command trên macOS hoặc Windows key trên Windows) được nhấn.
* 4. ALT_MASK: Đại diện cho phím Alt được nhấn.
* 5. ALT_GRAPH_MASK: Đại diện cho phím Alt Gr được nhấn.
* 6. BUTTON1_MASK: Đại diện cho nút chuột trái được nhấn.
* 7. BUTTON2_MASK: Đại diện cho nút chuột giữa được nhấn.
* 8. BUTTON3_MASK: Đại diện cho nút chuột phải được nhấn.
*
* Lưu ý rằng các giá trị này có thể được tìm thấy trong mã nguồn kế thừa cũ hơn và có thể không được
* sử dụng trong các phiên bản mới hơn của Java.
*
* Tuy nhiên, do khả năng xung đột giữa các bộ chỉnh sửa được sử dụng bởi các sự kiện bàn phím và sự kiện chuột, cũng như
* các vấn đề khác, các giá trị bộ chỉnh sửa mở rộng sau đây đã được thêm vào:
*
* Dưới đây là các giá trị bộ chỉnh sửa mở rộng được thêm vào:

- SHIFT_DOWN_MASK: Được sử dụng để xác định rằng phím Shift đang được nhấn.
- CTRL_DOWN_MASK: Được sử dụng để xác định rằng phím Ctrl đang được nhấn.
- META_DOWN_MASK: Được sử dụng để xác định rằng phím Meta (Command trên Mac) đang được nhấn.
- ALT_DOWN_MASK: Được sử dụng để xác định rằng phím Alt đang được nhấn.
- ALT_GRAPH_DOWN_MASK: Được sử dụng để xác định rằng phím Alt Gr (Alt Graph) đang được nhấn.
- BUTTON1_DOWN_MASK: Được sử dụng để xác định rằng nút chuột trái đang được nhấn.
- BUTTON2_DOWN_MASK: Được sử dụng để xác định rằng nút chuột giữa đang được nhấn.
- BUTTON3_DOWN_MASK: Được sử dụng để xác định rằng nút chuột phải đang được nhấn.
*
* Khi viết mã mới, bạn nên sử dụng các bộ chỉnh sửa mở rộng mới thay vì các bộ chỉnh sửa gốc. Hơn nữa, các bộ chỉnh sửa
* gốc đã bị gỡ bỏ (deprecated) từ JDK 9.
*
* Để kiểm tra xem một bộ chỉnh sửa đã được nhấn vào thời điểm tạo ra sự kiện hay không, bạn có thể sử dụng các phương thức
* isAltDown(),
* isAltGraphDown(),
* isControlDown(),
* isMetaDown(), và
* isShiftDown(). Các hình thức của các phương thức này được hiển thị dưới đây:
*
* boolean isAltDown()
* boolean isAltGraphDown()
* boolean isControlDown()
* boolean isMetaDown()
* boolean isShiftDown()
*
* Bạn có thể nhận được một giá trị chứa tất cả các cờ chỉnh sửa gốc bằng cách gọi phương thức getModifiers().
* Nó được hiển thị dưới đây:
*
* int getModifiers()
*
* Mặc dù bạn có thể gặp getModifiers() trong mã cũ, nhưng cần lưu ý rằng vì các cờ chỉnh sửa gốc đã bị gỡ bỏ từ JDK 9,
* phương thức này cũng đã bị gỡ bỏ.
*
* Thay vào đó, bạn nên nhận các bộ chỉnh sửa mở rộng bằng cách gọi phương thức getModifiersEx(), được hiển thị dưới đây:
*
* int getModifiersEx()
* */
public class i_InputEventClass {
}
