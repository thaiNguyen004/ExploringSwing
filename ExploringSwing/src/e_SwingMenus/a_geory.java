package e_SwingMenus;
/*
* Giới thiệu các Menu trong Swing
* Chương này giới thiệu một khía cạnh cơ bản khác của môi trường GUI Swing: menu.
* Menu là một phần quan trọng của nhiều ứng dụng vì chúng cung cấp các chức năng
* của chương trình cho người dùng. Vì tính quan trọng của chúng, Swing cung cấp
* hỗ trợ đáng kể cho việc tạo menu. Đây là một lĩnh vực mà sức mạnh của Swing
* được thể hiện rõ rệt.
*
* Hệ thống menu trong Swing hỗ trợ một số thành phần chính, bao gồm:
- Thanh menu, là thanh menu chính cho một ứng dụng.
- Menu tiêu chuẩn, có thể chứa các mục để lựa chọn hoặc các menu khác (submenu).
- Menu ngữ cảnh, thường được kích hoạt bằng cách nhấp chuột phải.
- Thanh công cụ, cung cấp truy cập nhanh đến chức năng của chương trình, thường tương ứng với các mục trong menu.
- Hành động, cho phép quản lý hai hoặc nhiều thành phần khác nhau bằng một đối tượng duy nhất. Hành động thường
* được sử dụng với menu và thanh công cụ.
*
*
* Các menu trong Swing cũng hỗ trợ phím tắt (accelerator keys), cho phép lựa chọn các mục trong menu
* mà không cần kích hoạt menu và mnemonic, cho phép lựa chọn một mục trong menu bằng bàn phím sau khi
* các tùy chọn của menu được hiển thị.
*
* Cơ bản về Menu
* Hệ thống menu trong Swing được hỗ trợ bởi một nhóm các lớp liên quan. Các lớp được sử dụng trong chương
* này được hiển thị trong Bảng 33-1 và đại diện cho lõi của hệ thống menu. Mặc dù ban đầu chúng có thể
* có vẻ hơi khó hiểu, nhưng việc sử dụng menu trong Swing khá dễ dàng. Swing cho phép tùy chỉnh một mức độ
* cao nếu cần; tuy nhiên, thông thường bạn sẽ sử dụng các lớp menu như đã có sẵn vì chúng hỗ trợ tất cả
* các tùy chọn cần thiết nhất. Ví dụ, bạn có thể dễ dàng thêm hình ảnh và phím tắt vào một menu.
*
* Dưới đây là mô tả về các lớp liên quan đến hệ thống menu trong Swing:
*
* JMenuBar: Lớp JMenuBar là thanh menu chính cho một ứng dụng. Nó là một container cho các đối tượng JMenu
* và được đặt ở trên cùng của cửa sổ ứng dụng.
*
* JMenu: Lớp JMenu đại diện cho một menu trong hệ thống menu. Nó có thể chứa các mục để lựa chọn hoặc
* các submenu (JMenu con). Mỗi JMenu có một cái tên và được hiển thị như một mục trong thanh menu.
*
* JMenuItem: Lớp JMenuItem đại diện cho một mục lựa chọn trong menu. Nó là một hành động cụ thể mà
* người dùng có thể chọn để thực hiện một chức năng nào đó. JMenuItem thường được đặt trong JMenu hoặc JPopupMenu.
*
* JCheckBoxMenuItem: Lớp JCheckBoxMenuItem đại diện cho một mục lựa chọn kiểu hộp kiểm trong menu.
* Người dùng có thể chọn hoặc bỏ chọn mục này bằng cách nhấp vào nó. Nó được sử dụng để bật hoặc tắt một tùy chọn cụ thể.
*
* JRadioButtonMenuItem: Lớp JRadioButtonMenuItem đại diện cho một mục lựa chọn kiểu nút radio trong menu.
* Chỉ một mục JRadioButtonMenuItem có thể được chọn vào một thời điểm. Nó được sử dụng khi chỉ cho phép
* người dùng chọn một trong số các tùy chọn.
*
* JSeparator: Lớp JSeparator đại diện cho một dòng ngăn cách trong menu hoặc popup menu. Nó được sử dụng để
* tạo khoảng cách hoặc nhóm các mục trong menu.
*
* JPopupMenu: Lớp JPopupMenu đại diện cho một menu ngữ cảnh (popup menu). Nó là một menu nhỏ xuất hiện khi
* người dùng nhấp chuột phải. JPopupMenu chứa các JMenuItem và có thể được kích hoạt từ một thành phần
* giao diện người dùng khác.
*
* Dưới đây là một cái nhìn tổng quan về cách các lớp tương tác với nhau. Để tạo menu cấp cao nhất cho một ứng dụng,
* trước tiên bạn tạo một đối tượng JMenuBar. Lớp này, một cách tổng quát, là một container cho các menu.
* Với đối tượng JMenuBar, bạn sẽ thêm các đối tượng JMenu. Mỗi đối tượng JMenu đại diện cho một menu.
* Nghĩa là, mỗi đối tượng JMenu chứa một hoặc nhiều mục có thể được lựa chọn. Các mục được hiển thị bởi một JMenu
* là các đối tượng JMenuItem. Do đó, một JMenuItem định nghĩa một lựa chọn có thể được chọn bởi người dùng.
*
* Như một sự thay thế hoặc phụ bản cho menu xuất hiện từ thanh menu, bạn cũng có thể tạo các menu xuất hiện độc lập,
* gọi là popup menu. Để tạo một popup menu, trước tiên tạo một đối tượng JPopupMenu. Sau đó, thêm JMenuItems vào đó.
* Một popup menu thường được kích hoạt bằng cách nhấp chuột phải khi chuột nằm trên một thành phần nào đó mà có
* menu popup đã được xác định.
*
* Ngoài các mục menu "tiêu chuẩn", bạn cũng có thể bao gồm hộp kiểm (checkbox) và nút radio trong menu. Một mục
* menu kiểu hộp kiểm được tạo bằng lớp JCheckBoxMenuItem. Một mục menu kiểu nút radio được tạo bằng lớp
* JRadioButtonMenuItem. Cả hai lớp này đều mở rộng JMenuItem và có thể được sử dụng trong các menu tiêu chuẩn và menu popup.
*
* JToolBar tạo ra một thành phần độc lập liên quan đến menu. Nó thường được sử dụng để cung cấp truy cập nhanh
* đến các chức năng được chứa trong các menu của ứng dụng. Ví dụ, một thanh công cụ có thể cung cấp truy cập nhanh
* đến các lệnh định dạng được hỗ trợ bởi một trình xử lý từ vựng.
*
* JSeparator là một lớp tiện ích tạo ra một dòng phân cách trong menu.
*
* Một điểm quan trọng để hiểu về menu trong Swing là mỗi mục menu mở rộng AbstractButton. Hãy nhớ rằng
* AbstractButton cũng là lớp cha của tất cả các thành phần nút trong Swing, chẳng hạn như JButton.
* Do đó, tất cả các mục menu thực chất là các nút. Tất nhiên, khi được sử dụng trong menu, chúng sẽ không
* trông giống như các nút, nhưng chúng sẽ hoạt động giống như các nút theo nhiều cách.
* Ví dụ, việc chọn một mục menu tạo ra một sự kiện hành động (action event) theo cùng cách nhấn một nút.
*
* Một điểm quan trọng khác là JMenuItem là lớp cha của JMenu. Điều này cho phép tạo ra các submenu, tức là
* menu trong menu. Để tạo một submenu, trước tiên tạo và điền thông tin vào một đối tượng JMenu, sau đó thêm
* nó vào một đối tượng JMenu khác. Quá trình này sẽ được thể hiện trong phần tiếp theo.
*
* Như đã đề cập trước đây, khi một mục menu được chọn, sẽ tạo ra một sự kiện hành động (action event).
* Chuỗi lệnh hành động liên quan đến sự kiện hành động đó sẽ, theo mặc định, là tên của lựa chọn. Do đó,
* bạn có thể xác định mục nào được chọn bằng cách xem xét lệnh hành động. Tất nhiên, bạn cũng có thể sử dụng
* các lớp inner class ẩn danh hoặc biểu thức lambda riêng biệt để xử lý sự kiện hành động của mỗi mục menu.
* Trong trường hợp này, lựa chọn menu đã được biết trước và không cần phải xem xét chuỗi lệnh hành động để
* xác định mục nào đã được chọn.
*
* Menu cũng có thể tạo ra các loại sự kiện khác. Ví dụ, mỗi khi một menu được kích hoạt, chọn hoặc hủy bỏ,
* một MenuEvent được tạo ra và có thể lắng nghe thông qua một MenuListener. Các sự kiện liên quan khác của
* menu bao gồm MenuKeyEvent, MenuDragMouseEvent và PopupMenuEvent. Tuy nhiên, trong nhiều trường hợp, bạn chỉ cần
* theo dõi sự kiện hành động, và trong chương này, chúng ta chỉ sử dụng sự kiện hành động
*/
public class a_geory {
}
