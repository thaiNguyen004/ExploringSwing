package e_SwingMenus;
/*
* JMenuItem
* JMenuItem đóng gói một phần tử trong menu. Phần tử này có thể là một lựa chọn liên kết đến một hành động
* chương trình cụ thể, chẳng hạn như Lưu hoặc Đóng, hoặc nó có thể hiển thị một submenu. Như đã đề cập,
* JMenuItem được thừa kế từ AbstractButton và mọi mục trong menu có thể được coi là một loại đặc biệt của nút.
* Do đó, khi một menu item được chọn, sẽ tạo ra một sự kiện hành động. (Điều này tương tự như cách một JButton
* phát ra sự kiện hành động khi được nhấn.) J
*
* MenuItem định nghĩa nhiều constructors. Các constructors được sử dụng trong chương này được hiển thị dưới đây:
*
* JMenuItem(String name)
* JMenuItem(Icon image)
* JMenuItem(String name, Icon image)
* JMenuItem(String name, int mnem)
* JMenuItem(Action action)
*
* Constructor đầu tiên tạo một menu item với tên được chỉ định bởi name.
* Constructor thứ hai tạo một menu item hiển thị hình ảnh được chỉ định bởi image.
* Constructor thứ ba tạo một menu item với tên được chỉ định bởi name và hình ảnh được chỉ định bởi image.
* Constructor thứ tư tạo một menu item với tên được chỉ định bởi name và sử dụng mnemonic của phím được chỉ định bởi mnem.
* Mnemonic này cho phép bạn chọn một mục từ menu bằng cách nhấn phím được chỉ định.
* Constructor cuối cùng tạo một menu item sử dụng thông tin được chỉ định trong action.
* Một constructor mặc định cũng được hỗ trợ.
*
* Vì menu items thừa kế AbstractButton, bạn có quyền truy cập vào các chức năng được cung cấp bởi AbstractButton.
* Một trong số những phương thức thường hữu ích với menu là setEnabled(), bạn có thể sử dụng để kích hoạt hoặc
* vô hiệu hóa một menu item. Nó được hiển thị như sau:
*
* void setEnabled(boolean enable)
*
* Nếu enable là true, menu item được kích hoạt. Nếu enable là false, mục được vô hiệu hóa và không thể được chọn.
* */
public class d_georyJMenuItem {
}
