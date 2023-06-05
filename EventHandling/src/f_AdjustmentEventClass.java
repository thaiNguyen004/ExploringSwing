/*
* Lớp AdjustmentEvent
* Một AdjustmentEvent được tạo ra bởi thanh cuộn (scroll bar). Có năm loại sự kiện điều chỉnh (adjustment events).
* Lớp AdjustmentEvent xác định các hằng số số nguyên có thể được sử dụng để xác định chúng.
* Các hằng số và ý nghĩa của chúng được hiển thị dưới đây:
*
* Dưới đây là danh sách năm hằng số của lớp AdjustmentEvent:

1. `ADJUSTMENT_FIRST`: Đại diện cho sự kiện điều chỉnh đầu tiên trong chuỗi sự kiện.
2. `ADJUSTMENT_LAST`: Đại diện cho sự kiện điều chỉnh cuối cùng trong chuỗi sự kiện.
3. `ADJUSTMENT_VALUE_CHANGED`: Đại diện cho sự kiện khi giá trị của thanh cuộn được thay đổi.
4. `BLOCK_DECREMENT`: Đại diện cho sự kiện khi giá trị của thanh cuộn giảm một khối lượng lớn.
5. `BLOCK_INCREMENT`: Đại diện cho sự kiện khi giá trị của thanh cuộn tăng một khối lượng lớn.

  Các hằng số này được sử dụng để xác định loại sự kiện điều chỉnh và phân biệt các hành động khác nhau khi
* tương tác với thanh cuộn.
*
*
* Lớp AdjustmentEvent có một hằng số nguyên bổ sung là `ADJUSTMENT_VALUE_CHANGED`, cho biết đã xảy ra một sự thay đổi.
*
* Dưới đây là một constructor của AdjustmentEvent:
*
*   AdjustmentEvent(Adjustable src, int id, int type, int val)
*
* Ở đây, src là tham chiếu đến đối tượng tạo ra sự kiện này. Tham số id chỉ định sự kiện.
* Loại điều chỉnh được chỉ định bởi type và giá trị liên quan của nó là val.
*
* Phương thức `getAdjustable()` trả về đối tượng đã tạo ra sự kiện. Định dạng chung của phương thức này được
* thể hiện dưới đây:
*
*   Adjustable getAdjustable()
*
* Loại sự kiện điều chỉnh có thể được lấy thông qua phương thức `getAdjustmentType()`. Nó trả về một trong các
* hằng số được định nghĩa bởi AdjustmentEvent. Định dạng chung của nó được thể hiện dưới đây:
*
*   int getAdjustmentType()
*
* Lượng điều chỉnh có thể được lấy từ phương thức `getValue()`, được thể hiện dưới đây:
*
*   int getValue()
*
* Ví dụ, khi thanh cuộn được điều khiển, phương thức này trả về giá trị được biểu thị bởi sự thay đổi đó.*/
public class f_AdjustmentEventClass {
}
