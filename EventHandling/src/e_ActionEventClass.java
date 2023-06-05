/*
*
* Lớp ActionEvent
* Một ActionEvent được tạo ra khi một nút được nhấn, một mục trong danh sách được nhấp đúp, hoặc một mục
* trong menu được chọn. Lớp ActionEvent định nghĩa bốn hằng số số nguyên có thể được sử dụng để xác định bất
* kỳ bộ sửa đổi nào liên quan đến sự kiện hành động: ALT_MASK, CTRL_MASK, META_MASK và SHIFT_MASK.
* Ngoài ra, có một hằng số số nguyên, ACTION_PERFORMED, có thể được sử dụng để xác định sự kiện hành động.
*
* ActionEvent có ba constructor như sau:
* ActionEvent(Object src, int type, String cmd)
* ActionEvent(Object src, int type, String cmd, int modifiers)
* ActionEvent(Object src, int type, String cmd, long when, int modifiers)
*
* Ở đây, src là một tham chiếu đến đối tượng đã tạo ra sự kiện này.
* Loại sự kiện được chỉ định bởi type,
* và chuỗi lệnh của nó được xác định bởi cmd.
* Đối số modifiers chỉ ra các phím sửa đổi (ALT, CTRL, META và/hoặc SHIFT) đã được nhấn khi sự kiện được tạo ra.
* Tham số when chỉ định thời điểm sự kiện xảy ra.
*
*
* Bạn có thể lấy tên lệnh của đối tượng ActionEvent gọi bằng cách sử dụng phương thức getActionCommand(),
* được hiển thị dưới đây:
*       String getActionCommand()
*
* Ví dụ, khi một nút được nhấn, một sự kiện hành động được tạo ra có tên lệnh bằng với nhãn trên nút đó.
*
* Phương thức getModifiers() trả về một giá trị chỉ ra các phím sửa đổi (ALT, CTRL, META và/hoặc SHIFT) đã
* được nhấn khi sự kiện được tạo ra. Đây là cấu trúc của phương thức getModifiers():
*
*   int getModifiers()
*
* Phương thức getWhen() trả về thời điểm xảy ra sự kiện. Đây được gọi là dấu thời gian của sự kiện.
* Dưới đây là phương thức getWhen():
*
*       long getWhen()*/
public class e_ActionEventClass {

}
