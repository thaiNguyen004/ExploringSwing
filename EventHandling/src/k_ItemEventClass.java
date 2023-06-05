/*
* Lớp ItemEvent
* Một ItemEvent được tạo ra khi một ô chọn hoặc một mục danh sách được nhấp chuột hoặc khi một mục menu
* có thể được chọn hoặc bỏ chọn. (Các ô chọn và danh sách sẽ được mô tả sau trong cuốn sách này.)
*
* Có hai loại sự kiện mục, được xác định bằng các hằng số nguyên sau:
*
* SELECTED: Đại diện cho trạng thái được chọn. Khi một mục trong danh sách hoặc lựa chọn được chọn,
* sự kiện ItemEvent sẽ có trạng thái SELECTED. Ví dụ, khi người dùng chọn một mục trong danh sách, sự kiện ItemEvent
* sẽ có trạng thái SELECTED.
*
* DESELECTED: Đại diện cho trạng thái không được chọn. Khi một mục trong danh sách hoặc lựa chọn không còn
* được chọn nữa, sự kiện ItemEvent sẽ có trạng thái DESELECTED. Ví dụ, khi người dùng bỏ chọn một mục đã được
* chọn trong danh sách, sự kiện ItemEvent sẽ có trạng thái DESELECTED.
*
* Lớp ItemEvent
* ItemEvent định nghĩa hằng số nguyên ITEM_STATE_CHANGED, đại diện cho sự thay đổi trạng thái.
* ItemEvent có constructor như sau:
* ItemEvent(ItemSelectable src, int type, Object entry, int state)
* Ở đây, src là tham chiếu đến thành phần tạo ra sự kiện này. Ví dụ, đây có thể là một danh sách hoặc một phần
* tử lựa chọn. Loại sự kiện được xác định bởi type. Mục cụ thể tạo ra sự kiện mục được truyền vào entry.
* Trạng thái hiện tại của mục đó được lưu trong state.
*
* Phương thức getItem() được sử dụng để lấy tham chiếu đến mục đã thay đổi. Chữ ký của phương thức này được hiển thị như sau:
*       Object getItem()
*
* Phương thức getItemSelectable() được sử dụng để lấy tham chiếu đến đối tượng ItemSelectable tạo ra sự kiện.
* Định dạng tổng quát của phương thức này như sau:
*
*       ItemSelectable getItemSelectable()
*
* Danh sách và lựa chọn là những ví dụ về các phần tử giao diện người dùng thực hiện giao diện ItemSelectable.
*
* Phương thức getStateChange() trả về sự thay đổi trạng thái (SELECTED hoặc DESELECTED) cho sự kiện.
* Chữ ký của phương thức này được hiển thị như sau:
*
*       int getStateChange()
* */
public class k_ItemEventClass {
}
