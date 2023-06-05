/*
* Một ComponentEvent được tạo ra khi kích thước, vị trí hoặc khả năng hiển thị của một thành phần bị thay đổi.
* Có bốn loại sự kiện thành phần. Lớp ComponentEvent xác định các hằng số nguyên có thể được sử dụng để nhận biết chúng.
* Dưới đây là các hằng số và ý nghĩa của chúng:
*
* - `COMPONENT_MOVED`: Xác định rằng thành phần đã di chuyển.
* - `COMPONENT_RESIZED`: Xác định rằng kích thước của thành phần đã thay đổi.
* - `COMPONENT_SHOWN`: Xác định rằng thành phần đã được hiển thị.
* - `COMPONENT_HIDDEN`: Xác định rằng thành phần đã bị ẩn.
*
* Ví dụ, khi một cửa sổ được di chuyển, sự kiện COMPONENT_MOVED sẽ được tạo ra.
* Khi kích thước của một thành phần được thay đổi, sự kiện COMPONENT_RESIZED sẽ được tạo ra.
*
* ComponentEvent có constructor như sau:
*
*       ComponentEvent(Component src, int type)
*
* Ở đây, src là một tham chiếu tới đối tượng tạo ra sự kiện này. Loại sự kiện được chỉ định bởi tham số type.
* ComponentEvent là lớp cơ sở trực tiếp hoặc gián tiếp của ContainerEvent, FocusEvent, KeyEvent,
* MouseEvent và WindowEvent, và một số lớp khác.
*
* Phương thức getComponent() trả về thành phần đã tạo ra sự kiện. Dưới đây là cấu trúc của phương thức này:
*       Component getComponent()
*
* Một ContainerEvent được tạo ra khi một thành phần được thêm vào hoặc xóa khỏi một container.
* Có hai loại sự kiện container. Lớp ContainerEvent định nghĩa các hằng số int có thể được sử dụng để
* xác định chúng: COMPONENT_ADDED và COMPONENT_REMOVED. Chúng chỉ ra rằng một thành phần đã được thêm vào hoặc xóa
* khỏi container.
*
* ContainerEvent là một lớp con của ComponentEvent và có constructor như sau:
*       ContainerEvent(Component src, int type, Component comp)
*
* Ở đây, src là một tham chiếu tới container đã tạo ra sự kiện này. Loại sự kiện được chỉ định bởi tham số type,
* và thành phần đã được thêm vào hoặc xóa khỏi container là comp.
*
* Bạn có thể lấy tham chiếu tới container đã tạo ra sự kiện này bằng cách sử dụng phương thức getContainer(),
* được mô tả như sau:
*       Container getContainer()
*
* Phương thức getChild() trả về một tham chiếu tới thành phần đã được thêm vào hoặc xóa khỏi container.
* Dưới đây là cấu trúc tổng quát của phương thức này:
*       Component getChild()
* */
public class g_ComponentEventClass {
}
